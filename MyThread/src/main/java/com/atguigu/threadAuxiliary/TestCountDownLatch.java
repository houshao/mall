package com.atguigu.threadAuxiliary;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 其他的线程都执行完毕的时候，该线程才启用
 */
class MyThread{
	ReentrantLock lock = new ReentrantLock();
	
	public void loser(){
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+"国被灭了");
		} finally {
			lock.unlock();
		}
	}
	public void success(){
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+"秦国同一六国了");
		} finally {
			lock.unlock();
		}
	}
}
/*
 * 七国争霸 ，需要灭掉六国，秦国才能同一
 */
public class TestCountDownLatch {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch cd = new CountDownLatch(6);
		MyThread mt = new MyThread();
		for (int i = 1; i <= 6; i++) {
			new Thread(() -> {
				//code
				mt.loser();
				cd.countDown();
			},Country.getCountry(i).getCountryName()).start();
		}
		cd.await();
		new Thread(() -> {
			//code
			mt.success();
		}).start();
	}

}
