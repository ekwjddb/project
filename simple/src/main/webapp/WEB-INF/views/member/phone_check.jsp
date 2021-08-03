<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">
//비밀번호 찾기_핸드폰_인증번호_확인
	function Approval_key_find_phone() {
		var form = document.Approval_key_send_phone;
		if (form.Approval_key.value == "") {
			alert("인증번호를 입력해주세요!");
			form.Approval_key.focus();

		} else {
			form.submit();
		}
	}
	 
</script>
</head>
<title>핸드폰 인증창</title>
<body>
<form name="Approval_key_send_phone" method="post" style="margin-bottom: 15px;" action="phone_confirm.do">
				<input type="text" name="Approval_key" id="Approval_key" style="margin-bottom: 10px; font-size: 14px;  border: 1px solid #dcdcdc; width: 163px; height: 36px;"
					size="37" placeholder="인증번호를 입력하세요">
				<button type="button" onclick="Approval_key_find_phone()"
					style="width: 160px; background-color: #7e9c8c; color:white; height:36px; border:none; border-radius: 2px;">인증번호 전송</button>
</form>

</body>
</html>
