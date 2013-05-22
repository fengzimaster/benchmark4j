package BenchmarkInJava;

import com.lifeng.benchmark.SocketHttpRequest;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        System.out.println( "Hello World!" );
         Long startTime=System.nanoTime();
         Thread.sleep(20);
         long endTime=System.nanoTime();
        System.out.println(endTime-startTime);
        SocketHttpRequest b=new SocketHttpRequest("www",5);
        int i=b.timeStatics.length;
        System.out.println(i);
    }
}
