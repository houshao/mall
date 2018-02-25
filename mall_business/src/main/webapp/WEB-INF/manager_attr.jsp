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
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>  title  </title>
</head>
<body>
<script type="text/javascript">
		function goto_attr_add(){
			var id = $("#select_class2").val();
			var name=$("#select_class2 option:selected").text();
			window.location.href="goaddattr.do?id="+id+"&name="+name;
		}
		function loadList(id){
			$("#attrlist").datagrid({
				queryParams:{
					id:id
				},
			    url:'attrvalue.do',
			    columns:[[
			        {field:'id',title:'属性编号',width:100},    
			        {field:'shxm_mch',title:'属性名称',width:100},    
			        {field:'chjshj',title:'创建时间',width:100,
			        	formatter: function(value,row,index){
							var name = new Date(value);
							return name.toLocaleString();
						}
			        },    
			        {field:'list_value',title:'属性和属性值信息',width:100,
			        	formatter: function(value,row,index){
			        		var name="";
							$(value).each(function(i,json){
								name=name+""+json.shxzh+json.shxzh_mch;
							});
							return name;
						}
					},    
			    ]]
			});
		};
</script>
<jsp:include page="/WEB-INF/base/manager_attr_select.jsp"></jsp:include>
<div id="attrlist"></div>
<a href="javascript:goto_attr_add()">添加属性</a>
</body>
</html>