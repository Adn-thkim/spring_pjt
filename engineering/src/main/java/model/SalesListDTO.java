package model;

public class SalesListDTO {

	String prodNo;
	String prodName;
	String prodPrice;
	String sumPurchQty;
	String sumPurchPrice;
	
	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
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
	public String getSumPurchQty() {
		return sumPurchQty;
	}
	public void setSumPurchQty(String sumPurchQty) {
		this.sumPurchQty = sumPurchQty;
	}
	public String getSumPurchPrice() {
		return sumPurchPrice;
	}
	public void setSumPurchPrice(String sumPurchPrice) {
		this.sumPurchPrice = sumPurchPrice;
	}
}
