<%@page import="db.DBConnection"%>
<%@page import="Dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
MemberDto mem = (MemberDto)session.getAttribute("login");
%> 
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<%@ include file="./../include/header.jsp"%>
<div class="container" align="center">
	<div class="title">
		<h2 class="mt-4 mb-3">AirFresh몰 회원탈퇴</h2>	
		<p>안전한 개인 정보 보호를 위해 비밀번호를 다시 한 번 확인하고 있습니다.</p>	
	</div>	
	<div class="login">
		<form id="loginInfo" action="<%=request.getContextPath() %>/delmem" method="post">			
			<input type="hidden" name="command" value="deleteAf">	
			<div>
			<div>
				아이디:<input type="text" placeholder="아이디(이메일)을 입력해주세요." id="mem_id" name="mem_id">
			</div>
			<div>
				비밀번호:<input type="password" placeholder="비밀번호를 입력해주세요." id="mem_pw" name="mem_pw">	
			</div>			
			</div>			
			<button type="button" id="btnSignout">회원탈퇴</button>							
		</form>
	</div>
</div>

<script type="text/javascript">

$("#btnSignout").click(function () {
	if( $("#mem_id").val().trim() == "" ){
		alert("id를 입력해 주십시오");
		$("#mem_id").focus();
	}
	else if( $("#mem_pw").val().trim() == "" ){
		alert("password를 입력해 주십시오");
		$("#mem_pw").focus();
	}
	else{
		$("#loginInfo").submit();
	}
});

</script>
<%@ include file="./../include/footer.jsp"%>