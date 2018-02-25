<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>商城管理系统</title>
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
	<script type="text/javascript">
	$(function(){
		var url= "${url}";
		var title = "${title}";
		if(url!=""&&title!=""){
			add_tab(title,url); 
		}
	});
	function add_tab(title,url){
			var flag = $('#tt').tabs('exists',title);
			$('#tt').tabs('select',title);
			if(!flag){
				$('#tt').tabs('add',{   
				    title:title,    
					href:url,
				    closable:true,    
				    tools:[{    
				        iconCls:'icon-mini-refresh',    
				        handler:function(){    
				            alert('refresh');    
				        }    
				  	  }]    
				}); 
			}
		}
	</script>
</head>
<body class="easyui-layout">
	
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">
		<div style="margin:10px 0;"></div>
		<div style="padding:5px;border:1px solid #ddd">
			<a href="#" class="easyui-linkbutton" data-options="plain:true">Home</a>
			<a href="#" class="easyui-menubutton" data-options="menu:'#mm1',iconCls:'icon-edit'">Edit</a>
			<a href="#" class="easyui-menubutton" data-options="menu:'#mm2',iconCls:'icon-help'">Help</a>
			<a href="#" class="easyui-menubutton" data-options="menu:'#mm3'">About</a>
		</div>
		<div id="mm1" style="width:150px;">
			<div data-options="iconCls:'icon-undo'">Undo</div>
			<div data-options="iconCls:'icon-redo'">Redo</div>
			<div class="menu-sep"></div>
			<div>Cut</div>
			<div>Copy</div>
			<div>Paste</div>
			<div class="menu-sep"></div>
			<div>
				<span>Toolbar</span>
				<div style="width:150px;">
					<div>Address</div>
					<div>Link</div>
					<div>Navigation Toolbar</div>
					<div>Bookmark Toolbar</div>
					<div class="menu-sep"></div>
					<div>New Toolbar...</div>
				</div>
			</div>
			<div data-options="iconCls:'icon-remove'">Delete</div>
			<div>Select All</div>
		</div>
		<div id="mm2" style="width:100px;">
			<div>Help</div>
			<div>Update</div>
			<div>About</div>
		</div>
		<div id="mm3" class="menu-content" style="background:#f0f0f0;padding:10px;text-align:left">
			<img src="http://www.jeasyui.com/images/logo1.png" style="width:150px;height:50px">
			<p style="font-size:14px;color:#444;">Try jQuery EasyUI to build your modern, interactive, javascript applications.</p>
		</div>
	</div>
	<div data-options="region:'west',split:true,title:'West'" style="width:190px;padding:10px;">
		<div class="demo-info">
		<div class="demo-tip icon-tip"></div>
		</div>
		<div style="margin:10px 0;"></div>
		<ul class="easyui-tree">	
			<li>
				<span>菜单</span>
				<ul>
					<li><a href="index.do">主页</a></li>
					<li >
						<span>二级菜单</span>
						<ul data-options="state:'open'">  
							<li><a href="javascript:add_tab('商品spu信息发布','gospuadd.do')">商品spu信息发布</a></li>
							<li><a href="javascript:add_tab('商品sku信息发布','gosku.do')">商品sku信息发布</a></li>
							<li><a href="javascript:add_tab('商品属性信息发布','goattr.do')">商品属性信息发布</a></li>
						</ul>
					</li>
					<li>about.html</li>
					<li>welcome.html</li>
					<li><a href="javascript:add_tab(this.value)">测试</a></li>
				</ul>
			</li>
		</ul>
			
		</div>
	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:330px;padding:10px;">
			<div id="aa" class="easyui-accordion" style="width:300px;height:150px;">   
			    <div title="Title2" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
			    	<a href="index.do">主页</a>
			    </div> 
			    <div title="Title1" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
			    	<a href="javascript:add_tab('商品spu信息发布','gospuadd.do')">商品spu信息发布</a><br> 
					<a href="javascript:add_tab('商品sku信息发布','gosku.do')">商品sku信息发布</a><br>
					<a href="javascript:add_tab('商品属性信息发布','goattr.do')">商品属性信息发布</a><br>
			    </div>   
			</div>  
	</div>
	<div data-options="region:'south',border:false" style="height:20px;background:#A9FACD;padding:10px;">
		<div class="easyui-layout" data-options="fit:true">
				<div data-options="region:'north',split:true,border:false" style="height:50px"></div>
				<div data-options="region:'west',split:true,border:false" style="width:100px"></div>
				<div data-options="region:'center',border:false">
					
				</div>
		</div>
	</div>
	<div data-options="region:'center',title:'Center'">
		<div id="tt" class="easyui-tabs" ></div> 
		
	</div>
</body>
</html>    
