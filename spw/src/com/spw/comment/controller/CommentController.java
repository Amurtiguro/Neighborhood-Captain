package com.spw.comment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spw.comment.service.CommentService;
import com.spw.comment.vo.CommentVO;
import com.spw.common.CommonUtil;

/**
 * 클래스
 * 설명
 * : 댓글 컨트롤러 (Ajax)
 * 날짜 : 2020/08/10
 * 작성자 : 최정규
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
	private Logger log = Logger.getLogger(CommentController.class);

	// 댓글 View가 저장된 폴더
	private static String VIEW_DIR = "comment/";

	@Autowired
	private CommentService commentService;

	/**
	 * 설명
	 * : 모든 댓글목록(관리자용)
	 * 매개변수 : CommentVO cvo - 페이지 번호(없으면 1)
	 * 반환값 : ModelAndView
	 * 날짜 : 2020/08/16
	 * 작성자 : 최정규
	 */
	@RequestMapping("/listall")
	public ModelAndView commentAllList(@ModelAttribute CommentVO cvo, HttpServletRequest request) {
		log.info("[commentAllList 시작] cvo => " + cvo);

		// 관리자여부
		boolean isAdmin = false;

		// 세션에서 회원번호 가져오기
		HttpSession hs =request.getSession();
		String memNum = (String)hs.getAttribute("mnum");
		log.info("[i] memNum => " + memNum);

		// 회원번호로 관리자여부 가져오기
		isAdmin = this.isAdminMem(memNum);
		log.info("[i] isAdmin => " + isAdmin);

		// ModelAndView
		ModelAndView mav = new ModelAndView();

		//관리자일때만 실행
		if(isAdmin == true) {
			// 페이징
			String groupSize = "10";
			String pageSize = "10";

			String curpage = "1";
	
			// 상품번호
			if(cvo != null) {
				String crpage = cvo.getCurpage();
				log.info("[i] crpage => " + crpage);
	
				if(crpage != null && crpage.length() > 0) {
					curpage = crpage;
				}
			}
			log.info("[i] curpage => " + curpage);

			CommentVO cmvo = new CommentVO();

			cmvo.setGroupsize(groupSize);
			cmvo.setPagesize(pageSize);
			cmvo.setCurpage(curpage);
			cmvo.setCcontents(cvo.getCcontents());

			// 댓글
			List<CommentVO> commentList = commentService.commentAllList(cmvo);
			log.info("[i] commentList => " + commentList);

			// ModelAndView 설정
			mav.addObject("commentList", commentList);
			mav.addObject("cmvo", cmvo);
			mav.setViewName(VIEW_DIR + "listAll");
		}else {
			// 관리자가 아니면
			mav.setViewName("common/noAuth");
		}

		log.info("[commentAllList 종료] mav => " + mav);
		return mav;
	}

	/**
	 * 설명
	 * : (상품번호로) 선택한 상품의 댓글목록
	 * 매개변수 : CommentVO cvo - 상품번호
	 * 반환값 : ModelAndView
	 * 날짜 : 2020/08/10
	 * 작성자 : 최정규
	 */
	@RequestMapping("/list")
	public ModelAndView commentList(@ModelAttribute CommentVO cvo) {
		log.info("[commentList 시작] cvo => " + cvo);

		// 상품번호
		if(cvo != null) {
			String pnum = cvo.getCpnum();
			log.info("[i] pnum => " + pnum);
		}

		// 댓글
		List<CommentVO> commentList = commentService.commentList(cvo);
		log.info("[i] commentList => " + commentList);

		// ModelAndView
		ModelAndView mav = new ModelAndView();
		mav.addObject("commentList", commentList);
		mav.setViewName(VIEW_DIR + "comList");

		log.info("[commentList 종료] mav => " + mav);
		return mav;
	}

	/**
	 * 설명
	 * : (상품번호로) 선택한 상품의 댓글데이터 (JSON)
	 * 매개변수 : CommentVO cvo - 상품번호
	 * 반환값 : ResponseEntity<String>
	 * 날짜 : 2020/08/11
	 * 작성자 : 최정규
	 */
	// {"status": "OK", "pnum" : "(상품번호)", "comments": [{(VO 데이터)}, ...]}
	// 오류 {"status": "ERROR", "msg": "(오류메세지)"}
	@RequestMapping("/listData")
	public ResponseEntity commentListData(@ModelAttribute CommentVO cvo) {
		log.info("[commentListData 시작] cvo => " + cvo);

		// 상품번호
		String pnum = null;
		if(cvo != null) {
			pnum = cvo.getCpnum();
		}
		log.info("[i] pnum => " + pnum);

		// 댓글
		List<CommentVO> commentList = commentService.commentList(cvo);
		log.info("[i] commentList => " + commentList);

		// JSON
		JSONObject listData = new JSONObject();
		if(pnum != null && pnum.length() > 0) {
			listData.put("status", "OK");
			listData.put("pnum", pnum);

			JSONArray commArr = new JSONArray();

			if(commentList != null && commentList.size() > 0) {
				for(int i = 0; i < commentList.size(); i++) {
					CommentVO commVo = commentList.get(i);
					JSONObject commData = new JSONObject();

					String cnum = commVo.getCnum();
					String cpnum = commVo.getCpnum();
					String cgroupnum = commVo.getCgroupnum();
					String ctargetnum = commVo.getCtargetnum();
					String cdelyn = commVo.getCdelyn();
					String ccontents = null;
					String cindate = null;
					String mnum = null;
					String mname = null;
					String mid = null;
					String tarname = null;

					if(cdelyn != null && "N".equals(cdelyn)) {
						ccontents = commVo.getCcontents();
						cindate = commVo.getCindate();
						mnum = commVo.getMnum();
						mname = commVo.getMname();
						mid = commVo.getMid();
						tarname = commVo.getTarname();
					}

					commData.put("cnum", cnum);
					commData.put("ccontents", ccontents);
					commData.put("cpnum", cpnum);
					commData.put("cgroupnum", cgroupnum);
					commData.put("ctargetnum", ctargetnum);
					commData.put("cdelyn", cdelyn);
					commData.put("cindate", cindate);
					commData.put("mnum", mnum);
					commData.put("mname", mname);
					commData.put("mid", mid);
					commData.put("tarname", tarname);

					commArr.add(commData);
				}
			}

			listData.put("comments", commArr);
		}else {
			listData.put("status", "ERROR");
			listData.put("msg", "파라미터 오류");
		}

		ResponseEntity<String> resData = CommonUtil.responseJSON(listData.toJSONString());
		log.info("[commentListData 종료] mav => " + resData);
		return resData;
	}

	/**
	 * 설명
	 * : 댓글입력 처리 (JSON)
	 * - 상품번호만 있으면 - 최상위 댓글 작성
	 * - 그룹번호도 같이 있으면 - 대 댓글 작성
	 * - 그룹번호, 타겟번호도 같이 있으면 - 대 댓글 작성
	 * 매개변수 : CommentVO cvo - 상품번호, 그룹번호, 타겟번호, 내용
	 * 반환값 : ResponseEntity<String>
	 * 날짜 : 2020/08/11
	 * 작성자 : 최정규
	 */
	// {"status": "OK", "msg": "(메세지)"}
	// {"status": "ERROR", "msg": "(오류 메세지)"}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<String> commentInsertProcess(@ModelAttribute CommentVO cvo, HttpServletRequest request) {
		log.info("[commentInsertProcess 시작] cvo => " + cvo);

		// 상품번호/그룹번호/타겟번호
		String cpnum = null;
		String cgroupnum = null;
		String ctargetnum = null;
		if(cvo != null) {
			cpnum = cvo.getCpnum();
			cgroupnum = cvo.getCgroupnum();
			ctargetnum = cvo.getCtargetnum();
		}
		log.info("[i] cpnum      => " + cpnum);
		log.info("[i] cgroupnum  => " + cgroupnum);
		log.info("[i] ctargetnum => " + ctargetnum);

		// 회원번호
		String memNum = null;

		// 세션에서 회원번호 가져오기
		HttpSession hs =request.getSession();
		memNum = (String)hs.getAttribute("mnum");
		cvo.setMnum(memNum);
		log.info("[i] memNum => " + memNum);


		// 세션에 회원번호가 없으면 차단하기
		boolean isAuth = memNum != null && memNum.length() > 0;

		// DB작업
		int cnt = 0;
		if(isAuth == true) {
			if(cpnum != null && cpnum.length() >= 0) {
				if(cgroupnum != null && cgroupnum.length() > 0) {
					// 대 댓글
					log.info("[i] 대댓글");
	
					if( !(ctargetnum != null && ctargetnum.length() >= 0) ) {
						cvo.setCtargetnum(cgroupnum);
					}
	
					cnt = commentService.commentReInsert(cvo);
				}else {
					// 최상위댓글
					log.info("[i] 최상위 댓글");
	
					cnt = commentService.commentRootInsert(cvo);
				}
			}
		}
		log.info("[i] cnt => " + cnt);

		// 알림을 보내기위해 알림을 보낼 사람의 회원번호 가져오기
		List<CommentVO> notiList = null;
		if(cnt > 0) {
			CommentVO cNotiVO = new CommentVO();

			if(cvo != null) {
				log.info("[i] cnum => " + cvo.getCnum());
				cNotiVO.setCnum(cvo.getCnum());

				notiList = commentService.commentSelectNoti(cNotiVO);
			}

		}
		log.info("[i] notiList => " + notiList);

		// 알림 보내기
		if(notiList != null && notiList.size() > 0) {
			log.info("[ 알림 정보 ]");
			for(int i = 0; i < notiList.size(); i++) {
				CommentVO cnvo = notiList.get(i);
				log.info("[i] 댓글 번호           => " + cnvo.getCnum());
				log.info("[i] 상품 번호           => " + cnvo.getCpnum());
				log.info("[i] 회원번호(상품)      => " + cnvo.getPmnum());
				log.info("[i] 회원번호(상위 댓글) => " + cnvo.getCmnum());
				
			}
		}

		String msg = null;
		String status = "ERROR";
		
		if(isAuth == false) {
			msg = "댓글작성은 로그인한 사용자만 가능합니다.";
		}else {
			if(cnt > 0) {
				status = "OK";
				msg = "댓글 작성 완료";
			}else {
				msg = "댓글 작성 실패";
			}
		}

		log.info("[i] status => " + status);
		log.info("[i] msg => " + msg);

		JSONObject inData = new JSONObject();
		inData.put("status", status);
		inData.put("msg", msg);

		ResponseEntity<String> resData = CommonUtil.responseJSON(inData.toJSONString());

		log.info("[commentInsertProcess 종료] resData => " + resData);
		return resData;
	}

	/**
	 * 설명
	 * : 수정을 위해 댓글 하나를 Select해서 가져옴 (작성자 본인만 Select) (JSON)
	 * 매개변수 : CommentVO cvo - 댓글 번호, HttpServletRequest request - 세션
	 * 반환값 : ResponseEntity<String>
	 * 날짜 : 2020/08/11
	 * 작성자 : 최정규
	 */
	// {"status": "OK", "commentData": {(VO데이터)}}
	// {"status": "ERROR", "msg": "(오류 메세지)"}
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ResponseEntity<String> commentUpdate(@ModelAttribute CommentVO cvo, HttpServletRequest request) {
		log.info("[commentUpdate 시작] cvo => " + cvo);

		// 댓글 번호
		String cnum = null;
		if(cvo != null) {
			cnum = cvo.getCnum();
		}
		log.info("[i] 댓글번호 => " + cnum);

		// 회원번호
		String memNum = null;

		// 세션에서 회원번호 가져오기
		HttpSession hs =request.getSession();
		memNum = (String)hs.getAttribute("mnum");
		log.info("[i] memNum => " + memNum);

		// 수정권한여부
		boolean isAuth = false;

		List<CommentVO> commentData = null;

		// 회원번호가 있을때만 DB작업하기
		if(memNum != null && memNum.length() > 0) {
			// DB작업 - Update 할 댓글정보 가져오기
			commentData = commentService.commentSelect(cvo);
			log.info("[i] comment => " + commentData);

			// 회원번호를 대조해서 작성자인지 확인하기
			if(commentData != null && commentData.size() > 0) {
				for(int i = 0; i < commentData.size(); i++) {
					String mnum = commentData.get(i).getMnum();

					// 작성자라면 수정권한 True
					if(memNum.equals(mnum)) {
						isAuth = true;
						break;
					}
				}
			}
		}

		JSONObject commData = new JSONObject();

		if(isAuth == true) {
			// 수정권한이 있다면

			if(commentData != null && commentData.size() > 0) {
				log.info("[i] commentData size => " + commentData.size());

				JSONObject commentObj = new JSONObject();

				CommentVO commVO = commentData.get(0);

				commentObj.put("cnum", commVO.getCnum());
				commentObj.put("ccontents", commVO.getCcontents());
				commentObj.put("cpnum", commVO.getCpnum());

				commData.put("status", "OK");
				commData.put("commentData", commentObj);
			}else {
				commData.put("status", "ERROR");
				commData.put("msg", "존재하지 않거나 삭제된 댓글입니다.");
			}

		}else {
			// 없다면
			commData.put("status", "ERROR");
			commData.put("msg", "댓글을 수정할 권한이 없습니다.");
		}

		ResponseEntity<String> resData = CommonUtil.responseJSON(commData.toJSONString());

		log.info("[commentUpdate 종료] mav => " + resData);
		return resData;
	}

	/**
	 * 설명
	 * : 댓글 수정 처리 (JSON)
	 * 매개변수 : CommentVO cvo - 댓글번호, 내용, HttpServletRequest request - 세션
	 * 반환값 : ResponseEntity<String>
	 * 날짜 : 2020/08/11
	 * 작성자 : 최정규
	 */
	// {"status": "OK", "msg": "(메세지)"}
	// {"status": "ERROR", "msg": "(오류 메세지)"} 
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<String> commentUpdateProcess(@ModelAttribute CommentVO cvo, HttpServletRequest request) {
		log.info("[commentUpdate 시작] cvo => " + cvo);

		// 댓글번호, 상품번호
		String cNum = null;
		String pNum = null;
		if(cvo != null) {
			cNum = cvo.getCnum();
			pNum = cvo.getCpnum();
		}
		log.info("[i] 댓글번호 => " + cNum);
		log.info("[i] 상품번호 => " + pNum);

		// 회원번호
		String memNum = null;

		// 세션에서 회원번호 가져오기
		HttpSession hs =request.getSession();
		memNum = (String)hs.getAttribute("mnum");
		cvo.setMnum(memNum);
		log.info("[i] memNum => " + memNum);

		// 수정권한
		boolean isAuth = false;

		// 회원번호가 있으면 수정권한주기
		if(memNum != null && memNum.length() > 0) {
			isAuth = true;
		}

		int updateCnt = 0;
		// 수정권한이 있으면
		if(isAuth == true) {
			updateCnt = commentService.commentUpdate(cvo);
		}
		log.info("[i] updateCnt => " + updateCnt);

		String status = "ERROR";
		String msg = null;

		if(updateCnt > 0) {
			status = "OK";
			msg = "수정 완료";
		}else {
			if(isAuth == false) {
				msg = "수정 실패";
			}else {
				msg = "수정권한이 없습니다.";
			}
		}

		log.info("[i] status => " + status);
		log.info("[i] msg => " + msg);

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("status", status);
		jsonObj.put("msg", msg);

		ResponseEntity<String> resData = CommonUtil.responseJSON(jsonObj.toJSONString());

		log.info("[commentUpdate 종료] mav => " + resData);
		return resData;
	}

	/**
	 * 설명
	 * : 댓글 삭제 처리 (JSON)
	 * 매개변수 : CommentVO cvo - 댓글 번호, HttpServletRequest request - 세션
	 * 반환값 : ResponseEntity<String>
	 * 날짜 : 2020/08/11
	 * 작성자 : 최정규
	 */
	// {"status": "OK", "msg": "(메세지)"}
	// {"status": "ERROR", "msg": "(오류 메세지)"}
	@RequestMapping("/delete")
	public ResponseEntity<String> commentDelete(@ModelAttribute CommentVO cvo, HttpServletRequest request) {
		log.info("[commentDelete 시작] cvo => " + cvo);
		
		// 댓글 번호
		String cnum = null;
		if(cvo != null) {
			cnum = cvo.getCnum();
		}
		log.info("[i] 댓글번호 => " + cnum);
		
		// 회원번호
		String memNum = null;
		
		// 관리자여부
		boolean isAdmin = false;
		
		// 세션에서 회원번호 가져오기
		HttpSession hs =request.getSession();
		memNum = (String)hs.getAttribute("mnum");
		log.info("[i] memNum => " + memNum);

		// 회원번호로 관리자여부 가져오기
		isAdmin = this.isAdminMem(memNum);
		log.info("[i] isAdmin => " + isAdmin);

		// 수정권한여부
		boolean isAuth = false;

		List<CommentVO> commentData = null;

		// 상품번호
		String pNum = null;

		// 관리자라면
		if(isAdmin == true) {
			isAuth = true;
		}else if(memNum != null && memNum.length() > 0) {
			// 회원번호가 있을때만 DB작업하기
			// DB작업 - Delete 할 댓글정보 가져오기
			commentData = commentService.commentSelect(cvo);
			log.info("[i] comment => " + commentData);
			
			// 회원번호를 대조해서 작성자인지 확인하기
			if(commentData != null && commentData.size() > 0) {
				for(int i = 0; i < commentData.size(); i++) {
					String mnum = commentData.get(i).getMnum();
					pNum = commentData.get(i).getCpnum();
					
					// 작성자라면 삭제권한 True
					if(memNum.equals(mnum)) {
						isAuth = true;
						break;
					}
				}
			}
		}

		String status = "ERROR";
		String msg = null;
		
		if(isAuth == true) {
			// 삭제권한 있다면

			// DB작업 - 삭제
			int delCnt = 0;

			if(isAdmin == true) {
				// 관리자
				delCnt = commentService.commentDeleteAdmin(cvo);
			}else {
				// 일반회원
				cvo.setMnum(memNum);
				delCnt = commentService.commentDelete(cvo);
			}
			log.info("[i] delCnt => " + delCnt);


			if(delCnt > 0) {
				status = "OK";
				msg = "삭제완료";
			}else {
				msg = "삭제실패";
			}
		}else {
			// 없다면
			msg = "댓글이 없거나 삭제할 권한이 없습니다.";
		}

		log.info("[i] status => " + status);
		log.info("[i] msg => " + msg);

		// 상태(성공, 실패)와 메세지를 출력
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("status", status);
		jsonObj.put("msg", msg);

		ResponseEntity<String> resData = CommonUtil.responseJSON(jsonObj.toJSONString());

		log.info("[commentDelete 종료] mav => " + resData);
		return resData;
	}

	/**
	 * 설명
	 * : 관리자 여부 확인
	 * 매개변수 : String memno 회원번호
	 * 반환값 : boolean (true - 관리자)
	 */
	private boolean isAdminMem(String mnum) {
		return "M202007300001".equals(mnum);
	}
	
}
