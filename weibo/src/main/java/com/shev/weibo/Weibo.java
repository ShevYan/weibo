package com.shev.weibo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


/**
 * Hello world!
 *
 */
public class Weibo 
{
    public static void main( String[] args )
    {
    	DefaultHttpClient httpClient = new DefaultHttpClient();
    	HttpGet post = new HttpGet("http://weibo.com/signup/signup.php?from=bp&lang=zh-cn");
//    	post.addHeader("client_id", "2339667422");
//    	post.addHeader("client_secret", "5d984b846d178f8863f8c82ef41ddc75");
//    	post.addHeader("grant_type", "authorization_code");
    	HttpResponse resp;
		try {
			resp = httpClient.execute(post);
			HttpEntity entity = resp.getEntity();
			BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8")); 
			String line = null;   
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			
			System.out.println(resp);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
