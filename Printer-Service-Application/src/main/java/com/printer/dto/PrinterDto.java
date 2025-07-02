package com.printer.dto;

public class PrinterDto {
	
	private int startFloor;
    private boolean needsColor;
    private int speed;
    private int pages;
	public int getStartFloor() {
		return startFloor;
	}
	public void setStartFloor(int startFloor) {
		this.startFloor = startFloor;
	}
	public boolean isNeedsColor() {
		return needsColor;
	}
	public void setNeedsColor(boolean needsColor) {
		this.needsColor = needsColor;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public PrinterDto(int startFloor, boolean needsColor, int speed, int pages) {
		super();
		this.startFloor = startFloor;
		this.needsColor = needsColor;
		this.speed = speed;
		this.pages = pages;
	}
	public PrinterDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PrinterDto [startFloor=" + startFloor + ", needsColor=" + needsColor + ", speed=" + speed + ", pages="
				+ pages + "]";
	}
    
	
	
}
