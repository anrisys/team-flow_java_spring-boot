package com.anrisys.team_flow.api.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.anrisys.team_flow.api.auth.dto.request.RegisterRequest;
import com.anrisys.team_flow.api.auth.dto.response.UserResponse;
import com.anrisys.team_flow.users.application.service.RegisterUserCommand;
import com.anrisys.team_flow.users.application.service.UserApplicationService;
import com.anrisys.team_flow.users.domain.model.User;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private final UserApplicationService userApplicationService;

	private AuthController(UserApplicationService userApplicationService) {
		super();
		this.userApplicationService = userApplicationService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest request) {
		RegisterUserCommand command = new RegisterUserCommand(
				request.email(),
				request.password(),
				request.firstName(),
				request.lastName()
		);
		
		User user = userApplicationService.registerUser(command);
		UserResponse response = UserResponse.from(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
