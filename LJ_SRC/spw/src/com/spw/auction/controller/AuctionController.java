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
* �꽕紐�
* :
* 留ㅺ컻蹂��닔 :
* 諛섑솚媛� :
* �궇吏� :
* �옉�꽦�옄 :
*/
@Controller
public class AuctionController {
	private Logger log=Logger.getLogger(AuctionController.class);
	
	@Autowired
	private AuctionService auctionservice;

	@Autowired
	private CategoryService categoryservice;
	
	// �뙆�씪 �뾽濡쒕뱶瑜� �쐞�븳 蹂��닔  ===========================
	int size = 10*1024*1024;
//	static String path = "\\spw\\uploadImages";
	
	
	/**
	 * �꽕紐�
	 * : 寃쎈ℓ�긽�뭹 湲� �옉�꽦�븯�뒗 �뤌�쑝濡� �씠�룞
	 * 留ㅺ컻蹂��닔 : auvo , req - �슂泥� 媛앹껜 
	 * 諛섑솚媛� : ModelAndView
	 * �궇吏� : 2020/08/06
	 * �옉�꽦�옄 : 議고븯�쁺
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
	 * �꽕紐�
	 * : 寃쎈ℓ�긽�뭹 �벑濡� 
	 * 留ㅺ컻蹂��닔 : auvo - �긽�뭹 �벑濡� �젙蹂� , req - �슂泥� 媛앹껜
	 * 諛섑솚媛� : ModelAndView
	 * �궇吏� : 2020/08/06
	 * �옉�꽦�옄 : 議고븯�쁺
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

			log.info("�솗�옣�옄 >>> "+fileExt);
			log.info("file >>> "+file);
			log.info("�뜽�꽕�씪 �뙆�씪 �깮�꽦 >>>>>>>>>>>>>>>>>");
			log.info("file.getAbsolutePath()"+file.getAbsolutePath());
			String editFile=FileEditUtil.makeThumbnail(file.getAbsolutePath(),aphoto,fileExt,req);
			log.info("�뜽�꽕�씪 �뙆�씪 �깮�꽦  �꽦怨� >>>>>>>>>>>>>>>>>");
			
			String atitle=multi.getParameter("atitle");
			String cgnum=multi.getParameter("cgnum");
			String pricemin=multi.getParameter("apricemin");
			String aendtime=multi.getParameter("aendtime");
			String aloc=multi.getParameter("aloc");;
			String acontents=multi.getParameter("acontents");
			String mnum=multi.getParameter("mnum");
			
			//泥쒕떒�쐞 肄ㅻ쭏 �젣嫄�
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
			
			log.info("�젣紐� >>> : "+atitle);
			log.info("移댄뀒怨좊━ >>> : "+cgnum);
			log.info("�궗吏� >>> : "+auvo.getAphoto());
			log.info("�떆�옉媛� >>> : "+apricemin);
			log.info("醫낅즺�떆媛� >>> : "+aendtime);
			log.info("嫄곕옒吏��뿭 >>> : "+aloc);
			log.info("�꽕紐�>>> : "+acontents);
			log.info("�옉�꽦�옄>>> : "+mnum);
			
		}catch(Exception e) {
			log.info("insert exception >>> "+e);
		}
		
		ModelAndView mav=new ModelAndView();
		
		int res=auctionservice.auctionInsert(auvo);
		log.info("insert 寃곌낵 >>> "+res);
		
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
	 * �꽕紐�
	 * : 寃쎈ℓ �긽�뭹 紐⑸줉 �럹�씠吏� 
	 * 留ㅺ컻蹂��닔 : auvo
	 * 諛섑솚媛� : ModelAndView
	 * �궇吏� : 2020/08/06
	 * �옉�꽦�옄 : 議고븯�쁺
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
	 * �꽕紐�
	 * : 寃쎈ℓ 湲� �긽�꽭蹂닿린
	 * 留ㅺ컻蹂��닔 : auvo - 湲� 踰덊샇 
	 * 諛섑솚媛� : ModelAndView
	 * �궇吏� : 2020/08/07
	 * �옉�꽦�옄 : 議고븯�쁺
	 */
	@RequestMapping("/auctionViewDetail")
	public ModelAndView auctionViewDetail(@ModelAttribute AuctionVO auvo) {
		log.info("AuctionController auctionViewDetail start >>> ");
		log.info("諛쏆븘�삩 湲� 踰덊샇 >>>"+auvo.getAnum());
		
		AuctionVO detailVO=auctionservice.auctionViewDetail(auvo);
		CategoryVO cavo=new CategoryVO();
		cavo.setCgnum(detailVO.getCgnum());
		List<CategoryVO> clist=categoryservice.categorySelect(cavo);
		
		log.info("�꽕紐� >>> "+detailVO.getAcontents());
		log.info("湲�踰덊샇 >>> "+detailVO.getAnum());
		log.info("湲��젣紐� >>> "+detailVO.getAtitle());
		log.info("�쉶�썝踰덊샇 >>> "+detailVO.getMnum());
		log.info("�궗吏�  >>> "+detailVO.getAphoto());
		log.info("�뜽�꽕�씪 �궗吏�  >>> "+detailVO.getArephoto());
		log.info("嫄곕옒吏��뿭 >>> "+detailVO.getAloc());
		log.info("理쒖냼媛� >>> "+detailVO.getApricemin());
		log.info("理쒓퀬媛� >>> "+detailVO.getBidhighprice());
		detailVO.setCgname(clist.get(0).getCgname());
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("auction/auctionDetail");
		mav.addObject("deatilVO", detailVO);
		
		return mav;
	}
	
	/**
	 * �꽕紐�
	 * : �닔�젙�뤌�쑝濡� �씠�룞
	 * 留ㅺ컻蹂��닔 : auvo - 湲�踰덊샇 
	 * 諛섑솚媛� : ModelAndView
	 * �궇吏� : 2020/08/07
	 * �옉�꽦�옄 : 議고븯�쁺
	 */
	@RequestMapping("/auctionUpdateView")
	public ModelAndView auctionUpdateView(@ModelAttribute AuctionVO auvo) {
		log.info("AuctionController auctionUpdateView start >>> ");
		
		log.info("�닔�젙�븷 湲� 踰덊샇 >>> "+auvo.getAnum());
		AuctionVO detailVO=auctionservice.auctionUpdateView(auvo);
		
		log.info("�꽕紐� >>> "+detailVO.getAcontents());
		log.info("湲�踰덊샇 >>> "+detailVO.getAnum());
		log.info("湲��젣紐� >>> "+detailVO.getAtitle());
		log.info("�쉶�썝踰덊샇 >>> "+detailVO.getMnum());
		log.info("�궗吏�  >>> "+detailVO.getAphoto());
		log.info("嫄곕옒吏��뿭 >>> "+detailVO.getAloc());
		log.info("理쒖냼媛� >>> "+detailVO.getApricemin());
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("detailVO",detailVO);
		mav.setViewName("auction/auctionUpdate");
		
		return mav;
	} 
	
	/**
	 * �꽕紐�
	 * : �긽�뭹 �닔�젙 
	 * 留ㅺ컻蹂��닔 : auvo - �긽�뭹 �닔�젙 �젙蹂� , req - �슂泥� 媛앹껜 
	 * 諛섑솚媛� : ModelAndView
	 * �궇吏� : 2020/08/07
	 * �옉�꽦�옄 : 議고븯�쁺
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

				log.info("�솗�옣�옄 >>> "+fileExt);
				log.info("file >>> "+file);
				log.info("�뜽�꽕�씪 �뙆�씪 �깮�꽦 >>>>>>>>>>>>>>>>>");
				log.info("file.getAbsolutePath()"+file.getAbsolutePath());
				editFile=FileEditUtil.makeThumbnail(file.getAbsolutePath(),aphoto,fileExt,req);
				log.info("�뜽�꽕�씪 �뙆�씪 �깮�꽦  �꽦怨� >>>>>>>>>>>>>>>>>");
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
			
			
			//泥쒕떒�쐞 肄ㅻ쭏 �젣嫄�
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
	 * �꽕紐�
	 * :�긽�뭹 �궘�젣 
	 * 留ㅺ컻蹂��닔 : auvo - 湲�踰덊샇 
	 * 諛섑솚媛� : ModelAndView
	 * �궇吏� : 2020/08/07
	 * �옉�꽦�옄 : 議고븯�쁺
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
			log.info("�궘�젣 �꽦怨� �썑 紐⑸줉 �럹�씠吏�濡� �씠�룞 !!" );
		}
		return mav;
	}
	
	/**
	 * �꽕紐�
	 * :�꽌踰꾩쓽 �쁽�옱�떆媛꾩쓣 �뿉�룷�겕 �떆媛꾨��꽣 �뼹留뚰겮�쓽���뒗吏� 留덉씠�겕濡쒖큹 �떒�쐞濡� 諛섑솚
	 * �넻�빀�떒怨꾩뿉 �떎瑜� 而⑦듃濡ㅻ윭濡� �삷寃⑥빞�븿
	 * 留ㅺ컻蹂��닔 : �뾾�쓬
	 * 諛섑솚媛� : ResponseEntity
	 * �궇吏� : 2020/08/06
	 * �옉�꽦�옄 : 理쒖젙洹�
	 */
	@RequestMapping("/getServerTime")
	public ResponseEntity<String> serverTime() {
		log.info("[ serverTime ]");

		// 而⑦뀗痢� ���엯�쓣 �뀓�뒪�듃濡� �꽕�젙�븯怨� 罹먯떛�븯吏� 紐삵븯寃� �꽕�젙
		HttpHeaders resHeader = new HttpHeaders();
		resHeader.add("Content-Type", MediaType.TEXT_PLAIN_VALUE);
		resHeader.add("Cache-Control", "no-cache, no-store, must-revalidate");

		String timeServ = Long.toString(new Date().getTime());

		ResponseEntity<String> resEntity = new ResponseEntity<String>(timeServ , resHeader, HttpStatus.OK);

		return resEntity;
	}
	
}