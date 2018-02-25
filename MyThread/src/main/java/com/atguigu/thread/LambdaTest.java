package com.atguigu.thread;


/*
 * Lambda表达式的练习
 */
public class LambdaTest {
	
	public static void main(String[] args) {
		/*
		 List<String> list = new ArrayList<>();
		 list.add("123");
		 list.add("abc");
		 list.forEach(System.out::println);
		 list.forEach(n -> System.out.println(n)); 
		 */
		 
		 
		//调用测试的接口
		 Person p = ()->{System.out.println("123");};
		 p.say();
	}

}
interface Person{
	
	 void say();
	 //可以写 默认权限的方法
	 default void test1(){
		 
	 }
	//还可以写静态的方法
	public static void test(){
	}
	
}
