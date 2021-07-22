<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<style>
#main_box { /*아이디 선택자*/
	display: flex;
	flex-direction: column;
	align-items: center;
	padding-top: 10px;
}

#login { /*아이디 선택자*/
	display: flex;
	flex-direction: column;
	width: 1300px;
	height: 100px;
	align-items: center;
	padding-top: 10px;
	font-size: 20px;
}

.order_text {
	display: flex;
	flex-direction: column;
	align-items: center;
	padding-bottom: 20px;
	font-size: 20px;
}

table {
	height: 100px;
}

th, td {
	text-align: center;
}

th:nth-child(2n+1), td:nth-child(2n+1) {
	background-color: rgb(200, 200, 200);
}

#main-back {
	padding-top: 20px;
	text-align: center;
}
</style>
</head>
<title>주문결제창</title>
<body>


	<!-- 최근 본 상품 -->
	<div id="recentlyProduct"
		style="position: absolute; width: 120px; height: 310px; margin-left: 1700px; border: 1px solid #d2d2d2; margin-top: 0px;">
		<ul
			style="list-style: none; margin-top: 10px; padding-left: 20px; margin-bottom: 10px;">
			<li><a href="#"
				style="padding-left: -10px; padding-bottom: 1px; color: black;">최근본상품</a></li>
		</ul>
		<hr style="margin-top: 0px; margin-bottom: 0px; color: #d2d2d2;">
		<ul style="list-style: none; padding-top: 5px;">
			<li><a href="#"><img
					src="${contextPath}/resources/images/image_1.jpg"
					style="width: 100px; height: 100px; padding-top: 10px; margin-left: -30px;"></a></li>
			<li><a href="#"><img
					src="${contextPath}/resources/images/image_2.jpg"
					style="width: 100px; height: 100px; padding-top: 10px; padding-top: 10px; margin-left: -30px;"></a></li>
		</ul>
		<hr style="margin-top: 0px; margin-bottom: 0px; color: #d2d2d2;">
		<ul
			style="list-style: none; padding-left: 30px; margin-bottom: 10px; margin-top: 8px;">
			<li><a href="#"
				style="color: black; text-align: center; margin-top: 8px; padding-top: 30px;">더보기▼</a></li>
		</ul>
	</div>
	<!-- 최근본상품끝 -->

	<!-- 내용 -->
	<section class="ftco-section"
		style="padding-top: 60px; padding-bottom: 0px;">
		<div class="container">
			<div class="row justify-content-center mb-5 pb-3"
				style="background-color: #f5f5f5; border: 1px solid #e7e7e7;">
				<div class="col-md-20 heading-section ftco-animate"
					style="height: 60px;">
					<h2 class="mb-4" style="font-size: 35px; padding-top: 14px;">주문완료</h2>
				</div>
			</div>
		</div>
	</section>
	<section class="ftco-section testimony-section"
		style="padding-top: 0px;">
		<div class="container">
			<div>
				<h4 class="order_text">주문 결제가 정상적으로 완료되었습니다.</h4>
			</div>
		</div>
		<div class="container" style="padding-bottom: 50px">
			<table border="1" width="1000" align="center">
				<tr height="60">
					<th width="250" style="background-color: #212529; color: white;">주문번호</th>
					<th width="300" style="background-color: #212529; color: white;">20210604-012345</th>
					<th width="250" style="background-color: #212529; color: white;">결제방법</th>
					<th width="300" style="background-color: #212529; color: white;">카드</th>
				</tr>
				<tr height="60">
					<th width="250" style="background-color: #212529; color: white;">결제금액</th>
					<th colspan="3" width="300"><a>230,000</a> <a>원</a></th>
				</tr>
			</table>
		</div>
		<div class="container">
			<div id="main-back">
				<button onclick="location=''"
					style="height: 50px; width: 150px; font-size: 17px; background-color: #212529; color: white;"">확인</button>
			</div>
		</div>
	</section>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

</body>
</html>














