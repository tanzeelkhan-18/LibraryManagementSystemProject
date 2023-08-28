package com.libraryManagementSystem.security;

public enum ApplicationUserPermission {
	USER_READ("users:read"),
	USER_WRITE("users:write"),
	BOOK_READ("books:read"),
	BOOK_WRITE("books:write");

	private final String permission;

	private ApplicationUserPermission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}

}
