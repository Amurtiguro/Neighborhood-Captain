package com.spw.auction.dao;

import java.util.List;

import com.spw.auction.vo.AuctionVO;
import com.spw.bid.vo.BidVO;

public interface AuctionMapper {
	
	//��Ż�ǰ ���
	public int auctionInsert(AuctionVO auvo); 
	
	//��Ż�ǰ ��� 
	public List<AuctionVO> auctionList(AuctionVO auvo);
	
	//��Ż�ǰ ����ȸ 
	public AuctionVO auctionViewDetail(AuctionVO auvo);

	//��Ż�ǰ �󼼺���
	public int auctionUpdate(AuctionVO auvo);
	
	//��Ż�ǰ ���� �󼼺��� 
	public AuctionVO auctionUpdateView(AuctionVO auvo);
	
	//��Ż�ǰ �󼼺��� ���� 
	public int auctionDelete(AuctionVO auvo);
	
	//��Ż�ǰ ����� ���� ���� 
	public int auctionUpdateEnd(AuctionVO auvo);

	//����� ��� select
	public List<AuctionVO> autoSelect();
}
