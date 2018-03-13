package com.thread;

import org.apache.log4j.Logger;

import com.Bean.AccessToken;
import com.Utils.GetAcess_TokenUtil;

public class TokenThread implements Runnable {  
    public static Logger log = Logger.getLogger(TokenThread.class);  
    // 第三方用户唯一凭证  
    public static String appid = "wx3f4bcc91aaccd4f3";  
    // 第三方用户唯一凭证密钥  
    public static String appsecret = "079810117e7925ff9d6dd15967276c85";  
    public static AccessToken accessToken = null;  
    @Override
	public void run() {
    	System.out.println("已經進來了TokenThread");
        while (true) {  
            try {  
                accessToken = GetAcess_TokenUtil.getAccessToken(appid, appsecret);  
                if (null != accessToken ) { 
                	System.out.println("获取access_token成功，有效时长{}秒 token:{}");
                	System.out.println(accessToken.getExpiresIn());
                	System.out.println(accessToken.getToken());
                	log.info("获取access_token成功，有效时长{}秒 token:{}");
                	log.info(accessToken.getExpiresIn());
                	log.info(accessToken.getToken());
                    // 休眠7000秒  
                	//下面的线程休眠会抛异常（timeout value is negative）
                	//休眠时间有可能为负数
                	Thread.sleep((accessToken.getExpiresIn() - 200) * 1000);  
                	//Thread.sleep(7000 * 1000); 
                    //Test休眠30秒
                    //Thread.sleep(30*1000);
                } else {  
                    // 如果access_token为null，60秒后再获取  
                    Thread.sleep(60 * 1000);  
                }  
            } catch (InterruptedException e) {  
                try {  
                    Thread.sleep(60 * 1000);  
                } catch (InterruptedException e1) {  
                    log.error("{}", e1); 
                    System.out.println("{}");
                    System.out.println(e1);
                }  
                log.error("{}", e);  
                System.out.println("{}");
                System.out.println(e);
            }  
        }  
    }  
}  