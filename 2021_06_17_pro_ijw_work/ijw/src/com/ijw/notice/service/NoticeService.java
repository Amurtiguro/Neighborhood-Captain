package com.ijw.notice.service;

import com.ijw.bid.vo.BidVO;
import com.ijw.notice.vo.NoticeVO;

public interface NoticeService {
	//경매 종료시 알림 
	public int notiInsertAuct(NoticeVO novo);
	
	// 알림 추가. ================================
	public int noticeInsert(NoticeVO nvo);
}
