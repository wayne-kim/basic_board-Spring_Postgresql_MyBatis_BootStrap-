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
							<th style="width: 100px"><h5>Target</h5></th>
							<th><h5>Log</h5></th>
							<th style="width: 60px"><h5>Result</h5></th>
						</tr>

						<tr id="new-business-log">
							<td>
								<button class="btn btn-danger glyphicon glyphicon-minus btn-delete"></button>
							</td>
							<td>
								<div class="input-group">
									<input type="text" class="form-control" aria-label="...">
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
								</div> <!-- /input-group -->
							</td>
							<td><input type="text" class="form-control" aria-label="..."></td>
							<td><button class="btn btn-danger glyphicon glyphicon-remove btn-result"></button></td>
						</tr>
					</table>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<button class="btn btn-success">Add</button>
			</div>
			<!-- /.box-footer-->
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

	var newBusinessLog = $("#new-business-log").clone(true, true);
	;
	$("#btn-plus").on("click", function() {
		var obj = newBusinessLog.clone(true, true);

		$(".table").append(obj);
	});
</script>

<%@include file="../include/footer.jsp"%>
