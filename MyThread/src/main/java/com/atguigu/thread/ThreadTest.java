package com.atguigu.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 卖票问题
 * 线程、操作、资源类
 * 低耦合、高内聚
 */
public class ThreadTest extends Thread{
	
	public static void main(String[] args) {
		Ticket t = new Ticket();
		Tickets ts = new Tickets();
		int num = 300;
		/*
		//普通实现
		new Thread(t,"1").start();
		new Thread(t,"2").start();
		new Thread(t,"3").start();
		
		//匿名内部类实现
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 300; i++) {
					System.out.println(Thread.currentThread().getName()+"卖出了第"+i+"张票,剩余"+(300-i)+"票");
				}
			}
		}).start();
		 */
		
		//Lamda表达式实现
		new Thread(()->{for (int i = 0; i < num; i++) ts.sale();},"s3").start();
		//匿名内部类实现
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < num; i++) {
					ts.sale();
				}
			}
		},"s1").start();
		
	}
}

/*
 *1.8之后的新实现	
 */
class Tickets{
	Lock lock = new ReentrantLock();
	private int num = 300;
	public void sale(){
		lock.lock();
		try {
			if(num>0){
				System.out.println(Thread.currentThread().getName()+"卖出了第"+num+"张票,剩余"+--num+"票");
				Thread.sleep(60);
				}
			}catch(Exception e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}	
}

/*
 * 1.8之前的普通实现
 */
class Ticket implements Runnable{
	private int num = 300;
	@Override
	public void run() {
		try {
			while(true){
				Thread.sleep(300);
				if(num<=0){
					break;
				}
				synchronized(this){
					System.out.println(Thread.currentThread().getName()+"卖了一张票，还剩下："+--num+"张");
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}