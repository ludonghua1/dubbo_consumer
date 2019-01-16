package com.yitian;

import static org.junit.Assert.assertTrue;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
//    @Test
//    public void shouldAnswerWithTrue()
//    {
//        assertTrue( true );
//    }
    public static void main(String[] args) {
        String rest_url = "http://192.168.137.1:8080/car/rest/findUserByUsername.shtml?loginName=admin&email=15801159100@163.com";
        //创建一个httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //创建请求方法对象
        HttpGet get = new HttpGet(rest_url);
        //请求发送之后，对方的向应对象
        CloseableHttpResponse response = null;
        String result = "";
        HttpEntity entity = null;
        try {
            response = client.execute(get);
            //内容对象
            entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity,"utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
