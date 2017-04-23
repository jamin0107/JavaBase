package com.jamin.java.concurrent.future;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {

	
	public static class Task implements Callable<String>{

		@Override
		public String call() throws Exception {
			String tid = String.valueOf(Thread.currentThread().getId());
//			System.out.printf("Thread# ---%s : in call \n" , tid);
			int millisond = new Random().nextInt(5000);
			Thread.sleep(millisond);
			
			System.out.printf("Thread# --- %s : job down in %d millsecond \n" , tid , millisond);
			
			return tid + " cost " + millisond + "ms" ;
		}
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		List<Future<String>> results = new ArrayList<>();
		ExecutorService excutorService = Executors.newCachedThreadPool();
		for(int i = 0 ; i <= 30 ; i++){
			results.add(excutorService.submit(new Task()));
		}
		System.out.println("--!!!-----!!!----");
		for(Future<String> result : results){
			try {
				System.out.println(result.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
