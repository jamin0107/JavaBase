package com.jamin.java.concurrent.hanppenbefore;

public class TestJoin implements Runnable{  
	  
	@Override
  public void run() {  
      for (int k = 0; k < 10; k++) {  
      	a = a + 1;
      	System.out.println("a = " + a);
      }  
  }  
	public static int a = 0;  
	 
	public static void main(String[] args) {
		Runnable r = new TestJoin();
	        Thread t = new Thread(r);  
	        t.start();     
	        try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println(a);  
	}	
	
	
}


class JoinRunnable implements Runnable{  
	  
	@Override
    public void run() {  
        for (int k = 0; k < 10; k++) {  
        	TestJoin.a = TestJoin.a + 1;  
        }  
    }  
}