package com.cognizant.fileupload.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.fileupload.model.StockExchange;
import com.cognizant.fileupload.service.StockExchangeService;



@RestController
public class StockExchangeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);
	
	@Autowired
    private StockExchangeService stockExchangeService;
	
	 @GetMapping("/stock-exchange")
	 public List<StockExchange> getAllStockExchange() {
		 
		 LOGGER.info("Start");
		 LOGGER.info("End");
			
		 return stockExchangeService.getAllStockExchange();
	 }
	 
	@PostMapping("/add-stock-exchange")
	public boolean addStockExchange(@RequestBody StockExchange stockExchange) {
			
		LOGGER.info("Start");
		LOGGER.info("End");
			
		return stockExchangeService.addStockExchange(stockExchange);
	}
	 
}
