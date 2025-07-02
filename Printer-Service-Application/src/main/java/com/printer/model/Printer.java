package com.printer.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Printer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int floor;
	private boolean available;
	private boolean colorSupported;
	private int speed;
	private LocalDateTime busyUntil;

    public boolean isAvailableNow() {
        return available && (busyUntil == null || busyUntil.isBefore(LocalDateTime.now()));
    }

	
	
	public LocalDateTime getBusyUntil() {
		return busyUntil;
	}
	public void setBusyUntil(LocalDateTime busyUntil) {
		this.busyUntil = busyUntil;
	}
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
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public boolean isColorSupported() {
		return colorSupported;
	}
	public void setColorSupported(boolean colorSupported) {
		this.colorSupported = colorSupported;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public Printer(int floor, boolean available, boolean colorSupported, int speed) {
		this.floor = floor;
		this.available = available;
		this.colorSupported = colorSupported;
		this.speed = speed;
	}
	public Printer() {}

	public Printer(Long id, int floor, boolean available, boolean colorSupported, int speed, LocalDateTime busyUntil) {
		this.id = id;
		this.floor = floor;
		this.available = available;
		this.colorSupported = colorSupported;
		this.speed = speed;
		this.busyUntil = busyUntil;
	}

}
