package org.database.domain;

public class PuzzleVO {
	private String ko;
	private String en;
	
	public String getKo() {
		return ko;
	}

	public void setKo(String ko) {
		this.ko = ko;
	}

	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}

	@Override
	public String toString() {
		return "PuzzleVO [ko=" + ko + ", en=" + en + "]";
	}
}
