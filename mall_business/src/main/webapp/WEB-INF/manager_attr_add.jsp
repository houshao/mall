<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<!-- <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>  title  </title>
</head>
<body>
<span>${name}属性添加页</span>
<form action="addattr.do" method="post">
	<input type="hidden" name="class2id"  value="${id }">
	<input type="hidden" name="class2name" value="${name }">
	<table border="1"> 
		<tr>
			<td>属性名:<input type="text" name="list[0].shxm_mch" ></td><td></td><td>添加值</td>
		</tr>
		<tr>
			<td>属性值:<input type="text" name="list[0].list_value[0].shxzh"></td><td>单位：<input type="text" name="list[0].list_value[0].shxzh_mch"></td><td>删除</td>
		</tr>
		<tr>
			<td>属性值:<input type="text" name="list[0].list_value[1].shxzh"></td><td>单位：<input type="text" name="list[0].list_value[1].shxzh_mch"></td><td>删除</td>
		</tr>
	</table>
	<br>
	<table border="1"> 
		<tr>
			<td>属性名:<input type="text" name="list[1].shxm_mch" ></td><td></td><td>添加值</td>
		</tr>
		<tr>
			<td>属性值:<input type="text" name="list[1].list_value[0].shxzh"></td><td>单位：<input type="text" name="list[1].list_value[0].shxzh_mch"></td><td>删除</td>
		</tr>
		<tr>
			<td>属性值:<input type="text" name="list[1].list_value[1].shxzh"></td><td>单位：<input type="text" name="list[1].list_value[1].shxzh_mch"></td><td>删除</td>
		</tr>
	</table>
	<input type="submit" value="提交">
	</form>

</body>
</html>