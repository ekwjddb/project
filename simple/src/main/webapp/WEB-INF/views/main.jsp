<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>

	<!-- END nav -->

	<section class="home-slider js-fullheight owl-carousel">
		<div class="slider-item js-fullheight"
			style="background-image:url(${contextPath}/resources/images/bg_1.jpg);">
			<div class="overlay"></div>
			<div class="container">
				<div
					class="row no-gutters slider-text js-fullheight align-items-center justify-content-end"
					data-scrollax-parent="true">
					<div class="col-md-7 text ftco-animate"
						data-scrollax=" properties: { translateY: '70%' }">
						<h1 class="mb-4"
							data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">안녕하세요
							3조 쇼핑몰입니다.</h1>
						<p data-scrollax="properties: { translateY: '30%', opacity: 1.6 }"></p>

					</div>
				</div>
			</div>
		</div>

		<div class="slider-item js-fullheight"
			style="background-image:url(${contextPath}/resources/images/bg_2.jpg);">
			<div class="overlay"></div>
			<div class="container">
				<div
					class="row no-gutters slider-text js-fullheight align-items-center justify-content-end"
					data-scrollax-parent="true">
					<div class="col-md-7 text ftco-animate"
						data-scrollax=" properties: { translateY: '70%' }">
						<h1 class="mb-4"
							data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">^^</h1>

					</div>
				</div>
			</div>
		</div>
	</section>


	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center mb-5 pb-3">
				<div class="col-md-20 heading-section ftco-animate">
					<h2 class="mb-4">이달의 BEST 상품</h2>

				</div>
			</div>
			<div class="row">
			   <c:choose>
			      <c:when test="${empty BestProductMap.BestProductList}">
			         <b><span style="color:black;">등록된 상품이 없습니다.</span></b>
			      </c:when>
			      <c:when test="${!empty BestProductMap.BestProductList}">
			      <c:forEach var="product" items="${BestProductMap.myProductList}">
				<div class="col-md-4 ftco-animate">
					<div class="blog-entry">
						
					<a href="${contextPath}/product/viewProduct.do?productNum=${product.productNum}">
				   <img  class="block-20" style="width: 346px;"src="${contextPath}/download_product.do?productNum=${product.productNum}&productImage=${product.productImage}" id="preview" /></a><br>
						
			
						<div class="text d-flex py-1">
							<div class="desc pl-2">
								<h3 class="heading">
									<a href="${contextPath}/product/viewProduct.do?productNum=${product.productNum}">${product.productName}</a>
								</h3>
								<hr style="margin-top: 25px;">
								<h3 class="heading"
									style="padding-left: 67%; white-space: nowrap;">
									<a href="${contextPath}/product/viewProduct.do?productNum=${product.productNum}" style="font-size: 22px;"><fmt:formatNumber pattern="###,###,###" value="${product.productPrice}"/></a>
								</h3>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
				</c:when>
				</c:choose>
				
			
			</div>
				
		</div>
	</section>
</body>
</html>