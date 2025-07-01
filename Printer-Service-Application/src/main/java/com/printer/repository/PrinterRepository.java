package com.printer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.printer.model.Printer;

public interface PrinterRepository extends JpaRepository<Printer, Long>{
	
	List<Printer> findByFloor(int floor);


}
