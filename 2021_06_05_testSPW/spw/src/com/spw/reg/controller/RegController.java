package com.spw.reg.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spw.common.CommonUtil;
import com.spw.reg.service.RegService;
import com.spw.reg.vo.RegVO;

/**
 * Ŭ���� RegController
 * ����
 * : �������ڵ����� ���� ��Ʈ�ѷ�
 * ��¥ : 2020/07/31
 * �ۼ��� : ������
 */
@Controller
@RequestMapping("/reg")
public class RegController {
	private static Logger log = Logger.getLogger(RegController.class);

	// ����
	@Autowired
	RegService regService;

	/**
	 * ����
	 * : '��/��', '��/��/��', '��/��/��', '��' �������ڵ����� JSON���� ��ȯ
	 * �Ű����� : RegVO - �������ڵ��Է�, String mode - ��� ����(���Է½� ��/��)
	 * 		'��/��'    : ��� -  CP,  ������ �ڵ� - ������� ����
	 * 		'��/��/��' : ��� - CCD, �� ������ �ڵ� - �� ���ڸ��� ���
	 * 		'��/��/��' : ��� - TTN, �� ������ �ڵ� - �� �ټ��ڸ��� ���
	 * 		'��'       : ��� -   V, ������ �ڵ� - �� �����ڸ��� ���
	 * ��ȯ�� : ResponseEntity (JSON ��ü�� ���� ���, Content-Type�� ���ڵ� ����)
	 * ��¥ : 2020/08/05
	 * �ۼ��� : ������
	 */
	// JSON ��ü : {"regData" : [{"regcode": "������ �ڵ�", "regname": "������ �̸�"}, ...]}
	@RequestMapping("/regList")
	public ResponseEntity<String> regList(@ModelAttribute RegVO rvo
										,@RequestParam(value = "mode", required = false) String mode){
		log.info("[ regList ���� ] rvo => " + rvo);
		log.info("[i] mode             => " + mode);

		// ������ �ڵ�
		String regcode = null;
		if(rvo != null) {
			regcode = rvo.getRegcode();
			log.info("[i] regcode          => " + regcode);
		}

		// ��� (�⺻�� "CP" - ��/��)
		String regMode = "CP";

		// ��� ����
		// ��庯���� ���� ������ ����(������ ��/�� ����)
		// ��忡 ���� �־ �������ڵ尡 ������ ��/�� ����
		if(mode !=null && mode.length() > 0
				&& regcode != null && regcode.length() > 0) {
			regMode = mode.toUpperCase();
		}

		log.info("[i] regMode          => " + regMode);

		// DB���� ������ ��� ��������
		List<RegVO> regList = null;

		// ��/��
		if("CP".equals(regMode)) {
			regList = regService.regListCitPro();
		}

		// ��/��/��
		if("CCD".equals(regMode)) {
			regList = regService.regListCiCoDi(rvo);
		}

		// ��/��/��
		if("TTN".equals(regMode)) {
			regList = regService.regListToToNe(rvo);
		}

		// ��
		if("V".equals(regMode)) {
			regList = regService.regListVillage(rvo);
		}
		
		log.info("[i] regList => " + regList);

		// JSON��ü�� �����
		JSONObject resultData = new JSONObject();

		// JSON ������ : regData (������ ���)
		JSONArray regData = new JSONArray();

		if(regList != null) {
			log.info("[i] regList size => " + regList.size());

			for(int i = 0; i < regList.size(); i++) {
				RegVO regVO = regList.get(i);

				JSONObject regRowData = new JSONObject();

				regRowData.put("regcode", regVO.getRegcode());
				
				regRowData.put("regname", regVO.getRegname());

				log.info("[i] regRowData => " + regRowData);
				regData.add(regRowData);
			}
		}

		resultData.put("regData", regData);

		// JSON��ü�� Ŭ���̾�Ʈ���� ���

		ResponseEntity<String> resEntity = CommonUtil.responseJSON(resultData.toJSONString());

		log.info("[ regList ���� ] resEntity => " + resEntity);
		return resEntity;
	}

}
