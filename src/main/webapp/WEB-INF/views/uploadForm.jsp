<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>업로드 테스트 페이지</title>
<style>
iframe {
	widh: 0px;
	height: 0px;
	border: 0px;
}
</style>
</head>
<body>
	<form id="form1" action="uploadForm" method="post" enctype="multipart/form-data" target="zeroFrame">
		<input type="file" name="file">
		<input type="submit">
	</form>
	
	<iframe name="zeroFrame"></iframe>
	
	<script>
		function addFilePath(msg){
			alert(msg);
			document.getElemenById("form1").result();
		}
	</script>
</body>
</html>