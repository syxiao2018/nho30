package com.tw.nho30.trainer.aop;

import com.tw.nho30.trainer.aop.constant.Status;
import com.tw.nho30.trainer.vo.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Aspect
public class ServiceAop {
    private final static String IGNORE_CHECK = "/user/login|/user/register";

    @Pointcut("execution(public * com.tw.nho30.trainer.controller.*.*(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Result<?> around(ProceedingJoinPoint proceedingJoinPoint) {
        Result<?> result = new Result<>();
        if (!isLogin()) {
            result.setMessage("当前用户未登录");
            result.setStatus(Status.FAIL);
            return result;
        }

        try {
            result = (Result<?>) proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            result.setStatus(Status.FAIL);
            result.setMessage("系统错误");
        }

        return result;
    }

    /**
     * 校验请求者是否登陆
     *
     * @return
     */
    private boolean isLogin() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //login和register请求不需要校验
        String requestURI = request.getRequestURI();
        if (ignoreCheckLogin(requestURI))
            return true;

        return request.getSession().getAttribute("user") != null;
    }

    /**
     * 忽略校验的路径
     * @param requestURI
     * @return
     */
    private boolean ignoreCheckLogin(String requestURI) {
        Pattern pattern = Pattern.compile(IGNORE_CHECK);
        Matcher matcher = pattern.matcher(requestURI);
        return matcher.find();
    }
}
