package com.anrisys.team_flow.users.exceptions;

import org.springframework.http.HttpStatus;

import com.anrisys.team_flow.shared.exceptions.common.BaseException;

public class EmailAlreadyExistsException extends BaseException {
	public EmailAlreadyExistsException() {
		super("EMAIL_ALREADY_EXISTS", "Email already registered", HttpStatus.CONFLICT);
	}
}
