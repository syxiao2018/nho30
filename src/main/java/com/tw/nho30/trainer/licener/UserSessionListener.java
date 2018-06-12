package com.tw.nho30.trainer.licener;

import com.tw.nho30.trainer.manage.SessionManager;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class UserSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        SessionManager.removeSession(httpSessionEvent.getSession());
    }
}
