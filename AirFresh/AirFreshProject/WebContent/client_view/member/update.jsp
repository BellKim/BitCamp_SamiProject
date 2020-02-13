<%@page import="Dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
MemberDto mem = (MemberDto)session.getAttribute("login");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>


	<div id="member" align="center">
		<div>
		<h2>Air FRESH 회원정보수정</h2>
		</div>
		<form id="frm" onsubmit="return validate();" action="<%=request.getContextPath() %>/updatemem" method="post">			
			<table>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" id="mem_name" name="mem_name" size="20" value="<%=mem.getMem_name() %>" readonly="readonly">						
					</td>
				</tr>
				<tr>
					<td>아이디(이메일)</td>
					<td>
						<input type="text" id="mem_id" name="mem_id" size="20" value="<%=mem.getMem_id() %>" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td>
						<input type="password" id="mem_pw" name="mem_pw" size="20" value="<%=mem.getMem_pw() %>" maxlength="20">
						<p style="font-size: 8px; color: gray;">영문,숫자,특수문자 3가지를 조합한 6자리 이상으로 입력해주세요.</p>												
					</td>
				</tr>				
				<tr>
					<td>휴대폰번호</td>
					<td>
						<input type="text" id="mem_cell" name="mem_cell" size="20" value="<%=mem.getMem_cell() %>" maxlength="12">
					</td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td>
						<input type="text" id="mem_birth" name="mem_birth" size="20" value="<%=mem.getMem_birth() %>" readonly="readonly">
						
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<input type="text" id="mem_addr1" name="mem_addr1" value="<%=mem.getMem_addr1() %>">
						<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
						<input type="text" id="mem_addr2" name="mem_addr2" value="<%=mem.getMem_addr2() %>"><br>
						<input type="text" id="mem_addr3" name="mem_addr3" value="<%=mem.getMem_addr3() %>">
						<input type="text" id="sample6_extraAddress" placeholder="참고항목"> <!-- dto에 만들어 불러올까열? -->
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="이전으로" onclick="location.href='mypage.jsp'">
						<input type="button" value="수정" id="_btnUpdate">
						<input type="button" value="회원탈퇴" id="_btnSignout" onclick="return confirm('정말로 탈퇴하시겠습니까?')">
					</td>
				</tr>

	</table>
	
	</form>
	
	</div>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
$(document).ready(function () {
		
	$("#_btnUpdate").click(function () {
		if( $("#mem_pw").val().trim() == "" ){
			alert("password를 입력해 주십시오");
			$("#mem_pw").focus();
		}		
		else if( $("#mem_cell").val().trim() == "" ){
			alert("휴대폰번호를 입력해 주십시오");
			$("#mem_cell").focus();
		}		
		else if( $("#mem_addr1").val().trim() == "" ){
			alert("주소를 입력해 주십시오");
			$("#mem_addr1").focus();
		}
		else{
			$("#frm").submit();		
		}	
	});
	
	$("#_btnSignout").click(function () {		
		//id, pw 입력받아 확인후 삭제됨, 새창 또는 팝업창으로 입력칸을 띄우던가 수정 요!		
		location.href = 'signout.jsp';	<%-- "<%=request.getContextPath() %>/delmem" --%>
	});
	
});

function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('mem_addr1').value = data.zonecode;
            document.getElementById("mem_addr2").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("mem_addr3").focus();
        }
    }).open();
}

function validate() {			
	var pw = $("#mem_pw").val();	// 특수문자 / 문자 / 숫자 포함 형태의 6~20자리 이내의 암호 정규식
	var pwReg = /^.*(?=^.{6,20}$)(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
		
	var cell= $("#mem_cell").val();	// 핸드폰번호 정규식
	var cellReg = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;
		
	if(pwReg.test(pw)==false){
		alert("패스워드는 6~20자리 이내의 영문,숫자,특수문자로만 입력해주세요.");
		pw = "";
		$("#mem_pw").focus();
		return false;
	}else if(cellReg.test(cell)==false){
		alert("적합하지 않은 휴대폰번호 형식입니다.");
		cell = "";
		$("#mem_cell").focus();
		return false;
	}
	return true;	
}


</script>


</body>
</html>