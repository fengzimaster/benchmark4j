package com.lifeng.benchmark;

import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: lifeng
 * Date: 5/13/13
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class BenchMark {
    public static void main(String[] args) {
        int n=1;
        int corruncy=1;
        int firstWeb=0;
        if (args.length>1&&args[0].equals("-n")) {
            n=Integer.parseInt(args[1]);
            firstWeb += 2;
        }
        if(args.length>3&&args[2].equals("-c")){
           corruncy=Integer.parseInt(args[3]);
            firstWeb +=2;
        }
        for(int i=firstWeb;i<args.length;i++){
               for(int j=0;j<corruncy;j++){
                      new SocketHttpRequest(args[i],n);
               }
        }




    }
}
