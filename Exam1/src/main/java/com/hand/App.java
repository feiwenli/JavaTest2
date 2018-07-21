package com.hand;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class App
{
    public static void main( String[] args )
    {
        try {
            URL url = new URL("http://192.168.11.205:18080/trainning/SampleChapter1.pdf");
            URLConnection connection = url.openConnection();

            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is,"UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine())!=null){
                builder.append(line);
            }

            br.close();
            isr.close();
            is.close();
            
            new File("Exam1/tmp").mkdir();
            new File("Exam2/tmp").mkdir();
            new File("Exam3/tmp").mkdir();

            File file = new File("Exam1/tmp/SampleChapter1.pdf");
            if (file.exists()){
                file.delete();
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            bw.write(builder.toString());
            bw.flush();
            bw.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
