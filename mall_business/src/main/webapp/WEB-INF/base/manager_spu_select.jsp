<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<title>商品spu信息维护</title>
<script type="text/javascript">
	$(function(){
		$("#select_class1").append("<option>请选择</option>")
		$.getJSON(("js/json/class_1.js"),function(data){
			$(data).each(function(i,json){
				$("#select_class1").append("<option value="+json.id+">"+json.flmch1+"</option>")
				
			});
			
		});
	});
	
	function getClass2(class_1_id){
		$("#select_class2").append("<option>请选择</option>")
		$.getJSON(("js/json/class_1_"+class_1_id+".js"),function(data){
			$("#select_class2").empty();
			$(data).each(function(i,json){ 
				$("#select_class2").append("<option value="+json.id+">"+json.flmch2+"</option>")
			});
		});
		getClass3(class_1_id);
	};
	function getClass3(class_1_id){
		$("#select_class3").append("<option>请选择</option>")
		$.getJSON(("js/json/tm_class_1_"+class_1_id+".js"),function(data){
			$("#select_class3").empty();
			$(data).each(function(i,json){ 
				$("#select_class3").append("<option value="+json.id+">"+json.ppmch+"</option>")
			});
		});
	};
</script>
</head>
<body>

一级菜单：<select id="select_class1" name="flbh1" onchange="getClass2(this.value)"></select>
二级菜单:<select id="select_class2" name="flbh2"></select>
商标 <select id="select_class3" name="pp_id"></select><br>
<hr>
</body>
</html>