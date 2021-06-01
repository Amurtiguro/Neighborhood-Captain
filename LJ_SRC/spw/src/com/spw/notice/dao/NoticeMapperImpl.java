package com.spw.notice.dao;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.spw.bid.vo.BidVO;
import com.spw.notice.vo.NoticeVO;

public class NoticeMapperImpl extends SqlSessionDaoSupport implements NoticeMapper {

	@Override
	public int notiInsertAuct(NoticeVO novo) {;
		// TODO Auto-generated method stub
		return getSqlSession().insert("notiInsertA");
	}


	// 알림 추가. ================================
	@Override
	public int noticeInsert(NoticeVO nvo) {
		// TODO Auto-generated method stub
		return (int)getSqlSession().insert("noticeInsert");
	}
}
