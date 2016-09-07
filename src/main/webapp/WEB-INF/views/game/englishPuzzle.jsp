<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>
<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-10">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">영어 퍼즐 게임</h3>
				</div>
				<div class="box-body" id="mode">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<p class="text-center">모드 선택</p>
						<button type="button" class="btn btn-primary btn-lg btn-block" disabled>스터디 모드</button>
						<button type="button" class="btn btn-default btn-lg btn-block">챌린지 모드</button>
					</div>
					<div class="col-md-3"></div>
				</div>

				<!-- 도전 모드 -->
				<div class="box-body hide" id="challenge">
					<div class="progress">
						<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
						</div>
					</div>
					<div class="box-body col-md-6 clone">
						<div class="puzzle box box-primary">
							<input type="hidden" value="" />
							<h3 class="text-center"></h3>
							<input type="text" class="form-control text-center result" disabled>
						</div>
					</div>
				</div>
				
				<!-- 학습모드 -->
				<div class="box-body hide" id="challenge">
					<h1>학습모드</h1>					
				</div>
			</div>
			<!-- /.box-body -->
		</div>
	</div>
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->
<script>
	
	$(".btn-block").on("click", function(event){
		$("#mode").hide();
		if($(event.target).text() == "챌린지 모드"){
			$("#challenge").removeClass("hide");
			challenge();
		}
		else;
	})
	
	var wrong=0;
	function challenge() {
		$.getJSON("/puzzle/getPuzzle", function(data) {
			var bar = $(".progress-bar");
			var percent = bar.width();
			var ori_percent = bar.width();
			var minus = (ori_percent / 100) * 30;
			
			var clone = $(".clone").clone();
			$(".clone").remove();
			
			for(i=0; i<data.length; i++){
				console.log(data[i].ko);
				console.log(data[i].en);
				
				var puzzle = clone.clone();
				puzzle.find("input[type=hidden]").val(data[i].en);
				puzzle.find("h3").text(data[i].ko);
				
				var sentence = puzzle.find("input[type=hidden]");
				
				var words = sentence.val().split(" ");
				for (var j = 0; j < words.length; j++) {
					if (j % 3 == 0) {
						puzzle.append("<div class='btn-group btn-group-justified'></div>");
					}
					var btnGroup = puzzle.find(".btn-group-justified");

					var p = Math.floor((Math.random() * 100) + 1);
					if (j % 2 == 0) p = p + 1;
					else p = p - 1;

					if (p % 2 == 0) {
						btnGroup.eq(btnGroup.length - 1).append(
								"<div class='btn-group'><button type='button' class='btn btn-primary word'>" + words[j] + "</button></div>");
					} else {
						btnGroup.eq(btnGroup.length - 1).prepend(
								"<div class='btn-group'><button type='button' class='btn btn-primary word'>" + words[j] + "</button></div>");
					}
				}
				
				$("#challenge").append(puzzle);
			}
			
			$(document).on("click", ".word", function(event) {
				var root = $(event.target).parent().parent().parent();
				var sentence = root.find("input[type=hidden]").val();
				var word = $(event.target).text();
				var userSentence = root.find(".result").val();
				var compareSentence;

				var bar = $(".progress-bar");
				var percent = bar.width();

				if (userSentence == "") {
					compareSentence = word;
				} else {
					compareSentence = userSentence + " " + word;
					compareSentence = compareSentence.trim();
				}

				if (sentence.startsWith(compareSentence)) {
					root.find(".result").val(userSentence + " " + word);
					$(event.target).attr("disabled", true);
					if (sentence.localeCompare(compareSentence) == 0) {
						root.hide('slow');
						//root.remove();
					}
				} else {
					$(event.target).removeClass("btn-primary");
					$(event.target).addClass("btn-danger");
					
					setTimeout(function(){
						$(event.target).removeClass("btn-danger");
						$(event.target).addClass("btn-primary");
					},100);
					
					wrong = wrong + 1;
				}	
			});

			//체력 감소 및 게임 종료 
			var life = setInterval(function() {
				var one = ((ori_percent / 100)) * 2;
				bar.width(bar.width() - one);
				if (bar.width() <= 0) {
					alert("게임 종료");
					clearInterval(life);
				}
			}, 100);
			
			var clear = setInterval(function(){
				if($(".clone:hidden").length == data.length){
					alert("클리어, 감점:"+wrong);
					clearInterval(life);
					clearInterval(clear);
					bar.width(ori_percent);
				}
			},500);
		});
	}
</script>
<%@include file="../include/footer.jsp"%>
