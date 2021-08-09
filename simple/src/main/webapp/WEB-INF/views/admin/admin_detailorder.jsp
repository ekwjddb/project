<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<style>


<style type="text/css">
.table-light {
	background: #F7F7F7;
}

.table {
	table-border: 2px;
}

h4 {
	margin-top: 60px;
	font-weight: bold;
}
</style>
</head>
<title>관리자 회원/비회원 주문상세창</title>
<body>


	<!-- 타이틀 -->
	<section class="ftco-section" style="padding-top: 60px;">
		<div class="container">
			<div class="row justify-content-center mb-5 pb-3"
				style="background-color: #f5f5f5; border: 1px solid #e7e7e7;">
				<div class="col-md-20 heading-section ftco-animate"
					style="height: 60px;">
					<h2 class="mb-4" style="font-size: 35px; padding-top: 14px;">관리자 회원/비회원 주문조회</h2>
				</div>
			</div>
			<!-- 타이틀 끝 -->
			<!-- 내용 -->
			<section class="ftco-section testimony-section"
				style="padding-top: 30px;">

			<div class="order_list text-center">
				<table class="table">
                  
					<thead class="table-dark">
						<tr>
						    <th scope="col" style="">주문번호</th>
							<th scope="col">제품</th>
							<th scope="col">수량</th>
							<th scope="col">가격</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="item" items="${nonOrderLookupList }">
						<tr>
						    <th scope="col" style=" padding-top: 15px;">${item.nonMemOrderNum}</th>
							<th scope="col"><img src="${contextPath}/download_product.do?productNum=${item.productNum}&productImage=${item.productImage}"style="width: 40px;height: 40px;margin-right: 20px;" >${item.productName}
							
							</th>
							<th scope="col" style=" padding-top: 15px;">${item.productCnt}</th>
							<th scope="col" style=" padding-top: 15px;">${item.productPrice}</th>
						</tr>
					</c:forEach>
					</tbody>
					
				</table>
			</div>

          
			<h4>주문자정보</h4>
			<a>주문일자: ${nonOrderLookupList[0].nonMemOrderDate }</a>
			<div class="order_list">
				<table class="table">
				
					<colgroup>
						<col width="20%" />
					</colgroup>
					<tbody>
						<tr>
							<th scope="col" style="padding-left: 40px"class="table-dark">이름</th>
							<th scope="col">${nonOrderLookupList[0].nonMemName }</th>
						</tr>
						<tr>
							<th scope="col" style="padding-left: 40px"class="table-dark">전화번호</th>
							<th scope="col">${nonOrderLookupList[0].nonMemPhoneNum }</th>
						</tr>
						<tr>
							<th scope="col" style="padding-left: 40px"class="table-dark">이메일</th>
							<th scope="col">${nonOrderLookupList[0].nonEmail }</th>
						</tr>
					</tbody>
				</table>
			</div>

			<h4>수령인정보</h4>
			<div class="order_list">
				<table class="table">
					<colgroup>
						<col width="20%" />
					</colgroup>
					<tbody>
						<tr>
							<th scope="col" style="padding-left: 40px" class="table-dark">이름</th>
							<th scope="col">${nonOrderLookupList[0].nonMemSpName }</th>
						</tr>
						<tr>
							<th scope="col" style="padding-left: 40px"class="table-dark">주소</th>
							<th scope="col">${nonOrderLookupList[0].nonMemSpAdr }</th>
						</tr>
						<tr>
							<th scope="col" style="padding-left: 40px"class="table-dark">연락처1</th>
							<th scope="col">${nonOrderLookupList[0].nonMemPhoneNum1 }</th>
						</tr>
						<tr>
							<th scope="col" style="padding-left: 40px"class="table-dark">연락처2</th>
							<th scope="col">${nonOrderLookupList[0].nonMemPhoneNum2 }</th>
						</tr>
						<tr>
						<th scope="col" style="padding-left: 40px; padding-bottom: 50px;"class="table-dark"><br>주문메세지<br>(100자내외)</th>
						<th scope="col"><textarea name="textarea" rows="4" cols="40" readonly>${nonOrderLookupList[0].nonMemOrderMsg }</textarea></th>
						</tr>
					
					</tbody>
				</table>
			</div>
			
			<h4>배송정보</h4>
			<div class="order_list">
				<table class="table">
					<colgroup>
						<col width="20%" />
					</colgroup>
					<tbody>
						<tr>
							<th scope="col" style="padding-left: 40px"class="table-dark">배송상태</th>
							<th scope="col">${nonOrderLookupList[0].currentStatus }</th>
						</tr>

					</tbody>
				</table>
			</div>

			<h4>결제정보</h4>
			<div class="order_list">
				<table class="table">
					<colgroup>
						<col width="20%" />
					</colgroup>
					<tbody>
						<tr>
							<th scope="col" style="padding-left: 40px"class="table-dark">결제방법</th>
							<th scope="col">${nonOrderLookupList[0].nonMemPaymentMethod }</th>
						</tr>
						<tr>
							<th scope="col" style="padding-left: 40px"class="table-dark">무통장 입금자명</th>
							<th scope="col">${nonOrderLookupList[0].nonMemDepositorName }</th>

						</tr>
						
					</tbody>
				</table>
			</div>
		
			<br> <br>

				<div class="container">
					<div id="main-back" style="text-align: center;">
						<button onclick="location='${contextPath}/main.do'"
							style="height: 50px; width: 150px; font-size: 17px; background-color: #212529; color: white; border-radius: 2px;">확인</button>
					</div>
				</div>
			</section>
		</div>
	</section>
	<!-- 내용 끝 -->
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














