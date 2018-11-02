<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>alpha平台全接口列表清单</title>
</head>

<style type="text/css">
table{
	font-family: verdana,arial,sans-serif;
	font-size:14px;
	color:#333333;
	border-width: 1px;
	border-color: #a9c6c9;
	border-collapse: collapse;
}
table th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table td {
	min-width: 60px;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
.title {
	height: 60px;
	background-color:#507f88;
	color:#eeeeee;
}
.oddrowcolor{
	background-color:#d4e3e5;
}
.evenrowcolor{
	background-color:#c3dde0;
}
</style>

<body>
	<table width="100%" id="consoleList">
		<tr>
       		<td>请求地址</td>
       		<td>请求类型</td>
       		<td>方法路径</td>
       		<td>返回类型</td>
       		<td>方法参数</td>
		</tr>
		<c:forEach items="${itemList}" var="item">
		<tr>
       		<td>${item.path}</td>
       		<td>${item.requestMethod}</td>
       		<td>${item.method}</td>
			<td>${item.responseType}</td>
			<td>${item.parameters}</td>
		</tr>
		</c:forEach>
	</table>
</body>

<script type="text/javascript">
function altRows(id){
	if(document.getElementsByTagName){  
		
		var table = document.getElementById(id);  
		var rows = table.getElementsByTagName("tr"); 
		 
		for(i = 0; i < rows.length; i++){        
			if(i % 2 == 0){
				rows[i].className = "oddrowcolor";
			}else{
				rows[i].className = "evenrowcolor";
			}
		}
		rows[0].className = "title"
	}
}
var parameters = '${itemList}';
console.log(parameters);
window.onload=function(){
	altRows('consoleList');
}
</script>
</html>
