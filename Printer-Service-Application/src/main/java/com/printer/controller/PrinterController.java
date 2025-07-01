package com.printer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.printer.model.Printer;
import com.printer.service.PrinterService;

@RestController
@RequestMapping("/printers")
public class PrinterController {
	
	private PrinterService printerService;

	public PrinterController(PrinterService printerService) {
		this.printerService = printerService;
	}
	
	@PostMapping
	public ResponseEntity<Printer> addPrinter(@RequestBody Printer p) {
		return new ResponseEntity<>(printerService.addPrinter(p), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Printer> list(){
		return printerService.listAll();
	}
	
	@GetMapping("/search")
	public ResponseEntity<Printer> searchPrinter(@RequestParam int floor,
			  @RequestParam boolean needsColor,
			  @RequestParam int minSpeed) {
		
		Optional<Printer> printer = printerService.findPrinter(floor, needsColor, minSpeed);
		
		if (printer.isPresent()) {
		    return ResponseEntity.ok(printer.get());
		} else {
		    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

		
	
	

}
