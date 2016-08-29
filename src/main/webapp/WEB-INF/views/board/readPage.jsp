<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>
<script type="text/javascript" src="/resources/js/upload.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<!-- Main content -->
<style type="text/css">
.popup {
	position: absolute;
}

.back {
	background-color: gray;
	opacity: 0.5;
	width: 100%;
	height: 300%;
	overflow: hidden;
	z-index: 1101;
}

.front {
	z-index: 1110;
	opacity: 1;
	boarder: 1px;
	margin: auto;
}

.show {
	position: relative;
	max-width: 1200px;
	max-height: 800px;
	overflow: auto;
}
</style>

<div class='popup back' style="display: none;"></div>
<div id="popup_front" class='popup front' style="display: none;">
	<img id="popup_img">
</div>
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">게시물 상세보기</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" action="modifyPage" method="post">
					<input type='hidden' name='bno' value="${boardVO.bno}">
					<input type='hidden' name='page' value="${cri.page}">
					<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='searchType' value="${cri.searchType}">
					<input type='hidden' name='keyword' value="${cri.keyword}">
				</form>

				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">제목</label>
						<input type="text" name='title' class="form-control" value="${boardVO.title}" readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">내용</label>
						<textarea class="form-control" name="content" rows="3" readonly="readonly">${boardVO.content}</textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">글쓴이</label>
						<input type="text" name="writer" class="form-control" value="${boardVO.writer}" readonly="readonly">
					</div>
				</div>
				<!-- /.box-body -->

				<div class="box-footer">
					<ul class="mailbox-attachments clearfix uploadedList">
					</ul>
					<div>
						<hr>
					</div>
					<button type="submit" class="btn btn-warning">수정</button>
					<button type="submit" class="btn btn-danger" id="btn-delete">삭제</button>
					<button type="submit" class="btn btn-primary" id="btn-list">목록</button>
				</div>
			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>

	<div class="row">
		<div class="col-md-12">

			<div class="box box-success">
				<div class="box-header">
					<h3 class="box-title">코멘트 추가 하기</h3>
				</div>
				<div class="box-body">
					<label for="exampleInputEmail1">글쓴이</label>
					<input class="form-control" type="text" placeholder="USER ID" id="newCommentWriter">
					<label for="exampleInputEmail1">내용</label>
					<input class="form-control" type="text" placeholder="Comment TEXT" id="newCommentText">
				</div>
				<!-- /.box-body -->
				<div class="box-footer">
					<button type="button" class="btn btn-primary" id="commentAddBtn">추가</button>
				</div>
			</div>


			<!-- The time line -->
			<ul class="timeline">
				<!-- timeline time label -->
				<li class="time-label" id="commentsDiv">
					<span class="bg-green">
						코멘트 리스트 <small id="commentCntSmall"> [ ${boardVO.comment_cnt} ]</small>
					</span>
				</li>
			</ul>

			<div class='text-center'>
				<ul id="pagination" class="pagination pagination-sm no-margin ">

				</ul>
			</div>

		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->

	<!-- Modal -->
	<div id="modifyModal" class="modal modal-primary fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"></h4>
				</div>
				<div class="modal-body" data-cno>
					<p>
						<input type="text" id="commentText" class="form-control">
					</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" id="commentModBtn">Modify</button>
					<button type="button" class="btn btn-danger" id="commentDelBtn">DELETE</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- /.content -->
<script>
	$(document).ready(function() {

		var formObj = $("form[role='form']");

		console.log(formObj);

		$(".btn-warning").on("click", function() {
			formObj.attr("action", "/board/modifyPage");
			formObj.attr("method", "get");
			formObj.submit();
		});

		$("#btn-delete").on("click", function() {
			if (confirm("삭제하시겠습니까?")) {
				formObj.attr("action", "/board/removePage");
				formObj.submit();
			}
		});

		$("#btn-list").on("click", function() {
			formObj.attr("method", "get");
			formObj.attr("action", "/board/list");
			formObj.submit();
		});

	});
</script>

<script id="templateAttach" type="text/x-handlebars-template">
<li data-src='{{fullName}}'>
  <span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
  <div class="mailbox-attachment-info">
	<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
	</span>
  </div>
</li>                
</script>

<script id="template" type="text/x-handlebars-template">
{{#each .}}
<li class="commentLi" data-cno={{cno}}>
<i class="fa fa-comments bg-blue"></i>
 <div class="timeline-item" >
  <span class="time">
    <i class="fa fa-clock-o"></i>{{prettifyDate regdate}}
  </span>
  <h3 class="timeline-header"><strong>{{cno}}</strong> -{{writer}}</h3>
  <div class="timeline-body">{{content}} </div>
    <div class="timeline-footer">
     <a class="btn btn-primary btn-xs" 
	    data-toggle="modal" data-target="#modifyModal">Modify</a>
    </div>
  </div>			
</li>
{{/each}}
</script>

<script type="text/javascript">
	Handlebars.registerHelper("prettifyDate", function(timeValue) {
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();
		return year + "/" + month + "/" + date;
	});

	var printData = function(replyArr, target, templateObject) {

		var template = Handlebars.compile(templateObject.html());

		var html = template(replyArr);
		$(".commentLi").remove();
		target.after(html);

	}

	var bno = ${boardVO.bno};

	var commentPage = 1;

	function getPage(pageInfo) {

		$.getJSON(pageInfo, function(data) {
			printData(data.list, $("#commentsDiv"), $('#template'));
			printPaging(data.pageMaker, $(".pagination"));

			$("#modifyModal").modal('hide');
			$("#commentCntSmall").html("[ " + data.pageMaker.totalCount + " ]");
		});
	}

	var printPaging = function(pageMaker, target) {

		var str = "";

		if (pageMaker.prev) {
			str += "<li><a href='" + (pageMaker.startPage - 1) + "'> << </a></li>";
		}

		for (var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++) {
			var strClass = pageMaker.cri.page == i ? 'class=active' : '';
			str += "<li "+strClass+"><a href='"+i+"'>" + i + "</a></li>";
		}

		if (pageMaker.next) {
			str += "<li><a href='" + (pageMaker.endPage + 1) + "'> >> </a></li>";
		}

		target.html(str);
	};

	$("#commentsDiv").on("click", function() {
		if ($(".timeline li").size() > 1) {
			return;
		}
		getPage("/comment/" + bno + "/1");
	})

	$(".pagination").on("click", "li a", function(event) {
		event.preventDefault();
		commentPage = $(this).attr("href");
		getPage("/comment/" + bno + "/" + commentPage);
	});

	$("#commentAddBtn").on("click", function(event) {
		var commentWriterObj = $("#newCommentWriter");
		var commentTextObj = $("#newCommentText");
		var commentWriter = commentWriterObj.val();
		var commentContent = commentTextObj.val();

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
				writer : commentWriter,
				content : commentContent
			}),
			success : function(result) {
				console.log("result: " + result);
				if (result == "SUCCESS") {
					alert("등록되었습니다.");
					commentPage = 1;
					getPage("/comment/" + bno + "/" + commentPage);
					commentWriterObj.val("");
					commentTextObj.val("");
				}
			}
		});
	});

	$(".timeline").on("click", ".commentLi", function(event) {
		var comment = $(this);

		$("#commentText").val(comment.find(".timeline-body").text());
		$(".modal-title").html(comment.attr("data-cno"));
	});

	$("#commentModBtn").on("click", function() {

		var cno = $(".modal-title").html();
		var commentText = $("#commentText").val();

		$.ajax({
			type : 'put',
			url : '/comment/' + cno,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "PUT"
			},
			data : JSON.stringify({
				content : commentText
			}),
			dataType : 'text',
			success : function(result) {
				console.log("result: " + result);
				if (result == 'SUCCESS') {
					alert("수정 되었습니다.");
					getPage("/comment/" + bno + "/" + commentPage);
				}
			}
		});
	});

	$("#commentDelBtn").on("click", function() {

		var cno = $(".modal-title").html();
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
					alert("삭제 되었습니다.");
					getPage("/comment/" + bno + "/" + commentPage);
				}
			}
		});
	});

	getPage("/comment/" + bno + "/1");

	//파일 처리
	var bno = ${boardVO.bno};
	var template = Handlebars.compile($("#templateAttach").html());

	$.getJSON("/board/getAttach/" + bno, function(list) {
		$(list).each(function() {

			var fileInfo = getFileInfo(this);

			var html = template(fileInfo);

			$(".uploadedList").append(html);

		});
	});
	
	$(".uploadedList").on("click", ".mailbox-attachment-info a", function(event){
		
		var fileLink = $(this).attr("href");
		
		if(checkImageType(fileLink)){
			
			event.preventDefault();
					
			var imgTag = $("#popup_img");
			imgTag.attr("src", fileLink);
			
			console.log(imgTag.attr("src"));
					
			$(".popup").show('slow');
			imgTag.addClass("show");		
		}	
	});
	
	$("#popup_img").on("click", function(){
		
		$(".popup").hide('slow');
		
	});	
</script>
</div>
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>
