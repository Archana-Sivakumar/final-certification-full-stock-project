package com.cognizant.fileupload.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.fileupload.controller.FileController;
import com.cognizant.fileupload.model.StockExchange;
import com.cognizant.fileupload.repository.StockExchangeRepository;

@Service
public class StockExchangeServiceImpl implements StockExchangeService {

private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);
	
	@Autowired
	StockExchangeRepository stockExchangeRepository;
	
	@Override
	public List<StockExchange> getAllStockExchange() {
		
		LOGGER.info("Start");
		LOGGER.info("End");
		
		return stockExchangeRepository.findAll();
	}
	
	
	@Override
	public boolean addStockExchange(StockExchange stockExchange) {
		
		LOGGER.info("Start");
		
		stockExchangeRepository.save(stockExchange);
		
		LOGGER.info("End");
		
		return true;
	}
	
}
