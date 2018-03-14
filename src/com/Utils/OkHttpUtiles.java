package com.Utils;

import java.io.IOException;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

//通用网络请求方法
public class OkHttpUtiles {
	// 获取网络的数据需要哪些东西?由用户提供给我们一个URL地址
	public static String Post(String url,RequestBody body) throws IOException {
		OkHttpClient okrequest = new OkHttpClient();
		// 链式编程法
		if (body != null) {
			Request request = new Request.Builder().post(body) // 设置请求方式
					.url(url) // 绑定数据源
					.build(); // 创建对象
			Response response = okrequest.newCall(request).execute();
			// 异常？程序运行，编写的时候，出现的错误
			if (response.isSuccessful()) {
				// 如果连接成功
				String jsonStr = response.body().string();
				// 过滤JSON中多余的数据
				String json = HttpUtil.delHTMLTag(jsonStr);
				return json;
			}
		}
		// 连接不成功，就返回null，表示没有连接成功，没有获取到数据
		return null;
	}
    
	public static String Get(String url) throws IOException{
		OkHttpClient okrequest = new OkHttpClient();
		// 链式编程
	    Request request = new Request.Builder().get()// 设置请求方式
					.url(url) // 绑定数据源
					.build(); // 创建对象
		Response response = okrequest.newCall(request).execute();
		// 异常？程序运行，编写的时候，出现的错误
		if (response.isSuccessful()) {
			// 如果连接成功
			String jsonStr = response.body().string();
			// 过滤JSON中多余的数据
			String json = HttpUtil.delHTMLTag(jsonStr);
			return json;
		}
		// 连接不成功，就返回null，表示没有连接成功，没有获取到数据
		return null;
	}
}
