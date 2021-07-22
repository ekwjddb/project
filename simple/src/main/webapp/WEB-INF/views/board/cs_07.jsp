<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<style>

#buttonmy {
	width: 80px;
	height: 30px;
	float: left;
	border-radius: 2px;
	padding-top: 1.8px;
}
</style>


</head>
<body>
	<!-- 타이틀 -->
	<section class="ftco-section"
		style="padding-top: 50px; margin-bottom: 50px;">
		<div class="container">
			<div class="row justify-content-center mb-5 pb-3"
				style="background-color: #f5f5f5; border: 1px solid #e7e7e7; margin-top: 50px;">
				<div class="col-md-20 heading-section ftco-animate"
					style="height: 60px;">
					<h2 class="mb-4" style="font-size: 35px; margin-top: 15px;">고객센터</h2>
				</div>
			</div>
			<!-- 타이틀 끝 -->
			<!-- 최근 본 상품 -->
			<div id="recentlyProduct"
				style="position: absolute; width: 120px; height: 310px; margin-left: 1370px; border: 1px solid #d2d2d2; margin-top: -100px;">
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
			<!-- 최근 본 상품 끝 -->
			<jsp:include page="/WEB-INF/views/common/csMenu.jsp" flush="false" />			
			<!-- 내용 -->

			<table class="table" style="margin-top: 20px; text-align: center;">

				<thead class="table-dark" align=center>
					<tr style="border-bottom: 1px solid grey; height: 30px;">
						<td>배송 언제 되나요</td>

					</tr>
					<tr
						style="height: 200px; text-align: left; background-color: white;">
						<td style="padding-bottom: 150px; color: black;">5월 말에 주문 했는데
							배송은 언제 되나요?</td>
					</tr>
					<tr style="height: 30px;">
						<td>[답변]배송 언제 되나요</td>

					</tr>
					<tr
						style="border-bottom: 0.5px solid grey; height: 200px; text-align: left; background-color: white;">
						<td style="padding-bottom: 150px; color: black;">홍길동 고객님
							안녕하세요. 주문하신 상품은 6/4일 오늘 출고 예정입니다.조금만 기다려주세요^^</td>
					</tr>
				</thead>
			</table>
			<button id="buttonmy" type="submit" class="btn btn-dark"
				style="float: left; margin-left: 590px; margin-top: 30px;">목록</button>
			<button id="buttonmy" type="submit" class="btn btn-dark"
				style="float: left; margin-left: 1100px; margin-top: -30px;">수정</button>
			<button id="buttonmy" type="submit" class="btn btn-dark"
				style="float: left; margin-left: 1190px; margin-top: -30px;">삭제</button>
		</div>
	</section>
	<!-- 내용 끝 -->
</body>
</html>