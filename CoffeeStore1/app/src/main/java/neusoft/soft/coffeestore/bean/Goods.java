package neusoft.soft.coffeestore.bean;

public class Goods {
     private String goodsName;
     private String goodsPrice;
     private String cover;
     private String goodsDiscount;
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Goods(String goodsName, String goodsPrice, String cover, String goodsDiscount) {
		super();
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.cover = cover;
		this.goodsDiscount = goodsDiscount;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getGoodsDiscount() {
		return goodsDiscount;
	}
	public void setGoodsDiscount(String goodsDiscount) {
		this.goodsDiscount = goodsDiscount;
	}
	@Override
	public String toString() {
		return "Goods [goodsName=" + goodsName + ", goodsPrice=" + goodsPrice + ", cover="
				+ cover + ", goodsDiscount=" + goodsDiscount + "]";
	}
     
}
