package com.lifeng.benchmark;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * Created with IntelliJ IDEA.
 * User: lifeng
 * Date: 5/22/13
 * Time: 6:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class BenchmarkOption {
       Options benchmarkOption=new Options();
       public BenchmarkOption(){
           Option numberOfVisit=new Option("n","input the number of visit times of the same url,defalt is 1");
           Option currencyOfVisit=new Option("c","input the number of curency of visit the same url,defalt is 1");
           Option urlToVisit=new Option("u","input the number of url you will test,defalt is 0");
           benchmarkOption.addOption(numberOfVisit);
           benchmarkOption.addOption(currencyOfVisit);
           benchmarkOption.addOption(urlToVisit);
       }
}
