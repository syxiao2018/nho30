package com.tw.nho30.trainer.controller.support;

public class ErrorResult {

	public int code;
	public String message;

	public ErrorResult() {
	}

	public ErrorResult(int code, String message) {
		this.code = code;
		this.message = message;
	}
}