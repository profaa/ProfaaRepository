<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
	<head></head>
	<body>
		<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js" />
		<script type="text/javascript">
			alert("kkk");
			const obj = {aaa : "파라미터 ㄱㄱ"};
			$.ajax({
        		url: "/testJson.do",
        		type: "post",
        		data: JSON.stringify(obj),
        		dataType: "json",
        		contentType: "application/json",
        		success: function(data) {
        		    alert("성공");
        		},
        		error: function(errorThrown) {
        		    alert(errorThrown.statusText);
        		}
    		});
		</script>
	</body>
</html>