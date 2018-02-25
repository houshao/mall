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
<script type="text/javascript">
	function b(){}
</script>
<title>  title  </title>
<script type="text/javascript">
	function goto_attr_add(){
		var id = $("#select_class2").val();
		var name=$("#select_class2 option:selected").text();
		window.location.href="goaddattr.do?id="+id+"&name="+name;
	}
</script>
</head>
<body>
	<%-- 
	<table>
		<c:forEach items="${attrList}" var="attr">
			<tr>
				<td>${attr.shxm_mch}</td>
				<c:forEach items="${attr.list_value}" var="value">
					<td>${value.shxzh }${value.shxzh_mch }</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	  --%>
	<div id="attrlist"></div>
	
	<a href="javascript:goto_attr_add()">添加属性</a>
</body>
</html>