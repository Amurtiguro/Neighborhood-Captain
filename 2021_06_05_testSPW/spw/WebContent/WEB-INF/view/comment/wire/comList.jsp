<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/spw/js/jquery-1.12.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){

		// 댓글 목록의 최상위 요소 ID
		var commentRootID = "#commentList";

		// 수정/답글 폼을 보여줄 요소의 클래스명
		var showFormClassName = ".formShow";
		
		// 수정/답글 폼
		var $commentUpdateForm = $("#insertReComment").clone();
		var $commentReCommentForm = $("#insertReComment").clone();

		// 수정 폼 가공
		$commentUpdateForm.attr("id", "updateComment");
		$commentUpdateForm.find("input.cgroupnum").closest("tr").remove();
		$commentUpdateForm.find("input.ctargetnum").closest("tr").remove();

		$commentUpdateForm.find("input.cpnum").attr({"class": "cnum", "name": "cnum"}).val("");
		$commentUpdateForm.find("input.cnum").closest("tr").find("th").text("댓글번호");

		// 견본폼 삭제
		$("#commentFormTemplate").remove();

		$("#updateComment").remove();

		console.log($commentUpdateForm);

		// 댓글 없을때 메세지 표시
		var $noCommentMsg = $("<tr><td colspan='14' align='center'>댓글이 없습니다.</td></tr>");

		// 상품번호 가져오기
		var cpNum = null;

		// 쿼리스트링
		var qStr = location.search;
		console.log("Query String => " + qStr);

		if(qStr != null && qStr != ""){
			qStr = qStr.replace("?", "");
			var qArr = qStr.split("&");

			if(qArr != null && qArr.length > 0){
				for(var i = 0; i < qArr.length; i++){
					var qData = qArr[i].split("=");

					if(qData != null && qData.length > 0){
						if(qData[0] == "cpnum"){
							cpNum = qData[1];
							break;
						}
					}
				}
			}
		}
		console.log("cpNum => " + cpNum);

		// 테이블 한줄 만들기
		function generateRow(rowData){
			var $rowRoot = $("<tr>");

			// 대댓글/최상위 댓글 감지
			var isRoot = false;
			if(rowData.ctargetnum == null || rowData.ctargetnum == ""){
				isRoot = true;
			}

			var commType = "대 댓글";
			if(isRoot == true){
				commType = "최상위 댓글";
			}

			// 답글
			var btnReComment = "<input type='button' class='btnReComment' value='답글' "
								+ "data-cgroupnum='" + rowData.cgroupnum + "' "
								+ "data-ctargetnum='" + rowData.ctargetnum + "'>";

			// 수정
			var btnUpdate = "<input type='button' class='btnUpdate' value='수정' "
							+ "data-cnum='" + rowData.cnum + "'>";

			// 삭제
			var btnDelete = "<input type='button' class='btnDelete' value='삭제' "
							+ "data-cnum='" + rowData.cnum + "'>";

			$rowRoot.append(getCol(rowData.cnum));
			$rowRoot.append(getCol(rowData.ccontents));
			$rowRoot.append(getCol(rowData.cgroupnum));
			$rowRoot.append(getCol(rowData.ctargetnum));
			$rowRoot.append(getCol(rowData.cpnum));
			$rowRoot.append(getCol(rowData.cindate));
			$rowRoot.append(getCol(rowData.mnum));
			$rowRoot.append(getCol(rowData.mname));
			$rowRoot.append(getCol(rowData.mid));
			$rowRoot.append(getCol(commType));
			$rowRoot.append(getCol(rowData.tarname));
			$rowRoot.append($("<td>").html(btnReComment));
			$rowRoot.append($("<td>").html(btnUpdate));
			$rowRoot.append($("<td>").html(btnDelete));

			// 열 만들기
			function getCol(colText){
				var $colEle = $("<td>");
				var resText = "";

				if(colText != null && colText != ""){
					resText = colText;
				}

				$colEle.text(resText);

				return $colEle;
			}

			return $rowRoot;
		}

		// 댓글 새로고침
		function reloadComment(){
			// 댓글목록
			$commentList = $(commentRootID).children("tbody");

			// 성공
			function reloadSuccess(data){
				console.log("data =>" + data);

				// 상태가 OK라면(댓글목록을 가져왔다면)
				if(data.status == "OK"){
					var commentsData = data.comments;

					// 댓글목록이 있으면
					$commentList.empty();
					if(commentsData != null && commentsData.length > 0){

						// 댓글 출력
						for(var i = 0; i < commentsData.length; i++){
							var commData = commentsData[i];
							var $commRow = null;

							// 삭제된 댓글이 아니라면 내용 출력하기
							if(commData.cdelyn != null && commData.cdelyn == "N"){
								$commRow = generateRow(commData);
							}else{
								// 대댓글 / 최상위댓글 감지
								var isRoot = false;
								if(commData.ctargetnum == null || commData.ctargetnum == ""){
									isRoot = true;
								}

								var commType = "대댓글";
								if(isRoot == true){
									commType = "최상위 댓글";
								}

								$commRow = $("<tr>"
												+ "<td colspan='9' align='center'>삭제된 댓글입니다.</td>"
												+ "<td colspan='5'>" + commType + "</td>"
											+ "</tr>");
							}

							$commentList.append($commRow);
						}
					}else{
						$commentList.append($noCommentMsg);
					}
				}else if(data.status == "ERROR"){
					alert(data.msg);
				}
			}

			// 목록 불러오기 실패
			function reloadError(){
				alert("Error!");
			}

			// URL
			var dataUrl = "/spw/comment/listData.spw";

			// 전송할 데이터
			var dataArr = {cpnum: cpNum};

			// ajax
			$.ajax({
				url: dataUrl,
				data: dataArr,
				type : "GET",
				success: reloadSuccess,
				error: reloadError
			});
		}

		// 댓글 쓰기
		function insertComment(formEle, fnAct){
			console.log("Insert Comment");

			var insertURL = "/spw/comment/insert.spw";

			// 전송할 데이터
			var sendData = formEle.serialize();
			console.log("sendData => " + sendData);

			// 성공
			function insertSuccess(data){
				console.log("댓글 입력", data);

				// 응답데이터가 정상이면 메세지 출력
				if(data != null){
					if(data.status != null){
						alert(data.msg);
						// data.status가 OK면(댓글 등록이 성공하면) 댓글목록 새로고침
						if(data.status == "OK"){
							reloadComment();

							// 설정한 동작 실행
							if(fnAct != null){
								fnAct();
							}
						}
					}
				}
			}

			// 실패
			function insertError(){
				alert("통신오류 - 댓글 등록 요청 실패.");
			}

			// ajax
			$.ajax({
				url: insertURL,
				data: sendData,
				type : "POST",
				success: insertSuccess,
				error: insertError
			});
		}

		// 수정
		function updateComment(formEle, fnAct){
			console.log("update Comment");

			// URL
			var updateURL = "/spw/comment/update.spw";

			// 데이터
			var sendData = formEle.serialize();
			console.log("sendData => " + sendData);

			// 성공
			function updateSuccess(data){
				console.log("댓글 수정", data);

				// 응답데이터가 정상이면 메세지 출력
				if(data != null){
					if(data.status != null){
						alert(data.msg);
						// data.status가 OK면(댓글 수정이 성공하면) 댓글목록 새로고침
						if(data.status == "OK"){
							reloadComment();

							// 설정한 동작 실행
							if(fnAct != null){
								fnAct();
							}
						}
					}
				}
			}

			// 실패
			function updateError(){
				alert("통신오류 - 댓글 수정 요청 실패.");
			}

			// ajax
			$.ajax({
				url: updateURL,
				data: sendData,
				type : "POST",
				success: updateSuccess,
				error: updateError
			});
		}

		// 삭제
		function deleteComment(btnEle){
			console.log("댓글 삭제", btnEle);
			if(confirm("삭제하시겠습니까?")){
				var insertURL = "/spw/comment/delete.spw";

				// 댓글번호
				var commNum = btnEle.attr("data-cnum");
				console.log("commNum => ", commNum);

				// 데이터
				var sendData = {cnum : commNum};

				// 성공
				function deleteSuccess(data){
					console.log("댓글 삭제", data);

					// 응답데이터가 정상이면 메세지 출력
					if(data != null){
						if(data.status != null){
							alert(data.msg);
							// data.status가 OK면(댓글 삭제가 성공하면) 댓글목록 새로고침
							if(data.status == "OK"){
								reloadComment();
							}
						}
					}
				}

				// 실패
				function deleteError(){
					alert("통신오류 - 댓글 삭제 요청 실패.");
				}

				// ajax
				$.ajax({
					url: insertURL,
					data: sendData,
					type : "POST",
					success: deleteSuccess,
					error: deleteError
				});
			}
		}

		// 폼을 출력할 요소들의 내용물 비우기
		function emptyShowForm(){
			var showFormEle = null
			//showFormEle = $(commentRootID).find(showFormClassName).empty();
			showFormEle = $("#recommentForm");

			if(showFormEle != null){
				showFormEle.empty();
			}
		}

		// 댓글에 폼 출력
		function showForm(btnEle, formObj){
			console.log("댓글에 폼 출력", btnEle);

			// 폼을 출력할 요소
			var showEle = null;

			//showEle = btnEle.closest(showFormClassName)
			showEle = $("#recommentForm");
			console.log("showEle => ", showEle);

			// 폼을 출력할 요소들의 내용물 비우기
			emptyShowForm()

			// 폼 출력
			if(showEle != null){
				showEle.prepend(formObj);
			}
		}

		// 수정 폼 출력
		function showUpdate(){
			console.log("수정 폼 출력");

			// 이벤트가 발생한 요소
			var eventEle = $(this);

			// 댓글번호
			var commNum = eventEle.attr("data-cnum");

			// 수정 데이터 가져오기 (ajax)
			// URL
			var selCommURL = "/spw/comment/update.spw";

			// 데이터(댓글번호)
			var selCommData = {"cnum": commNum};

			// 성공
			function selectSuccess(data){
				console.log("댓글 수정폼 준비 => ", data);

				// 데이터가 성공적으로 왔다면
				if(data != null && data.status != ""){
					// 데이터가 도착했다면(status가 OK라면)
					if(data.status != null && data.status == "OK"){
						var commResData = data.commentData;

						if(commResData != null){
							// 댓글 수정 폼 준비
							var $updateForm = $commentUpdateForm.clone();
			
							// 댓글번호 / 내용
							if(commResData.cnum != null && commResData.cnum.length > 0){
								$updateForm.find(".cnum").val(commResData.cnum);
							}

							if(commResData.ccontents != null && commResData.ccontents.length > 0){
								$updateForm.find(".ccontents").val(commResData.ccontents);
							}

							// 폼 출력하기
							showForm(eventEle, $updateForm);
						}
						
					}else{
						if(data.msg != null && data.msg.length > 0){
							alert(data.msg);
						}
					}
				}
			}

			// 실패
			function selectError(){
				alert("통신오류 - 댓글정보를 가져올 수 없습니다.");
			}
			
			// ajax
			$.ajax({
				url: selCommURL,
				data: selCommData,
				type: "GET",
				success: selectSuccess,
				error: selectError
			});
		}

		// 대 댓글 폼 출력
		function showReComment(){
			console.log("대 댓글 폼 출력");

			// 이벤트가 발생한 요소
			var eventEle = $(this);

			// 대댓글 폼 준비
			var $reCommForm = $commentReCommentForm.clone();

			// 그룹번호 / 타겟번호
			var cGroupNum = eventEle.attr("data-cgroupnum");
			var cTargetNum = eventEle.attr("data-ctargetnum");

			console.log("cGroupNum => ", cGroupNum);
			console.log("cTargetNum => ", cTargetNum);

			// 대 댓글폼에 그룹번호 / 타겟번호 / 상품번호 설정하기
			if(cGroupNum != null){
				$reCommForm.find(".cgroupnum").val(cGroupNum);
			}

			if(cTargetNum != null){
				$reCommForm.find(".ctargetnum").val(cTargetNum);
			}

			if(cpNum != null){
				$reCommForm.find(".cpnum").val(cpNum);
			}

			// 폼 출력하기
			showForm(eventEle, $reCommForm);
		}

		// 댓글 새로고침 버튼
		$("#btnCommReload").click(reloadComment);

		// 댓글 작성 submit
		$("#insertComment").submit(function(){
			console.log("댓글 작성 => " + this);

			function actionSuccess(){
				$("#insertComment .ccontents").val("");
			}

			insertComment($(this), actionSuccess);

			return false;
		});

		// 대댓글 작성 submit
		$(document).on("submit", "#insertReComment", function(){
			console.log("대댓글 작성 => " + this);

			function actionSuccess(){
				emptyShowForm();
			}

			insertComment($(this), actionSuccess);

			return false;
		});

		// 대댓글 수정 submit
		$(document).on("submit", "#updateComment", function(){
			console.log("댓글 수정 => " + this);

			function actionSuccess(){
				emptyShowForm();
			}

			updateComment($(this), actionSuccess);

			return false;
		});

		// 댓글 삭제 버튼
		$(commentRootID).on("click", ".btnDelete", function(){
			 deleteComment($(this));
		});

		// 댓글 수정 버튼
		$(commentRootID).on("click", ".btnUpdate", showUpdate);

		// 대댓글 버튼
		$(commentRootID).on("click", ".btnReComment", showReComment);
	});
</script>
<table id="commentList" border>
	<thead>
		<tr>
			<th>댓글번호</th>
			<th>내용</th>
			<th>그룹번호</th>
			<th>타겟번호</th>
			<th>상품번호</th>
			<th>작성날짜</th>
			<th>회원번호</th>
			<th>회원이름</th>
			<th>회원 ID</th>
			<th>대댓글</th>
			<th>타겟</th>
			<th>답글</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
<c:if test="${empty commentList}">
	<tr>
		<td colspan="14" align="center">댓글이 없습니다.</td>
	</tr>
</c:if>
<c:forEach items="${commentList}" var="cvo">
	<c:if test="${cvo.cdelyn == 'Y'}">
		<tr>
			<td colspan="9" align="center">삭제된 댓글입니다.</td>
			<td colspan="5">
				<c:if test="${empty cvo.ctargetnum}">최상위 댓글</c:if>
				<c:if test="${not empty cvo.ctargetnum}">대 댓글</c:if>
			</td>
		</tr>
	</c:if>
	<c:if test="${cvo.cdelyn == 'N'}">
		<tr>
			<td>${cvo.cnum}</td>
			<td>${cvo.ccontents}</td>
			<td>${cvo.cgroupnum}</td>
			<td>${cvo.ctargetnum}</td>
			<td>${cvo.cpnum}</td>
			<td>${cvo.cindate}</td>
			<td>${cvo.mnum}</td>
			<td>${cvo.mname}</td>
			<td>${cvo.mid}</td>
			<td>
				<c:if test="${empty cvo.ctargetnum}">최상위 댓글</c:if>
				<c:if test="${not empty cvo.ctargetnum}">대 댓글</c:if>
			</td>
			<td>${cvo.tarname}</td>
			<td>
				<input type="button" class="btnReComment" value="답글"
						data-cgroupnum="${cvo.cgroupnum}" data-ctargetnum="${cvo.cnum}">
			</td>
			<td>
				<input type="button" class="btnUpdate" value="수정" data-cnum="${cvo.cnum}">
			</td>
			<td>
				<input type="button" class="btnDelete" value="삭제" data-cnum="${cvo.cnum}">
			</td>
		</tr>
	</c:if>
</c:forEach>
	</tbody>
</table>
<input type="button" id="btnCommReload" value="새로고침">

<form method="POST" id="insertComment">
	<table border>
		<tr>
			<th>내용</th>
			<td><input type="text" class="ccontents" name="ccontents"></td>
		</tr>
		<tr>
			<th>상품번호</th>
			<td><input type="text" class="cpnum" name="cpnum" value="${param.cpnum}" readonly></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="입력"></td>
		</tr>
	</table>
</form>



<div id="commentFormTemplate" style="display:none;">
	<form method="POST" id="insertReComment">
		<table border>
			<tr>
				<th>그룹번호</th>
				<td><input type="text" class="cgroupnum" name="cgroupnum" readonly></td>
			</tr>
			<tr>
				<th>타겟번호</th>
				<td><input type="text" class="ctargetnum" name="ctargetnum" readonly></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" class="ccontents" name="ccontents"></td>
			</tr>
			<tr>
				<th>상품번호</th>
				<td><input type="text" class="cpnum" name="cpnum" value="${param.cpnum}" readonly></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="입력"></td>
			</tr>
		</table>
	</form>
</div>

<div id="recommentForm" class="formShow">
	
</div>
