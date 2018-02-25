package com.atguigu.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("come in call.");
		Thread.sleep(5000);
		return 200;
	}
	
}
/*
 * Callable接口实现多线程
 */
public class CallableTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
//		FutureTask<Integer> ft = new FutureTask<>(new MyThread());
//		new Thread(ft, "t01").start();
//		new Thread(()->{System.out.println("123");}).start();
		new Thread(()->{System.out.println("123");return ;} ).start();
		
//		Integer i = ft.get();
//		System.out.println(i);
		

	}

}
