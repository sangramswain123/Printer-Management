package com.printer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.printer.model.Printer;
import com.printer.repository.PrinterRepository;

@Service
public class PrinterService {
	
	private PrinterRepository printerRepo;
	private final int floors = 10;
	
	public PrinterService(PrinterRepository printerRepo) {
		this.printerRepo = printerRepo;
	}
	
	public Printer addPrinter(Printer p) {
		return printerRepo.save(p);
	}

	public List<Printer> listAll() {
	    return printerRepo.findAll();
	}
	
	public Optional<Printer> findPrinter(int startFloor, boolean needsColor, int minSpeed){
		
		if (startFloor < 0 || startFloor >= floors) {
	        throw new IllegalArgumentException("Invalid floor number: " + startFloor);
	    }
		
		for (int d = 0; d < floors; d++) {
		      int[] offsets = (d == 0) ? new int[]{0} : new int[]{d, -d};
		     
		      for (int offset : offsets) {
		        int f = startFloor + offset;
		        if (f < 0 || f >= floors) continue;
		        List<Printer> printers = printerRepo.findByFloor(f);
		        for (Printer p : printers) {
		          if (p.isAvailable() && (!needsColor || p.isColorSupported())
		        		  && p.getSpeed() >= minSpeed) {
		            return Optional.of(p);
		          }
		        }
		      }
		    }
		return Optional.empty();	
	}
	
}
