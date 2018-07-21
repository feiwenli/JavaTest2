package com.hand;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.dom4j.*;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GetXML extends Thread{

    String result;

    GetXML(String result){
        this.result = result;
    }

    @Override
    public void run(){

        String [] list = result.split(",");

        StringBuffer name = new StringBuffer();


        for(int j=21; j<list[0].length(); j++) {
            char c = list[0].charAt(j);
            name.append(c);
        }

        double open = new Double(list[1]);
        double close = new Double(list[2]);
        double current = new Double(list[3]);
        double high = new Double(list[4]);
        double low = new Double(list[5]);


        String xmlString = "<xml><stock><name>"+name+"</name><open>"+open+"</open><close>"+close+"</close>" +
                "<current>"+current+"</current><high>"+high+"</high><low>"+low+"</low></stock></xml>";
        try {
            Document document = DocumentHelper.parseText(xmlString);
            String xml = document.asXML();

            File file = new File("tmp/股票编码.xml");

            if (file.exists()){
                file.delete();
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            bw.write(xml);
            bw.flush();
            bw.close();

            System.out.println("解析为xml成功！");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class GetJson extends Thread{

    String result;

    GetJson(String result){
        this.result = result;
    }

    @Override
    public void run(){

        String [] list = result.split(",");

        StringBuffer name = new StringBuffer();


        for(int j=21; j<list[0].length(); j++) {
            char c = list[0].charAt(j);
            name.append(c);
        }

        double open = new Double(list[1]);
        double close = new Double(list[2]);
        double current = new Double(list[3]);
        double high = new Double(list[4]);
        double low = new Double(list[5]);

        JsonObject lan1 = new JsonObject();
        lan1.addProperty("name", String.valueOf(name));
        lan1.addProperty("open",open);
        lan1.addProperty("close",close);
        lan1.addProperty("current",current);
        lan1.addProperty("high",high);
        lan1.addProperty("low",low);


//        System.out.println(lan1);
        File file = new File("tmp/股票编码.json");

        if (file.exists()){
            file.delete();
        }

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            bw.write(lan1.toString());
            bw.flush();
            bw.close();

            System.out.println("解析为json成功！");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}



public class App
{
    public static void main( String[] args )
    {
        HttpClient client = HttpClients.createDefault();
        Scanner in = new Scanner(System.in);
        System.out.println("请输入股票代码：");
        String str = in.next();

        String url = "http://hq.sinajs.cn/list="+str;

        System.out.println("股票编码:"+str);
        System.out.println("开始获取数据。。。。。。");
        HttpGet get = new HttpGet(url);

        HttpResponse response = null;
        try {
            response = client.execute(get);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity,"UTF-8");

            System.out.println("获取数据成功！");


            new GetXML(result).start();

            new GetJson(result).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
