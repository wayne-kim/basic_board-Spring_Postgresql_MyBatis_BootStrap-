<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax test page</title>
<style>
#modDiv {
	width: 300px;
	height: 100px;
	background-color: gray;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -50px;
	margin-left: -150px;
	padding: 10px;
	z-index: 1000;
}
</style>
</head>
<body>
	<h2>Ajax Test Page</h2>

	<div>
		<div>
			Commenter
			<input type="text" name="commenter" id="newCommemtWriter">
		</div>
		<div>
			Comment TEXT
			<input type="text" name="commentText" id="newCommentText">
		</div>
		<button id="commentAddBtn">ADD Comment</button>
	</div>

	<div id="modDiv" style="display: none;">
		<div class="model-title"></div>
		<div>
			<input type="text" id="commentText" />
		</div>
		<div>
			<button type="button" id="commentModBtn">Modify</button>
			<button type="button" id="commentDelBtn">Delete</button>
			<button type="button" id="closeBtn">Close</button>
		</div>
	</div>

	<ul id="comments">
	</ul>

	<ul class="pagination">
	</ul>
	<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<script>
		function getAllList() {

			$.getJSON("/comment/all/" + bno, function(data) {
				console.log(data.length);

				var str = "";

				$(data).each(function() {
					str += "<li data-cno='" + this.cno+ "' class='commentLi'>" + this.cno + ":" + this.content + "<button>MOD</button></li>";
				});
				$("#comments").html(str);
			});
		}

		function getPageList(page) {

			$.getJSON("/comment/" + bno + "/" + page, function(data) {
				console.log(data.list.length);

				var str = "";

				$(data.list).each(function() {
					str += "<li data-cno='" + this.cno+ "' class='commentLi'>" + this.cno + ":" + this.content + "<button>MOD</button></li>";
				});

				$("#comments").html(str);

				printPaging(data.pageMaker);

			});
		}

		function printPaging(pageMaker) {
			var str = "";

			if (pageMaker.prev) {
				str += "<li><a href='" + (pageMaker.startPage - 1) + "'> << <a/></li>";
			}

			for (var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++) {
				var strClass = pageMaker.cri.page == i ? 'class=active' : '';
				str += "<li "+strClass+"><a href='"+i+"'>" + i + "</a></li>";
			}

			if (pageMaker.next) {
				str += "<li><a href='" + (pageMaker.endPage + 1) + "'> >> </a></li>";
			}
			$('.pagination').html(str);
		}

		$("#commentAddBtn").on("click", function() {
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
				success : function(result) {
					if (result == 'SUCCESS') {
						alert("등록 되었습니다.");
						//getAllList();
						getPageList(1);
					}
				}
			});
		});
		//위임 방식, jQuery의 편리한 기능으로 존재하지 않는 요소에 이벤트를 위임한다.
		$("#comments").on("click", ".commentLi button", function() {
			var comment = $(this).parent();

			var cno = comment.attr("data-cno");
			var content = comment.text();

			$(".model-title").html(cno);
			$("#commentText").val(content);
			$("#modDiv").show("slow");
			//getAllList();
		});

		$("#commentDelBtn").on("click", function() {
			var cno = $(".model-title").html();
			var commentText = $("#commentText").val();

			$.ajax({
				type : 'delete',
				url : '/comment/' + cno,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : 'text',
				success : function(result) {
					console.log("result: " + result);
					if (result == 'SUCCESS') {
						alert("삭제되었습니다.");
						$("#modDiv").hide("show");
						getPageList(1);
					}
				}
			})
		});

		$("#commentModBtn").on("click", function() {
			var cno = $(".model-title").html();
			var commentText = $("#commentText").val();

			$.ajax({
				type : 'put',
				url : '/comment/' + cno,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "put"
				},
				data : JSON.stringify({
					content : commentText
				}),
				dataType : 'text',
				success : function(result) {
					console.log("result: " + result);
					if (result == 'SUCCESS') {
						alert("수정되었습니다.");
						$("#modDiv").hide("show");
						getPageList(1);
					}
				}
			})
		})

		var commentPage = 1;
		$(".pagination").on("click", "li a", function(event){
			event.preventDefault();
			commentPage = $(this).attr("href");
			getPageList(commentPage);
		});
		
		var bno = 21201;
		getPageList(1);
	</script>
</body>
</html>