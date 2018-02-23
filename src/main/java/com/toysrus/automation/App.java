package com.toysrus.automation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception, IOException
   
    {
    	Properties prop=new Properties();
    	prop.load(new FileReader("./qa2.properties"));
    	System.out.println(prop.getProperty("tru"));
        System.out.println( "Hello World!" );
    }
}
