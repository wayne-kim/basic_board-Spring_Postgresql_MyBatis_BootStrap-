<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->


			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Business Log</h3>
				</div>

				<div class="box-body">
					<div class="input-group">
						<div class="input-group-btn search-panel">
							<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
								<span id="search_concept">선택</span>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu" id="filter" role="menu">
								<li><a>Log</a></li>
								<li><a>WRITER</a></li>
							</ul>
						</div>
						<input type="text" class="form-control" name="keyword" value='${cri.keyword}' id="keywordInput">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button" id="searchBtn">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>

				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px"><button class="btn btn-primary glyphicon glyphicon-plus" id="btn-plus"></button></th>
							<th style="width: 200px"><h5>Target</h5></th>
							<th><h5>Log</h5></th>
							<th style="width: 60px"><h5>Result</h5></th>
						</tr>

						<tr class="new-business-log">
							<td>
								<button class="btn btn-danger glyphicon glyphicon-minus btn-delete"></button>
							</td>
							<td>
								<div class="input-group">
									<div class="input-group-btn">
										<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
											<span class="caret"></span>
										</button>
										<ul class="dropdown-menu" role="menu">
											<li><a href="#">C</a></li>
											<li><a href="#">C++</a></li>
											<li><a href="#">C#</a></li>
											<li><a href="#">Java</a></li>
											<li><a href="#">Javascript</a></li>
											<li><a href="#">etc</a></li>
										</ul>
									</div>
									<input type="text" class="form-control">
								</div> <!-- /input-group -->
							</td>
							<td><input type="text" class="form-control" aria-label="..."></td>
							<td><button class="btn btn-danger glyphicon glyphicon-remove btn-result"></button></td>
						</tr>
					</table>
					<br/>
					<button class="btn btn-success pull-right" id="addLogBtn">Add</button>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.box-body -->
		</div>
	</div>
	<!--/.col (left) -->
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

	$(".btn-delete").on("click", function(e) {
		$(e.target).parent().parent().remove();
	});

	$(".btn-result").on("click", function(e) {
		if ($(e.target).hasClass("glyphicon-remove")) {
			$(e.target).removeClass("glyphicon-remove");
			$(e.target).addClass("glyphicon-ok");

			$(e.target).removeClass("btn-danger");
			$(e.target).addClass("btn-success");
		} else {
			$(e.target).removeClass("glyphicon-ok");
			$(e.target).addClass("glyphicon-remove");

			$(e.target).removeClass("btn-success");
			$(e.target).addClass("btn-danger");
		}
	});

	var newBusinessLog = $(".new-business-log").clone(true, true);
	;
	$("#btn-plus").on("click", function() {
		var obj = newBusinessLog.clone(true, true);

		$(".table").append(obj);
	});
	
	$(".table").on("click", ".dropdown-menu li", function(){
		var target = $(this);
		var input = target.parent().parent().parent().find("input");
		input.val(target.text());
	});
	
	$("#addLogBtn").on("click",function(){
		var logs = $(".new-business-log");
		
		var datas = new Array();
		
		for(var i=0; i<logs.length; i++){
			var data = new Object();
			var target = logs.eq(i).find("input").eq(0).val();
			var content = logs.eq(i).find("input").eq(1).val();
			var result =  logs.eq(i).find(".btn-result");
			result = (result.attr('class').includes("btn-danger") == true ? "0" : "1");
			
			if(target == ""){
				alert("input target");
				logs.eq(i).find("input").eq(0).focus();
				return;
			}
			if(content == ""){
				alert("input log");
				logs.eq(i).find("input").eq(1).focus();
				return;
			}
			data.target = target;
			data.log = content;
			data.restult = result;
			datas.push(data);
		}
		
		$.ajax({
			type : 'post',
			url : '/businessLogREST',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : 'text',
			data : JSON.stringify({
				user_num : 3,
				log : JSON.stringify(datas)
			}),
			success : function(result) {
				console.log("result: " + result);
				if (result == "SUCCESS") {
					alert("등록되었습니다.");
				}
			}
		});
	});
</script>

<%@include file="../include/footer.jsp"%>
