// 댓글을 위한 자바스크립트 코드 
$(document).ready(function(){

	// 댓글 목록의 최상위 요소 ID
	var commentRootID = "#commentWrap";

	var commentRowClass = ".comment_row";
	// 수정/답글 폼을 보여줄 요소의 클래스명
	var showFormClassName = ".formShow";
	
	// 수정/답글 폼
	var $commentUpdateForm = $("#insertReComment").clone();
	var $commentReCommentForm = $("#insertReComment").clone();

	// 댓글 Row
	var $commentRow = $("#commentRowTemplate > div").clone();

	// 수정 폼 가공
	$commentUpdateForm.attr("id", "updateComment");
	$commentUpdateForm.find("input.cgroupnum").remove();
	$commentUpdateForm.find("input.ctargetnum").remove();

	$commentUpdateForm.find(".cformtitle").text("수정");
	$commentUpdateForm.find("input.cpnum").attr({"class": "cnum", "name": "cnum"}).val("");
	$commentUpdateForm.find("input.cnum").closest("tr").find("th").text("댓글번호");
	$commentUpdateForm.find("input[type=submit]").val("수정");

	// 견본폼 삭제
	$("#commentFormTemplate").remove();

	$("#updateComment").remove();

	$("#commentRowTemplate").remove();

	console.log($commentUpdateForm);

	// 댓글 없을때 메세지 표시
	var $noCommentMsg = $("<div class='comment_root'><div class='comment_row'>댓글이 없습니다.</div></div>");

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
					if(qData[0] == "cpnum"
					|| qData[0] == "gnum"
					|| qData[0] == "anum"){
						cpNum = qData[1];
						break;
					}
				}
			}
		}
	}
	console.log("cpNum => " + cpNum);

	// 한줄 만들기
	function generateRow(rowData){
		var $cRow = $commentRow.clone();

		// 대댓글/최상위 댓글 감지
		var isRoot = false;
		if(rowData.ctargetnum == null || rowData.ctargetnum == ""){
			isRoot = true;
		}

		var commType = "comment_re";
		if(isRoot == true){
			commType = "comment_root";
		}

		$cRow.attr("class", commType);

		// 답글
		var btnReComment = "<input type='button' class='btnReComment sitebtn' value='답글' "
							+ "data-cgroupnum='" + rowData.cgroupnum + "' "
							+ "data-ctargetnum='" + rowData.cnum + "'> ";

		// 수정
		var btnUpdate = "<input type='button' class='btnUpdate sitebtn' value='수정' "
						+ "data-cnum='" + rowData.cnum + "'> ";

		// 삭제
		var btnDelete = "<input type='button' class='btnDelete sitebtn' value='삭제' "
						+ "data-cnum='" + rowData.cnum + "'> ";

		$cRow.find(".comment_btns").append(btnUpdate);
		$cRow.find(".comment_btns").append(btnDelete);
		$cRow.find(".comment_btns").append(btnReComment);

		// 대댓글이면서 타겟이 있다면
		if(isRoot == false && rowData.cgroupnum != rowData.ctargetnum){
			$cRow.find(".recomm_target").attr("href", "#Comment-" + rowData.ctargetnum);
			$cRow.find(".recomm_target").text(rowData.tarname);
		}else{
			$cRow.find(".recomm_target").remove();
		}

		$cRow.find(".comment_row").attr("id", "Comment-" + rowData.cnum);

		if(rowData.ccontents == null){
			rowData.ccontents = "";
		}

		$cRow.find(".comment_txt > span").text(rowData.ccontents);
		$cRow.find(".comment_date > span").text(rowData.cindate);
		$cRow.find(".comment_writer").text(rowData.mname);

		return $cRow;
	}

	// 댓글 새로고침
	function reloadComment(){
		// 댓글목록
		$commentList = $(commentRootID).children(".comment_content");

		// 성공
		function reloadSuccess(data){
			console.log("data =>", data);

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

							var commType = "comment_re";
							if(isRoot == true){
								commType = "comment_root";
							}

							$commRow = $("<div class='" + commType + "'>"
											+ "<div class='comment_row'>삭제된 댓글입니다.</div></div>");
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

			// 응답데이터가 정상이면
			if(data != null){
				if(data.status != null){
					// data.status가 OK면(댓글 등록이 성공하면) 댓글목록 새로고침
					if(data.status == "OK"){
						reloadComment();

						// 설정한 동작 실행
						if(fnAct != null){
							fnAct();
						}
					}else{
						alert(data.msg);
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

			// 응답데이터가 정상이면
			if(data != null){
				if(data.status != null){
					// data.status가 OK면(댓글 수정이 성공하면) 댓글목록 새로고침
					if(data.status == "OK"){
						reloadComment();

						// 설정한 동작 실행
						if(fnAct != null){
							fnAct();
						}
					}else{
						alert(data.msg);
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
		showFormEle = $(commentRootID).find(showFormClassName).empty();

		if(showFormEle != null){
			showFormEle.empty();
		}
	}

	// 댓글에 폼 출력
	function showForm(btnEle, formObj){
		console.log("댓글에 폼 출력", btnEle);

		// 폼을 출력할 요소
		var showEle = null;

		showEle = btnEle.closest(commentRowClass).parent().find(showFormClassName);
		console.log("showEle => ", showEle);

		// 폼을 출력할 요소들의 내용물 비우기
		emptyShowForm();

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

	// 댓글 수정 submit
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

	//Byte 확인
	function printCommentByte(){
		// 댓글 텍스트 에리어
		var tArea = $(this);

		// 댓글 내용
		var commentStr = tArea.val();

		// 댓글 내용 Byte
		var strByte = getByteLength(commentStr);

		// 300바이트 이상이면
		if(strByte > 300){
			alert("댓글은 300바이트까지만 입력할 수 있습니다.");

			// 자르기
			$(this).val(substrByte(commentStr, 300));

			// Byte 재확인
			strByte = getByteLength(tArea.val());
		}

		// 출력
		tArea.parent().find(".commentByte").text(strByte);
	}

	$("#insertComment, #commentWrap").on("input", "textarea.ccontents", printCommentByte);
});