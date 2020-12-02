<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%@include file="/pages/common/head.jsp"%>
	<script>
		$(function () {
			$("#sub_btn").click(function () {
				var username = $("#username").val();
				var usernamePatt = /^\w{5,12}$/
				if(!usernamePatt.test(username)){
					$("span.errorMsg").text("用户不合法！");
					return false;

				}

				var password = $("#password").val();
				var passwordPatt = /^\w{5,12}$/
				if(!passwordPatt.test(password)){
					$("span.errorMsg").text("密码不合法！");
					return false;
				}

				var repassword = $("#repwd").val();
				if(repassword!=password){
					$("span.errorMsg").text("密码不相同！");
					return false;
				}

				var email = $("#email").val();
				var emailPatt = /^[a-z\d]+(\.[a-z00\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/
				if(!emailPatt.test(email)){
					$("span.errorMsg").text("邮箱格式不正确！");
					return false;
				}

				var code = $("#code").val();
				code = $.trim(code);
				if(code==null||code==""){
					$("span.errorMsg").text("验证码不能为空！");
					return false;
				}

				$("span.errorMsg").text("");
			})


		});
	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">${msg==null?"":msg}</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" value="${username==null?"":username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" value="${email==null?"":email}"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code" id="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>

		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>