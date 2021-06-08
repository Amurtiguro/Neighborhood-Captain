package com.spw.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spw.member.service.MemberService;

import com.spw.member.vo.MemberVO;

/**
 * 클래스
 * 설명
 * : 관리자 화면에서 사용할 컨트롤러
 * 
 * 날짜 :20200810
 * 작성자 : 김주호
 */
@Controller
public class AdminController {
	Logger log = Logger.getLogger(AdminController.class);
	
	@Autowired
	private MemberService memberservice;
	
	@RequestMapping(value = "/adminform", method = RequestMethod.GET)
	public ModelAndView adminSelectAll() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/adminform");
		return mav;
	}
	/**
	 * 클래스
	 * 설명
	 * : 회원 전체 조회해서 출력할 컨트롤러
	 * 날짜 :20200810
	 * 작성자 : 김주호
	 */
	@RequestMapping(value = "/adminSelectAll",method = RequestMethod.GET)
	public ModelAndView admin(@ModelAttribute MemberVO mvo,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		log.info(mvo.getMid());
		
		String pageSize = "10";
		String groupSize = "5";
		String curPage = "1";
		String totalCount = "0";
		if (mvo.getCurPage() !=null){
			curPage = mvo.getCurPage();
		}
	//	mvo.setTotalCount("0");// 전체 페이지의 갯수
		mvo.setPageSize(pageSize);//현재페이지에 보여질 게시물 수
		mvo.setGroupSize(groupSize); //아래 페이지 그룹의 크기
		mvo.setCurPage(curPage);
		mvo.setTotalCount(totalCount);
		List list;
		list = memberservice.memSelectAll(mvo);
		MemberVO mvo2=(MemberVO)list.get(0);
		//list.add(mvo2);
		System.out.println("CurPage : "+mvo2.getCurPage());
		System.out.println("PageSize : "+mvo2.getPageSize());
		System.out.println("GroupSize : "+mvo2.getGroupSize());
		System.out.println("TotalCount : "+mvo2.getTotalCount());
		mav.addObject("mvo", mvo);
		mav.addObject("list", list);
		mav.setViewName("/admin/adminSelectAll");
		return mav;
	}
	
	/**
	 * 설명
	 * : 관리자모드에서 회원삭제.
	 * 매개변수 :
	 * 반환값 :
	 * 날짜 :
	 * 작성자 :
	 */
	@RequestMapping(value = "/adminDel", method = RequestMethod.POST)
	public ModelAndView adminDel(@ModelAttribute MemberVO mvo,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		System.out.println(request.getParameter("chkInMnum"));
		
		mvo.setMnum(request.getParameter("chkInMnum"));;
		
		int result=0;
		result = memberservice.adminDel(mvo);
		if(result>0) {
			mav.setViewName("/admin/adminDelOK");// 진짜 뷰만 실행하는거라서			
		}else {
			log.info("adminDel 실패 : ");
		}
		return mav;
	}
	
	
	
}
