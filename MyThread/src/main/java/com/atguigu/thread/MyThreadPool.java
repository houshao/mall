package com.atguigu.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/*
 * 1个银行5个受理窗口，接受15个客户来办理业务
 */
public class MyThreadPool {
	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
		ScheduledFuture<Integer> result =null;
		try {
			for (int i = 0; i < 15; i++) {
				 result = service.schedule(()->{
					 System.out.println(Thread.currentThread().getName());
					 return new Random().nextInt(10);
				}, 2, TimeUnit.SECONDS);
				System.out.println(result.get());
			}
		} catch (Exception e) {
		} finally {
			service.shutdown();
		}
	}
	
	public void test1(){
		ExecutorService service = Executors.newCachedThreadPool();
//		ExecutorService service = Executors.newSingleThreadExecutor();
//		ExecutorService service = Executors.newFixedThreadPool(5);// 一池多线程
		Future<Integer> result = null;
			try {
				for (int i = 0; i < 15; i++) {
					result = service.submit(() -> {
						System.out.println(Thread.currentThread().getName());
						return new Random().nextInt(10);
					});
					System.out.println(result.get());
				}
			} catch (Exception e) {
			} finally {
				service.shutdown();
			}
	}
}
