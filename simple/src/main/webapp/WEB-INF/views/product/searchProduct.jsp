<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />


<!DOCTYPE html>
<html lang="en">
<head>

<style>
.page_wrap {
	text-align: center;
	font-size: 0;
}
.page_nation {
	display: inline-block;
}
.page_nation .none {
	display: none;
}
.page_nation a {
	display: block;
	margin: 0 3px;
	float: left;
	border: 1px solid #e6e6e6;
	width: 28px;
	height: 28px;
	line-height: 28px;
	text-align: center;
	background-color: #fff;
	font-size: 13px;
	color: #999999;
	text-decoration: none;
}
.page_nation .arrow {
	border: 1px solid #ccc;
}
.page_nation .pprev {
	background: #f8f8f8
		url('${contextPath}/resources/images/page_pprev.png') no-repeat center
		center;
	margin-left: 0;
}
.page_nation .prev {
	background: #f8f8f8 url('${contextPath}/resources/images/page_prev.png')
		no-repeat center center;
	margin-right: 7px;
}
.page_nation .next {
	background: #f8f8f8 url('${contextPath}/resources/images/page_next.png')
		no-repeat center center;
	margin-left: 7px;
}
.page_nation .nnext {
	background: #f8f8f8
		url('${contextPath}/resources/images/page_nnext.png') no-repeat center
		center;
	margin-right: 0;
}
.page_nation a.active {
	background-color: #42454c;
	color: #fff;
	border: 1px solid #42454c;
}
</style>


</head>
<body>

	
	<section class="ftco-section" style="padding-top: 30px;">
		<div class="container">
		<img src="${contextPath}/resources/images/product/selina.jpg" width=100%
		height=350px style="margin-bottom:30px;">
		

			<!-- 최근 본 상품 -->
			<jsp:include page="/WEB-INF/views/common/quick.jsp" flush="false" />
            <hr style="margin-top: -15px; margin-bottom: 30px;">

			

			<div class="row">
			   <c:choose>
			      <c:when test="${empty productList}">
			         <b><span style="color:black;">제품이 없습니다.</span></b>
			      </c:when>
			      <c:when test="${!empty productList}">
			      <c:forEach var="product" items="${productList}" >
				<div class="col-md-4 ftco-animate">
					<div class="blog-entry">
					<c:choose>
										<c:when
											test="${not empty product.productImage && product.productImage != 'null'}">
											<input type="hidden" name="OrignProductFile"
												value="${product.productImage}" class="block-20" />
											<a
												href="${contextPath}/product/viewProduct.do?productNum=${product.productNum}">
												<img class="block-20" style="width: 400px;"
												src="${contextPath}/download_product.do?productNum=${product.productNum}&productImage=${product.productImage}"
												id="preview" />
											</a>
										</c:when>
									</c:choose>
						
						<div class="text d-flex py-1">
										<div class="desc pl-2">
											<h3 class="heading">
												<a style="font-size:15px;"
													href="${contextPath}/product/viewProduct.do?productNum=${product.productNum}">${product.productName}</a>
											</h3>
											<hr style="margin-top: 15px; margin-bottom:10px;">
												<h3 class="heading"
													style="float: right; white-space: nowrap; margin-bottom: 10px;">
													<a href="#" style="font-size: 16px;"><fmt:formatNumber
															pattern="###,###,###" value="${product.productPrice}" />원</a>
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