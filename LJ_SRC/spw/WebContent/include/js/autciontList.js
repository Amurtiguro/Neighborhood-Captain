
	function auctionInsert(){
		alert("insert btn click >>> ");
		var mnumber = "<%=sessionNum%>";
		alert("세션에 담김 회원 번호당  :: "+mnumber);
		
		if(mnumber.indexOf("M")==0){
			//세션 번호가 있을 경우에는 
			document.detailForm.action="/spw/auctionWrite.spw";
			document.detailForm.submit();
		}else{
			//아닐경우에는 로그인 폼으로 이동 
			alert("로그인 먼저 하세요 !");
			document.detailForm.action="/spw/loginform.spw";
			document.detailForm.submit();
		}
	}
	
	function detailAuction(){
		alert("detail auction btn click >>> ");
		document.detailForm.method="GET";
		//document.detailForm.enctype="multipart/form-data";
		document.detailForm.action="/spw/auctionViewDetail.spw";
		document.detailForm.submit();
	}
	
	function searchForm(val){
		alert("ajax 호출이당 ");
		console.log("ajax val1 >>> : "+val);
		
		var urls="/spw/auctionList.spw";
		
		$.ajax({
			type : "get",
			url:urls,
			data : {searchTerm: searchTerm.value},
			success:whenSuccess,
			error:whenError
		});
		
		//성공했을 때
		function whenSuccess(data){
			alert(" ajax 성공 >>> ");
			console.log(">>> "+data);
			$("#detailForm tbody").replaceWith($(data).find("#detailForm tbody"));
			 console.log(">>>>>>>>>>>>>>>>>"+$(data).find("#detailForm div.displayNow"));
			    $("#detailForm div.displayNow").replaceWith($(data).find("#detailForm div.displayNow"));
		}
		
		//실패했을 때
		function whenError(){
			var datas=searchTerm.value;
			var date="";
			
			if(datas=="latestOneDay"){
					date="1일"
			}
			alert("최근 " + date+"에 등록된 데이터 없음 !!");
		}
	}
	
	
	function searchDate(){
		alert("날짜검색 >>> start  ");
	
		var from=document.getElementById("dateFrom").value;
		console.log("from :: "+from);
		var to=document.getElementById("dateTo").value;
		console.log("to :: "+to);
	
		var urls="/spw/auctionList.spw";
		//var formData=$("form[name=detailForm]").serialize();
		var formData={
						dateFrom:from,
						dateTo:to, }
		
		if(from!=null&&from!=''&&to!=null&&to!=''){
			alert("from/to 값 모두 입력 했음 ");
			$.ajax({
				type : "get",
				url:urls,
				data : formData,
				success: whenSuccess,
				error: whenError
			});
		}else{
			alert("from/ to 둘다 입력 하세요!");
		}
		//성공했을 때
		function whenSuccess(data){
			alert(" ajax 성공 !!!! ");
			//console.log(data);
		    $("#detailForm div.list_grid").replaceWith($(data).find("#detailForm div.list_grid"));
		    $("#detailForm div.list_paging paging_saja").replaceWith($(data).find("#detailForm div.list_paging paging_saja"));
		}
		//실패했을 때
		function whenError(){
			alert("데이터 없음 !! ");
		}
		
	}
	
	$(document).ready(function(){
		 var dateFormat = "yy/mm/dd",
	     
		 from = $( "#dateFrom" )
	        .datepicker({
	          defaultDate: "+1w",
	          changeMonth: true,
	          numberOfMonths: 1,
	          dateFormat: dateFormat
	        })
	        .on( "change", 
	        		function() {
	          to.datepicker( "option", "minDate", getDate( this ) );
	         
	         var date= $.datepicker.formatDate('yy/mm/dd', new Date(getDate(this)));
	         console.log("from >>>>>>"+date);
	         //$( "#dateFrom" ).val(date);	         
	
	        }),
	        
	      to = $( "#dateTo" ).datepicker({
	        defaultDate: "+1w",
	        changeMonth: true,
	        numberOfMonths: 1,
	        dateFormat: dateFormat
	      })
	      .on( "change", function() {
	        from.datepicker( "option", "maxDate", getDate( this ) );
	        
	        var date= $.datepicker.formatDate('yy/mm/dd', new Date(getDate(this)));
	         console.log("to >>>>>>"+date);
	         //$( "#dateTo" ).val(date);
	      });
	 
	    function getDate( element ) {
	      var date;
	      try {
	        date = $.datepicker.parseDate( dateFormat, element.value );
	      } catch( error ) {
	        date = null;
	        console.log(error);
	      }
	 
	      return date;
	    }
	});
