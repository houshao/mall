package com.atguigu.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
/**
 * 上传文件工具类
 * @param files
 * @return
 */
public class UploadUtil {
	/*
	 *上传图片
	 */
	public static List<String> upload_images(MultipartFile[] files) {
		List<String> list_image = new ArrayList<>();
		for (int i = 0; i < files.length; i++) {
			String image_name = System.currentTimeMillis()+files[i].getOriginalFilename();
			try {
//				System.out.println(MyPropertisUtil.getMyPath("imagePath.properties","image_path"));
				files[i].transferTo(new File(MyPropertisUtil.getMyPath("imagePath.properties","image_path")+"/"+image_name));
				list_image.add(image_name);
			} catch (IllegalStateException | IOException e) {
				System.err.println("文件上传错误");
				e.printStackTrace();
			}
		}
		return list_image;
	}

}
