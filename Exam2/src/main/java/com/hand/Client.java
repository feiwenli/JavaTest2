package com.hand;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String [] arga){
        try {
            Socket s = new Socket("127.0.0.1",12345);

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine())!=null){
                sb.append(line);
            }
            br.close();

            File file = new File("Exam2/tmp/SampleChapter1.pdf");
            if (file.exists()){
                file.delete();
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            bw.write(sb.toString());
            bw.flush();
            bw.close();



        }catch(ConnectException connExc){
            System.out.println("连接失败！");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
