package com.spw.member.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spw.member.service.MemberService;
import com.spw.member.vo.MemberVO;

/**
 * �꽕紐�: �쉶�썝媛��엯, 濡쒓렇�씤, ID李얘린 ,鍮꾨�踰덊샇 李얘린 �꽕�씠踰� 濡쒓렇�씤�쓣 �쐞�븳 而⑦듃濡ㅻ윭 �궗�슜湲곗닠 :
 * log4j, MVC�뙣�꽩, mybatis, ajax(�쉶�썝媛��엯�떆 ID以묐났泥댄겕), 硫붿씪�쟾�넚(Mail library),
 * �꽕�씠踰꾨줈洹몄씤 API(json-simple)
 * 
 * HTTP 諛붾뵒�뿉 �떞湲곕뒗 content type�쓽 醫낅쪟 3媛�吏� 1.text type : html,css,js �벑�벑
 * 2.multi type : multipart/form-data 3.application type : json,xml �벑�벑
 * 
 * 留ㅺ컻蹂��닔 �꽕�젙 : meminsert( @RequestParam(value="mvo", defaultValue="湲곕낯媛�")
 * String mvo ) meminsert(String mvo) �쐞�뿉 �몢媛쒓� 媛숈�留� request �냽�꽦�쓣 �뜑�슧
 * �긽�꽭�븯寃� �쟻�슜�븷 �닔 �엳�떎.
 * 
 * meminsert(@RequestBody MemberVO mvo) post諛⑹떇留� �옉�룞�븯怨� VO, JSON,XML �뜲�씠�꽣瑜�
 * 諛쏆쓣 寃쎌슦 �궗�슜
 * 
 * meminsert(@ModelAttribute MemberVO mvo) post諛⑹떇留� �옉�룞�븯怨� VO, JSON,XML
 * �뜲�씠�꽣瑜� 諛쏆쓣 寃쎌슦 �궗�슜
 * 
 * @ModelAttribute : http�슂泥��뿉 �뱾�뼱�엳�뒗 �냽�꽦媛믩뱾�쓣 memeberVO 媛앹껜�뿉 �옄�룞�쑝濡�
 *                 諛붿씤�뵫 @ModelAttribute([NAME]) �삎�깭濡� 遺숈씪 寃쎌슦 jwsp�뙆�씪�뿉�꽌
 *                 ${[NAME].property} 濡� model 媛앹껜 媛믪쓣 �궗�슜媛��뒫
 * 
 * 
 *                 �궇吏� : 20200807 �옉�꽦�옄 : 源�二쇳샇
 */
@Controller
public class MemberController {
	Logger log = Logger.getLogger(MemberController.class);

	/*
	 * �쓽議댁꽦 二쇱엯�떆耳� �씠 �겢�옒�뒪�뿉�꽌 �씤�뒪�꽩�뒪 �븯吏� �븡怨� �궗�슜媛��뒫 �븯寃� �븳�떎.(default濡�
	 * �떛湲��넠�궗�슜)
	 */
	@Autowired
	private MemberService memberservice;

	/*
	 * �쇅遺��뿉�꽌 "meminsertform"�씠�씪�뒗 url�씠 �뱾�뼱�삤硫� �씠 而⑦듃濡ㅻ윭媛� 諛쏆븘�꽌 泥섎━�븳�떎.
	 * value媛믪쓣 "/meminsertform" �씠�젃寃� �빐�룄 �옉�룞�맂�떎. �럹�씠吏�留� �씠�룞�븯湲� �븣臾몄뿉
	 * GET諛⑹떇�쓣 �쟻�슜�빐 蹂댁븯�떎.
	 */

	@RequestMapping(value = "meminsertform", method = RequestMethod.GET)
	public ModelAndView memInsertForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("meminsert/meminsertform");
		log.info(mav);
		return mav;
	}

	/*
	 * �븘�씠�뵒 以묐났 泥댄겕 ajax�뿉�꽌 �씠�슜�븯怨� �븘�옒�뿉 �쉶�썝媛��엯�뿉�꽌�룄 �씠�슜�븳�떎.
	 * 
	 * @RequestBody, @ResponseBody(�씠 硫붿꽌�뱶�쓽 由ы꽩媛믪쓣 http諛붾뵒�뿉 �떞�븘 蹂대궦�떎.) �쐞�뿉 �몢
	 * �뼱�끂�뀒�씠�뀡�쓣 �씠�슜�븯硫� json�뜲�씠�꽣瑜� 二쇨퀬 諛쏆쓣 �닔 �엳�떎.
	 * 
	 * @RequestBody�뒗 controller�뿉 �뱾�뼱�삤�뒗 json�뜲�씠�꽣瑜� �꽕�젙�븳 媛앹껜�굹,map�뿉
	 * 留ㅽ븨�빐以��떎.(json�뜲�씠�꽣�� 媛앹껜�쓽 �봽濡쒗띁�떚媛� �룞�씪�빐�빞�븳�떎. POST諛⑹떇留� �옉�룞)
	 */
	@ResponseBody
	@RequestMapping(value = "/idchk", method = RequestMethod.POST)
	public String idchk(MemberVO memberVO) {
		int result = memberservice.idchk(memberVO);
		Integer.toString(result);
		String result2;
		result2 = result + "";
		return result2;
	}

	// �쉶�썝媛��엯form�럹�씠吏��뿉�꽌 �엯�젰諛쏆� 媛믪쓣 DB�뿉 ���옣 �썑 �셿猷뚰럹�씠吏�濡� �씠�룞
	@RequestMapping(value = "/meminsert", method = RequestMethod.POST)
	public ModelAndView memInsert(@ModelAttribute MemberVO mvo, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		/*
		 * request濡� 諛쏆븘�꽌 �떎�떆 �꽭�똿�븯�뒗 �씠�쑀�뒗 mvo媛앹껜�뿉 湲곕낯�쑝濡� �꽭�똿�릺�뼱 �엳�뒗 媛믪씠
		 * �엯�젰�뤌怨� 李⑥씠媛� �엳湲� �븣臾몄뿉 �뵲濡� 諛쏆븘�꽌 �뀑�똿�쓣 �븯���떎.
		 */
		String mphone0 = request.getParameter("mphone0");
		String mphone1 = request.getParameter("mphone1");
		String mphone2 = request.getParameter("mphone2");
		String mphone = mphone0 + "-" + mphone1 + "-" + mphone2;
		mvo.setMphone(mphone);
		String memail0 = request.getParameter("memail0");
		String memail1 = request.getParameter("memail1");
		String memail = memail0 + "@" + memail1;
		mvo.setMemail(memail);
		try {
			//위에서 만든 id 체크 컨트롤러 한번 사용
			//서버에서 한번 더 ID중복체크를 실행한다.
			int idchkResult;
			idchkResult = memberservice.idchk(mvo);
			if (idchkResult >= 1) {
//				Object obj = request.getAttribute("result");
//				String result = (String)obj;
				mav.addObject("result", "아이디 중복입니다.");
				mav.setViewName("meminsert/meminsertform");
				return mav;
			} else {
				//여기서 실질적인 멤버인서트가 일어난다.
				int result;
				result = memberservice.memInsert(mvo);

				mav.addObject("mvo0", mvo);
				mav.addObject("result", result);
				/**
				 * 硫붿씪 �쟾�넚 �궗�슜 �궡媛� 留뚮뱺 硫붿꽌�뱶�씪�꽌 留ㅺ컻蹂��닔 3媛�吏�瑜� 諛쏄쾶 留뚮뱾�뿀�떎. 1.諛쏅뒗 �궗�엺硫붿씪
				 * 二쇱냼 , 2. 硫붿씪�젣紐�, 3. 硫붿씪 �궡�슜
				 **/
				String toUser;
				String sendSubject;
				String sendText;
				toUser = mvo.getMemail();
				sendSubject = "사자판다 가입 확인";
				sendText = mvo.getMname() + " 님 안녕하세요. " + " \n " + " 가입정보는 다음과 같습니다. \n " + "아이디 : "
						+ mvo.getMid() + "  \n 비밀번호 : " + mvo.getMpw() + "\n " + "이메일 : " + mvo.getMemail();
				mailsend(toUser, sendSubject, sendText);

				mav.setViewName("login/loginform");
			}
		} catch (Exception e) {
		}
		log.info(mav);
		return mav;// �쉶�썝媛��엯 �떎�뻾�씠 �셿猷뚮릺硫� 濡쒓렇�씤 �럹�씠吏�濡� 蹂대궡�빞 �븳�떎. (誘멸뎄�쁽)
	}

	// 濡쒓렇�씤 form�럹�씠吏�濡� �씠�룞�븯湲� �쐞�븳 而⑦듃濡ㅻ윭
	@RequestMapping("loginform")
	public ModelAndView memloginform() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/login/loginform");
		return mav;
	}

	// 濡쒓렇�씤form�럹�씠吏��뿉�꽌 �엯�젰諛쏆븘 濡쒓렇�씤�떎�뻾�븯�뒗 而⑦듃濡ㅻ윭
	@RequestMapping(value = "/loginOK", method = RequestMethod.POST)
	public ModelAndView memloginOK(@ModelAttribute MemberVO mvo, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		try {
			MemberVO resultVO = memberservice.memLogin(mvo);
			/**
			 * 메일 전송 사용
			 * 내가 만든 메서드라서 매개변수 3가지를 받게 만들었다.
			 * 1.받는 사람메일 주소 , 2. 메일제목, 3. 메일 내용
			 **/ 
			if (resultVO.getMid() != "" || resultVO.getMid() != null) {

				HttpSession session = request.getSession();
				session.setAttribute("mnum", resultVO.getMnum());
				session.setAttribute("mid", resultVO.getMid());
				session.setMaxInactiveInterval(-1);// �꽭�뀡 臾댄븳��
//濡쒓렇�씤 			
				if (resultVO.getMnum().equals("M202106050001")) {
					mav.addObject("memberVO", resultVO);
					mav.setViewName("/admin/adminform");
				} else {
					mav.addObject("memberVO", resultVO);
					mav.setViewName("/login/loginOK");
				}
			} else {
				mav.setViewName("/login/loginX");
			}
		} catch (Exception e) {
			mav.setViewName("/login/loginX");
			return mav;
		}
		return mav;
	}

	// 濡쒓렇�븘�썐 留뚮뱾湲�
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView memlogOut(@ModelAttribute MemberVO mvo, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		/**
		 * �꽭�뀡�쓣 �깮�꽦�븯怨� �꽭�뀡�뿉 媛믪쓣 遺��뿬 �꽭�뀡 �꽕�젙�� �넱耳� server�뿉 web.xml�뿉
		 * <session-config>�뿉�꽌 �븳�떎. 湲곕낯 �꽕�젙媛믪� 30遺꾩쑝濡� �릺�뼱 �엳�떎. HttpServletRequest
		 * request 瑜� 留ㅺ컻蹂��닔濡� 諛쏆븘�꽌 �꽭�뀡�쓣 諛쏆븘�빞 �븳�떎. session.invalidate() �뒗 �꽭�뀡�쓣
		 * 紐⑤몢 �궘�젣 �븳�떎,
		 */
		session.invalidate();
		mav.setViewName("/login/loginform");
		return mav;
	}

	// id李얘린 �럹�씠吏�濡� 蹂대궡湲�
	@RequestMapping(value = "idfind", method = RequestMethod.GET)
	public ModelAndView memidfind(@ModelAttribute MemberVO mvo) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/idfind/idfind");
		return mav;
	}

	// id李얘린 �럹�씠吏��뿉�꽌 �븘�씠�뵒李얘린 �썑 �셿猷뚰럹�씠吏�濡� 蹂대궡湲�
	@RequestMapping(value = "/idfindOK", method = RequestMethod.POST)
	public ModelAndView memidfindOK(@ModelAttribute MemberVO mvo, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String memail = request.getParameter("memail");
		String mnum = request.getParameter("mnum");
		MemberVO mvo0 = new MemberVO();
		mvo0.setMemail(memail);
		mvo0.setMnum(mnum);
		try {
			MemberVO result = memberservice.memIdfind(mvo0);
			if (result.getMid() != null && result.getMid() != "") {
				mav.addObject("result", result);
				mav.setViewName("/idfind/idfindOK");
				/**
				 * 硫붿씪 �쟾�넚 �궗�슜 �궡媛� 留뚮뱺 硫붿꽌�뱶�씪�꽌 留ㅺ컻蹂��닔 3媛�吏�瑜� 諛쏄쾶 留뚮뱾�뿀�떎. 1.諛쏅뒗 �궗�엺硫붿씪
				 * 二쇱냼 , 2. 硫붿씪�젣紐�, 3. 硫붿씪 �궡�슜
				 **/
				String toUser;
				String sendSubject;
				String sendText;
				toUser = result.getMemail();
				sendSubject = "�궗�옄�뙋�떎 �쉶�썝 �븘�씠�뵒 李얘린";
				sendText = "�븞�뀞�븯�꽭�슂. " + result.getMname() + " �떂  �쉶�썝�떂�쓽 �븘�씠�뵒�뒗 " + result.getMid()
						+ " �엯�땲�떎.";
				mailsend(toUser, sendSubject, sendText);
				return mav;
			} else {
				mav.setViewName("/idfind/idfindx");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/idfind/idfindx");
			return mav;
		}
		return mav;
	}

	// 鍮꾨�踰덊샇 李얘린 �럹�씠吏�濡� �씠�룞
	@RequestMapping(value = "/pwfind.spw", method = RequestMethod.GET)
	public ModelAndView mempwfind(@ModelAttribute MemberVO mvo, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/pwfind/pwfind");
		return mav;
	}

	// 鍮꾨�踰덊샇 李얘린 �럹�씠吏��뿉�꽌 �엯�젰 �썑 �셿猷뚰럹�씠吏�濡� �씠�룞.
	@RequestMapping(value = "/pwfindOK.spw", method = RequestMethod.POST)
	public ModelAndView mempwfindOK(@ModelAttribute MemberVO mvo, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		try {
			MemberVO resultVO = memberservice.memPwfind(mvo);
			if (resultVO.getMpw() != null && resultVO.getMpw() != "") {
				/**
				 * 硫붿씪 �쟾�넚 �궗�슜 �궡媛� 留뚮뱺 硫붿꽌�뱶�씪�꽌 留ㅺ컻蹂��닔 3媛�吏�瑜� 諛쏄쾶 留뚮뱾�뿀�떎. 1.諛쏅뒗 �궗�엺硫붿씪
				 * 二쇱냼 , 2. 硫붿씪�젣紐�, 3. 硫붿씪 �궡�슜
				 **/
				String toUser;
				String sendSubject;
				String sendText;
				toUser = resultVO.getMemail();
				sendSubject = "�궗�옄�뙋�떎  �쉶�썝 鍮꾨�踰덊샇 李얘린";
				sendText = "�븞�뀞�븯�꽭�슂.\n " + resultVO.getMname() + " �떂 " + "�쉶�썝�떂�쓽 id : " + resultVO.getMname()
						+ "\n �쉶�썝�떂�쓽 鍮꾨�踰덊샇 : " + resultVO.getMpw();
				mailsend(toUser, sendSubject, sendText);
				mav.addObject("memberVO", resultVO);
				mav.setViewName("/pwfind/pwfindOK");
				return mav;
			} else {
				mav.setViewName("/pwfind/pwfindx");
			}
		} catch (Exception e) {
			mav.setViewName("/pwfind/pwfindx");
			return mav;
		}
		return mav;
	}

	/*
	 * �옄諛붾찓�씪 �쟾�넚 李멸퀬 �궗�씠�듃 二쇱냼 �씪�씠釉뚮윭由� https://9aram.tistory.com/28 �궗�슜踰�
	 * https://ktko.tistory.com/entry/JAVA-SMTP%EC%99%80-Mail-%EB%B0%9C%EC%86%A1%ED%
	 * 95%98%EA%B8%B0Google-Naver
	 */
	public void mailsend(String toUser, String sendSubject, String sendText) {
		String user = "com.sajapanda@gmail.com";
		String password = "wkd928657*";
		// SMTP �꽌踰� �젙蹂대�� �꽕�젙�븳�떎.
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
//		蹂대궡�뒗 �궗�엺�씠 gmail �궗�슜�떆 �룷�듃
		prop.put("mail.smtp.port", 465);
//		蹂대궡�뒗 �궗�엺�씠 naver硫붿씪 �궗�슜�떆 �룷�듃
//		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		// mail �씪�씠釉뚮윭由ъ쓽 媛앹껜 硫붿꽌�뱶 �궗�슜
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			// �닔�떊�옄 硫붿씪 二쇱냼
			// message.addRecipient(Message.RecipientType.TO, new
			// InternetAddress("rlaj005@naver.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toUser));
			message.setSubject(sendSubject);
			message.setText(sendText);
			Transport.send(message);// 硫붿씪 �쟾�넚
			log.info(message + "硫붿씪 �쟾�넚�셿猷�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end of mailsend()

//---------------�꽕�씠踰� 濡쒓렇�씤�쓣 �쐞�븳 ----------------------------------
	/*
	 * �꽕紐� : �꽕�씠踰� 濡쒓렇�씤 API
	 * 
	 * 二쇱슂�궗�슜湲곗닠: json-simple�씪�씠釉뚮윭由� �옉�꽦 踰�
	 * https://developers.naver.com/docs/login/api/ �뿉�꽌 JSP�냼�뒪 1. naverlogin.jsp
	 * �뒗 濡쒓렇�씤 �솕硫댁뿉 遺숈뿬�꽔湲� 2. callback.jsp �뿉�꽌 2踰덉㎏ 200踰� �긽�깭瑜� �솗�씤�븯�뒗
	 * if臾몄뿉�꽌 json-simple�씪�씠釉뚮윭由щ�� �솢�슜�빐�꽌 access_token 媛믪쓣 戮묒븘 �삩�떎. 洹� 媛믪쓣
	 * request�뿉 �떞�븘 蹂대궦�떎. https://developers.naver.com/docs/login/profile/ �뿉�꽌
	 * JAVA�냼�뒪 3. api�뿉�꽌 �썝�븯�뒗 媛믪쓣 紐⑤몢 �꽔怨� main�뿉 �쟻�엺 �냼�뒪瑜� �솢�슜�븳�떎.
	 * 
	 * 
	 * 二쇱쓽 �빐�빞 �븷嫄� �뿬湲곗꽌 �솢�슜�맂寃껋쓣 諛뷀깢�쑝濡� �넻�떊 �꽦怨듭쓣 �븯硫� String ���엯�쑝濡� 媛믪씠
	 * �꽆�뼱�삤�뒗�뜲. �뿬湲곗꽌 �떎�떆 json-simple�씪�씠釉뚮윭由щ�� �솢�슜�빐�꽌 媛믪쓣 戮묒븘�삩�떎. 洹몃━怨�
	 * DB媛믪쓣 議고쉶瑜� 癒쇱� �빐�꽌 媛믪씠 �엳�떎硫� �꽭�뀡留� 遺��뿬�븯怨� �꽆湲곌퀬 媛믪씠 �뾾�떎硫�
	 * �쉶�썝媛��엯�쓣�븯怨� �꽭�뀡�쓣 遺��뿬�븯怨� �꽆湲대떎.
	 * 
	 * �옉�꽦�씪: 20200820 �옉�꽦�옄: 源�二쇳샇
	 */
	@RequestMapping("/naverlogin")
	public ModelAndView naverlogin(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		// �뿬湲곗꽌 遺��꽣 �븘�옒 responseBody 源뚯��뒗 �궡媛� �븯�뒗寃� �븘�땲�씪 api�쓽 臾몄꽌瑜� 洹몃�濡� �솢�슜
		String access_token = (String) request.getAttribute("access_token");
		System.out.println("access_token:::" + access_token);
		String token = access_token; // �꽕�씠踰� 濡쒓렇�씤 �젒洹� �넗�겙;
		String header = "Bearer " + token; // Bearer �떎�쓬�뿉 怨듬갚 異붽�
		String apiURL = "https://openapi.naver.com/v1/nid/me";
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Authorization", header);
		String responseBody = get(apiURL, requestHeaders);
		System.out.println(responseBody);

		// {"resultcode":"00","message":"success","response":{"id":"21746765","age":"30-39","email":"rlaj005@naver.com","name":"\uae40\uc8fc\ud638","birthday":"10-09"}}
		// �쐞�뿉 媛믪쓣 肄섏넄濡� 李띿뼱蹂몃떎. name 媛믪씠 �쑀�땲肄붾뱶�씤�뜲 釉뚮씪�슦���뿉�꽌 �옄�룞�쑝濡� 蹂��솚�빐�꽌
		// �씫怨� json simple �씪�씠釉뚮윭由ш� 蹂��솚�빐以��떎.
		JSONObject jobj = new JSONObject();
		JSONParser parser = new JSONParser();
		MemberVO mvo = new MemberVO();
		try {
			jobj = (JSONObject) parser.parse(responseBody);
			String resultcode = (String) jobj.get("resultcode");
			String message = (String) jobj.get("message");
			jobj = (JSONObject) jobj.get("response"); // �뿬湲곗꽌 response媛� json媛앹껜 �븞�뿉 json媛앹껜�씠湲� �븣臾몄뿉
			String id = (String) jobj.get("id");
			String age = (String) jobj.get("age");
			String email = (String) jobj.get("email");
			String name = (String) jobj.get("name");
			String birthday = (String) jobj.get("birthday");

			if (resultcode.equals("00") && message.equals("success")) {
				// �넻�떊�쓣 �꽦怨듭쟻�쑝濡� 諛쏆븯�떎硫�
				mvo.setMid(id);
				mvo.setMname(name);
				mvo.setMemail(email);
				MemberVO nsVO;
				nsVO = memberservice.naverSelect(mvo);
				if (nsVO != null) {
					String mnum = nsVO.getMnum();
					HttpSession session = request.getSession();
					session.setAttribute("mnum", mnum);
					session.setMaxInactiveInterval(-1);// �꽭�뀡 臾댄븳��
				} else {
					int INresult = memberservice.naverInsert(mvo);

					if (INresult > 0) {
						System.out.println("�쉶�썝媛��엯�셿猷�");
						MemberVO resultVO;
						resultVO = memberservice.naverLogin(mvo);
						String mnum = resultVO.getMnum();
						HttpSession session = request.getSession();
						session.setAttribute("mnum", mnum);
						session.setMaxInactiveInterval(-1);// �꽭�뀡 臾댄븳��
					} else {
						System.out.println("insert媛� �떎�뻾�릺吏� �븡�븯�뒿�땲�떎.");
					} // end of if(insert result)
				} // end of if(naverSelect mnum)
			} else {
				System.out.println("�꽕�씠踰� API�뿉�꽌 媛믪쓣 諛쏆븘�삤吏� 紐삵뻽�뒿�땲�떎.");
			} // end of if(resultcode,massage)
		} catch (ParseException e) {
			System.out.println("json 媛앹껜 蹂��솚�떎�뙣");
			e.printStackTrace();
		} // end of try catch
		mav.setViewName("/login/loginOK");
		return mav;
	}// end of naverlogin controller

	@RequestMapping(value = "/callback")
	public static ModelAndView callbackPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login/callback");
		return mav;
	}

	public static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}
			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // �젙�긽 �샇異�
				return readBody(con.getInputStream());
			} else { // �뿉�윭 諛쒖깮
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API �슂泥�怨� �쓳�떟 �떎�뙣", e);
		} finally {
			con.disconnect();
		}
	}

	public static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL�씠 �옒紐삳릺�뿀�뒿�땲�떎. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("�뿰寃곗씠 �떎�뙣�뻽�뒿�땲�떎. : " + apiUrl, e);
		}
	}

	public static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);
		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();
			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}
			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API �쓳�떟�쓣 �씫�뒗�뜲 �떎�뙣�뻽�뒿�땲�떎.", e);
		}
	}

}
