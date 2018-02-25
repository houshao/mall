package com.atguigu.threadAuxiliary;

import java.util.concurrent.Semaphore;
/*
 * 多个共享资源的互斥使用，并发线程数的控制
 */
public class TestSemaphore {

	public static void main(String[] args) {
		Semaphore sp = new Semaphore(2);
		
		for (int i = 0; i < 6; i++) {
		new Thread(() -> {
			//code
			System.out.println(Thread.currentThread().getName()+"号车入库");
			try {
				sp.acquire();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		},String.valueOf(i)).start();
		}
		
			sp.release();
	}

}
