package com.Bean;

public class AccessToken {

	public static String access_token;
	private int expires_in;
	private int errcode;
	private String errmsg;
	
	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public AccessToken(int expires_in, int errcode, String errmsg) {
		super();
		this.expires_in = expires_in;
		this.errcode = errcode;
		this.errmsg = errmsg;
	}

	@Override
	public String toString() {
		return "AccessToken [expires_in=" + expires_in + ", errcode=" + errcode + ", errmsg=" + errmsg + "]";
	}

	public AccessToken() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
