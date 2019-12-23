package com.cognizant.fileupload.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.cognizant.fileupload.model.StockExchange;


@Service
public interface StockExchangeService {
	
   public List<StockExchange> getAllStockExchange();
	
   public boolean addStockExchange(StockExchange stockExchange);
   
}
