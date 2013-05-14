package com.lifeng.benchmark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: lifeng
 * Date: 5/14/13
 * Time: 6:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class SocketHttpRequest extends Thread {
    private String url;
    public SocketHttpRequest(String url){
        this.url=url;
    }
    @Override
    public void run() {
        //To change body of implemented methods use File | Settings | File Templates.
          System.out.println(url);

        try {
            URL urlconnection = new URL(url);
            String host=urlconnection.getHost();
            int port=urlconnection.getPort()==-1 ? urlconnection.getDefaultPort():urlconnection.getPort();
            String path=urlconnection.getPath();
            //构造http request
            StringBuffer sb =new StringBuffer();
            sb.append("GET / HTTP/1.1\r\n");
            sb.append("Host: "+host+":"+port+"\r\n");
            //注，这是关键的关键，忘了这里让我搞了半个小时。这里一定要一个回车换行，表示消息头完，不然服务器会等待
            sb.append("\r\n");
            Socket client = new Socket(host,port);
            OutputStreamWriter request = new OutputStreamWriter(client.getOutputStream());
            request.write(sb.toString());
            request.flush();
            BufferedReader read = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String[] line=read.readLine().split(" ");
            System.out.println(line[1]);
            client.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    public static void main(String[] args){
        new SocketHttpRequest("hello").start();
        new SocketHttpRequest("world").start();
    }
}
