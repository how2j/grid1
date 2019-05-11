package cn.how2j.grid.pojo;

public class Grid {

	private int num;
	private float gear;
	private float buyPrice;
	private float sellPrice;
	private float buyAmount;
	private float buyCost;
	private float sellAmount;
	private float sellCost;
	private float profit;
	private float profitRate;
	
	public Grid() {
		this(1, 0.05f, 10000);
	}
	public Grid(int num, float gearEach, float buyCost) {
		this.num = num;
		this.gear = 1-gearEach*(num-1);
		this.buyPrice = this.gear;
		this.sellPrice =buyPrice  + gearEach;
		this.buyCost = buyCost;
		this.buyAmount = buyCost/this.buyPrice;

		sellAmount = buyAmount;
		sellCost = sellAmount * this.sellPrice;
		profit = sellCost-buyCost;
		profitRate = profit/buyCost;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getGear() {
		return gear;
	}
	public void setGear(float gear) {
		this.gear = gear;
	}
	public float getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(float buyPrice) {
		this.buyPrice = buyPrice;
	}
	public float getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(float sellPrice) {
		this.sellPrice = sellPrice;
	}
	public float getBuyAmount() {
		return buyAmount;
	}
	public void setBuyAmount(float buyAmount) {
		this.buyAmount = buyAmount;
	}
	public float getBuyCost() {
		return buyCost;
	}
	public void setBuyCost(float buyCost) {
		this.buyCost = buyCost;
	}
	public float getSellAmount() {
		return sellAmount;
	}
	public void setSellAmount(float sellAmount) {
		this.sellAmount = sellAmount;
	}
	public float getSellCost() {
		return sellCost;
	}
	public void setSellCost(float sellCost) {
		this.sellCost = sellCost;
	}
	public float getProfit() {
		return profit;
	}
	public void setProfit(float profit) {
		this.profit = profit;
	}
	public float getProfitRate() {
		return profitRate;
	}
	public void setProfitRate(float profitRate) {
		this.profitRate = profitRate;
	}
	
	
	
}
