package com.atguigu.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ExchangeNumTest {

	public static void main(String[] args) {
		
		MyThread2 mt = new MyThread2();
		/*
		 * 只有一个增加方法一个减少方法
		 
		new Thread(() -> {
			try {
				for (int i = 0; i < 5; i++) {
					mt.increment();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		},"t1").start();
		new Thread(() -> {
			try {
				for (int i = 0; i < 5; i++) {
					mt.decrement();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		},"t2").start();
		*/
		
		/*
		 * 两个添加方法，两个减少方法
		 */
		new Thread(() -> {
			for (int i = 0; i < 5; i++)
				try {
					mt.increment();
				} catch (Exception e) {
				}
		},"t1").start();
		new Thread(() -> {
			for (int i = 0; i < 5; i++)
				try {
					mt.increment();
				} catch (Exception e) {
				}
		},"t2").start();
		new Thread(() -> {
			for (int i = 0; i < 5; i++)
				try {
					mt.decrement();
				} catch (Exception e) {
				}
		},"t3").start();
		new Thread(() -> {
			for (int i = 0; i < 5; i++)
				try {
					mt.decrement();
				} catch (Exception e) {
				}
		},"t4").start();
	}

}
class MyThread2{
	/*
	 * 现在两个线程，
	 * 可以操作初始值为零的一个变量，
	 * 实现一个线程对该变量加1，一个线程对该变量减1，
	 * 交替，来5轮，变量初始值为零。
	 */
	public int num = 0;
	
	public synchronized void increment() throws InterruptedException{
		ReentrantLock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
//		condition.await();
//		condition.signalAll();
		//判断
		while(num!=0){
			this.wait();
		}
		//干活
		++num;
		System.out.println(Thread.currentThread().getName()+",num:"+num);
		//通知
		this.notifyAll();
	}
	public synchronized void decrement() throws InterruptedException{
		//判断
		while(num==0){
			this.wait();
		}
		//干活
		--num;
		System.out.println(Thread.currentThread().getName()+",num:"+num);
		//通知
		this.notifyAll();
	}
	
}
