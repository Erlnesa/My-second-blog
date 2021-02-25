<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="A test web page" />
    <meta name="author" content="Erl" />
	
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/main.js"></script>
    <!--需要180*180和32*32的icon-->
    <link rel="icon" type="image/png" href="GIA.bmp">
    
    <title>Erlnesa的主页</title>
</head>
<body>
    <script language="javascript">
    	window.location = "http://www.erlnesa.com/source_code";
	</script>
    <div id="footer">
        <a href="http://beian.miit.gov.cn/" >鄂ICP备19017813号</a>
    </div>
</body>
</html>



