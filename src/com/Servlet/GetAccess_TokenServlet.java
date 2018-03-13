package com.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.Thread.TokenThread;
import com.Utils.GetAcess_TokenUtil;

@WebServlet("/GetAccess_Token")
public class GetAccess_TokenServlet extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(GetAcess_TokenUtil.class); 
  
    @Override
	public void init() throws ServletException {  
        // 获取web.xml中配置的参数  
    	System.out.println("已經進來了GetAccess_TokenServlet");
    	System.out.println("weixin api appid:{}");
    	System.out.println(TokenThread.appid);
    	System.out.println("weixin api appsecret:{}");
    	System.out.println(TokenThread.appsecret);
        log.info("weixin api appid:{}");
        log.info(TokenThread.appid);
        log.info("weixin api appsecret:{}");  
        log.info(TokenThread.appsecret);
        // 未配置appid、appsecret时给出提示  
        if ("".equals(TokenThread.appid) || "".equals(TokenThread.appsecret)) {  
            log.error("appid and appsecret configuration error, please check carefully.");  
        } else {  
            // 启动定时获取access_token的线程  
            new Thread(new TokenThread()).start();  
        }  
    }  
}  