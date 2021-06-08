package com.spw.auction.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spw.auction.dao.AuctionMapper;
import com.spw.auction.vo.AuctionVO;
import com.spw.bid.vo.BidVO;

@Service
@Transactional
public class AuctionServiceImpl implements AuctionService{
	private Logger log=Logger.getLogger(AuctionServiceImpl.class);

	@Autowired
	private AuctionMapper auctionmapper;

	
	@Override
	public int auctionInsert(AuctionVO auvo) {
		// TODO Auto-generated method stub
		log.info("AuctionServiceImpl auctionInsert start >>>  ");
		
		log.info("���� >>> : "+auvo.getAtitle());
		log.info("ī�װ� >>> : "+auvo.getCgnum());
		log.info("���� >>> : "+auvo.getAphoto());
		log.info("���۰� >>> : "+auvo.getApricemin());
		log.info("����ð� >>> : "+auvo.getAendtime());
		log.info("�ŷ����� >>> : "+auvo.getAloc());
		log.info("����>>> : "+auvo.getAcontents());
		
		int res=auctionmapper.auctionInsert(auvo);
		log.info("insert ���� ���� >>> "+res);
		
		return res;
	}

	//��Ż�ǰ ���
	@Override
	public List<AuctionVO> auctionList(AuctionVO auvo) {
		// TODO Auto-generated method stub
		log.info("AuctionServiceImpl auctionList start >>>  ");
		
		if(auvo.getPagesize()==null) {
			auvo.setPagesize("16");
		}
		if(auvo.getCurpage()==null) {
			auvo.setCurpage("1");
		}
		List<AuctionVO> alist=new ArrayList<AuctionVO>();
		alist=auctionmapper.auctionList(auvo);
		log.info("alist size >>> : "+alist.size());
		
		log.info("AuctionServiceImpl auctionList end >>>  ");
		return alist;
	}

	//��Ż�ǰ �󼼺���
	@Override
	public AuctionVO auctionViewDetail(AuctionVO auvo) {
		// TODO Auto-generated method stub
		log.info("AuctionServiceImpl auctionViewDetail start >>>  ");
		AuctionVO detailVO=auctionmapper.auctionViewDetail(auvo);
		return detailVO;
	}

	@Override
	public AuctionVO auctionUpdateView(AuctionVO auvo) {
		// TODO Auto-generated method stub
		log.info("AuctionServiceImpl auctionUpdateView start >>>  ");
		AuctionVO detailVO=auctionmapper.auctionUpdateView(auvo);
		return detailVO;
	}

	//��Ż�ǰ �󼼺��� ���� 
	@Override
	public int auctionUpdate(AuctionVO auvo) {
		// TODO Auto-generated method stub
		log.info("AuctionServiceImpl auctionUpdate start >>>  ");
		int res=auctionmapper.auctionUpdate(auvo);
		log.info("update res >>> " +res);
		return res;
	}

	//��Ż�ǰ �󼼺��� ���� 
	@Override
	public int auctionDelete(AuctionVO auvo) {
		// TODO Auto-generated method stub
		log.info("AuctionServiceImpl auctionDelete start >>>  ");
		log.info("auvo.getAnum() >>> "+auvo.getAnum());
		
		int res=auctionmapper.auctionDelete(auvo);
		log.info("delete res >>> " +res);
		
		return res;
	}

	@Override
	public int auctionUpdateEnd(AuctionVO auvo) {
		// TODO Auto-generated method stub
		log.info("AuctionServiceImpl auctionUpdateEnd start >>>  ");
		log.info("auvo.getAnum() >>> "+auvo.getAnum());
		
		int res=auctionmapper.auctionUpdateEnd(auvo);
		log.info("auctionUpdateEnd res >>> " +res);
		
		return res;
	}

	
	//��� ����� ��ǰ select 
	@Override
	public List<AuctionVO> autoSelect() {
		// TODO Auto-generated method stub
		log.info("BidServiceImpl autoSelect start >>> ");
		
		List<AuctionVO> listAuto=auctionmapper.autoSelect();
		log.info("service �������� ��ǰ ���� >>>> "+listAuto.size());
		
		return listAuto;
	}
	
}
