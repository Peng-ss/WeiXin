package com.Bean;


public class Template {

	private String touser;
	private String template_id;
	private String url;
	private TemplateData  data;
	public Template(String touser, String template_id, String url, TemplateData data) {
		super();
		this.touser = touser;
		this.template_id = template_id;
		this.url = url;
		this.data = data;
	}
	public Template() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public TemplateData getData() {
		return data;
	}
	public void setData(TemplateData data) {
		this.data = data;
	}
	

	
	
}

