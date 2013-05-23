package com.lifeng.benchmark;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.ParseException;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: lifeng
 * Date: 5/13/13
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class BenchMark {
    public static void main(String[] args) throws InterruptedException {
        int n=1;
        int corruncy=1;
        int firstWeb=0;
        int urlNum=0;

        CommandLineParser parser=new BasicParser();
        try {
            CommandLine line=parser.parse(new BenchmarkOption().benchmarkOption,args);
            if (line.hasOption("n")) {
                n=Integer.parseInt(line.getOptionValue("n"));
                firstWeb+=2;
            }
            if(line.hasOption("c")){
                corruncy=Integer.parseInt(line.getOptionValue("c"));
                firstWeb+=2;
            }
            if(line.hasOption("u")){
                urlNum=Integer.parseInt(line.getOptionValue("u"));
                firstWeb+=2;
            }
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        CountDownLatch downLatch=new CountDownLatch(corruncy);


        Thread[] CurruncyVisits=new Thread[corruncy];
        for(int i=firstWeb;i<args.length;i++){
               for(int j=0;j<corruncy;j++){
                      CurruncyVisits[j]=new SocketHttpRequest(args[i],n,downLatch);
               }
        }
        //all subThread complish,then main thread run
       downLatch.await();
       System.out.println("compute complish");


    }
}
