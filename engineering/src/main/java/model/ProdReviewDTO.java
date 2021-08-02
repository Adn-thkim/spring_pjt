package model;

import oracle.sql.DATE;

public class ProdReviewDTO {

	String membId;
	String purchNo;
	String prodNo;
	String reviewContent;
	DATE reviewDate;
	DATE purchDate;
	
	public String getMembId() {
		return membId;
	}
	public void setMembId(String membId) {
		this.membId = membId;
	}
	public String getPurchNo() {
		return purchNo;
	}
	public void setPurchNo(String purchNo) {
		this.purchNo = purchNo;
	}
	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public DATE getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(DATE reviewDate) {
		this.reviewDate = reviewDate;
	}
	public DATE getPurchDate() {
		return purchDate;
	}
	public void setPurchDate(DATE purchDate) {
		this.purchDate = purchDate;
	}
}
