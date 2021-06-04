package com.spw.general.vo;

public class GeneralCountVO {
	private String regcode;
	private String saja;
	private String panda;

	// 생성자
	public GeneralCountVO() {
		
	}

	public GeneralCountVO(String regcode, String saja, String panda) {
		this.regcode = regcode;
		this.saja = saja;
		this.panda = panda;
	}

	// Getter / Setter
	public String getRegcode() {
		return regcode;
	}

	public void setRegcode(String regcode) {
		this.regcode = regcode;
	}

	public String getSaja() {
		return saja;
	}

	public void setSaja(String saja) {
		this.saja = saja;
	}

	public String getPanda() {
		return panda;
	}

	public void setPanda(String panda) {
		this.panda = panda;
	}
}
