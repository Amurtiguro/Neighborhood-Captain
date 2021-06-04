package com.spw.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spw.member.service.ChartService;
import com.spw.member.vo.ChartVO;

@Controller
public class ChartController {
	Logger log = Logger.getLogger(ChartController.class);
	@Autowired
	private ChartService chartService;
	
	//차트.jsp 로 보내는 컨트롤러
	@RequestMapping(value = "/chartboard",method = RequestMethod.GET)
	public ModelAndView chartboard(@ModelAttribute ChartVO chartVO) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/chart/chart");
		return mav;
	}
	
	//원래는 @responsebody 어노테이션을 썻는데 한글이 깨진다.그래서 아래와 같이 사용한다.
	@RequestMapping(value = "/cntAllData",method = RequestMethod.POST)
	public ResponseEntity<String> cntAllData(@ModelAttribute ChartVO chartVO) { 
		log.info(chartVO);
		log.info(chartVO.getSelectYear());
		log.info(chartVO.getCgNum());
		ChartVO cvo = chartService.cntAll(chartVO);
		//굳이 list에 담을 필요가 없다. 그냥 vo에 담아서 그걸 꺼내서 다시 list에 담으면 된다.
		int saja1=Integer.parseInt(cvo.getSaJaCount1());
		int panda1=Integer.parseInt(cvo.getPanDaCount1());
		int auct1 = Integer.parseInt(cvo.getAuctCount1());
		int total1= Integer.parseInt(cvo.getTotalCount1());
		
		int saja2=Integer.parseInt(cvo.getSaJaCount2());
		int panda2=Integer.parseInt(cvo.getPanDaCount2());
		int auct2 = Integer.parseInt(cvo.getAuctCount2());
		int total2= Integer.parseInt(cvo.getTotalCount2());
		
		int saja3=Integer.parseInt(cvo.getSaJaCount3());
		int panda3=Integer.parseInt(cvo.getPanDaCount3());
		int auct3 = Integer.parseInt(cvo.getAuctCount3());
		int total3= Integer.parseInt(cvo.getTotalCount3());

		int saja4=Integer.parseInt(cvo.getSaJaCount4());
		int panda4=Integer.parseInt(cvo.getPanDaCount4());
		int auct4 = Integer.parseInt(cvo.getAuctCount4());
		int total4= Integer.parseInt(cvo.getTotalCount4());
		
		JSONArray jsubject = new JSONArray();
		jsubject.add("분기별");
		jsubject.add("사자");
		jsubject.add("판다");
		jsubject.add("경매");
		jsubject.add("합계");
		
		JSONArray ja = new JSONArray();
		ja.add("1분기");
		ja.add(saja1);
		ja.add(panda1);
		ja.add(auct1);
		ja.add(total1);
		JSONArray ja2 =new JSONArray();
		
		ja2.add("2분기");
		ja2.add(saja2);
		ja2.add(panda2);
		ja2.add(auct2);
		ja2.add(total2);
		JSONArray ja3 =new JSONArray();
		ja3.add("3분기");
		ja3.add(saja3);
		ja3.add(panda3);
		ja3.add(auct3);
		ja3.add(total3);
		JSONArray ja4 =new JSONArray();
		ja4.add("4분기");
		ja4.add(saja4);
		ja4.add(panda4);
		ja4.add(auct4);
		ja4.add(total4);
		
		JSONArray jlist =new JSONArray();
		jlist.add(jsubject);
		jlist.add(ja);
		jlist.add(ja2);
		jlist.add(ja3);
		jlist.add(ja4);
		
		//기존에 return은  jlist.toJSONString(); 으로 return타입은 String으로 하고 @responsebody로 값을 보냈는데. 그럼 한글이 깨진다.
		//리턴 타입을 ResponseEntity로 하고 매개변수로 (바디문자열,headers,HttpStatus.OK)로 해서 response를 맵핑해서 추가해서 보낸다. 
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=UTF-8");
		return new ResponseEntity<String>(jlist.toJSONString(),headers,HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/cntSaja",method = RequestMethod.POST)
	public ModelAndView cntSaja(@ModelAttribute ChartVO chartVO,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
//html의 폼테그 내부의 input태그 값
		//이건 가지고 온다. 태그의 id를 가지고 오는지 name을 가지고 오는지는 모른다.
		String selectYear2 =request.getParameter("selectYear"); 
		//이건 안됨
		//String selectYear =(String) request.getAttribute("selectYear"); 
		
//자바스크립트에서 만든 값 불러 와보기 
		//아래 두개다 안된다.
		//String startDate = (String)request.getAttribute("startDate");
		//String startDate2 = request.getParameter("startDate");
		// 그래서 자바 스크립트에서 클릭이벤트 메서드 실행할때 document.createElement("input").setAttribute("startDate",startDate); 로 만들면서 값을 넘겨 주었다.
	
//mapper.xml은  뷰에서 cgNum 값을 받아  조건문을 사용하는데   당연히 null일 줄 알고 null조건만 걸었는데
//빈 문자열로 되어 있는 거 였다. 그래서 이상한 결과 값이 나온거 였다.
		mav.setViewName("/chart/chartSajaCount");
		return mav;
	}
	
	@RequestMapping(value = "/cntPanda",method = RequestMethod.POST)
	public ModelAndView cntPanda(@ModelAttribute ChartVO chartVO) {
		ModelAndView mav = new ModelAndView();
		ChartVO cvo=chartService.cntPanda(chartVO);
		mav.addObject("cvo", cvo);
		mav.setViewName("/chart/chartPandaCount");
		return mav;
	}
	@RequestMapping(value = "/cntAuct",method=RequestMethod.POST)
	public ModelAndView cntAuct(@ModelAttribute ChartVO chartVO) {
		ModelAndView mav = new ModelAndView();
		ChartVO cvo=chartService.cntAuct(chartVO);
		mav.addObject("cvo", cvo);
		mav.setViewName("/chart/chartAcutionCount");
		
		return mav;
	}
	
/*
	@RequestMapping
	@ResponseBody//이 어노테이션을 쓰면 response사용 가능
	public void chartData(HttpServletResponse response, @RequestParam(value = "memberNo") String memberNo) {
		
	}
	
*/
	
	
}
