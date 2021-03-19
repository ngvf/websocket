package com.jr.mw;

import org.springframework.beans.factory.annotation.Autowired;

import com.jr.mw.server.WebSocket;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    @Autowired
    private static WebSocket webSocket;

	public static void sendToWeb() {
		WebSocket webSocket1=new WebSocket();
		webSocket1.sendMessage("行不");
		
	}
    
	 public static void main(String[] args) {
		 sendToWeb();
	   }
	
	
}
