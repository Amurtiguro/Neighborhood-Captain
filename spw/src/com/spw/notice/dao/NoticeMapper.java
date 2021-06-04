package com.spw.notice.dao;

import com.spw.bid.vo.BidVO;
import com.spw.notice.vo.NoticeVO;

public interface NoticeMapper {

	//경매 종료 알림 
	public int notiInsertAuct(NoticeVO novo);
	
	// 알림 추가. ================================
	public int noticeInsert(NoticeVO nvo);
}
