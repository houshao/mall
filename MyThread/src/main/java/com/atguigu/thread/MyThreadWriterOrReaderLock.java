package com.atguigu.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyResource{
		private String str = null;
//		ReentrantLock lock = new ReentrantLock();//重入锁
//		Condition condition = lock.newCondition();//状态
		ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();//读写锁的对象
		
		public void writer(String str){
			readWriteLock.writeLock().lock();
			try {
				this.str = str;
				System.out.println(Thread.currentThread().getName()+"str:"+str);
			} catch (Exception e) {
			} finally {
			readWriteLock.writeLock().unlock();
			}
		}
		public void reader(){
			readWriteLock.readLock().lock();
			try {
				System.out.println(Thread.currentThread().getName()+"str:"+str);
			} catch (Exception e) {
			} finally {
				readWriteLock.readLock().unlock();
			}
		}
		
}
/**
 * 
 * @author zhouyang
 *读写锁
 *一个线程写，100个线程读取
 */
public class MyThreadWriterOrReaderLock {
	public static void main(String[] args) {
		MyResource s = new MyResource();
		new Thread(() -> {
			//code
			s.writer("测试一下");
		},"11111111").start();
		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				//code
				s.reader();
			},String.valueOf(i)).start();
		}
	}
}
