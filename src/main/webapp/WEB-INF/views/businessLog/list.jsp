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
					<table class="table table-bordered" id="createTable">
						<tr>
							<th style="width: 10px"><button class="btn btn-primary glyphicon glyphicon-plus" id="btn-plus"></button></th>
							<th style="width: 200px"><h5>분류</h5></th>
							<th><h5>내용</h5></th>
							<th style="width: 60px"><h5>결과</h5></th>
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
				</div>
				<div class="box-footer">
					<button class="btn btn-success pull-right" id="addLogBtn">추가</button>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.box-body -->

			<!-- for clone -->
			<ul class="timeline">
				<!-- timeline time label -->
				<li class="time-label" id="bussinessLogDiv"><span class="bg-green"> 업무일지</span></li>
				<li class="businessLogLi"><i class="glyphicon glyphicon-thumbs-up bg-blue"></i>
					<div class="timeline-item">
						<input type="hidden" />
						<span class="time"> 날짜 </span>
						<h3 class="timeline-header">웨인</h3>
						<div class="timeline-body">
							<table class="table table-bordered" id="businessList" style="margin-bottom: 0px;">
								<thead>
									<tr>
										<th style="width: 200px"><h5>분류</h5></th>
										<th><h5>내용</h5></th>
										<th style="width: 60px"><h5>결과</h5></th>
									</tr>
								</thead>
							</table>
						</div>
						<div class="box-footer">
							<button class="btn btn-danger pull-right btnLogDelete">삭제</button>
						</div>
					</div></li>
			</ul>
		</div>
	</div>
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
	
	var newBusinessLog = $(".new-business-log").clone(true, true);

	$("#btn-plus").on("click", function() {
		var obj = newBusinessLog.clone(true, true);

		$("#createTable").append(obj);
	});

	$(".table").on("click", ".dropdown-menu li", function() {
		var target = $(this);
		var input = target.parent().parent().parent().find("input");
		input.val(target.text());
	});

	//업무일지 쓰기 RESTful
	$("#addLogBtn").on("click", function() {
		var logs = $(".new-business-log");

		if (logs.length <= 0) {
			alert("업무일지를 작성해주세요.");
			return;
		}

		var datas = new Array();

		for (var i = 0; i < logs.length; i++) {
			var data = new Object();
			var target = logs.eq(i).find("input").eq(0).val();
			var content = logs.eq(i).find("input").eq(1).val();
			var result = logs.eq(i).find(".btn-result");
			result = (result.attr('class').includes("btn-danger") == true ? "0" : "1");

			if (target == "") {
				alert("input target");
				logs.eq(i).find("input").eq(0).focus();
				return;
			}
			if (content == "") {
				alert("input log");
				logs.eq(i).find("input").eq(1).focus();
				return;
			}
			data.target = target;
			data.log = content;
			data.result = result;
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
					logs.remove();
					$(".businessLogLi").remove();
					getTodatBusinessLog();
				}
			}
		});
	});
	
	//업무일지 내역 모델
	var modelBusinessLog = $(".businessLogLi").clone(true, true);
	$(".businessLogLi").remove();

	//금일 업무 일지 가져오기
	function getTodatBusinessLog() {
		$.getJSON("/businessLogREST", function(data) {
			console.log(data);
			for (var i = 0; i < data.length; i++) {
				var lno = data[i].lno;
				var log = data[i].log;
				var regdate = data[i].regdate;
				var user_num = data[i].user_num;

				var checkAttendance;

				var obj = modelBusinessLog.clone(true, true);
				//업무일지 번호
				$(obj).find("input").val(lno);
				//로그 내용
				var jsonLog = JSON.parse(log);
				var tag = "";
				for (var j = 0; j < jsonLog.length; j++) {
					var target = jsonLog[j][[ 'target' ]];
					var log = jsonLog[j][[ 'log' ]];
					var result = jsonLog[j][[ 'result' ]];
					console.log(result);
					tag += "<tr>";
					//tag += "<td style='width:10px;'><button class='btn btn-danger glyphicon glyphicon-minus btn-delete'></button></td>;"
					tag += "<td><h5>"+target+"</h5></td>";
					tag += "<td><h5>"+log+"</h5></td>";
					tag += "<td><button class='btn btn-result btn-result-change ";
					if (result == "0"){
						tag += "glyphicon glyphicon-remove btn-danger'></button></td></tr>";
						console.log("왜 여기야?");
					} else{
						tag += "glyphicon glyphicon-ok btn-success'></button></td></tr>";
						console.log("성공으로 안 나오나?");
					}
						
				}
				$(obj).find("#businessList").append(tag);
				//날짜
				var date = new Date(regdate);

				var hours = date.getHours();
				var minutes = date.getMinutes();
				if (hours < 10)
					hours = "0" + hours;
				if (minutes < 10)
					minutes = "0" + minutes;
				date = hours + ":" + minutes;
				checkAttendance = hours + minutes + "";

				if (checkAttendance > "0900") {
					var icon = $(obj).find(".glyphicon-thumbs-up");
					icon.removeClass("glyphicon-thumbs-up");
					icon.removeClass("bg-blue");

					icon.addClass("glyphicon-thumbs-down");
					icon.addClass("bg-red");

				}

				$(obj).find(".time").text(date);
				//유저번호
				$(obj).find(".timeline-header").text(user_num);

				$(".timeline").append(obj);
			}
		});
	}
	
	//업무일지 삭제 RESTful
	$(".timeline").on("click", ".btnLogDelete", function(event){
		var root = $(event.target).parent().parent();
		var lno = root.find("input").val();
		
		if(confirm("삭제하시겠습니까?")){
			$.ajax({
				type : 'delete',
				url : '/businessLogREST/'+lno,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : 'text',
				data : JSON.stringify({
					user_num : 3
				}),
				success : function(result) {
					if (result == "SUCCESS") {
						alert("삭제되었습니다.");
						$(".businessLogLi").remove();
						getTodatBusinessLog();
					}
				}
			});
	    }
	});
	
	getTodatBusinessLog();
	
	//업무일지 쓰기, 결과 변환 버튼
	$(document).on("click", ".btn-result" , function(e) {
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
	
	//결과 변환 RESTful
	$(document).on("click", ".btn-result-change", function(e){
		var root = $(e.target).parent().parent().parent(); //tbody
		var lno = root.parent().parent().parent().find("input");
		var trs = root.find("tr");
		
		var sendMessage = true;
		
		var datas = new Array();
		for(var i=0; i<trs.length;i++){
			var tr = trs.eq(i);
			var tds = tr.find("td");
			
			var data = new Object();			
			var target = tds.eq(0).text();
			var content = tds.eq(1).text();
			var result = tds.eq(2).find(".btn-result");
			
			result = (result.attr('class').includes("btn-danger") == true ? "0" : "1");
			if(result == "0") sendMessage = false;
			data.target = target;
			data.log = content;
			data.result = result;
			datas.push(data);
		}
		$.ajax({
			type : 'put',
			url : '/businessLogREST/'+lno.val(),
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "PUT"
			},
			dataType : 'text',
			data : JSON.stringify({
				user_num : 3,
				log : JSON.stringify(datas)
			}),
			success : function(result) {
				console.log("result: " + result);
				if (result == "SUCCESS") {
					if(sendMessage){
						var n = Math.floor(Math.random()*5);
						
						switch(n){
							case 0 : alert("오늘도 고생하셨습니다."); break;
							case 1 : alert("이것 또한 지나갑니다."); break;
							case 2 : alert("실패는 성공의 어머니 입니다."); break;
							case 3 : alert("피가 되고 살이 되는 시간이였습니다."); break;
							case 4 : alert("정상에서 뵙시다."); break;
						}
					}
				}
			}
		});
	});
</script>

<%@include file="../include/footer.jsp"%>
