<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 추가</title>
</head>
<body>
<form action="/spw/category/insert.spw" method="POST">
	<table border="1">
		<tr>
			<th colspan="2">
				<h2>카테고리 추가</h2>
			</th>
		</tr>
		<tr>
			<th>카테고리 이름</th>
			<td>
				<input type="text" name="cgname">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="추가">
				<input type="reset" value="다시쓰기">
			</td>
		</tr>
	</table>
</form>
</body>
</html>