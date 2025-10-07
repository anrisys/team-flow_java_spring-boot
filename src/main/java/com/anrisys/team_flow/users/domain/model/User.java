package com.anrisys.team_flow.users.domain.model;

import java.time.Instant;
import java.util.Objects;

import com.anrisys.team_flow.shared.common.PublicID;
import com.anrisys.team_flow.shared.security.PasswordEncoder;

public class User {
	private final PublicID id;
	private final String email;
	private String hashedPassword;
	private String firstName;
	private String lastName;
	private String role;
	private final Instant createdAt;
	private Instant updatedAt;

	private User(PublicID id, String email, String hashedPassword, String firstName, String lastName, String role,
			Instant createdAt, Instant updatedAt) {
		this.id = Objects.requireNonNull(id);
		this.email = validateEmail(email);
		this.hashedPassword = validatePassword(hashedPassword);
		this.firstName = validateName(firstName, "First name");
		this.lastName = validateName(lastName, "Last name");
		this.role = validateRole(role);
		this.createdAt = Objects.requireNonNull(createdAt);
		this.updatedAt = Objects.requireNonNull(updatedAt);
	}

	public static User registerNew(String email, String rawPassword, String firstName, String lastName,
			PasswordEncoder encoder) {
		Instant now = Instant.now();
		return new User(PublicID.generate(), email, encoder.encode(rawPassword), firstName, lastName, "USER", now, now);
	}

	public static User fromDB(String publicId, String email, String hashedPassword, String firstName,
			String lastName, String role, Instant createdAt, Instant updatedAt) {
		return new User(PublicID.from(publicId), email, hashedPassword, firstName, lastName, role, createdAt,
				updatedAt);
	}

	// Validation methods
	private String validateEmail(String email) {
		if (email == null || !email.contains("@")) {
			throw new IllegalArgumentException("Invalid email");
		}
		return email.toLowerCase().trim();
	}

	private String validatePassword(String password) {
		if (password == null || password.length() < 8) {
			throw new IllegalArgumentException("Password must be at least 8 characters");
		}
		return password;
	}

	private String validateName(String name, String field) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException(field + " cannot be empty");
		}
		return name.trim();
	}

	private String validateRole(String role) {
		if (role == null)
			throw new IllegalArgumentException("Role cannot be null");
		return role;
	}

	// Getters
	public PublicID getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getRole() {
		return role;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}
}
