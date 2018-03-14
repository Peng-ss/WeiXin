package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.AccessToken;
import com.Bean.Item;
import com.Bean.Template;
import com.Bean.TemplateData;
import com.Utils.OkHttpUtiles;
import com.alibaba.fastjson.JSON;

import okhttp3.MediaType;
import okhttp3.RequestBody;


@WebServlet("/SendTemplate")
public class SendTemplateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="
	      +AccessToken.access_token;
		Template template =new Template();
		template.setTouser("ob1Fj0hcxN-8lCouYYZb7CF-BBJs");
		template.setUrl("http://111.230.151.235/New/");
		template.setTemplate_id("7orwl1evQSbY_Ln-c-kQ9EfWyjxNFDOmYIn9TK_x37g");
		TemplateData data = new TemplateData();
		data.put("first", new Item("恭喜你购买成功！", "#173177"));
		data.put("keyword1", new Item("巧克力", "#173177"));
		data.put("keyword2", new Item("123123123", "#173177"));
		data.put("keyword3", new Item("39元", "#173177"));
		data.put("keyword4", new Item("2014年9月22日", "#173177"));
		data.put("remark", new Item("欢迎再次购买！", "#173177"));
		template.setData(data);
		if (template !=null) {
			RequestBody body =RequestBody.create(MediaType.parse("application/json"), JSON.toJSONString(template));  
			String jsonStr = OkHttpUtiles.Post(url,body);
			System.out.println(jsonStr);
		    
		}
		
	}
}
