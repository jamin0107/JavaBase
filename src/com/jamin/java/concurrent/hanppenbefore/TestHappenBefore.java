package com.jamin.java.concurrent.hanppenbefore;
/**
 * http://www.blogjava.net/xylz/archive/2010/07/03/325168.html
 * @author Jamin
 *
 */
public class TestHappenBefore {

	  static volatile int x = 0, y = 0, a = 0, b = 0; 

	    public static void main(String[] args) throws Exception { 

	        for (int i = 0; i < 1100; i++) {
	            x=y=a=b=0;
	            Thread one = new Thread() {
	                public void run() {
	                    a = 1;
	                    x = b;
	                }
	            };
	            Thread two = new Thread() {
	                public void run() {
	                    b = 1;
	                    y = a;
	                }
	            };
	            one.start();
	            two.start();
	            one.join();
	            two.join();
//	            if(x==1 && y==1){
//	            	  System.out.println(x + "---------------" + y);
//	            }else{
	            System.out.println(x + " " + y);
//	            }
	        }
	    } 
	
}
