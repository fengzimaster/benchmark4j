package com.lifeng.benchmark;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: lifeng
 * Date: 5/14/13
 * Time: 6:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class SocketHttpRequest extends Thread {
    private String url;
    private int n;
    public TimeStatic[] timeStatics;
    private CountDownLatch downLatch;

    public SocketHttpRequest(String url,int n,CountDownLatch downLatch){
        this.url=url;
        this.n=n;
        this.timeStatics=new TimeStatic[n];
        this.downLatch=downLatch;
       // super.setName(url);
    }

    @Override
    public void run() {
        //To change body of implemented methods use File | Settings | File Templates.
        for(int i=0;i<n;i++) {
        try {
            timeStatics[i].setUrl(url);
            URL urlconnection = new URL(url);
            String host=urlconnection.getHost();
            int port=urlconnection.getPort()==-1 ? urlconnection.getDefaultPort():urlconnection.getPort();
            String path=urlconnection.getPath();

            //make http request
            StringBuffer sb =new StringBuffer();
            sb.append("GET / HTTP/1.1\r\n");
            sb.append("Host: "+host+":"+port+"\r\n");
            // add a \r\n to complete the request
            sb.append("\r\n");

            //begin connect time
            //start of connect
            timeStatics[i].setConnectStartTime(System.nanoTime());
            Socket client = new Socket(host,port);
            //end of connect
            timeStatics[i].setConnectEndTime(System.nanoTime());
            OutputStreamWriter request = new OutputStreamWriter(client.getOutputStream());
            //start writetime
            timeStatics[i].setWriteRequestTime(System.nanoTime());
            request.write(sb.toString());
            request.flush();
            //end write
            InputStream clientInputStream=client.getInputStream();
            //responce time
            timeStatics[i].setResponceTime(System.nanoTime());
            BufferedReader read = new BufferedReader(new InputStreamReader(clientInputStream));
            String[] line=read.readLine().split(" ");
            //read time and send time

            timeStatics[i].setStatus(line[1]);
            client.close();
            this.downLatch.countDown();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        }
    }
}
