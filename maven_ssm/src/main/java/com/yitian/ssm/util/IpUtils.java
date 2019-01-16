package com.yitian.ssm.util;



import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class IpUtils {

//	public static void main(String[] args) {
//
//		System.out.println(IpUtils.getProvince("59.108.15.133"));
//	}

	public static String getProvince(String ip) {
		String url = "http://api.map.baidu.com/location/ip?ak=F454f8a5efe5e577997931cc01de3974&ip="
				+ ip;
		url= StringUtils.deleteWhitespace(url);
		// 1.创建HttpClient对象 这里使用默认的配置的httpclient
		CloseableHttpClient client = HttpClients.createDefault();
		// 2.创建某种请求方法的实例。这里使用get方法
		HttpGet httpGet = new HttpGet(url);
		InputStream inputStream = null;
		CloseableHttpResponse response = null;
		String result = "";
		try {
			// 3.执行请求，获取响应
			response = client.execute(httpGet);
			// 4.获取响应的实体内容，就是我们所要抓取得网页内容
			HttpEntity entity = response.getEntity();

			// 5.将其打印到控制台上面，这里使用EntityUtils（也可以用inputStream）
			if (entity != null) {
				String str = unicodeToString(EntityUtils.toString(entity,
						"utf-8"));
				JSONObject obj = JSONObject.fromObject(str);
				if (obj.get("status").toString().equals("0")) {
					JSONObject content = obj.getJSONObject("content");

					JSONObject array = content.getJSONObject("address_detail");

					result = array.get("province").toString();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6.关闭连接，释放资源（很重要）
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static String unicodeToString(String str) {

		Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
		Matcher matcher = pattern.matcher(str);
		char ch;
		while (matcher.find()) {
			// group 6728
			String group = matcher.group(2);
			// ch:'木' 26408
			ch = (char) Integer.parseInt(group, 16);
			// group1 \u6728
			String group1 = matcher.group(1);
			str = str.replace(group1, ch + "");
		}
		return str;
	}
	
	

}
