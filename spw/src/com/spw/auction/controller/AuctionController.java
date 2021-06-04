package com.spw.auction.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.spw.auction.service.AuctionService;
import com.spw.auction.vo.AuctionVO;
import com.spw.category.service.CategoryService;
import com.spw.category.vo.CategoryVO;
import com.spw.common.FileEditUtil;


/**
* 설명
* :
* 매개변수 :
* 반환값 :
* 날짜 :
* 작성자 :
*/
@Controller
public class AuctionController {
	private Logger log=Logger.getLogger(AuctionController.class);
	
	@Autowired
	private AuctionService auctionservice;

	@Autowired
	private CategoryService categoryservice;
	
	// 파일 업로드를 위한 변수  ===========================
	int size = 10*1024*1024;
//	static String path = "\\spw\\uploadImages";
	
	
	/**
	 * 설명
	 * : 경매상품 글 작성하는 폼으로 이동
	 * 매개변수 : auvo , req - 요청 객체 
	 * 반환값 : ModelAndView
	 * 날짜 : 2020/08/06
	 * 작성자 : 조하영
	 */
	@RequestMapping("/auctionWrite")
	public ModelAndView writeForm(@ModelAttribute AuctionVO auvo, HttpServletRequest req) {
		log.info("AuctionController writeForm start >>> ");
		
		HttpSession hs = req.getSession();
		String mnum = (String)hs.getAttribute("mnum");
		
		ModelAndView mav=new ModelAndView();
		
		if(mnum!=null&&mnum.length()>0) {
			mav.setViewName("auction/auctionInsert");			
		}else {
			mav.setViewName("login/loginform");
		}
		return mav;
	}
	
	/**
	 * 설명
	 * : 경매상품 등록 
	 * 매개변수 : auvo - 상품 등록 정보 , req - 요청 객체
	 * 반환값 : ModelAndView
	 * 날짜 : 2020/08/06
	 * 작성자 : 조하영
	 */
	@RequestMapping("/auctionInsert")
	public ModelAndView insertAuction(@ModelAttribute AuctionVO auvo, HttpServletRequest req) {
		log.info("AuctionController insertAuction start >>> ");

		ServletContext context = req.getSession().getServletContext();
		String originalPath = context.getRealPath("uploadImages");
		log.info("originalPath >>> "+originalPath );
		
		try {
			MultipartRequest multi = new MultipartRequest(req,originalPath,size,"UTF-8",new DefaultFileRenamePolicy());
			
			Enumeration <String> em=multi.getFileNames();
			List<String> list=new ArrayList<String>();
			String aphoto="";
			
			while(em.hasMoreElements()) {
				String photo=em.nextElement();
				aphoto=multi.getFilesystemName(photo);
				log.info("photo name >>> "+aphoto);
			}
			// mac.
			File file=new File(originalPath+"//"+aphoto);
			// window.
			//File file=new File(originalPath+"\\"+aphoto);
			int index=aphoto.lastIndexOf(".");
			String fileExt=aphoto.substring(index+1);

			log.info("확장자 >>> "+fileExt);
			log.info("file >>> "+file);
			log.info("썸네일 파일 생성 >>>>>>>>>>>>>>>>>");
			log.info("file.getAbsolutePath()"+file.getAbsolutePath());
			String editFile=FileEditUtil.makeThumbnail(file.getAbsolutePath(),aphoto,fileExt,req);
			log.info("썸네일 파일 생성  성공 >>>>>>>>>>>>>>>>>");
			
			String atitle=multi.getParameter("atitle");
			String cgnum=multi.getParameter("cgnum");
			String pricemin=multi.getParameter("apricemin");
			String aendtime=multi.getParameter("aendtime");
			String aloc=multi.getParameter("aloc");;
			String acontents=multi.getParameter("acontents");
			String mnum=multi.getParameter("mnum");
			
			//천단위 콤마 제거
			String apricemin=pricemin.replaceAll("[^0-9]", "");
			
			auvo.setAphoto(aphoto);
			auvo.setAtitle(atitle);
			auvo.setCgnum(cgnum);
			auvo.setApricemin(apricemin);
			auvo.setAendtime(aendtime);
			auvo.setAloc(aloc);
			auvo.setAcontents(acontents);
			auvo.setAsort("3");
			auvo.setAstatus("1"); 
			auvo.setAdelyn("N"); 
			auvo.setArephoto(editFile);
			auvo.setMnum(mnum);
			
			log.info("제목 >>> : "+atitle);
			log.info("카테고리 >>> : "+cgnum);
			log.info("사진 >>> : "+auvo.getAphoto());
			log.info("시작가 >>> : "+apricemin);
			log.info("종료시간 >>> : "+aendtime);
			log.info("거래지역 >>> : "+aloc);
			log.info("설명>>> : "+acontents);
			log.info("작성자>>> : "+mnum);
			
		}catch(Exception e) {
			log.info("insert exception >>> "+e);
		}
		
		ModelAndView mav=new ModelAndView();
		
		int res=auctionservice.auctionInsert(auvo);
		log.info("insert 결과 >>> "+res);
		
		if(res>0) {
			auvo.setCurpage("1");
			auvo.setPagesize("10");
			List<AuctionVO> auctionList=auctionservice.auctionList(auvo);
			mav.addObject("auctionList",auctionList);
			mav.setViewName("redirect:auctionList.spw");
		}
		return mav;
	}

	/**
	 * 설명
	 * : 경매 상품 목록 페이지 
	 * 매개변수 : auvo
	 * 반환값 : ModelAndView
	 * 날짜 : 2020/08/06
	 * 작성자 : 조하영
	 */
	@RequestMapping("/auctionList")
	public ModelAndView auctionList(@ModelAttribute AuctionVO auvo) {
		log.info("AuctionController auctionList start >>> ");
		
		auvo.setPagesize("16");
		
		if(auvo.getCurpage()==null){
			auvo.setCurpage("1");
		}
		
		List<AuctionVO> auctionList=new ArrayList<AuctionVO>();
		auctionList=auctionservice.auctionList(auvo);
		if(auctionList.size()>0) {
			auvo.setCurpage(auctionList.get(0).getCurpage());
		}
		log.info("Curpage : "+auvo.getCurpage());
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("auctionList",auctionList);
		mav.setViewName("auction/auctionList");
		
		return mav;
	}
	
	/**
	 * 설명
	 * : 경매 글 상세보기
	 * 매개변수 : auvo - 글 번호 
	 * 반환값 : ModelAndView
	 * 날짜 : 2020/08/07
	 * 작성자 : 조하영
	 */
	@RequestMapping("/auctionViewDetail")
	public ModelAndView auctionViewDetail(@ModelAttribute AuctionVO auvo) {
		log.info("AuctionController auctionViewDetail start >>> ");
		log.info("받아온 글 번호 >>>"+auvo.getAnum());
		
		AuctionVO detailVO=auctionservice.auctionViewDetail(auvo);
		CategoryVO cavo=new CategoryVO();
		cavo.setCgnum(detailVO.getCgnum());
		List<CategoryVO> clist=categoryservice.categorySelect(cavo);
		
		log.info("설명 >>> "+detailVO.getAcontents());
		log.info("글번호 >>> "+detailVO.getAnum());
		log.info("글제목 >>> "+detailVO.getAtitle());
		log.info("회원번호 >>> "+detailVO.getMnum());
		log.info("사진  >>> "+detailVO.getAphoto());
		log.info("썸네일 사진  >>> "+detailVO.getArephoto());
		log.info("거래지역 >>> "+detailVO.getAloc());
		log.info("최소가 >>> "+detailVO.getApricemin());
		log.info("최고가 >>> "+detailVO.getBidhighprice());
		detailVO.setCgname(clist.get(0).getCgname());
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("auction/auctionDetail");
		mav.addObject("deatilVO", detailVO);
		
		return mav;
	}
	
	/**
	 * 설명
	 * : 수정폼으로 이동
	 * 매개변수 : auvo - 글번호 
	 * 반환값 : ModelAndView
	 * 날짜 : 2020/08/07
	 * 작성자 : 조하영
	 */
	@RequestMapping("/auctionUpdateView")
	public ModelAndView auctionUpdateView(@ModelAttribute AuctionVO auvo) {
		log.info("AuctionController auctionUpdateView start >>> ");
		
		log.info("수정할 글 번호 >>> "+auvo.getAnum());
		AuctionVO detailVO=auctionservice.auctionUpdateView(auvo);
		
		log.info("설명 >>> "+detailVO.getAcontents());
		log.info("글번호 >>> "+detailVO.getAnum());
		log.info("글제목 >>> "+detailVO.getAtitle());
		log.info("회원번호 >>> "+detailVO.getMnum());
		log.info("사진  >>> "+detailVO.getAphoto());
		log.info("거래지역 >>> "+detailVO.getAloc());
		log.info("최소가 >>> "+detailVO.getApricemin());
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("detailVO",detailVO);
		mav.setViewName("auction/auctionUpdate");
		
		return mav;
	} 
	
	/**
	 * 설명
	 * : 상품 수정 
	 * 매개변수 : auvo - 상품 수정 정보 , req - 요청 객체 
	 * 반환값 : ModelAndView
	 * 날짜 : 2020/08/07
	 * 작성자 : 조하영
	 */
	@RequestMapping("/auctionUpdate")
	public ModelAndView auctionUpdate(@ModelAttribute AuctionVO auvo,HttpServletRequest req) {
		log.info("AuctionController auctionUpdate start >>> ");
		
		ServletContext context = req.getSession().getServletContext();
		log.info("context >>> "+context );
		String originalPath = context.getRealPath("uploadImages");
		log.info("originalPath >>> "+originalPath );
		
		try {
			MultipartRequest multi = new MultipartRequest(req,originalPath,size,"UTF-8",new DefaultFileRenamePolicy());
			
			Enumeration <String> em=multi.getFileNames();
			List<String> list=new ArrayList<String>();
			String aphoto="";
			String editFile="";
			while(em.hasMoreElements()) {
				String photo=em.nextElement();
				aphoto=multi.getFilesystemName(photo);
				log.info("photo : "+photo);
				log.info("aphoto : "+aphoto);
			}
			
			if(aphoto!=null&&aphoto.length()>0) {
				
				//File file=new File(originalPath+"\\"+aphoto);
				File file=new File(originalPath+"//"+aphoto);
				int index=aphoto.lastIndexOf(".");
				String fileExt=aphoto.substring(index+1);

				log.info("확장자 >>> "+fileExt);
				log.info("file >>> "+file);
				log.info("썸네일 파일 생성 >>>>>>>>>>>>>>>>>");
				log.info("file.getAbsolutePath()"+file.getAbsolutePath());
				editFile=FileEditUtil.makeThumbnail(file.getAbsolutePath(),aphoto,fileExt,req);
				log.info("썸네일 파일 생성  성공 >>>>>>>>>>>>>>>>>");
			}else {
				aphoto=multi.getParameter("aphoto1");
				editFile="Thumb_"+aphoto;
			}
			String anum = multi.getParameter("anum");
			String atitle=multi.getParameter("atitle");
			String cgnum=multi.getParameter("cgnum");
			String pricemin=multi.getParameter("apricemin");
			String aendtime=multi.getParameter("aendtime");
			String aloc=multi.getParameter("aloc");;
			String acontents=multi.getParameter("acontents");
			
			
			//천단위 콤마 제거
			String apricemin=pricemin.replaceAll("[^0-9]", "");
			
			auvo.setAnum(anum);
			auvo.setAtitle(atitle);
			auvo.setCgnum(cgnum);
			auvo.setAphoto(aphoto);
			auvo.setArephoto(editFile);
			auvo.setApricemin(apricemin);
			auvo.setAendtime(aendtime);
			auvo.setAloc(aloc);
			auvo.setAcontents(acontents);
			
		}catch(Exception e) {
			log.info("update exception >>> ");
			e.printStackTrace();
		}
		
		ModelAndView mav=new ModelAndView();
		
		int res=auctionservice.auctionUpdate(auvo);
		if(res>0) {
			AuctionVO detailVO=auctionservice.auctionViewDetail(auvo);
			CategoryVO cavo=new CategoryVO();
			cavo.setCgnum(detailVO.getCgnum());
			List<CategoryVO> clist=categoryservice.categorySelect(cavo);
			detailVO.setCgname(clist.get(0).getCgname());
			
			mav.setViewName("auction/auctionDetail");
			mav.addObject("deatilVO",detailVO);
		}
		
		return mav;
	}
	
	/**
	 * 설명
	 * :상품 삭제 
	 * 매개변수 : auvo - 글번호 
	 * 반환값 : ModelAndView
	 * 날짜 : 2020/08/07
	 * 작성자 : 조하영
	 */
	@RequestMapping ("/auctionDelete")
	public ModelAndView auctionDelete(@ModelAttribute AuctionVO auvo) {
		log.info("AuctionController auctionDelete start >>> ");
		log.info("delete anum >>> "+auvo.getAnum());
		ModelAndView mav=new ModelAndView();
		
		int res=auctionservice.auctionDelete(auvo);
		log.info("delete res >>> "+res);
	
		if(res>0) {
			List<AuctionVO> list=auctionservice.auctionList(auvo);
			mav.setViewName("auction/auctionDeleteOK");
			mav.addObject("auctionList",list);
			mav.addObject("res",res);
			log.info("삭제 성공 후 목록 페이지로 이동 !!" );
		}
		return mav;
	}
	
	/**
	 * 설명
	 * :서버의 현재시간을 에포크 시간부터 얼만큼흘렀는지 마이크로초 단위로 반환
	 * 통합단계에 다른 컨트롤러로 옮겨야함
	 * 매개변수 : 없음
	 * 반환값 : ResponseEntity
	 * 날짜 : 2020/08/06
	 * 작성자 : 최정규
	 */
	@RequestMapping("/getServerTime")
	public ResponseEntity<String> serverTime() {
		log.info("[ serverTime ]");

		// 컨텐츠 타입을 텍스트로 설정하고 캐싱하지 못하게 설정
		HttpHeaders resHeader = new HttpHeaders();
		resHeader.add("Content-Type", MediaType.TEXT_PLAIN_VALUE);
		resHeader.add("Cache-Control", "no-cache, no-store, must-revalidate");

		String timeServ = Long.toString(new Date().getTime());

		ResponseEntity<String> resEntity = new ResponseEntity<String>(timeServ , resHeader, HttpStatus.OK);

		return resEntity;
	}
	
}
