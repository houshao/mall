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
		$.getJSON(("js/json/class_1.js"),function(data){
			$(data).each(function(i,json){
				$("#select_class1").append("<li onmouseover='getClass2(this.value)' value="+json.id+"><a href=''>"+json.flmch1+"</a></li>")
			});
		});
	});
	
	function getClass2(class_1_id){
		$.getJSON(("js/json/class_1_"+class_1_id+".js"),function(data){
			$("#select_class2").empty();
			$(data).each(function(i,json){
				$("#select_class2").append("<a href='loadList.do?id="+json.id+"'><li value="+json.id+">"+json.flmch2+"</li></a>")
			});
		});
	};
</script>
</head>
<body>
<div class="menu">
		<div class="nav">
			<div class="navs">
				<div class="left_nav">
					全部商品分类
					<div class="nav_mini">
						<ul  id="select_class1">
							<li>
								<a href="">家用电器</a>
								<div class="two_nav" id="select_class2">
								</div>
							</li>
							<li><a href="">手机、数码、通信</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
<hr>
</body>
</html>