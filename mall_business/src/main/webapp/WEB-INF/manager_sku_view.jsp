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
<script type="text/javascript">
	function showRedio(attrid,checked){
		if(checked){
			$("#value_"+attrid).show();
		}else{
			$("#value_"+attrid).hide();
		}
	}
	function getshpid(shp_id){
		$("#shpid").val(shp_id);
	}
</script>
	<form action="addsku.do">
	<c:forEach items="${attrAndValueList}" var="attr" varStatus="index">
		${attr.shxm_mch}<input type="checkbox" name="list[${index.index}].shxm_id" value="${attr.id }" onchange="showRedio(${attr.id },this.checked)" />
	</c:forEach>
	<hr>
	<c:forEach items="${attrAndValueList}" var="attr" varStatus="index">
		<div  id="value_${attr.id }" style="display:none;">
		<c:forEach items="${attr.list_value}" var="value">
			<input type="radio" name="list[${index.index}].shxzh_id" value="${value.id }">${value.shxzh }${value.shxzh_mch }
		</c:forEach><br>
		</div>
	</c:forEach>
	<hr>
	<input type="hidden" id="shpid" name="shp_id">
	商品库存名称：<input type="text" name="sku_mch" ><br>
	商品库存数量：<input type="text" name="kc" ><br>
	商品库存价格：<input type="text" name="jg" ><br>
	商品库存地址：<input type="text" name="kcdz" ><br>
	<input type="submit" value="提交"><br>
	</form>
</body>
</html>