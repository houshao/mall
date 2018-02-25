<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script> -->
<title>sku manager</title>

</head>
<body>
<script type="text/javascript">
	function loadSkuList(id){
		$.post("sku.do",{id:id},
			function(data){
				$("#skuview").html(data);
			});
		}
</script>
<jsp:include page="/WEB-INF/base/manager_sku_select.jsp"></jsp:include>
<div id="skuview"></div>
</body>
</html>