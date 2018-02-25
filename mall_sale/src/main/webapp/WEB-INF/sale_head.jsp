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
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function(){
		var yh_nch = get_cookie_value("user");
		$("#test").html(yh_nch);
		
	});
	function get_cookie_value(key){
		var value="";
		var cookies = document.cookie;
		cookies.replace(" ","")
		var cookarr = cookies.split(";");
		for ( i = 0; i < cookarr.length; i++) {
			var cookie = cookarr[i].split("=");
			if(cookie[0]=key){
				value =  cookie[1];
			}
		}
		var return_value = decodeURIComponent(value); //解码
		return return_value;
	};
</script>
<title></title>
<body>
<div class="top">
	<div class="top_text">
		<%-- <c:if test="${empty user }">
		<span id="test">
		</span>请<a href="gologin.do">登陆</a>
		</c:if> --%>
		<c:if test="${!empty user }">
		欢迎：<span id="test"></span>
		<a href="loginout.do">注销</a>
		</c:if>
		<a href="">用户注册</a>
		<a href="">供应商登录</a>
		<a href="">供应商注册</a>
	</div>
</div>
<div class="top_img">
		<img src="./images/top_img.jpg" alt="">
</div>


<br>
</body>
</html>