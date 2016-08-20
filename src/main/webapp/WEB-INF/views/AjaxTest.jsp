<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax test page</title>
</head>
<body>
	<h2>Ajax Test Page</h2>

	<div>
		<div>
			Commenter <input type="text" name="commenter" id="newCommemtWriter">
		</div>
		<div>
			Comment TEXT <input type="text" name="commentText" id="newCommentText">
		</div>
		<button id="getAllCommentBtn">Get All Comment</button>
		<button id="commentAddBtn">ADD Comment</button>
		
		<div>
			Delete Comment no <input type="text" name="commentText" id="deleteCommentNo">
		</div>
		<button id="commentDeleteBtn">DELETE Comment</button>
		
		<div>
			Modify Comment no <input type="text" name="commentText" id="modefiyCommentNo">
			Modify Comment TEXT <input type="text" name="commentText" id="modefiyCommentText">
		</div>
		<button id="commentModifyBtn">MODIFY Comment</button>
	</div>
		
	<ul id="comments">
	</ul>
	<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<script>
		var bno = 21201;

		function getAllList() {

			$.getJSON("/comment/all/" + bno, function(data) {
				console.log(data.length);

				var str = "";

				$(data).each(function() {
					str += "<li data-cno='" +this.cno+ "' class='commentLi'>" + this.cno + ":" + this.content + "</li>";
				});
				$("#comments").html(str);
			});
		}
		
		$("#commentAddBtn").on("click", function(){
			var commenter = $("#newCommemtWriter").val();
			var commentText = $("#newCommentText").val();
			
			$.ajax({
				type : 'post',
				url : '/comment',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				data : JSON.stringify({
					bno : bno,
					writer : commenter,
					content : commentText
				}),
				success : function(result){
					if(result == 'SUCCESS'){
						alert("등록 되었습니다.");
						$("#newCommemtWriter").val("AAAAAaa");
					}
				}
			});
		});
		
		$("#getAllCommentBtn").on("click",function(){
			$("#comments li").remove();
			getAllList();
		});
		
		
		$("#commentDeleteBtn").on("click",function(){
			var cno =  $("#deleteCommentNo").val();

			$.ajax({
				type : 'post',
				url : '/comment/',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : 'text',
				data : JSON.stringify({
					cno : cno
				}),
				success : function(result){
					if(result == 'SUCCESS'){
						alert("삭제 되었습니다.");
					}
				}
			});
		});
	</script>
</body>
</html>