package com.jr.mw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan("com.jr.mw.*") //扫描mw以下的所有包
public class App 
{
    public static void main(String[] args)
    {
    	  SpringApplication.run(App.class, args);
    }
    
}
