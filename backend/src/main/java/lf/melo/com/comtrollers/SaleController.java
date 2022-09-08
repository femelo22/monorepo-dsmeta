package lf.melo.com.comtrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lf.melo.com.entities.Sale;
import lf.melo.com.services.SaleService;

@RestController
@RequestMapping("/")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping("/status")
	public ResponseEntity<String> status() {
		return ResponseEntity.ok().body("Ok");
	}
	
	
	@GetMapping("/sales")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Page<Sale>> findSales(
			@RequestParam(value="minDate", defaultValue = "") String minDate,
			@RequestParam(value="maxDate", defaultValue = "") String maxDate, 
			Pageable pageable) {
		return ResponseEntity.ok().body(service.findSales(minDate, maxDate, pageable));
	}

}
