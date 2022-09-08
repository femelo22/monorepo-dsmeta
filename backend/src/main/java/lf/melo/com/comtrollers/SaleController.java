package lf.melo.com.comtrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lf.melo.com.entities.Sale;
import lf.melo.com.services.SaleService;
import lf.melo.com.services.SmsService;

@RestController
@RequestMapping("/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@Autowired
	private SmsService smsService;
	
	@GetMapping("/status")
	public ResponseEntity<String> status() {
		return ResponseEntity.ok().body("Ok");
	}
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Page<Sale>> findSales(
			@RequestParam(value="minDate", defaultValue = "") String minDate,
			@RequestParam(value="maxDate", defaultValue = "") String maxDate, 
			Pageable pageable) {
		return ResponseEntity.ok().body(service.findSales(minDate, maxDate, pageable));
	}
	
	
	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable int id) {
		smsService.sendSms(id);
	}

}
