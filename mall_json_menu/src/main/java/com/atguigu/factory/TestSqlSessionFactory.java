package com.atguigu.factory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.atguigu.bean.T_MALL_CLASS_1;
import com.atguigu.bean.T_MALL_CLASS_2;
import com.atguigu.bean.T_MALL_TRADE_MARK;
import com.atguigu.mapper.ClassMapper;
import com.google.gson.Gson;

public class TestSqlSessionFactory {
	public static void main(String[] args) throws IOException {
		getClass2();
//		getClass1();
//		select_trade_markByClass_1_id();
		select_spu_ByClass_1_id();
	}
	/*
	 * 获取一级菜单
	 */
	public static void getClass1() throws IOException{
		SqlSessionFactory myFactory = MySqlSessionFactory.getMyFactory();
		  Gson gson = new Gson();
		  ClassMapper mapper = myFactory.openSession().getMapper(ClassMapper.class);
		  List<T_MALL_CLASS_1> class_1 = mapper.select_class_1();
		  String json = gson.toJson(class_1);
		  outPutWriter(json, "1");
	}
	/*
	 * 获取二级菜单
	 */
	public static void getClass2() throws IOException{ 
		SqlSessionFactory myFactory = MySqlSessionFactory.getMyFactory();
		  Gson gson = new Gson();
		  ClassMapper mapper = myFactory.openSession().getMapper(ClassMapper.class);
		  List<T_MALL_CLASS_1> class_1 = mapper.select_class_1();
		  for (T_MALL_CLASS_1 list : class_1) {
			  List<T_MALL_CLASS_2> class_2 = mapper.select_class_2ByClass_1_id(list.getId());
			  String name = Integer.toString(list.getId());
			  outPutWriter(gson.toJson(class_2),name);
		  }
	}
		/*
		 * 获取商标
		 */
		public static void select_trade_markByClass_1_id() throws IOException{
			SqlSession session = MySqlSessionFactory.getMySession();
			ClassMapper mapper = session.getMapper(ClassMapper.class);
			List<T_MALL_CLASS_1> class1 = mapper.select_class_1();
			for (T_MALL_CLASS_1 list1 : class1) {
				List<T_MALL_TRADE_MARK> list = mapper.select_trade_markByClass_1_id(list1.getId());
				 Gson gson = new Gson();
				 String json = gson.toJson(list);
				 String name=Integer.toString(list1.getId());
				outPutWriter(json, name);
			}
		}
			/*
			 * 获取商品信息
			 */
			public static void select_spu_ByClass_1_id() throws IOException{
				SqlSession session = MySqlSessionFactory.getMySession();
				ClassMapper mapper = session.getMapper(ClassMapper.class);
				List<T_MALL_CLASS_1> class1List = mapper.select_class_1();
				for (T_MALL_CLASS_1 class1 : class1List) {
					List<T_MALL_TRADE_MARK> list = mapper.select_trade_markByClass_1_id(class1.getId());
					for (T_MALL_TRADE_MARK marklist : list) {
						List<T_MALL_TRADE_MARK> spulist = mapper.select_spu_ByTrade_mark(marklist.getId());
						Gson gson = new Gson();
						String json = gson.toJson(spulist);
						String name = Integer.toString(marklist.getId());
						outPutWriter(json, name);
					}
					
				}
			
		}
	/*
	 * 公共的写出到磁盘上的方法
	 */
	public static void outPutWriter(String json ,String name) throws IOException{
//		 	Gson gson = new Gson();
//		 	String json = gson.toJson(list);
		 	
		  FileOutputStream outputStream = new FileOutputStream(new File("i:/spu_"+name+".js"));
		  try {
			outputStream.write(json.getBytes("utf-8"));
		  } catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		  }  finally {
			outputStream.close();
		}
	}

}
