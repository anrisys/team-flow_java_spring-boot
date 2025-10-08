package com.anrisys.team_flow.shared.exceptions.common;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String errorCode;
	private final HttpStatus httpStatus;
	protected BaseException(String errorCode, String message, HttpStatus httpStatus) {
		super(message);
		this.errorCode = errorCode;
		this.httpStatus = httpStatus;
	}
	protected BaseException(String errorCode, String message, HttpStatus httpStatus, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
		this.httpStatus = httpStatus;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
