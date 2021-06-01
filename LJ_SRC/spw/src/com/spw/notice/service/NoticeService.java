package com.spw.notice.service;

import com.spw.bid.vo.BidVO;
import com.spw.notice.vo.NoticeVO;

public interface NoticeService {
	//경매 종료시 알림 
	public int notiInsertAuct(NoticeVO novo);
	
	// 알림 추가. ================================
	public int noticeInsert(NoticeVO nvo);
}
