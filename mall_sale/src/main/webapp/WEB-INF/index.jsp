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
<link rel="stylesheet" type="text/css" href="css/css.css">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/css.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
</script>
<title></title>
<body>
	<jsp:include page="sale_head.jsp"></jsp:include>
	
	<div class="search">
	<jsp:include page="sale_seach_area.jsp"></jsp:include>
	<jsp:include page="sale_miniCart.jsp"></jsp:include>
	</div>
	<jsp:include page="sale_seach_select.jsp"></jsp:include>
	
	<jsp:include page="sale_footer.jsp"></jsp:include>
</body>
</html>