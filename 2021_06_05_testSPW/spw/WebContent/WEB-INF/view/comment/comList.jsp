<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="/spw/include/js/strByte.js"></script>
<script type="text/javascript" src="/spw/include/js/comment-aj.js"></script>
<div class="comment_wrap" id="commentWrap">
	<div class="comment_content">
	<c:if test="${empty commentList}">
		<div class="comment_root">
			<div class="comment_row">
				댓글이 없습니다.
			</div>
		</div>
	</c:if>
	<c:forEach items="${commentList}" var="cvo">
		<c:if test="${cvo.cdelyn == 'Y'}">

			<c:if test="${empty cvo.ctargetnum}">
				<c:set var="commtype" value="comment_root"/>
			</c:if>
			<c:if test="${not empty cvo.ctargetnum}">
				<c:set var="commtype" value="comment_re"/>
			</c:if>
			
			<div class="${commtype}">
				<div class="comment_row" id="Comment-${cvo.cnum}">
					삭제된 댓글입니다.
				</div>
			</div>
		</c:if>
		<c:if test="${cvo.cdelyn == 'N'}">
		
			<c:if test="${empty cvo.ctargetnum}">
				<c:set var="commtype" value="comment_root"/>
			</c:if>
			<c:if test="${not empty cvo.ctargetnum}">
				<c:set var="commtype" value="comment_re"/>
			</c:if>
			<div class="${commtype}">
				<div class="comment_row" id="Comment-${cvo.cnum}">
					<div class="comment_top">
						<span class="comment_writer">${cvo.mname}</span>
						<span class="comment_date">(${cvo.cindate})</span>
						<div class="comment_btns">
							<input type="button" class="btnUpdate sitebtn" value="수정" data-cnum="${cvo.cnum}">
							<input type="button" class="btnDelete sitebtn" value="삭제" data-cnum="${cvo.cnum}">
							<input type="button" class="btnReComment sitebtn" value="답글"
									data-cgroupnum="${cvo.cgroupnum}" data-ctargetnum="${cvo.cnum}">
						</div>
					</div>
					<div class="comment_txt">
						<c:if test="${not empty cvo.ctargetnum && not empty cvo.tarname}">
							<a href="#Comment-${cvo.ctargetnum}" class="recomm_target">${cvo.tarname}</a>
						</c:if>
						${cvo.ccontents}
					</div>
				</div>
				<div class="formShow"></div>
			</div>
		</c:if>
	</c:forEach>
	</div>
</div>
<div class="formbox formbox_100">
	<div class="formcontent">
		<form method="POST" id="insertComment">
			<textarea name="ccontents" class="sitetxt form_ele_max ccontents"></textarea>
			<div class="formrow formrow_right">
				<input type="hidden" class="cpnum" name="cpnum" value="${param.cpnum}" readonly>
				<span class="commentByte">0</span><span>/300 Byte</span>&nbsp;&nbsp;
				<input type="submit" class="sitebtn" value="작성">
			</div>
		</form>
	</div>
</div>

<div id="commentFormTemplate" style="display:none;">
	<form method="POST" id="insertReComment">
		<div class="formcontent">
			<h3 class="cformtitle">답글</h3>
			<textarea id="areabox" name="ccontents" class="sitetxt form_ele_max ccontents"></textarea>
			<div class="formrow formrow_right">
				<input type="hidden" class="cgroupnum" name="cgroupnum" readonly>
				<input type="hidden" class="ctargetnum" name="ctargetnum" readonly>
				<input type="hidden" class="cpnum" name="cpnum" value="${param.cpnum}" readonly>
				<span class="commentByte">0</span><span>/300 Byte</span>&nbsp;&nbsp;
				<input type="submit" class="sitebtn " value="작성">
			</div>
		</div>
	</form>
</div>

<%-- <input type="button" id="btnCommReload" value="새로고침"> --%>

<div id="commentRowTemplate" style="display:none;">
	<div>
		<div class="comment_row" id="Comment-">
			<div class="comment_top">
				<span class="comment_writer">txt</span>
				<span class="comment_date">(<span>txt</span>)</span>
				<div class="comment_btns"></div>
			</div>
			<div class="comment_txt">
				<a href="#Comment-" class="recomm_target"></a>
				<span>txt</span>
			</div>
		</div>
		<div class="formShow"></div>
	</div>
</div>

