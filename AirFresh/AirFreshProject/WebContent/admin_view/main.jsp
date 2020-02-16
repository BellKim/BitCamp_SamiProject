<%@page import="Dto.NoticeBbsDto"%>
<%@page import="java.util.List"%>
<%@page import="Dto.ManagerMemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp"%>
<%
	HttpSession adminlogincheck = request.getSession();
	ManagerMemberDto managerMem = (ManagerMemberDto) session.getAttribute("managerLogin");
	List<NoticeBbsDto> list = (List<NoticeBbsDto>) request.getAttribute("mainList");
%>

<div class="container-fluid">
	<h1 class="mt-4">AirFresh 관리자 페이지입니다.</h1>
	<hr>
	<div class="row">
		<div class="col-xl-6">
			<div class="card mb-4">
				<div class="card-header">
					공지사항
					<div style="float: right">
						<a href="<%=request.getContextPath()%>/noticelist?command=admin">>more</a>
					</div>
				</div>
				<div class="card-body">
					
					<ul style="list-style-type: decimal;">
						<%
							for (int i = 0; i < list.size(); i++) {
						%>
						<li><a
							href="<%=request.getContextPath()%>/noticedetail?command=admin&noti_index=<%=list.get(i).getNoti_index()%>">
								<%=list.get(i).getNoti_title()%></a></li>
						<%
							}
						%>
					</ul>
				</div>
			</div>
		</div>
		<div class="col-xl-6">
			<div class="card mb-4">
				<div class="card-header">
					렌탈 리스트
					<div style="float: right">>more</div>
				</div>
				<div class="card-body"></div>
			</div>
		</div>
	</div>

</div>

<%@ include file="./include/footer.jsp"%>