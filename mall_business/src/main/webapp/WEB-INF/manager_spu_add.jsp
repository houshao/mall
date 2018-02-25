<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<meta charset="UTF-8">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script> -->
<title>商品spu信息维护</title>

</head>
<body>
<script type="text/javascript">

	function img_click(index){
		$("#image_upload_file_"+index).click();
	}
	function file_change(index){
		//获取缓存
		var file = $("#image_upload_file_"+index)[0].files[0];
		//转换成js的url对象
		var url = window.URL.createObjectURL(file);
		//把参数复制给image对象
		$("#image_file_"+index).attr("src",url);
		var length = $(":file").length;
		if(length==index+1){
		add_img(index);
		}
	}
	function add_img(index){
		$("#test").append('<img alt="" id="image_file_'+(index+1)+'" src="upload/image/1.jpg" onclick="img_click('+(index+1)+')">');
		$("#test").append('<input id="image_upload_file_'+(index+1)+'" type="file"  name="files" onchange="file_change('+(index+1)+')"><br>');
	}
</script>
<h3>商品spu信息添加</h3>
<form action="spuadd.do" method="post" enctype="multipart/form-data">
<jsp:include page="/WEB-INF/base/manager_attr_select.jsp"></jsp:include>
商品名称：<input id="sphmc" name="shp_mch" type="text"><br>
商品介绍：<textarea id="sphjs" name="shp_msh" rows="" cols=""></textarea><br>

<img alt="" id="image_file_0" src="upload/image/1.jpg" onclick="img_click(0)" style="cursor:pointer">
<input id="image_upload_file_0" type="file"  name="files" onchange="file_change(0)"><br>
<div id="test"> </div>
<input type="submit" value="添加"><br>
</form>

</body>
</html>