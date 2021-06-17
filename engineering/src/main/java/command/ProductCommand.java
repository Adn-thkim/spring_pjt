package command;

import org.springframework.web.multipart.MultipartFile;

public class ProductCommand {
	
	String prodNo;
	String catNum;
	String prodName;
	String prodPrice;
	String prodInfo;
	MultipartFile [] prodImage;
	
	public MultipartFile[] getProdImage() {
		return prodImage;
	}
	public void setProdImage(MultipartFile[] prodImage) {
		this.prodImage = prodImage;
	}
	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	public String getCatNum() {
		return catNum;
	}
	public void setCatNum(String catNum) {
		this.catNum = catNum;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getProdInfo() {
		return prodInfo;
	}
	public void setProdInfo(String prodInfo) {
		this.prodInfo = prodInfo;
	}

}
