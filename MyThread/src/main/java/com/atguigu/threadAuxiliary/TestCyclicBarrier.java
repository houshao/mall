package com.atguigu.threadAuxiliary;

import java.util.concurrent.CyclicBarrier;

/*
 * 所有的线程都达到一个屏障的时候，屏障就会开门。
 */
public class TestCyclicBarrier {
	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(6, ()->{System.out.println("恭喜，66大顺");});
		for (int i = 0; i < 6; i++) {
		new Thread(() -> {
			//code
			try {
			System.out.println(Thread.currentThread().getName()+"摇色子");
				cb.await();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		},String.valueOf(i)).start();
		}
	}
}
