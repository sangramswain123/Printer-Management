package com.printer.dto;

public class PrinterDto {
	private Long id;
	private int floor;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public PrinterDto(Long id, int floor) {
		super();
		this.id = id;
		this.floor = floor;
	}
	public PrinterDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PrinterDto [id=" + id + ", floor=" + floor + "]";
	}
	
	
}
