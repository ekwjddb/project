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
#Mypage { /*아이디 선택자*/
	display: flex;
	flex-direction: column;
	width: 1300px;
	height: 100px;
	align-items: center;
	padding-top: 10px;
	padding-right: 20px;
	font-size: 10px;
}
.my_row {
	flex-direction: row;
}
.container1 {
	width: 250px;
}
.container2 {
	width: 800px;
}
#sect {
	display: flex;
	flex-direction: row;
	padding-bottom: 10px;
}
.nav_MyPage {
	width: 120px;
	list-style-type: none;
	margin: 0;
	padding: 0;
	font-size: 14px;
}
#MyPage_center1 {
	border: 1px solid rgb(140, 140, 140);
}
.nav_MyPage li a {
	display: block;
	color: #000000;
	padding: 8px;
	text-align: center;
	text-decoration: none;
	font-weight: bold;
}
.nav_MyPage li a.current {
	background-color: rgb(200, 200, 200);
	color: block;
}
.nav_MyPage li a: hover:not(.current) {
	background-color: #CD853F;
	color: white;
}
#MyPage_top {
	padding-top: 50px;
	align-items: center;
	width: 700px;
	height: 100px;
}
#MyPage_top1 {
	padding-top: 50px;
	align-items: center;
	padding-left: 330px;
	width: 700px;
	height: 100px;
}
#MyPage_top2 {
	padding-top: 50px;
	align-items: center;
	padding-left: 200px;
	width: 700px;
	height: 100px;
}
.PASSWORD_confirm_text {
	position: relative;
	left: 15px;
}
#MyPage_top3 {
	align-items: center;
	padding-left: 300px;
	width: 700px;
	height: 100px;
}
.btn_PASSWORD_confirm {
	position: relative;
	font-size: 15px;
	width: 80px;
}
.btn_main_back {
	position: relative;
	left: 14px;
	font-size: 15px;
	width: 80px;
}
#Mypage_nav {
	width: 400px;
}
#Mypage-center {
	display: flex;
	flex-direction: row;
}
#Mypage_nav {
	display: flex;
	flex-direction: column;
	width: 120px;
}
.Easy-sgin-in-wrap {
	display: flex;
	flex-direction: column; /*column으로 정렬 */
	float: right;
}
.Easy-sgin-in-wrap .sign-button-list {
	list-style: none;
	width: 350px;
	display: flex;
	flex-direction: column;
}
.Easy-sgin-in-wrap .sign-button-list li {
	padding-top: 10px;
}
.Easy-sgin-in-wrap .sign-button-list li button {
	width: 350px;
	height: 40px;
	border: 1px solid rgb(0, 0, 0);
	text-align: center;
	background: rgb(255, 255, 255);
}
.Easy-sgin-in-wrap .sign-button-list li button i {
	font-size: 10px;
}
</style>
</head>
<title>주문결제창</title>
<body>
	<section class="ftco-section"
		style="padding-top: 50px; margin-bottom: 50px; padding-bottom: 0px; margin-bottom:500px;">
		<div class="container" style="margin-bottom: 100px;">
			<div class="row justify-content-center mb-5 pb-3"
				style="background-color: #f5f5f5; border: 1px solid #e7e7e7; margin-top: 50px;">
				<div class="col-md-20 heading-section ftco-animate"
					style="height: 60px;">
					<h2 class="mb-4" style="font-size: 35px; margin-top: 15px;">최근
						본 상품</h2>
				</div>
			</div>

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






			<!-- 내용 -->


			<div class="order_list">

				<table class="table" style="width: 1400px;">
					<thead class="table-dark" align=center>
						<tr align="center"
							style="background-color: #212529; color: white;">
							<td scope="col" width="300"></td>
							<td scope="col" width="800" align="center">상품</td>
							<td scope="col" width="300">금액</td>
				
						</tr>
					</thead>
					<tbody>
	
						<tr>
							
							<td scope="col" align="center"><img
								src="${contextPath}/resources/images/chair01.jpg" width=130
								height=130></td>
							<td scope="col" align="center" style="padding-top: 0px;"><br>
							<br>
							<br>원목의자</td>
							<td scope="col" align="center" style="padding-top: 0px;"><br>
							<br>
							<br>100,000</td>
						</tr>


					</tbody>
				</table>

			</div>
		</div>
	</section>



  </body>
</html>