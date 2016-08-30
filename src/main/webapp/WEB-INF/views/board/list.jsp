<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->


			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">게시판</h3>
				</div>

				<div class="box-body">
					<div class="input-group">
						<div class="input-group-btn search-panel">
							<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
								<span id="search_concept">선택</span>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu" id="filter" role="menu">
								<li><a>TITLE</a></li>
								<li><a>CONTENT</a></li>
								<li><a>WRITER</a></li>
								<li><a>TITLE OR CONTENT</a></li>
								<li><a>CONTENT OR WRITER</a></li>
								<li><a>TITLE OR CONTENT OR WRITER</a></li>
							</ul>
						</div>
						<input type="text" class="form-control" name="keyword" value='${cri.keyword}' id="keywordInput">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button" id="searchBtn">
								<span class="glyphicon glyphicon-search"></span>
							</button>
							<a href="/board/register" class="btn btn-success" id="newBtn">추가</a>
						</span>
					</div>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px;">번호</th>
							<th>타이틀</th>
							<th>글쓴이</th>
							<th>등록일시</th>
							<th style="width: 60px">조회수</th>
						</tr>

						<c:forEach items="${list}" var="boardVO">
							<tr>
								<td>${boardVO.bno}</td>
								<td><a href="/board/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&bno=${boardVO.bno}"> ${boardVO.title} <string>[ ${boardVO.comment_cnt} ] </a></td>
								<td>${boardVO.writer}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate}" /></td>
								<td><span class="badge bg-red">${boardVO.viewcnt }</span></td>
							</tr>
						</c:forEach>

					</table>

				</div>
				<!-- /.box-body -->

				<div class="text-center">
					<ul class="pagination">

						<c:if test="${pageMaker.prev}">
							<li><a href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
						</c:if>

						<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
							<li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
								<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
							</li>
						</c:forEach>

						<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
							<li><a href="list${pageMaker.makeSearch(pageMaker.endPage +1)}">&raquo;</a></li>
						</c:if>

					</ul>
				</div>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script>
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}

	var searchType = '${cri.searchType}';
	if(searchType!=''){
		for(var i=0; i< $("#filter li").length; i++){
			if($("#filter li a").eq(i).text() == searchType){
				$("#search_concept").text(searchType);
				$("#filter li a").eq(i).text("ALL");
			}
		}
	}
	
	var keyword = '${cri.keyword}';
	if(keyword == '' && searchType == '') $("#keywordInput").attr("disabled", true);
	
	$("#filter li").click(function(e) {
		var temp = $("#search_concept").text();
		$("#search_concept").text(e.target.text);
		e.target.text = temp;
		if($("#search_concept").text()!='선택'){
			$("#keywordInput").attr("disabled", false);
		}else {
			$("#keywordInput").attr("disabled", true);
		}
	});
	
	$("#searchBtn").on("click", function(e){
		self.location = "list"
		+'${pageMaker.makeQuery(1)}'
		+'&searchType='
		+$("#search_concept").text()
		+"&keyword="+$("#keywordInput").val();
	});
	
	
</script>

<%@include file="../include/footer.jsp"%>
