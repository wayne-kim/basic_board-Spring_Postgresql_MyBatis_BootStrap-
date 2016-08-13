<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">LOGIN PAGE</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" method="post" action="doorKnock">
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">아이디</label>
							<input type="text" name='user_id' class="form-control" placeholder="Enter Title">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">비밀번호</label>
							<input type="password" name='user_pw' class="form-control" placeholder="Enter Title">
						</div>
					</div>
					<!-- /.box-body -->

					<div class="box-footer">
						<button type="submit" class="btn btn-primary">일반 로그인</button>
						<button type="submit" class="btn btn-warning" disabled="disabled">카톡 로그인</button>
						<button type="submit" class="btn btn-success" disabled="disabled">회원가입</button>
					</div>
				</form>


			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>