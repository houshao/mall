package com.atguigu.gc;

import java.util.ArrayList;
import java.util.List;

public class TestGC {
	byte[] byteArray = new byte[1024*1024];
	
	public static void main(String[] args) {
		TestGC gc = new TestGC();
		
		int count = 0;
		List<TestGC> list = new ArrayList<>();
		try {
			while(true){
				list.add(gc);
				count++;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			System.out.println(count);
		}
		
		
	}
	public void OutOfMemoryError(){
		int[] arr = new int[1024*1024*10];
		System.out.println(arr);
	}
	public void ty(){
		long maxMemory = Runtime.getRuntime().maxMemory();//返回虚拟机视图使用的最大内存量
		long totalMemory = Runtime.getRuntime().totalMemory();//返回虚拟机中的内存总量
		System.out.println("MAX_MEMORY = " + maxMemory + "（字节）、" + (maxMemory / (double)1024 / 1024) + "MB");
		System.out.println("TOTAL_MEMORY = " + totalMemory + "（字节）、" + (totalMemory / (double)1024 / 1024) + "MB");
	}
}
