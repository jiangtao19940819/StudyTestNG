package com.jt.qa;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author: jiangtao
 * @create: 2020/1/4
 * @description: TestHttpClient
 **/

public class TestHttpClient {
    private String url = "http://localhost:8888";
    private CloseableHttpClient client = null;
    private Logger logger = Logger.getLogger(this.getClass().getName());
    @BeforeClass
    public void setUp(){
         client = HttpClients.createDefault();
         logger.info("创建连接client成功");
    }
    @AfterClass
    public void tearDown() throws Exception{
        if(client != null){
            client.close();
        }
        logger.info("测试完毕，关闭连接");

    }
    @Test
    public void testHttpGet() throws Exception{
        client = HttpClients.createDefault();
        HttpGet request = new HttpGet(url+"/project/getAll");
        //request.setHeader();
        HttpResponse response = client.execute(request);
        String res = EntityUtils.toString(response.getEntity());
        logger.info("请求/project/getAll返回:{}"+res);
        Assert.assertTrue(res.contains("result"));

    }

    @Test
    public void testHttpPostJson() throws Exception{
        String requestBaowen = getProjectData();
        HttpPost request = new HttpPost(url+"/project/create");
        request.setHeader("Content-Type","application/json");
       StringEntity entity = new StringEntity(requestBaowen,"utf-8");
       request.setEntity(entity);
       HttpResponse response = client.execute(request);
       String res = EntityUtils.toString(response.getEntity());
       logger.info("请求/project/create返回："+res);
       Assert.assertTrue(res.contains("200"));

    }

    @Test
    public void testHttpPostForm() throws Exception{
        HttpPost request = new HttpPost(url+"/project/query");
        List<BasicNameValuePair> alist= new ArrayList<>();
        alist.add(new BasicNameValuePair("serch","yunguan"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(alist);
        request.setEntity(entity);
        HttpResponse response = client.execute(request);
        String res = EntityUtils.toString(response.getEntity());
        logger.info("请求/project/query返回："+res);
        Assert.assertTrue(res.contains("200"));
    }
    public String getProjectData(){
        int randomNum = (int)(Math.random()*100);
        HashMap<String,String> map= new HashMap<String,String>();
        map.put("projectName","BO"+randomNum);
        map.put("projectDescription","BO"+randomNum);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(map);
        return jsonStr;
    }


}
