package com.atguigu.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 线程  操作 资源类
 */
class MyThreada{
	private int number = 0 ;
	ReentrantLock lock = new ReentrantLock();
	Condition c1 = lock.newCondition();
	Condition c2 = lock.newCondition();
	Condition c3 = lock.newCondition();
	public void printA(int num){
		lock.lock();
		try {
			//判断
			while(number!=0){
					c1.await();
			}
			//干活
				for (int i = 0; i < 5; i++) {
					System.out.println(Thread.currentThread().getName()+"A，轮数："+num);
				}
			//通知
			number = 1;
			c2.signal();
		} catch (Exception e) {

		} finally {
			lock.unlock();
		}
	}
	public void printB(int num){
		lock.lock();
		try {
			//判断
			while(number!=1){
				c2.await();
			}
				//干活
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName()+"B，轮数："+num);
				}
				//通知
				number = 2;
				c3.signal();	
		} catch (Exception e) {
			
		} finally {
			lock.unlock();
		}
	}
	public  void printC(int num){
		lock.lock();
		try {
			//判断
			while(number!=2){
				c3.await();
			}
				//干活
				for (int i = 0; i < 15; i++) {
					System.out.println(Thread.currentThread().getName()+"C，轮数："+num);
				}
				//通知
				number = 0;
				c1.signal();	
			
		} catch (Exception e) {
			
		} finally {
			lock.unlock();
		}
	}
	
}
/*
 * 三个线程，1线程先打印5个A，2线程再打印10个B，3线程在打印15个C
 */
public class ThreadPolling {

	public static void main(String[] args) {
		MyThreada mt = new MyThreada();
		
		new Thread(() -> {
			//code
			for (int i = 0; i < 10; i++) {
				mt.printA(i);
			}
		},"t1").start();
		new Thread(() -> {
			//code
			for (int i = 0; i < 10; i++) {
				mt.printB(i);
			}
		},"t2").start();
		new Thread(() -> {
			//code
			for (int i = 0; i < 10; i++) {
				mt.printC(i);
			}
		},"t3").start();
	}
	
}
