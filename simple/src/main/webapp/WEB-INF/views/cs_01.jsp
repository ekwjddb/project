<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<script>
    function InquiryList() {
        if (${isLogOn != true && member == null}) {
            alert("로그인이 필요합니다.");
            location.href = '${contextPath}/login_01.do';
        } else {
        	location.href='${contextPath}/board/listInquiry.do'
        }
    }
</script>
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

#recentlyProduct {
	
}
</style>


</head>
<body>
	<!-- 타이틀 -->
	<section class="ftco-section" style="padding-top: 50px;">
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
			
			<!-- 내용 -->
			<div class="btn-group btn-group-justified" role="group"
				aria-label="..." style="margin-bottom: 30px; margin-top: 10px;">
				<div class="btn-group" role="group">
					<button type="button" onclick="location.href=''"
						class="btn btn-default"
						style="font-size: 28px; font-weight: bold; border: none; color: #5a5a5a; padding-right: 210px; background-color: white; margin-left: 28px;">*공지사항</button>
				</div>
				<div class="btn-group" role="group">
					<button type="button" onclick="location.href='${contextPath}/board/listQuestion.do'"
						class="btn btn-default"
						style="font-size: 25px; border: none; color: #5a5a5a; padding-right: 210px; background-color: white;">*자주
						묻는 질문</button>
				</div>
				<div class="btn-group" role="group">
					<button type="button" onclick="InquiryList()"
						class="btn btn-default"
						style="font-size: 25px; border: none; color: #5a5a5a; padding-right: 210px; background-color: white;">*1:1문의</button>
				</div>
				<div class="btn-group" role="group">
					<button type="button" onclick="location.href=''"
						class="btn btn-default"
						style="font-size: 25px; border: none; color: #5a5a5a; background-color: white;">*A/S센터</button>
				</div>

			</div>
			<table class="table">
				<thead class="table-dark" align=center>
					<tr align="center">
						<td scope="col" width="100">번호</td>
						<td scope="col" width="500">내용</td>
						<td scope="col" width="150">작성자</td>
						<td scope="col" width="150">작성일</td>
						<td scope="col" width="80">조회수</td>
					</tr>
				<c:choose>
					<c:when test="${empty noticeList}">
						<tr height="200">
							<td colspan="5" style="background-color:white; padding-top:100px;">
								<p align="center">
									<b><span style="color:black; ">등록된 글이 없습니다.</sapn></b>
								</p>
							</td>
						</tr>	
					</c:when>
					<c:when test="${!empty noticeList}">
					<c:forEach var="notice" items="${noticeList}" varStatus="noticeNum">
						<tr
						style="border-bottom: 1px solid #c6c8ca; background-color: white; color: black;">
						<td scope="col" width="50">${noticeNum.count}</td>
						<td align="left" scope="col" width="500"><a href="${contextPath}/board/viewNotice.do?noticeNum=${notice.noticeNum}"
							style="color: black; padding-left: 30px;">${notice.noticeTitle}</a></td>
						<td scope="col" width="150">${notice.noticeWriter }</td>
						<td scope="col" width="150"><fmt:formatDate value="${notice.noticeDate}" /></td>
						<td scope="col" width="80">0</td>
					</tr>
					</c:forEach>
					</c:when>
					</c:choose>
				
				</thead>
			</table>
		</div>
		<!-- 내용 끝 -->
		
		<!-- 페이징 글번호 -->
		<div class="page_wrap" style="margin-left: 80px; margin-top: 60px;">
			<div class="page_nation">
				<a class="arrow pprev" href="#"></a> <a class="arrow prev" href="#"></a>
				<a href="#" class="active">1</a> <a href="#">2</a> <a href="#">3</a>
				<a href="#">4</a> <a href="#">5</a> <a href="#">6</a> <a href="#">7</a>
				<a href="#">8</a> <a href="#">9</a> <a href="#">10</a> <a
					class="arrow next" href="#"></a> <a class="arrow nnext" href="#"></a>
			</div>
		</div>
	</section>
</body>
</html>