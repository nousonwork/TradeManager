package com.tradesmanager.entities;

public class TradeData {
	
	private String trade_id;
	private String version;
	private String counter_party_id;
	private String book_id;
	private String maturity_date;
	private String created_date;
	private String expired;
	
	
	public String getTrade_id() {
		return trade_id;
	}
	public void setTrade_id(String trade_id) {
		this.trade_id = trade_id;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getCounter_party_id() {
		return counter_party_id;
	}
	public void setCounter_party_id(String counter_party_id) {
		this.counter_party_id = counter_party_id;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getMaturity_date() {
		return maturity_date;
	}
	public void setMaturity_date(String maturity_date) {
		this.maturity_date = maturity_date;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public String getExpired() {
		return expired;
	}
	public void setExpired(String expired) {
		this.expired = expired;
	}
	

}
