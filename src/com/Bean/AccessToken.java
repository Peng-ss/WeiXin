package com.Bean;

public class AccessToken {

	private String Token;
	private int ExpiresIn;
	@Override
	public String toString() {
		return "AccessToken [Token=" + Token + ", ExpiresIn=" + ExpiresIn + "]";
	}
	public AccessToken(String token, int expiresIn) {
		super();
		Token = token;
		ExpiresIn = expiresIn;
	}
	public AccessToken() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		Token = token;
	}
	public int getExpiresIn() {
		return ExpiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		ExpiresIn = expiresIn;
	}
	
}
