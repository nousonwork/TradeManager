package com.tradesmanager.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Test {

	public static void main(String args[]) {
		/*
		 * ExecutorService service = Executors.newFixedThreadPool(10);
		 * IntStream.range(0, 100).forEach(i -> service.submit( () ->
		 * System.out.println("Task ID : " + i + " performed by " +
		 * Thread.currentThread().getName())));
		 */
		
		ExecutorService service = Executors.newFixedThreadPool(10);
	    IntStream.range(0, 100).forEach(i -> service.submit(new Task(i)));
		
	}

	

	public static void main_1(String[] args) {

		String str1 = "T21";
		String str2 = "T22";
		String str3 = "T21";

		int var1 = str1.compareTo(str2);
		System.out.println("str1 & str2 comparison: " + var1);

		int var2 = str1.compareTo(str3);
		System.out.println("str1 & str3 comparison: " + var2);

		int var3 = str2.compareTo(str3);
		System.out.println("str2 & str3 " + var3);

	}

}


final class Task implements Runnable {
	private int taskId;

	public Task(int id) {
		this.taskId = id;
	}

	@Override
	public void run() {
		System.out.println("Task ID : " + this.taskId + " performed by " + Thread.currentThread().getName());
	}
}
