<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
<script type="text/javascript">
$('document').ready(function() {
	 var area0 = ["카테고리 선택","침대","소파","화장대/옷장/수납","식탁/의자","테이블/책상/책장"];
	  var area1 = ["싱글","킹","이층침대","패밀리","퀸"];
	   var area2 = ["코너형","1인/웜체어","패브릭","리클라이너","4/6인 일자형"];
	   var area3 = ["거실장","장식장","화장대/콘솔","옷장","서랍장"];
	   var area4 = ["2인 이상","4인 이상","8인 이상", "식탁의자","테이블의자"];
	   var area5 = ["소파 테이블","좌식 테이블","원목 테이블", "다용도 테이블","책상/책장"];
	   // 카테고리 선택 박스 초기화
	 //하위카테고리 선택 박스 초기화

	   $("select[name^=category]").each(function() {
	    $selcategory = $(this);
	    $.each(eval(area0), function() {
	     $selcategory.append("<option value='"+this+"'>"+this+"</option>");
	    });
	    $selcategory.next().append("<option value=''>하위 카테고리 선택</option>");
	   });



	   // 카테고리 선택시 하위카테고리 설정

	   $("select[name^=category]").change(function() {
	    var area = "area"+$("option",$(this)).index($("option:selected",$(this))); // 선택지역의 Array
	    var $subcategory = $(this).next(); // 선택영역 객체
	    $("option",$subcategory).remove(); // 하위카테고리 초기화

	    if(area == "area0")
	     $subcategory.append("<option value=''>하위 카테고리 선택</option>");
	    else {
	     $.each(eval(area), function() {
	      $subcategory.append("<option value='"+this+"'>"+this+"</option>");
	     });
	    }
	   });


	   });

</script>
</head>
<body>

	
	<img src="${contextPath}/resources/images/product-01.jpg" width=100%
		height=350px>

	<section class="ftco-section" style="padding-top: 30px;">
		<div class="container">
			<div class="row justify-content-center mb-5 pb-3"
				style="background-color: #f5f5f5; border: 1px solid #e7e7e7; margin-top: 20px;">
				<div class="col-md-20 heading-section ftco-animate"
					style="height: 60px;">
					<h2 class="mb-4" style="font-size: 35px; margin-top: 15px;">상품 관리</h2>
				</div>
			</div>

			

			<div class="btn-group btn-group-justified" role="group"
				aria-label="..." style="margin-bottom: 30px; margin-top: 10px;">
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default" onclick="location.href='${contextPath}/product/admin_listProduct.do'"
						style="font-size: 25px; border: none; color: #5a5a5a; padding-right: 210px; background-color: white; margin-left: 10px; font-weight: bold;">*상품조회</button>
				</div>
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default" onclick="location.href='${contextPath}/product/add_product.do'"
						style="font-size: 25px; border: none; color: #5a5a5a; padding-Zright: 210px; background-color: white;">상품등록</button>
				</div>
			
			</div>

		
			<hr style="margin-top: -10px;">

              <select style="width:190px; height:35px;" name="category" id="category"></select>                   
              <select style="width:190px; height:35px;" name="subcategory" id="subcategory"></select>
              <button class="btn btn-primary" name="btnSearch" id="btnSearch">조회</button> 
	
           <hr style="margin-top: 15px;">

              
			<div class="row">
			   <c:choose>
			      <c:when test="${empty admin_productList}">
			         <b><span style="color:black;">등록된 상품이 없습니다.</sapn></b>
			      </c:when>
			      <c:when test="${!empty admin_productList}">
			      <c:forEach var="product" items="${admin_productList}" varStatus="productNum">
				<div class="col-md-4 ftco-animate">
					<div class="blog-entry">
					<c:choose>		
				<c:when test="${not empty product.productImage && product.productImage != 'null'}">
					<input type="hidden" name="OrignProductFile" value="${product.productImage}"class="block-20" />
					<a href="${contextPath}/product/viewProduct.do?productNum=${product.productNum}">
				   <img  class="block-20" style=" width: 346px;"src="${contextPath}/download_product.do?productNum=${product.productNum}&productImage=${product.productImage}" id="preview" /></a><br>
						</c:when>
			</c:choose>
						<div class="text d-flex py-1">
							<div class="desc pl-2">
								<h3 class="heading">
									<a href="${contextPath}/product/admin_detailproduct.do?productNum=${product.productNum}">${product.productName}</a>
								</h3>
								<hr style="margin-top: 25px;">
							
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
				</c:when>
				</c:choose>
			
				
			
			</div>
		</div>
		
		<!-- 페이징 글번호 -->
		<div class="page_wrap" style="margin-left: 80px; margin-top: 60px;">
			<div class="page_nation" style="text-align: center;">

				<c:if test="${pageMaker1.prev}">

					<a class="arrow prev"
						href='<c:url value="/product/admin_listProduct.do?page=${pageMaker1.startPage-1 }"/>'><i
						class="fa fa-chevron-left"></i></a>

				</c:if>
				<c:forEach begin="${pageMaker1.startPage }"
					end="${pageMaker1.endPage }" var="pageNum">

					<a href='<c:url value="/product/admin_listProduct.do?page=${pageNum }"/>'><i
						class="fa">${pageNum }</i></a>

				</c:forEach>
				<c:if test="${pageMaker1.next && pageMaker1.endPage >0 }">

					<a class="arrow next"
						href='<c:url value="/product/admin_listProduct.do?page=${pageMaker1.endPage+1 }"/>'><i
						class="fa fa-chevron-right"></i></a>

				</c:if>

			</div>
		</div>



	</section>


</body>
</html>