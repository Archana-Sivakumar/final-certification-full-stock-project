package com.cognizant.fileupload.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.cognizant.fileupload.FileUploadApplication;
import com.cognizant.fileupload.model.StockPrice;
import com.cognizant.fileupload.model.Summary;
import com.cognizant.fileupload.service.DBFileStorageService;
import java.util.List;


@RestController
public class FileController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadApplication.class);


    @Autowired
    private DBFileStorageService dbFileStorageService;

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
    	
    	LOGGER.info("START");
    	
        dbFileStorageService.storeFile(file);
        
        LOGGER.info("END");
        
        return "File Copied Successfully!!";
        
    }
	 @GetMapping("/summary")
	 public Summary getSummary() {
		 
		 LOGGER.info("START");
		 LOGGER.info("END");
		 
		 return dbFileStorageService.getSummary();
	 }
   
	 
	 @GetMapping("/get-stock-price/{companyCode}")
	 public List<StockPrice> getStock(@PathVariable long companyCode) {
		 
		 LOGGER.info("START");
		 LOGGER.info("END");
		 
		 return dbFileStorageService.getStock(companyCode);
	 }
   
}