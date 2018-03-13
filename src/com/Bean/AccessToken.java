package com.Bean;

public class AccessToken {

	private String access_token;
	private int expires_in;
	private int errcode;
	private String errmsg;
	@Override
	public String toString() {
		return "AccessToken [access_token=" + access_token + ", expires_in=" + expires_in + ", errcode=" + errcode
				+ ", errmsg=" + errmsg + "]";
	}
	public AccessToken(String access_token, int expires_in, int errcode, String errmsg) {
		super();
		this.access_token = access_token;
		this.expires_in = expires_in;
		this.errcode = errcode;
		this.errmsg = errmsg;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
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
	public AccessToken() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
