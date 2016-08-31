<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Database Lab | Log in</title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<!-- Bootstrap 3.3.4 -->
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<!-- Font Awesome Icons -->
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
<!-- iCheck -->
<link href="/resources/plugins/iCheck/square/blue.css" rel="stylesheet" type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="/">
				<b>Database</b> Lab
			</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">Join Request</p>

			<form action="/user/joinRequest" method="post">
				<div class="form-group has-feedback">
					<input type="text" name="user_id" class="form-control" placeholder="USER ID" />
					<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" name="user_pw" class="form-control" placeholder="Password" />
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" placeholder="Password Confirm" />
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="text" name="user_name" class="form-control" placeholder="Name" />
					<span class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8"></div>
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">가입 요청</button>
					</div>
				</div>
			</form>
		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 2.1.4 -->
	<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<!-- Bootstrap 3.3.2 JS -->
	<script src="/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<!-- iCheck -->
	<script src="/resources/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});

		$("form").submit(function(event) {
			var inputs = $("input");
			var check = false;
			
			for (var i = 0; i < inputs.length; i++) {
				var input = inputs.eq(i);
				if (input.val() == "") {
					input.focus();
					alert(input.attr("placeholder") + "를 입력해주세요.");
					check = true;
					
					return false;
				}
			}

			//아이디 중복확인
			$.ajax({
				type : 'POST',
				url : '/user/checkOverlap',
				data : {
					user_id : inputs.eq(0).val()
				},
				async : false,
				success : function(result) {
					if (result == "FAIL") {
						alert("중복된 아이디 입니다.");
						check = true;
						inputs.eq(0).focus();
					}
				}
			});
			
			//비밀번호 확인
			if (inputs.eq(1).val() != inputs.eq(2).val()) {
				alert("비밀번호가 서로 다릅니다.");
				inputs.eq(1).focus();
				return false;
			}
			
			//Ajax를 위해서
			if(check) {
				return false;
			}else{
				alert("가입 요청이 되었습니다. 관리자의 승인이 될 때까지 기다려주세요.")
			}
		});
	</script>
</body>
</html>