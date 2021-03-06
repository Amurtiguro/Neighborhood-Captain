package com.spw.general.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spw.general.vo.GeneralCountVO;
import com.spw.general.vo.GeneralVO;
import com.spw.reg.vo.RegVO;

public class GeneralDaoImpl implements GeneralDao {
	private static Logger log = Logger.getLogger(GeneralDaoImpl.class);
	
	@Autowired(required = false)
	private SqlSessionTemplate sqlSession;
	
	// �쟾泥� 湲� 紐⑸줉 : generalAllList ==========================
	@Override
	public List<GeneralVO> generalAllList(GeneralVO gvo) {
		log.info("GeneralDaoImpl.generalAllList �떆�옉 >>");
		
		List<GeneralVO> aList = sqlSession.selectList("generalAllList");
		log.info("GeneralDaoImpl.generalAllList : aList >>" + aList);
		
		log.info("GeneralDaoImpl.generalAllList �걹 >>");
		return aList;
	}
	// �궗�옄 湲� 紐⑸줉 : generalSList ==========================
	@Override
	public List<GeneralVO> generalSList(GeneralVO gvo) {
		log.info("GeneralDaoImpl.generalSList �떆�옉 >>");
		
		List<GeneralVO> sList = sqlSession.selectList("generalSList");
		
		log.info("GeneralDaoImpl.generalSList �걹 >>");
		return sList;
	}

	// �뙋�떎 湲� 紐⑸줉 : generalPList ==========================
	@Override
	public List<GeneralVO> generalPList(GeneralVO gvo) {
		log.info("GeneralDaoImpl.generalPList �떆�옉 >>");
		
		List<GeneralVO> pList = sqlSession.selectList("generalPList");
		
		log.info("GeneralDaoImpl.generalPList �걹 >>");
		return pList;
	}

	// 湲� �긽�꽭 : generalSelect ========================
	@Override
	public GeneralVO generalSelect(GeneralVO gvo) {
		log.info("GeneralDaoImpl.generalSelect �떆�옉 >>");
		
		GeneralVO select = sqlSession.selectOne("generalSelect");
		log.info("GeneralDaoImpl.generalSelect : select >>" + select);
		
		log.info("GeneralDaoImpl.generalSelect �걹 >>");
		return select;
	}

	// 湲� �엯�젰 : generalInsert ========================
	@Override
	public int generalInsert(GeneralVO gvo) {
		log.info("GeneralDaoImpl.generalInsert �떆�옉 >>");
		
		int insert = sqlSession.insert("generalInsert");
		log.info("GeneralDaoImpl.generalSelect : insert >>" + insert);
		
		log.info("GeneralDaoImpl.generalInsert �걹 >>");
		return insert;
	}

	// 湲� �닔�젙 : generalUpdate ========================
	@Override
	public int generalUpdate(GeneralVO gvo) {
		log.info("GeneralDaoImpl.generalUpdate �떆�옉 >>");
		
		int update = sqlSession.update("generalUpdate");
		log.info("GeneralDaoImpl.generalSelect : update >>" + update);
		
		log.info("GeneralDaoImpl.generalUpdate �걹 >>");
		return update;
	}

	// 湲� �궘�젣 : generalDelete ========================
	@Override
	public int generalDelete(GeneralVO gvo) {
		log.info("GeneralDaoImpl.generalDelete �떆�옉 >>");
		
		int delete = sqlSession.delete("generalDelete");
		log.info("GeneralDaoImpl.generalSelect : delete >>" + delete);
		
		log.info("GeneralDaoImpl.generalDelete �떆�옉 >>");
		return delete;
	}
	
	private static String PACKAGE_PATH = "com.spw.general.dao.GeneralDao.";

	/**
	 * �꽕紐�
	 * : 踰뺤젙�룞 肄붾뱶濡� �룞�꽕蹂� �긽�뭹紐⑸줉 議고쉶
	 * 留ㅺ컻蹂��닔 : GeneralVO gvo - �럹�씠吏� 踰덊샇, 洹몃９ �궗�씠利�, �럹�씠吏� �궗�씠利�, 踰뺤젙�룞 肄붾뱶
	 * 諛섑솚媛� : List<GeneralVO> - �긽�뭹紐⑸줉
	 * �궇吏� : 2020/08/13
	 * �옉�꽦�옄 : 理쒖젙洹�
	 */
	public List<GeneralVO> generalSelectLocal(GeneralVO gvo){
		log.info("[ generalSelectLocal() �떆�옉 ] gvo => " + gvo);

		List<GeneralVO> list = sqlSession.selectList("generalSelectLocal");

		log.info("[ generalSelectLocal() 醫낅즺 ] list => " + list);
		return list;
	}

	/**
	 * �꽕紐�
	 * : 踰뺤젙�룞 肄붾뱶濡� �떆援곌뎄�쓽 �룞�꽕蹂� �긽�뭹媛쒖닔 議고쉶
	 * 留ㅺ컻蹂��닔 : RegVO rvo - 踰뺤젙�룞 肄붾뱶
	 * 諛섑솚媛� : List<GeneralCountVO> - �룞�꽕蹂� �긽�뭹媛쒖닔
	 * �궇吏� : 2020/08/13
	 * �옉�꽦�옄 : 理쒖젙洹�
	 */
	public List<GeneralCountVO> generalSelectCount(RegVO rvo){
		log.info("[ generalSelectCount() �떆�옉 ] rvo => " + rvo);

		List<GeneralCountVO> list = sqlSession.selectList("generalSelectCount");

		log.info("[ generalSelectCount() 醫낅즺 ] list => " + list);
		return list;
	}
}
