package model;

public class DataSamp {
	private int year;
	private int cowPop;
	private int horsePop;
	private int deerPop;
	private int wolfPop;
	
	
	public DataSamp(int year, int cowPop, int horsePop, int deerPop, int wolfPop) {
		
		this.year = year;
		this.cowPop = cowPop;
		this.horsePop = horsePop;
		this.deerPop = deerPop;
		this.wolfPop = wolfPop;
	}


	
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getCowPop() {
		return cowPop;
	}
	public void setCowPop(int cowPop) {
		this.cowPop = cowPop;
	}
	public int getHorsePop() {
		return horsePop;
	}
	public void setHorsePop(int horsePop) {
		this.horsePop = horsePop;
	}
	public int getDeerPop() {
		return deerPop;
	}
	public void setDeerPop(int deerPop) {
		this.deerPop = deerPop;
	}
	public int getWolfPop() {
		return wolfPop;
	}
	public void setWolfPop(int wolfPop) {
		this.wolfPop = wolfPop;
	}
	
	
	
	
	
	
}
