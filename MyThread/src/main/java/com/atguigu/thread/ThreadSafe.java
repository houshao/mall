package com.atguigu.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
public class ThreadSafe {

	public static void main(String[] args) {
		

		/*List<String> list = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			new  Thread(() -> {
				list.add(i, UUID.randomUUID().toString());
			},String.valueOf(i)).start();
		}
		System.out.println(list);*/
		
		List<String> list =new ArrayList<String>(); // new CopyOnWriteArrayList<String>();//
		
		for (int i = 1; i <=30; i++) 
		{
			new Thread(() -> {
				list.add(UUID.randomUUID().toString().substring(0,4));//320x
				System.out.println(list);
			},String.valueOf(i)).start();
		}
		//java.util.ConcurrentModificationException 	写时复制
	}
	
	public void ArrayList(){
		
	}
	
	public void HashSet(){
		
	}
	
	public void HahsMap(){
		
	}
	
}
