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
	//取消选定
	function down(index){
		$("#a"+index).remove();
		$("#"+index).show();
		attr_seach();
	}
	//多选的提交
	function submit(i){
	 var sxz_id = "";//属性值id的字符串
	 var sx_id = $(".checkbox_sxid"+i+"").val();//属性id
	 var sxz="";//属性值
// 	 var shdw = "";
	 var sxzdw = $(".checkbox_sxzdw"+i+"").val();
	 
	 var sxzid = $(".checkbox"+i+"");
	 var sxz = $(".checkbox_sxz"+i+"").val();
	 
	 $(".checkbox"+i+"").each(function(i,json){
		 sxz_id = sxz_id +","+ json.value;
		 sxz_id = sxz_id.substr(1);
	 });
	 sxz_id = "\""+sxz_id+"\"";
	  for ( f = 0; f < $(".checkbox_sxz"+i+"").size(); f++) {
		 sxz = sxz + ","+$(".checkbox_sxz"+i+"")[f].value  ;
		 sxz = sxz.substr(1);
	 }
	seah(sxz_id,sxz,sx_id,sxzdw,i);
	  
	  
	}
	//选定   		  属性值id 属性值     属性id   属性单位       索引
	function seah(attrid,value,attrnameid,valuename,index){
	alert(attrid+","+value+","+attrnameid+","+valuename+","+index)
	$("#"+index+"").hide();
	var a = "<span id='a"+index+"'>";
	var b ="<a href='javascript:down("+index+")''>"+value+valuename+"<a> ";
	var c ="<input type='hidden' name='attr_param' value='{\"attrvalue\":"+attrnameid+",\"attrid\":"+attrid+"}' />";
	var d ="</span>";
	$("#selecteddiv").append(a+b+c+d);
		attr_seach();
	};	
	function attr_seach(){
		var id = $("#class2id").val();
		var param ="id="+id;
		var i = $(":input[name='attr_param']").size();
		if(i>0){
		$(":input[name='attr_param']").each(function(i,json){
			var obj = $.parseJSON(json.value);
			param = param + "&list_av["+i+"].shxm_id="+obj.attrvalue +"&list_av["+i+"].shxzh_id="+obj.attrid;
		});
		$.get("loadSeachList.do",param,function(data){
			$("#sale_seach").html(data);
		});
		}else{
			$.get("loadList.do",param,function(data){
				$("#sale_seach").html(data);
			});
		}
	};
		//多选按钮
		function checkbox(classnum){
			$("."+classnum+"").show();	
			$("."+classnum+"b").show();
		}
</script>
<title></title>
<body>
	<input type="hidden" id="class2id" name="class2id" value="${class2id }">
	<div id="selecteddiv"><span>已选定的属性：</span></div>
	<c:forEach items="${attrList}" var="attr" varStatus="index">
			<div id="${index.index }">
			<span >${attr.shxm_mch}</span>
			<c:forEach items="${attr.list_value}" var="value" >
				<input type="checkbox"  class="checkbox${index.index }" value="${value.id }"  style="display: none"><a  href="javascript:seah(${value.id },'${value.shxzh }','${value.shxm_id }','${value.shxzh_mch }','${index.index }');">${value.shxzh }${value.shxzh_mch }</a>
				<input type="hidden" class="checkbox_sxid${index.index }"  value="${value.shxm_id }">
				<input type="hidden" class="checkbox_sxz${index.index }"  value="${value.shxzh }">
				<input type="hidden" class="checkbox_sxzdw${index.index }"  value="${value.shxzh_mch }">
			</c:forEach>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="checkbox${index.index }b" href="javascript:submit('${index.index }')" style="display: none">提交</a>
			<a href="javascript:checkbox('checkbox${index.index }');">  +多选</a>
			</div>
	</c:forEach>
	
	<div id="sale_seach">
	<c:forEach items="${skuList}" var="sku">
			<div style="border:red 1px solid;height:300px;width:280px;margin-left:10px;margin-top:10px;float:left;">
			<img src="upload/image/${sku.product.shp_tp}" width="280px" height="150px"><br>
			<a href="product.do?sku_id=${sku.id}&spu_id=${sku.product.id}">${sku.sku_mch}</a><br>
			${sku.jg}<br>
			${sku.kc}<br>
			${sku.sku_xl}<br>
			${sku.product.shp_mch}<br>
			</div>
	</c:forEach>
	</div>
</body>
</html>