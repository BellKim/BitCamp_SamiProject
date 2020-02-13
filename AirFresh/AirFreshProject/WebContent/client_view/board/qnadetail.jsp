<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../include/header.jsp"%>
<div class="container">
	<h1 class="mt-4 mb-3">QnA</h1>
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="index.html">Home</a></li>
		<li class="breadcrumb-item active">고객센터</li>
		<li class="breadcrumb-item active">QnA</li>
	</ol>
	
	<div class="card mb-4">
		<div class="card-body">
			<h2 class="card-title">제목</h2>
				
			<p align="right">2020-02-22</p>
			<hr>
			<p class="card-text">

				QNA내용</p>
			
		</div>

	</div>
	 <div class="media mb-4" style="padding-left:30px;">
          <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
          <div class="media-body">
            <h5 class="mt-0">관리자</h5>
            	<p>돈줘라!!</p>
            </div>
        </div>
	<div align="right" style = "padding :10px;">
				<a href="<%=request.getContextPath()%>/qnalist?command=user" class="btn btn-primary">목록</a>
	</div>
	</div>
<%@ include file="./../include/footer.jsp"%>