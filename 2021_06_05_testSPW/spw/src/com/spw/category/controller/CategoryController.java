package com.spw.category.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spw.category.service.CategoryService;
import com.spw.category.vo.CategoryVO;

@Controller
@RequestMapping("category")
public class CategoryController {
	private static Logger log = Logger.getLogger(CategoryController.class);

	// 카테고리 View가 저장된 폴더
	private static String VIEW_DIR = "category/";

	@Autowired
	private CategoryService categoryService;

	/**
	 * 설명
	 * : 카테고리 목록 (일반 사용자 확인용)
	 * 매개변수 : 없음
	 * 반환값 : ModelAndView
	 * 날짜 : 2020. 8. 7
	 * 작성자 : 최정규
	 */
	@RequestMapping("/list")
	public ModelAndView categoryList(){
		log.info("[ categoryList 시작 ]");

		// 카테고리 목록
		List<CategoryVO> list = categoryService.categoryList();
		log.info("[i] list => " + list);

		// Model and View
		ModelAndView mav = new ModelAndView();

		// 카테고리 목록 설정
		mav.addObject("list", list);

		// View 설정
		mav.setViewName(VIEW_DIR + "caList");

		log.info("[ categoryList 종료 ] mav => " + mav);
		return mav;
	}

	/**
	 * 설명
	 * : 카테고리 목록 (관리자용)
	 * 매개변수 : 없음
	 * 반환값 : ModelAndView
	 * 날짜 : 2020. 8. 7
	 * 작성자 : 최정규
	 */
	@RequestMapping("/selectAll")
	public ModelAndView categorySelectAll(){
		log.info("[ categorySelectAll 시작 ]");

		// 카테고리 목록
		List<CategoryVO> list = categoryService.categoryList();
		log.info("[i] list => " + list);

		// Model and View
		ModelAndView mav = new ModelAndView();

		// 카테고리 목록 설정
		mav.addObject("list", list);

		// View 설정
		mav.setViewName(VIEW_DIR + "caSelectAll");

		log.info("[ categorySelectAll 종료 ] mav => " + mav);
		return mav;
	}

	/**
	 * 설명
	 * : 카테고리 등록 폼 (관리자 기능)
	 * 매개변수 : request - 요청 객체
	 * 반환값 : String - 폼 View
	 * 날짜 : 2020/08/07
	 * 작성자 : 최정규
	 */
	@RequestMapping(value="/insert", method = RequestMethod.GET)
	public String categoryInsert(HttpServletRequest request) {
		log.info("[ categoryInsert ]");

		// 세션을 통해 관리자인지 확인
		boolean isAuth = false;

		// 관리자 확인 - 아직 미구현 (임시로 허용)
		isAuth = true;

		// 관리자일때만 접근허용
		String viewName = "common/noAuth";

		if(isAuth == true) {
			viewName = VIEW_DIR + "caInsert";
		}

		return viewName;
	}
	
	/**
	 * 설명
	 * : 카테고리 등록 처리 (관리자 기능)
	 * 매개변수 : request - 요청 객체, CategoryVO cvo - 카테고리 이름
	 * 반환값 : ModelAndView
	 * 날짜 : 2020/08/07
	 * 작성자 : 최정규
	 */
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public ModelAndView categoryInsertProcess(HttpServletRequest request, @ModelAttribute CategoryVO cvo) {
		log.info("[ categoryInsertProcess 시작] cvo => " + cvo);

		// 입력값 정보
		if(cvo != null) {
			log.info("[i] 카테고리 이름 => " + cvo.getCgname());
		}

		// 세션을 통해 관리자인지 확인
		boolean isAuth = false;

		// 관리자 확인 - 아직 미구현 (임시로 허용)
		isAuth = true;

		// 관리자일때만 접근허용 + 기능작동
		ModelAndView mav = new ModelAndView();

		if(isAuth == true) {
			// DB 작업
			int cnt = categoryService.categoryInsert(cvo);
			log.info("[i] cnt => " + cnt);

			// 메세지, URL설정
			String msg = null;
			String url = null;
			if(cnt > 0) {
				msg = "카테고리 추가 완료";
				url = "category/selectAll.spw";
			}else {
				msg = "카테고리 추가 실패";
			}

			mav.setViewName("common/msg");
			mav.addObject("msg", msg);
			mav.addObject("url", url);
		}else {
			mav.setViewName("common/noAuth");
		}

		log.info("[ categoryInsertProcess 종료] mav => " + mav);
		return mav;
	}

	/**
	 * 설명
	 * : 카테고리 편집 폼 (관리자 기능)
	 * 매개변수 : request - 요청 객체, CategoryVO cvo - 선택한 카테고리 번호
	 * 반환값 : ModelAndView
	 * 날짜 : 2020/08/07
	 * 작성자 : 최정규
	 */
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public ModelAndView categoryUpdate(HttpServletRequest request, @ModelAttribute CategoryVO cvo) {
		log.info("[ categoryUpdate 시작] cvo => " + cvo);

		// 세션을 통해 관리자인지 확인
		boolean isAuth = false;

		// 관리자 확인 - 아직 미구현 (임시로 허용)
		isAuth = true;

		// 관리자일때만 접근허용 + 기능작동
		ModelAndView mav = new ModelAndView();

		if(isAuth == true) {
			mav.setViewName(VIEW_DIR + "caUpdate");

			// DB에서 내용 가져오기
			List<CategoryVO> list = categoryService.categorySelect(cvo);
			log.info("[i] list => " + list);

			mav.addObject("list", list);
		}else {
			mav.setViewName("common/noAuth");
		}

		log.info("[ categoryUpdate 종료] mav => " + mav);
		return mav;
	}

	/**
	 * 설명
	 * : 카테고리 편집 처리 (관리자 기능)
	 * 매개변수 : request - 요청 객체, CategoryVO cvo - 카테고리 코드, 이름
	 * 반환값 : ModelAndView
	 * 날짜 : 2020/08/07
	 * 작성자 : 최정규
	 */
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public ModelAndView categoryUpdateProcess(HttpServletRequest request, @ModelAttribute CategoryVO cvo) {
		log.info("[ categoryUpdateProcess 시작] cvo => " + cvo);

		// 입력값 정보
		if(cvo != null) {
			log.info("[i] 카테고리 코드 => " + cvo.getCgnum());
			log.info("[i] 카테고리 이름 => " + cvo.getCgname());
		}

		// 세션을 통해 관리자인지 확인
		boolean isAuth = false;

		// 관리자 확인 - 아직 미구현 (임시로 허용)
		isAuth = true;

		// 관리자일때만 접근허용 + 기능작동
		ModelAndView mav = new ModelAndView();

		if(isAuth == true) {
			// DB 작업
			int cnt = categoryService.categoryUpdate(cvo);
			log.info("[i] cnt => " + cnt);

			// 메세지, URL설정
			String msg = null;
			String url = null;
			if(cnt > 0) {
				msg = "카테고리 편집 완료";
				url = "category/selectAll.spw";
			}else {
				msg = "카테고리 편집 실패";
			}

			mav.setViewName("common/msg");
			mav.addObject("msg", msg);
			mav.addObject("url", url);
		}else {
			mav.setViewName("common/noAuth");
		}

		log.info("[ categoryUpdateProcess 종료] mav => " + mav);
		return mav;
	}
}
