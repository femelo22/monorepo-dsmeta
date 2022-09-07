package lf.melo.com.comtrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<List<Sale>> findSales() {
		return ResponseEntity.ok().body(service.findSales());
	}

}
