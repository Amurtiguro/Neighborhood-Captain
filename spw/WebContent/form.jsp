<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("siteTitle", "폼 레이아웃");
%>
<link rel="stylesheet" href="./include/css/mainstyle.css">
<!-- 본문 타이틀(그냥 아무거나) -->
<h2>폼 레이아웃</h2>

<!-- 폼 박스 50% 사이즈(작은 폼) -->
<div class="formbox formbox_50">
	<div class="formcontent">
		폼박스 크기 50% (소형)
	</div>
</div>

<!-- 폼 박스 75% 사이즈(중간 사이즈 폼) -->
<div class="formbox formbox_75">
	<div class="formcontent">
		폼박스 크기 75% (중형)
	</div>
</div>

<!-- 폼 박스 100% 사이즈 -->
<div class="formbox formbox_100">
	<div class="formcontent">
		폼박스 크기 100% (대형)
	</div>
</div>

<!-- 사용예 -->
<div class="formbox formbox_75">
	<!-- 타이틀(그냥 아무거나) -->
	<h3>사용예</h3>
	<div class="formcontent">
		<form>
			<!-- 텍스트 필드 -->
			<div class="formrow">
				<label for="someID1" class="rowlabel">텍스트1</label>
				<input type="text" id="someID1" class="sitetxt form_ele_100">
			</div>
			<!-- form_ele_ 클래스를 통해 사이즈 조절 가능 -->
			<div class="formrow">
				<label for="someID2" class="rowlabel">텍스트2</label>
				<input type="text" id="someID2" class="sitetxt form_ele_50">
			</div>
			<!-- 사이즈는 4개(가로 20%, 30%, 50%, 100%) -->
			<div class="formrow">
				<label for="someID3" class="rowlabel">텍스트3</label>
				<input type="text" id="someID3" class="sitetxt form_ele_30">
			</div>
			<!-- 한줄마다 formrow클래스를 적용한 div필요함 -->
			<div class="formrow">
				<label for="someID4" class="rowlabel">텍스트4</label>
				<input type="text" id="someID4" class="sitetxt form_ele_20">
			</div>
			<!-- 한줄에 여러개의 폼요소 사용가능 -->
			<!-- form_ele_ 뒤의 숫자 합계가 100을 넘으면 안됨 -->
			<div class="formrow">
				<label class="rowlabel">전화</label>
				<input type="text" id="someID5" class="sitetxt form_ele_30">
				<span class="form_ele_onechar">-</span>
				<input type="text" id="someID6" class="sitetxt form_ele_30">
				<span class="form_ele_onechar">-</span>
				<input type="text" id="someID7" class="sitetxt form_ele_30">
			</div>
			<!-- 폼요소들 사이에 구분을 위한 한글자가 필요하다면 
				form_ele_onechar클래스를 적용한 span태그 사용 -->
			<!-- form_ele_ 뒤의 숫자 합계 계산시 
				form_ele_onechar하나당 숫자 5를 차지한다고 보고 계산 -->
			<div class="formrow">
				<label class="rowlabel">이메일</label>
				<input type="text" id="someID8" class="sitetxt form_ele_40">
				<span class="form_ele_onechar">@</span>
				<input type="text" id="someID9" class="sitetxt form_ele_50">
			</div>
			<!-- 라디오버튼 -->
			<div class="formrow">
				<label class="rowlabel">라디오 버튼</label>
				<div class="form_ele_30">
					<input type="radio" id="btnradio1" name="radiobtn" value="1">
					<label for="btnradio1">버튼1</label>
				</div>
				<div class="form_ele_30">
					<input type="radio" id="btnradio2" name="radiobtn" value="2">
					<label for="btnradio2">버튼2</label>
				</div>
				<div class="form_ele_30">
					<input type="radio" id="btnradio3" name="radiobtn" value="3">
					<label for="btnradio3">버튼3</label>
				</div>
			</div>
			<!-- 체크박스 -->
			<div class="formrow">
				<label class="rowlabel">체크박스</label>
				<div class="form_ele_20">
					<input type="checkbox" id="btnchk1" name="chkbtn" value="1">
					<label for="btnchk1">박스1</label>
				</div>
				<div class="form_ele_20">
					<input type="checkbox" id="btnchk2" name="chkbtn" value="2">
					<label for="btnchk2">박스2</label>
				</div>
				<div class="form_ele_20">
					<input type="checkbox" id="btnchk3" name="chkbtn" value="3">
					<label for="btnchk3">박스3</label>
				</div>
				<div class="form_ele_20">
					<input type="checkbox" id="btnchk4" name="chkbtn" value="4">
					<label for="btnchk4">박스4</label>
				</div>
				<div class="form_ele_20">
					<input type="checkbox" id="btnchk5" name="chkbtn" value="5">
					<label for="btnchk5">박스5</label>
				</div>
			</div>
			<!-- 드롭박스(select) -->
			<div class="formrow">
				<label class="rowlabel" for="selbox1">드롭박스(select)</label>
				<select id="selbox1" name="selbox1" class="siteselect form_ele_100">
					<option value="1">하나</option>
					<option value="2">둘</option>
					<option value="3">셋</option>
					<option value="4">넷</option>
					<option value="5">다섯</option>
				</select>
			</div>
			<!-- 텍스트 필드가 아니라도 form_ele_50클래스를 지정하면 길이조절가능 -->
			<div class="formrow">
				<label class="rowlabel" for="selbox2">드롭박스(절반길이)</label>
				<select id="selbox2" name="selbox2" class="siteselect form_ele_50">
					<option value="1">하나</option>
					<option value="2">둘</option>
					<option value="3">셋</option>
					<option value="4">넷</option>
					<option value="5">다섯</option>
				</select>
			</div>
			<!-- 텍스트 Area -->
			<div class="formrow">
				<label class="rowlabel" for="areabox">텍스트 Area</label>
				<textarea id="areabox" name="areabox" class="sitetxt form_ele_100"></textarea>
			</div>
			<div class="formrow formrow_center">
				<input type="submit" value="가입" class="sitebtn">
			</div>
		</form>
	</div>
</div>

<!-- 사용예(탭 + 폼) -->
<div class="formbox formbox_50">
	<h3>사용예(탭 + 폼)</h3>
	<!-- 탭 -->
	<div class="formtab">
		<div class="tabbtn tabbtn_3 tabsaja tabbtn_sel">사자</div>
		<div class="tabbtn tabbtn_3 tabpanda">
			<a href="#링크">판다</a>
		</div>
		<div class="tabbtn tabbtn_3">
			<a href="#링크">경매</a>
		</div>
	</div>
	<!-- 폼 -->
	<div class="formcontent">
		<form>
			<div class="formrow">
				<label for="otherID1" class="rowlabel">텍스트1</label>
				<input type="text" id="otherID1" class="sitetxt form_ele_100">
			</div>
			<div class="formrow">
				<label for="otherID2" class="rowlabel">텍스트2</label>
				<input type="text" id="otherID2" class="sitetxt form_ele_50">
			</div>
			<div class="formrow">
				<label for="otherID3" class="rowlabel">텍스트3</label>
				<input type="text" id="otherID3" class="sitetxt form_ele_30">
			</div>
			<div class="formrow">
				<label for="otherID4" class="rowlabel">텍스트4</label>
				<input type="text" id="otherID4" class="sitetxt form_ele_20">
			</div>
			<div class="formrow">
				<label class="rowlabel">전화</label>
				<input type="text" id="otherID5" class="sitetxt form_ele_30">
				<span class="form_ele_onechar">-</span>
				<input type="text" id="otherID6" class="sitetxt form_ele_30">
				<span class="form_ele_onechar">-</span>
				<input type="text" id="otherID7" class="sitetxt form_ele_30">
			</div>
			<div class="formrow">
				<label class="rowlabel">이메일</label>
				<input type="text" id="sotherID8" class="sitetxt form_ele_40">
				<span class="form_ele_onechar">@</span>
				<input type="text" id="otherID9" class="sitetxt form_ele_50">
			</div>
			<div class="formrow">
				<label class="rowlabel">라디오 버튼</label>
				<div class="form_ele_30">
					<input type="radio" id="otherradio1" name="radiobtn" value="1">
					<label for="otherradio1">버튼1</label>
				</div>
				<div class="form_ele_30">
					<input type="radio" id="otherradio2" name="radiobtn" value="2">
					<label for="otherradio2">버튼2</label>
				</div>
				<div class="form_ele_30">
					<input type="radio" id="otherradio3" name="radiobtn" value="3">
					<label for="otherradio3">버튼3</label>
				</div>
			</div>
			<div class="formrow">
				<label class="rowlabel">체크박스</label>
				<div class="form_ele_20">
					<input type="checkbox" id="otherchk1" name="chkbtn" value="1">
					<label for="otherchk1">박스1</label>
				</div>
				<div class="form_ele_20">
					<input type="checkbox" id="otherchk2" name="chkbtn" value="2">
					<label for="otherchk2">박스2</label>
				</div>
				<div class="form_ele_20">
					<input type="checkbox" id="otherchk3" name="chkbtn" value="3">
					<label for="otherchk3">박스3</label>
				</div>
				<div class="form_ele_20">
					<input type="checkbox" id="otherchk4" name="chkbtn" value="4">
					<label for="otherchk4">박스4</label>
				</div>
				<div class="form_ele_20">
					<input type="checkbox" id="btnchk5" name="chkbtn" value="5">
					<label for="btnchk5">박스5</label>
				</div>
			</div>
			<div class="formrow">
				<label class="rowlabel" for="othersel1">드롭박스(select)</label>
				<select id="othersel1" name="selbox1" class="siteselect form_ele_100">
					<option value="1">하나</option>
					<option value="2">둘</option>
					<option value="3">셋</option>
					<option value="4">넷</option>
					<option value="5">다섯</option>
				</select>
			</div>
			<div class="formrow">
				<label class="rowlabel" for="othersel2">드롭박스(절반길이)</label>
				<select id="othersel2" name="selbox2" class="siteselect form_ele_50">
					<option value="1">하나</option>
					<option value="2">둘</option>
					<option value="3">셋</option>
					<option value="4">넷</option>
					<option value="5">다섯</option>
				</select>
			</div>
			<div class="formrow formrow_center">
				<input type="submit" value="가입" class="sitebtn">
			</div>
		</form>
	</div>
</div>

