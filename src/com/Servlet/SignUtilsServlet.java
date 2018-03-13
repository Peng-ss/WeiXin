package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.Utils.SignUtil;

/**
 * @Author Pss
 * @Date 2018/03
 * 
 */
@WebServlet("/SignUtils")
public class SignUtilsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SignUtilsServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp，nonce参数
        String signature = request.getParameter("signature");
        //时间戳
        String timestamp = request.getParameter("timestamp");
        //随机数
        String nonce = request.getParameter("nonce");
        //随机字符串
        String echostr = request.getParameter("echostr");

        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            logger.info("[signature: "+signature + "]<-->[timestamp: "+ timestamp+"]<-->[nonce: "+nonce+"]<-->[echostr: "+echostr+"]");
            response.getOutputStream().println(echostr);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
