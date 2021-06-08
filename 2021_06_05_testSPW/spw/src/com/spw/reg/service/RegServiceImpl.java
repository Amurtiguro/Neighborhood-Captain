package com.spw.reg.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spw.reg.dao.RegDao;
import com.spw.reg.vo.RegVO;

/**
 * 클래스 RegServiceImpl
 * 설명
 * : 법정동코드와 관련된 기능을 위한 서비스 클래스 ('RegService' 인터페이스의 구현체)
 * 날짜 : 2020/07/31
 * 작성자 : 최정규
 */
@Service
@Transactional
public class RegServiceImpl implements RegService{
	private static Logger log = Logger.getLogger(RegServiceImpl.class);

	@Autowired
	private RegDao regDao;

	// JSON 파싱
	private JSONParser parser = new JSONParser();

	/**
	 * 설명
	 * : '시/도' 법정동코드목록을 반환
	 * 매개변수 : 없음
	 * 반환값 : List (RegVO)
	 * 날짜 : 2020/07/31
	 * 작성자 : 최정규
	 */
	@Override
	public List<RegVO> regListCitPro() {
		log.info("[ regListCitPro ]");

		return regDao.regListCitPro();
	}

	/**
	 * 설명
	 * : '시/군/구' 법정동코드목록을 반환
	 * 매개변수 : RegVO - 법정동코드(앞 두자리만)입력
	 * 반환값 : List (RegVO)
	 * 날짜 : 2020/07/31
	 * 작성자 : 최정규
	 */
	@Override
	public List<RegVO> regListCiCoDi(RegVO rvo) {
		log.info("[ regListCiCoDi ]");

		return regDao.regListCiCoDi(rvo);
	}

	/**
	 * 설명
	 * : '읍/면/동' 법정동코드목록을 반환
	 * 매개변수 : RegVO - 법정동코드(앞 다섯자리만)입력
	 * 반환값 : List (RegVO)
	 * 날짜 : 2020/07/31
	 * 작성자 : 최정규
	 */
	@Override
	public List<RegVO> regListToToNe(RegVO rvo) {
		log.info("[ regListToToNe ]");

		return regDao.regListToToNe(rvo);
	}

	/**
	 * 설명
	 * : '리' 법정동코드목록을 반환
	 * 매개변수 : RegVO - 법정동코드(앞 여덟자리만)입력
	 * 반환값 : List (RegVO)
	 * 날짜 : 2020/07/31
	 * 작성자 : 최정규
	 */
	@Override
	public List<RegVO> regListVillage(RegVO rvo) {
		log.info("[ regListVillage ]");

		return regDao.regListVillage(rvo);
	}

	/**
	 * 설명
	 * : 선택한 법정동 코드의 정보를 반환
	 * 매개변수 : RegVO - 법정동코드입력
	 * 반환값 : List (RegVO)
	 * 날짜 : 2020/07/31
	 * 작성자 : 최정규
	 */
	@Override
	public List<RegVO> regListSelect(RegVO rvo) {
		log.info("[ regListFromCode ]");

		return regDao.regListSelect(rvo);
	}

	/**
	 * 설명
	 * : 국토 교통부의 오픈 API를통해 읍면동 영역정보를 JSON형식으로 가져오기
	 * 매개변수 : RegVO - 법정동이름입력
	 * 반환값 : JSONObject - API결과물을 그대로 반환
	 * 날짜 : 2020/08/04
	 * 작성자 : 최정규
	 * @throws Exception 
	 */
	@Override
	public JSONObject getRegArea(RegVO rvo) {
		log.info("[ getRegArea 시작 ]");

		String regName = null;

		if(rvo != null) {
			regName = rvo.getRegname();
		}
		log.info("[i] regName => " + regName);

		// 결과값(문자열)
		String resData = null;

		// 결과값
		JSONObject jsonData = null;

		try{
			String regNameEncode = URLEncoder.encode(regName, "UTF-8");
			log.info("[i] regNameEncode => " + regNameEncode);
	
			// URL
			StringBuffer urlBuffer = new StringBuffer();
			urlBuffer.append("https://api.vworld.kr/req/data?");
			urlBuffer.append("service=data&request=GetFeature&data=LT_C_ADEMD_INFO");
			urlBuffer.append("&key=8317E7B5-3605-3464-AE7B-4965270D3F35&domain=localhost:8088/spw");
			urlBuffer.append("&crs=EPSG:4326&size=1000&attrfilter=full_nm:like:");
			urlBuffer.append(regNameEncode);
	
			URL url = new URL(urlBuffer.toString());
	
			// HTTPS연결을 통해 API에서 영역정보 가져오기
			HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
	
			// 결과값을 저장하는곳
			StringBuilder result = new StringBuilder();
	
			// 응답을 읽어옴
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	
			// 읽어온 응답을 저장
			String line = null;
	
			while((line = in.readLine()) != null) {
				result.append(line);
			}
	
			in.close();
	
			resData = result.toString();
		}catch (Exception e) {
			log.info("[!] API오류! => " + e.getMessage());
		}

		try {
			if(resData != null && resData.length() > 0) {
				jsonData = (JSONObject)parser.parse(resData);
			}
		}catch(ParseException e) {
			log.info("[!] JSON 파싱 오류! => " + e.getMessage());
		}

		//JSON데이터가 너무 길어서 로그에 그대로 출력시 콘솔에 표시된 다른 로그를 지워버림
		//log.info("[ getRegArea 종료 ] jsonData => " + jsonData);
		log.info("[ getRegArea 종료 ] jsonData => " + (jsonData != null && jsonData.size() > 0));
		return jsonData;
	}
}
