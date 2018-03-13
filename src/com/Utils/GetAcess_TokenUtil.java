package com.Utils;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ddf.EscherColorRef.SysIndexProcedure;

import com.Bean.AccessToken;


public class GetAcess_TokenUtil {
	
	
	public static AccessToken getAccessToken(String appid,String appsecret){
		System.out.println("已经进来了getAccessToken");
		if(StringUtils.isEmpty(appid)|| StringUtils.isEmpty(appsecret))  
        {  
            //DEBUG_LOGGER.error("appid or secret is null");  
            return null;  
        }  
        AccessToken accessToken = new AccessToken();
        try  
        {  
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                          +appid+"&secret="+appsecret;  
            HttpClient httpClient = new HttpClient();  
            GetMethod getMethod = new GetMethod(url);  
            int execute = httpClient.executeMethod(getMethod);  
            System.out.println("execute:"+execute);  
            String getResponse = getMethod.getResponseBodyAsString();  
            accessToken.setToken(getResponse);
        }  
        catch (IOException e)  
        {  
           // DEBUG_LOGGER.error("getAccessToken failed,desc:::"+e);  
            e.printStackTrace();  
        }  
        System.out.println(accessToken);  
        return accessToken;  
    }  
		
}

