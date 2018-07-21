package com.hand;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String [] arga){


        try{
            ServerSocket ss = new ServerSocket(12345);

            File file = new File("Exam1/tmp/SampleChapter1.pdf");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            StringBuffer total = new StringBuffer();

            String line;
            while ((line = br.readLine())!=null) {
                total.append(String.valueOf(line));
                total.append("\n");
            }

            br.close();

            Socket s = ss.accept();
            System.out.println("connected!");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

            bw.write(total.toString());
            bw.flush();
            bw.close();


        }catch(IOException e){
            e.printStackTrace();
            System.out.println("程序运行错误："+e);
        }
    }
}
