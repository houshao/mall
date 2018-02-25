package com.atguigu.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LocksTo8 {
	public static void main(String[] args) {
		myThreads mt = new myThreads();
		//仅有两个线程
		/*new Thread(() -> {for (int i = 0; i < 5; i++) mt.increment();},"t1").start();
		new Thread(() -> {for (int i = 0; i < 5; i++) mt.decrement();},"t2").start();*/
		//有4个线程的时候
		new Thread(() -> {for (int i = 0; i < 5; i++) mt.increment();},"t1").start();
		new Thread(() -> {for (int i = 0; i < 5; i++) mt.decrement();},"t2").start();
		new Thread(() -> {for (int i = 0; i < 5; i++) mt.increment();},"t1").start();
		new Thread(() -> {for (int i = 0; i < 5; i++) mt.decrement();},"t2").start();
	}

}
/*
 * jdk1.8现在两个线程，
 * 可以操作初始值为零的一个变量，
 * 实现一个线程对该变量加1，一个线程对该变量减1，
 * 交替，来5轮，变量初始值为零。
 */
class myThreads{
	public int num = 0;
	ReentrantLock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	public void increment() {
		lock.lock();
		try {
		// 判断
		while(num!=0){
			condition.await();
		}
		//干活
		++num;
		System.out.println(Thread.currentThread().getName()+"num:"+num);
		//通知
		condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	public void decrement() {
		lock.lock();
		try {
			// 判断
			while(num==0){
				condition.await();
			}
			//干活
			--num;
			System.out.println(Thread.currentThread().getName()+"num:"+num);
			//通知
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
}