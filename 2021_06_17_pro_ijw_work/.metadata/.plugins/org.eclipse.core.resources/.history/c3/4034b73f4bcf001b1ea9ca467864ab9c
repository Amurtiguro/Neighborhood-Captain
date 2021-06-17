package com.ijw.mypage.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ijw.auction.vo.AuctionVO;
import com.ijw.general.vo.GeneralVO;
import com.ijw.member.vo.MemberVO;
import com.ijw.mypage.service.MypageService;
import com.ijw.mypage.vo.MyPickVO;
import com.ijw.notice.vo.NoticeVO;


/**
 * 클래스
 * 설명
 * : 마이페이지 컨트롤러.(회원 수정, 찜하기, 알림, 구매,판매,경매 목록)
  */
@Controller
public class MypageController {

	// 로그. ========================================
	private Logger log = Logger.getLogger(MypageController.class);
	
	// 마이페이지 서비스. ========================================
	@Autowired
	private MypageService mypageService;
	
	
	/**
	 * 설명
	 * : 마이페이지에서 정보 수정화면이동.
	 * 매개변수 :
	 * 반환값 :
	 */
	@RequestMapping("myInfo")
	public ModelAndView memberInfo(HttpServletRequest req, @ModelAttribute MemberVO mvo) {
		log.info("MypageController memberInfo 실행 : ");
		
		// 세션 번호로 정보 가져오기.
		HttpSession hs = req.getSession();
		String mnum = (String)hs.getAttribute("mnum");
		log.info("세션 mnum : "+mnum);
		// 세션으로 정보가져오기.
		mvo.setMnum(mnum);
		
		MemberVO _mvo = mypageService.myInfo(mvo.getMnum());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("myPage/myInfo");
		mav.addObject("mvo", _mvo);
		log.info("MypageController memberInfo 종료 : ");
		return mav;
	}
	
	/**
	 * 설명
	 * : 수정화면에서 수정.
	 * 매개변수 :
	 * 반환값 :
	 */
	@RequestMapping("memberUpdate")
	public ModelAndView memberUpdate(@ModelAttribute MemberVO mvo, HttpServletRequest req) {
		log.info("MypageController memberUpdate 실행 : ");
		log.info("번호 : "+mvo.getMnum());
		log.info("아이디 : "+mvo.getMid());
		log.info("비밀번호 : "+mvo.getMpw());
		log.info("이름 : "+mvo.getMname());
		log.info("휴대폰 번호 : "+mvo.getMphone());
		log.info("이메일 : "+mvo.getMemail());
		log.info("우편번호 : "+mvo.getMaddr0());
		log.info("주소 : "+mvo.getMaddr1());
		log.info("상세주소 : "+mvo.getMaddr2());
		log.info("삭제여부 : "+mvo.getMdelyn());
		log.info("회원 히스토리 번호 : "+mvo.getHnum());
		int uCnt=0;
		ModelAndView mav = new ModelAndView();
		uCnt = mypageService.myInfoUpdate(mvo);
		
		if(uCnt!=0&&uCnt>0) {
			// 세션 번호로 정보 가져오기.
			HttpSession hs = req.getSession();
			String mnum = (String)hs.getAttribute("mnum");
			log.info("세션 mnum : "+mnum);
			// 세션으로 정보가져오기.
			MemberVO _mvo = mypageService.myInfo(mnum);
			log.info("mvo : "+_mvo);
			mav.setViewName("myPage/myPage");
			mav.addObject("mvo", _mvo);
		}
		log.info("MypageController memberUpdate 종료 : ");
		return mav;
	}
	
	/**
	 * 설명
	 * : 수정화면에서 삭제.
	 * 매개변수 :
	 * 반환값 :
	 */
	@RequestMapping("memberDelete")
	public ModelAndView memberDelete(@ModelAttribute MemberVO mvo, HttpServletRequest req) {
		log.info("MypageController memberDelete 실행 : ");
		log.info("번호 : "+mvo.getMnum());
		log.info("아이디 : "+mvo.getMid());
		log.info("비밀번호 : "+mvo.getMpw());
		log.info("이름 : "+mvo.getMname());
		log.info("휴대폰 번호 : "+mvo.getMphone());
		log.info("이메일 : "+mvo.getMemail());
		log.info("우편번호 : "+mvo.getMaddr0());
		log.info("주소 : "+mvo.getMaddr1());
		log.info("상세주소 : "+mvo.getMaddr2());
		log.info("삭제여부 : "+mvo.getMdelyn());
		log.info("회원 히스토리 번호 : "+mvo.getHnum());
		int dCnt=0;
		ModelAndView mav = new ModelAndView();
			
		// 삭제.
		dCnt = mypageService.myInfoDelete(mvo);
	
		if(dCnt!=0&&dCnt>0) {
			// 세션 번호로 정보 가져오기.
			HttpSession hs = req.getSession();
			String mnum = (String)hs.getAttribute("mnum");
			log.info("세션 mnum : "+mnum);
			// 세션으로 정보가져오기.
			MemberVO _mvo = mypageService.myInfo(mnum);
			log.info("mvo : "+_mvo);
			mav.setViewName("myPage/myPage");
			mav.addObject("mvo", _mvo);
		}
	
		//mav.setViewName("myPage/myDeleteOK");
		//mav.addObject("dCnt", new Integer(dCnt));
		log.info("MypageController memberDelete 종료 : ");
		return mav;
	}
	/**
	 * 설명
	 * : 마이페이지 이동.
	 * 매개변수 :
	 * 반환값 :
	 */
	@RequestMapping("myPage")
	public ModelAndView myPage(@ModelAttribute MemberVO mvo, HttpServletRequest req) {
		log.info("MypageController myPage 실행 : ");
		// 세션 번호로 정보 가져오기.
		HttpSession hs = req.getSession();
		String mnum = (String)hs.getAttribute("mnum");
		log.info("세션 mnum : "+mnum);
		// 세션으로 정보가져오기.
		MemberVO _mvo = mypageService.myInfo(mnum);
		log.info("mvo : "+_mvo);
		// 아이디 가져오기.
		String mid = _mvo.getMid();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("myPage/myPage");
		mav.addObject("mvo", _mvo);
		log.info("MypageController myPage 종료 : ");
		return mav;
	}


	
	/**
	 * 설명
	 * : 마이페이지 경매목록 조회.
	 * 매개변수 :
	 * 반환값 :
	 */
	@RequestMapping("myAuction")
	public ModelAndView myAuction(@ModelAttribute AuctionVO mavo, HttpServletRequest req) {
		log.info("MypageController myAuction 실행 : ");
		String groupsize = "5"; 	// 그룹사이즈  
		String pagesize = "16";   	// 페이지사이즈 
		String curpage = "1"; 	    // 현재페이지  
		String totalcount = "0"; 	// 총데이터수
		
		if(req.getParameter("curpage") != null) {
			curpage = req.getParameter("curpage");
		}
		
		mavo.setGroupsize(groupsize);
		mavo.setPagesize(pagesize);
		mavo.setCurpage(curpage);
		mavo.setTotalcount(totalcount);
		// 경매 조회 시 버튼에서 넘어오는 구분. (조회시 구분이랑 회원번호필요.)
		String asort = req.getParameter("asort");
		// 경매 조회 시 로그인된 세션의 회원번호 가져오기.
		HttpSession hs = req.getSession();
		String mnum = (String)hs.getAttribute("mnum");
		// 구분과 회원번호 vo 에 지정.
		log.info("세션 안 회원번호 : "+mnum);
		log.info("페이지 구분코드 : "+asort);
		mavo.setMnum(mnum);
		mavo.setAsort(asort);
		// 조회 쿼리를 갖다온 결과값을 list 에 담음.
		List<AuctionVO> auctionList = mypageService.myAuctionSALL(mavo);
		
		// 마이페이지 아이디값을 가져오기위해 쿼리를 갖다옴.
		MemberVO _mvo = mypageService.myInfo(mnum);
		log.info("mvo : "+_mvo);
		ModelAndView mav = new ModelAndView();
		// view.
		mav.setViewName("myPage/myAuction");
		// 구매,판매 목록.
		mav.addObject("auctionList", auctionList);
		// 현재 로그인한 vo.
		mav.addObject("mvo", _mvo);
		log.info("MypageController myAuction 종료 : ");
		return mav;
	}
	/**
	 * 설명
	 * : 마이페이지 경매 삭제.
	 * 매개변수 :
	 * 반환값 :
	 */
	@RequestMapping("myAuctionDel")
	public ModelAndView myAuctionDel(@ModelAttribute AuctionVO mavo, HttpServletRequest req) {
		log.info("MypageController myAuctionDel 실행 : ");
		// 경매 삭제시 버튼에서 넘어오는 구분. (삭제시 구분이랑 회원번호필요.)
		String asort = req.getParameter("asort");
		// 경매 삭제시 로그인된 세션의 회원번호 가져오기.
		HttpSession hs = req.getSession();
		String mnum = (String)hs.getAttribute("mnum");
		// 구분과 회원번호 vo 에 지정.
		log.info("세션 안 회원번호 : "+mnum);
		log.info("페이지 구분코드 : "+asort);
		mavo.setMnum(mnum);
		mavo.setAsort(asort);
		// 경매 삭제할 글번호. 를 마이페이지에서 받아옴.
		String anum =req.getParameter("anum");
		mavo.setAnum(anum);
		// 경매 삭제할 쿼리 결과.
		int dCnt = mypageService.myAuctionDel(mavo);
		// ModelAndView.
		ModelAndView mav =new ModelAndView();
		// 마이페이지 아이디값을 가져오기위해 쿼리를 갖다옴.
		MemberVO _mvo = mypageService.myInfo(mnum);
		log.info("mvo : "+_mvo);
		// 현재 로그인한 vo.
		mav.addObject("mvo", _mvo);
		// 삭제가 됐을 경우.
		try {
			if(dCnt>0) {
				// 삭제 후 다시 조회.
				// 삭제 후 다시 조회.
				String groupsize = "5"; 	// 그룹사이즈  
				String pagesize = "16";   	// 페이지사이즈 
				String curpage = "1"; 	    // 현재페이지  
				String totalcount = "0"; 	// 총데이터수
				
				if(req.getParameter("curpage") != null) {
					curpage = req.getParameter("curpage");
				}
				
				mavo.setGroupsize(groupsize);
				mavo.setPagesize(pagesize);
				mavo.setCurpage(curpage);
				mavo.setTotalcount(totalcount);
				List<AuctionVO> auctionList = mypageService.myAuctionSALL(mavo);
				// view.
				mav.setViewName("myPage/myAuction");
				// 경매 목록.
				mav.addObject("auctionList", auctionList);
			}
		}catch(Exception e) {
			e.getMessage();
		}
		log.info("MypageController myAuctionDel 종료 : ");
		return mav;
	}
	
	/**
	 * 설명
	 * :  경매 상세 페이지 경매 조회. 
	 * 매개변수 :
	 * 반환값 :
	 */
	@RequestMapping("selectAuction")
	public ModelAndView selectAuction(@ModelAttribute AuctionVO mavo) {
		log.info("MypageController selectAuction 실행 : ");
		log.info("MypageController 선택한 글번호 : "+mavo.getAnum());
		List<AuctionVO> list = mypageService.selectAuction(mavo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("myPage/selectAuction");
		mav.addObject("selectAuction",list);
		
		log.info("MypageController selectAuction 종료 : ");
		return mav;
	}
	
	/**
	 * 설명
	 * :구매,판매 조회.
	 * 매개변수 : @ModelAttribute GeneralVO mgvo, HttpServletRequest req
	 * 반환값 : mav
	 */
	@RequestMapping("myGeneral")
	public ModelAndView myGeneral(@ModelAttribute GeneralVO mgvo, HttpServletRequest req) {
		log.info("MypageController myGeneral 실행 : ");
		String groupsize = "5"; 	// 그룹사이즈  
		String pagesize = "16";   	// 페이지사이즈 
		String curpage = "1"; 	    // 현재페이지  
		String totalcount = "0"; 	// 총데이터수
		
		if(req.getParameter("curpage") != null) {
			curpage = req.getParameter("curpage");
		}
		
		mgvo.setGroupsize(groupsize);
		mgvo.setPagesize(pagesize);
		mgvo.setCurpage(curpage);
		mgvo.setTotalcount(totalcount);
		// 날짜 검색.
		String dateFrom = req.getParameter("dateFrom");
		String dateTo = req.getParameter("dateTo");
		mgvo.setDateFrom(dateFrom);
		mgvo.setDateTo(dateTo);
		log.info("dateFrom : "+dateFrom);
		log.info("dateTo : "+dateTo);
		// 구매,판매 조회 시 버튼에서 넘어오는 구분. (조회시 구분이랑 회원번호필요.)
		String gsort = req.getParameter("gsort");
		// 구매,판매 조회 시 로그인된 세션의 회원번호 가져오기.
		HttpSession hs = req.getSession();
		String mnum = (String)hs.getAttribute("mnum");
		// 구분과 회원번호 vo 에 지정.
		log.info("세션 안 회원번호 : "+mnum);
		log.info("페이지 구분코드 : "+gsort);
		mgvo.setMnum(mnum);
		mgvo.setGsort(gsort);
		// 조회 쿼리를 갖다온 결과값을 list 에 담음.
		List<GeneralVO> generalList = mypageService.myGeneralSALL(mgvo);
		
		// 마이페이지 아이디값을 가져오기위해 쿼리를 갖다옴.
		MemberVO _mvo = mypageService.myInfo(mnum);
		log.info("mvo : "+_mvo);
		ModelAndView mav = new ModelAndView();
		// view.
		mav.setViewName("myPage/myGeneral");
		// 구매 판매 목록.
		mav.addObject("generalList", generalList);
		// 현재 로그인한 vo.
		mav.addObject("mvo", _mvo);

		log.info("MypageController myGeneral 종료 : ");
		return mav;
	}
	/**
	 * 설명
	 * :구매,판매 삭제.
	 * 매개변수 :
	 * 반환값 :
	 */
	@RequestMapping("myGeneralDel")
	public ModelAndView myGeneralDel(@ModelAttribute GeneralVO mgvo, HttpServletRequest req) {
		log.info("MypageController myGeneralDel 실행 : ");
		// 구매,판매 삭제시 버튼에서 넘어오는 구분. (삭제시 구분이랑 회원번호필요.)
		String gsort = req.getParameter("gsort");
		// 구매,판매 삭제시 로그인된 세션의 회원번호 가져오기.
		HttpSession hs = req.getSession();
		String mnum = (String)hs.getAttribute("mnum");
		// 구분과 회원번호 vo 에 지정.
		log.info("세션 안 회원번호 : "+mnum);
		log.info("페이지 구분코드 : "+gsort);
		mgvo.setMnum(mnum);
		mgvo.setGsort(gsort);
		// 구매,판매 삭제할 글번호. 를 마이페이지에서 받아옴.
		String gnum =req.getParameter("gnum");
		log.info("삭제할 글번호 : "+gnum);
		mgvo.setGnum(gnum);
		// 구매,판매 삭제할 쿼리 결과.
		int dCnt = mypageService.myGeneralDel(mgvo);
		// ModelAndView.
		ModelAndView mav =new ModelAndView();
		// 마이페이지 아이디값을 가져오기위해 쿼리를 갖다옴.
		MemberVO _mvo = mypageService.myInfo(mnum);
		log.info("mvo : "+_mvo);
		// 현재 로그인한 vo.
		mav.addObject("mvo", _mvo);
		// 삭제가 됐을 경우.
		try {
			if(dCnt>0) {
				// 삭제 후 다시 조회.
				String groupsize = "5"; 	// 그룹사이즈  
				String pagesize = "16";   	// 페이지사이즈 
				String curpage = "1"; 	    // 현재페이지  
				String totalcount = "0"; 	// 총데이터수
				
				if(req.getParameter("curpage") != null) {
					curpage = req.getParameter("curpage");
				}
				
				mgvo.setGroupsize(groupsize);
				mgvo.setPagesize(pagesize);
				mgvo.setCurpage(curpage);
				mgvo.setTotalcount(totalcount);
				List<GeneralVO> generalList = mypageService.myGeneralSALL(mgvo);
				// view.
				mav.setViewName("myPage/myGeneral");
				// 구매,판매 목록.
				mav.addObject("generalList", generalList);
			}
		}catch(Exception e) {
			e.getMessage();
		}
		log.info("MypageController myGeneralDel 종료 : ");
		return mav;
	}
	/**
	 * 설명
	 * : 마이페이지 알림목록 조회.
	 * 매개변수 :
	 * 반환값 :
	 */
	@RequestMapping("myNotice")
	public ModelAndView myNotice(@ModelAttribute NoticeVO mnvo, HttpServletRequest req) {
		log.info("MypageController myNotice 실행 : ");
		log.info("MypageController myInfo 현재 로그인한 아이디의 회원번호 : "+mnvo.getMnum());
		// 세션으로 박기.
		// 세션 번호로 정보 가져오기.
		HttpSession hs = req.getSession();
		String mnum = (String)hs.getAttribute("mnum");
		log.info("세션 mnum : "+mnum);
		mnvo.setMnum(mnum);
		List<NoticeVO> list = mypageService.noticeSALL(mnvo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("myPage/myNotice");
		mav.addObject("myNoticeList", list);
		
		log.info("MypageController myNotice 종료 : ");
		return mav;
	}
	
	
	/**
	 * 설명
	 * : 마이페이지 찜하기 목록 조회.
	 * 매개변수 :
	 * 반환값 :
	 */
	@RequestMapping("myPick")
	public ModelAndView myPick(@ModelAttribute MyPickVO mpvo, HttpServletRequest req) {
		log.info("MypageController myPick 실행 : ");
		String groupsize = "5"; 	// 그룹사이즈  
		String pagesize = "16";   	// 페이지사이즈 
		String curpage = "1"; 	    // 현재페이지  
		String totalcount = "0"; 	// 총데이터수
		
		if(req.getParameter("curpage") != null) {
			curpage = req.getParameter("curpage");
		}
		String dateFrom = req.getParameter("dateFrom");
		String dateTo = req.getParameter("dateTo");
		mpvo.setDateFrom(dateFrom);
		mpvo.setDateTo(dateTo);
		mpvo.setGroupsize(groupsize);
		mpvo.setPagesize(pagesize);
		mpvo.setCurpage(curpage);
		mpvo.setTotalcount(totalcount);
		// 찜목록 시 버튼에서 넘어오는 구분. (조회시 회원번호필요.)
		// 찜목록 조회 시 로그인된 세션의 회원번호 가져오기.
		HttpSession hs = req.getSession();
		String mnum = (String)hs.getAttribute("mnum");
		// 구분과 회원번호 vo 에 지정.
		log.info("세션 안 회원번호 : "+mnum);	
		mpvo.setMnum(mnum);
		String gnum = req.getParameter("gnum");
		log.info("찜할글번호 : "+gnum);
		mpvo.setGnum(gnum);
		if(gnum!=null) {
			int iCnt = mypageService.pickInsert(mpvo);			
		}
		// 조회 쿼리를 갖다온 결과값을 list 에 담음.
		List<MyPickVO> pickList =mypageService.myPickSALL(mpvo);
		
		// 마이페이지 아이디값을 가져오기위해 쿼리를 갖다옴.
		MemberVO _mvo = mypageService.myInfo(mnum);
		log.info("mvo : "+_mvo);
		ModelAndView mav = new ModelAndView();
		// view.
		mav.setViewName("myPage/myPick");
		// 구매,판매 목록.
		mav.addObject("pickList", pickList);
		// 현재 로그인한 vo.
		mav.addObject("mvo", _mvo);

		log.info("MypageController myPick 종료 : ");
		return mav;
	}
	@RequestMapping("myPickDel")
	public ModelAndView myPickDel(@ModelAttribute MyPickVO mpvo, HttpServletRequest req) {
		log.info("MypageController myPickDel 실행 : ");
		// 찜 삭제 시 버튼에서 넘어오는 구분. (삭제시 구분이랑 회원번호필요.)
		String gsort = req.getParameter("gsort");
		// 찜 삭제 시 로그인된 세션의 회원번호 가져오기.
		HttpSession hs = req.getSession();
		String mnum = (String)hs.getAttribute("mnum");
		// 구분과 회원번호 vo 에 지정.
		log.info("세션 안 회원번호 : "+mnum);
		log.info("페이지 구분코드 : "+gsort);
		mpvo.setMnum(mnum);
		mpvo.setGsort(gsort);
		// 찜 삭제할 글번호. 를 마이페이지에서 받아옴.
		String gnum =req.getParameter("gnum");
		mpvo.setGnum(gnum);
		// 찜 삭제할 쿼리 결과.
		int dCnt = mypageService.myPickDel(mpvo);
		// ModelAndView.
		ModelAndView mav =new ModelAndView();
		// 마이페이지 아이디값을 가져오기위해 쿼리를 갖다옴.
		MemberVO _mvo = mypageService.myInfo(mnum);
		log.info("mvo : "+_mvo);
		// 현재 로그인한 vo.
		mav.addObject("mvo", _mvo);
		// 삭제가 됐을 경우.
		try {
			if(dCnt>0) {
				// 삭제 후 다시 조회.
				String groupsize = "5"; 	// 그룹사이즈  
				String pagesize = "16";   	// 페이지사이즈 
				String curpage = "1"; 	    // 현재페이지  
				String totalcount = "0"; 	// 총데이터수
				
				if(req.getParameter("curpage") != null) {
					curpage = req.getParameter("curpage");
				}
				
				mpvo.setGroupsize(groupsize);
				mpvo.setPagesize(pagesize);
				mpvo.setCurpage(curpage);
				mpvo.setTotalcount(totalcount);
				List<MyPickVO> pickList = mypageService.myPickSALL(mpvo);
				// view.
				mav.setViewName("myPage/myPick");
				// 구매,판매 목록.
				mav.addObject("pickList", pickList);
			}
		}catch(Exception e) {
			e.getMessage();
		}
		log.info("MypageController myPickDel 종료 : ");
		return mav;
	}

	/**
	 * 설명
	 * : 마이페이지 찜하기에서 상세 페이지 이동.
	 * 매개변수 :
	 * 반환값 :
	 */
	@RequestMapping("selectGeneral")
	public ModelAndView selectGeneral(@ModelAttribute GeneralVO mgvo) {
		log.info("MypageController selectGeneral 실행 : ");
		
		List<GeneralVO> list = mypageService.selectGeneral(mgvo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("myPage/selectGeneral");
		mav.addObject("selectGeneral",list);
		
		log.info("MypageController selectGeneral 종료 : ");
		return mav;
	}
}
