package com.anrisys.team_flow.api.auth.dto.request;

import com.anrisys.team_flow.shared.validation.PasswordMatch;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@PasswordMatch(
	    password = "password",
	    confirmPassword = "confirmPassword",
	    message = "Password and confirmation password do not match"
	)
	public record RegisterRequest(
	    @NotBlank @Email String email,
	    @NotBlank @Size(min = 8) String password,
	    @NotBlank String confirmPassword,
	    @NotBlank String firstName,
	    @NotBlank String lastName
	) {}
