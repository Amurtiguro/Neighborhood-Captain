package com.spw.bid.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spw.bid.service.BidService;
import com.spw.bid.vo.BidVO;

@Controller
public class BidController {
	private Logger log=Logger.getLogger(BidController.class);
	@Autowired
	private BidService bidservice;
	
	/**
	 * 설명
	 * : 경매 입찰시 입찰 테이블에 입찰 정보 저장
	 * 매개변수 : bivo
	 * 반환값 : String  
	 * 날짜 : 2020/08/10
	 * 작성자 : 조하영
	 */
	@ResponseBody
	@RequestMapping("/bidInsert")
	public String bidInsert(@ModelAttribute BidVO bivo) {
		log.info("BidController bidInsert start >>> ");
		
		log.info("data test 입찰가격 >>> "+bivo.getBprice());
		log.info("data test 경매번호 >>> "+bivo.getAnum());
		log.info("data test 회원번호 >>> "+bivo.getMnum());
		
		String bwinyn="N";
		bivo.setBwinyn(bwinyn);
		
		int res=bidservice.bidInsert(bivo);
		
		String resStr="";
		
		if(res>0) {
			resStr="bid insert success!";
		}else {
			resStr="bid insert fail!";
		}
		log.info(resStr);
		
		return resStr;
	}
}
