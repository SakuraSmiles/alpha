<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<body>
	<div id="app">

	</div>
    <h2>Hello World</h2>
    <h3>
     	<a href="hello">点击跳转</a>
    </h3>
</body>
<script type="text/javascript">
    var app2 = new Vue({
    	  el: '#app',
    	  data: {
    		  message: '页面加载于 ' + new Date().toLocaleString()
    	  }
    	})
</script>
</html>
