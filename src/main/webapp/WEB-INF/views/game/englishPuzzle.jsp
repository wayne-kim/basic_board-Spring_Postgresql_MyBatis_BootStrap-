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
				<div class="box-body">
					<div class="puzzle box box-primary">
						<input type="hidden" value="I'm making a English Game." />
						<h3 class="text-center">나는 영어 게임을 만드는 중이다.</h3>
					</div>
					<div class="puzzle box box-primary">
						<input type="hidden" value="I'm coding hard." />
						<h3 class="text-center">나는 열심히 코딩 중이다.</h3>
					</div>	
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
	var puzzles = $(".puzzle");

	for (var i = 0; i < puzzles.length; i++) {
		var sentence = puzzles.eq(i).find("input[type=hidden]");

		var words = sentence.val().split(" ");
		for (var j = 0; j < words.length; j++) {
			if (j % 3 == 0) {
				puzzles.eq(i).append("<div class='btn-group btn-group-justified'></div>");
			}
			var btnGroup = puzzles.eq(i).find(".btn-group-justified");

			var p = Math.floor((Math.random() * 2));

			if (p == 0) {
				btnGroup.eq(btnGroup.length - 1).append(
						"<div class='btn-group'><button type='button' class='btn btn-default'>" + words[j] + "</button></div>");
			} else {
				btnGroup.eq(btnGroup.length - 1).prepend(
						"<div class='btn-group'><button type='button' class='btn btn-default'>" + words[j] + "</button></div>");
			}
		}
		puzzles.eq(i).append("<input class='form-control text-center result' disabled>");		
	}
	
	
	$(document).on("click",".btn", function(event){
		var root = $(event.target).parent().parent().parent();
		var sentence = root.find("input[type=hidden]").val();
		var word = $(event.target).text();
		var userSentence = root.find(".result").val();
		var compareSentence;
		
		if(userSentence == ""){
			compareSentence = word;
		}else {
			compareSentence = userSentence +" "+ word;
			console.log(compareSentence);
			compareSentence = compareSentence.trim();
		}
		
		if(sentence.startsWith(compareSentence)){
			userSentence +" "+ word
			root.find(".result").val(userSentence +" "+ word);
			$(event.target).attr("disabled", true);
			if(sentence.localeCompare(compareSentence) == 0){
				root.hide('slow');
			}
		}
	})
</script>
<%@include file="../include/footer.jsp"%>
