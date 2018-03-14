package com.Utils;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;

import com.Bean.AccessToken;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class GetAcess_TokenUtil {
	
	public static AccessToken accessToken = null;  
	
	public static AccessToken getAccessToken(String appid,String appsecret){
		if(StringUtils.isEmpty(appid)|| StringUtils.isEmpty(appsecret))  
        {  
            //DEBUG_LOGGER.error("appid or secret is null");  
            return null;  
        }  
        accessToken = new AccessToken();
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                +appid+"&secret="+appsecret;  
        HttpClient httpClient = new HttpClient();  
        GetMethod getMethod = new GetMethod(url); 
        try  
        {  
            int execute = httpClient.executeMethod(getMethod);  
            System.out.println("execute:"+execute);  
            String getResponse = getMethod.getResponseBodyAsString(); 
            JSONObject jsonObject = JSON.parseObject(getResponse);
            AccessToken.access_token =(jsonObject.getString("access_token"));
            accessToken.setErrcode(jsonObject.getIntValue("errcode"));
            accessToken.setErrmsg(jsonObject.getString("errmsg"));
            accessToken.setExpires_in(jsonObject.getIntValue("expires_in"));
        }  
        catch (IOException e)  
        {  
            //DEBUG_LOGGER.error("getAccessToken failed,desc:::"+e);  
            e.printStackTrace();  
		}finally {
			getMethod.releaseConnection();
		}
        
        return accessToken;  
    }  
		
}

