package BenchmarkInJava;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: lifeng
 * Date: 5/14/13
 * Time: 5:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class URLParser {
    private URL url;

    public URLParser(String urlString) throws MalformedURLException {
        url=new URL(urlString);
    }

    public String getHost() throws MalformedURLException {

        return url.getHost();
    }
    public int getPort() throws MalformedURLException {
        int port= url.getPort();
        return port==-1 ? url.getDefaultPort():port;
    }
    public String getRequestPath() {
        return  url.getPath();
    }
    public static void main(String[] args) throws MalformedURLException {
        URLParser urlParser=new URLParser("http://localhost/");
        System.out.println(urlParser.getHost());
        System.out.println(urlParser.getPort());
        System.out.println(urlParser.getRequestPath());
    }

}
