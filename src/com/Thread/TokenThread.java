package com.Thread;

import org.apache.log4j.Logger;

import com.Bean.AccessToken;
import com.Utils.GetAcess_TokenUtil;

public class TokenThread implements Runnable {  
    public static Logger log = Logger.getLogger(TokenThread.class);  
    // 第三方用户唯一凭证  
    public static String appid = "wxf9615400c4af6007"; //测试账号appid
    // 第三方用户唯一凭证密钥  
    public static String appsecret = "abfdc0f96365d27e3ececb0d6a089ea2";  //测试账号密码appsecret
    public static AccessToken accessToken = null;  
    @Override
	public void run() {
        while (true) {  
            try {  
                accessToken = GetAcess_TokenUtil.getAccessToken(appid, appsecret);  
                log.info(accessToken);
                if (accessToken.getErrcode() ==0 && AccessToken.access_token!=null ) {
                	System.out.println("获取access_token成功，有效时长{"+accessToken.getExpires_in()+"}秒 token:{"+AccessToken.access_token+"}");
                    log.info("获取access_token成功，有效时长{"+accessToken.getExpires_in()+"}秒 token:{"+AccessToken.access_token+"}");
                    // 休眠7000秒  
                    //下面的线程休眠会抛异常（timeout value is negative）
                    //休眠时间有可能为负数
                    //Thread.sleep((accessToken.getExpiresIn() - 200) * 1000);  
                    Thread.sleep(7000 * 1000); 
                    //Test休眠30秒
                    //Thread.sleep(30*1000);
					}
                else {
                	//输出返回的错误信息
                    System.out.println("说明:"+accessToken.getErrmsg()+"返回码:"+accessToken.getErrcode());
				    log.info("说明:"+accessToken.getErrmsg()+"返回码:"+accessToken.getErrcode());
                	// 如果access_token为null，60秒后再获取  
                    Thread.sleep(60 * 1000); 
				}
            } catch (InterruptedException e) {  
                try {  
                    Thread.sleep(60 * 1000);  
                } catch (InterruptedException e1) {  
                    log.error("{}", e1); 
                    System.out.println("{"+e1+"}");
                }  
                log.error("{}", e);  
                System.out.println("{"+e+"}");
            }  
        }  
    }  
}  