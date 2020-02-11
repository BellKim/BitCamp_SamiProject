package Dto;

import java.io.Serializable;

public class AsAppDto implements Serializable {
	/*
	 * as_index NUMBER(6) NOT NULL,
	 *  mem_id VARCHAR2(20) NULL,
	 *  wdate VARCHAR2(20)  NULL,
	 *  req_date VARCHAR2(20) NULL,
	 *  mrg_id VARCHAR2(50) NULL,
	 *  as_title VARCHAR2(200) NULL,
	 *  as_content VARCHAR2(4000) NULL,
	 *  as_img_path VARCHAR2(100) NULL,
	 *  model_name NUMBER NULL,
	 */
	
	private int asSeq;					//as인덱스
	private String memId;				//회원id
	private String wdate;				//작성일
	private String req_date;			//희망일
	private int mgr_index;				//매니저index
	private String asTitle;				//as신청 제목
	private String asContent;			//as신청 내용
	private String asImgPath;			//as신청 이미지첨부
	private int pur_index;				//렌탈 index
	private String model_name;			//모델명
	private String prd_name;			//제품명
	
	public AsAppDto() {
	}
	
	

	public AsAppDto(String memId, String req_date, String asTitle, String asContent, String asImgPath, int asSeq) {
		super();
		this.memId = memId;
		this.req_date = req_date;
		this.asTitle = asTitle;
		this.asContent = asContent;
		this.asImgPath = asImgPath;
		this.asSeq = asSeq;
	}



	public AsAppDto(String memId, String req_date, String asTitle, String asContent, String asImgPath, int pur_index, String prd_name) {
		super();
		this.memId = memId;
		this.req_date = req_date;
		this.asTitle = asTitle;
		this.asContent = asContent;
		this.asImgPath = asImgPath;
		this.pur_index = pur_index;
		this.prd_name = prd_name;

	}



	public AsAppDto(int asSeq, String memId, String wdate, String req_date, int mgr_index, String asTitle,
			String asContent, String asImgPath, int pur_index, String prd_name) {
		super();
		this.asSeq = asSeq;
		this.memId = memId;
		this.wdate = wdate;
		this.req_date = req_date;
		this.mgr_index = mgr_index;
		this.asTitle = asTitle;
		this.asContent = asContent;
		this.asImgPath = asImgPath;
		this.pur_index = pur_index;
		this.prd_name = prd_name;
	}



	public int getAsSeq() {
		return asSeq;
	}

	public void setAsSeq(int asSeq) {
		this.asSeq = asSeq;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getReq_date() {
		return req_date;
	}

	public void setReq_date(String req_date) {
		this.req_date = req_date;
	}

	public int getMgr_index() {
		return mgr_index;
	}

	public void setMgr_index(int mgr_index) {
		this.mgr_index = mgr_index;
	}

	public String getAsTitle() {
		return asTitle;
	}

	public void setAsTitle(String asTitle) {
		this.asTitle = asTitle;
	}

	public String getAsContent() {
		return asContent;
	}

	public void setAsContent(String asContent) {
		this.asContent = asContent;
	}

	public String getAsImgPath() {
		return asImgPath;
	}

	public void setAsImgPath(String asImgPath) {
		this.asImgPath = asImgPath;
	}

	public int getPur_index() {
		return pur_index;
	}

	public void setPur_index(int pur_index) {
		this.pur_index = pur_index;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}



	public String getPrd_name() {
		return prd_name;
	}



	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}



	@Override
	public String toString() {
		return "AsAppDto [asSeq=" + asSeq + ", memId=" + memId + ", wdate=" + wdate + ", req_date=" + req_date
				+ ", mgr_index=" + mgr_index + ", asTitle=" + asTitle + ", asContent=" + asContent + ", asImgPath="
				+ asImgPath + ", pur_index=" + pur_index + ", model_name=" + model_name + ", prd_name=" + prd_name
				+ "]";
	}




	
	
	

}
