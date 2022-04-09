package com.codeknights.ProEstimates1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeknights.ProEstimates1.models.Quote;
import com.codeknights.ProEstimates1.repositories.QuotesRepository;

@Service
public class MyQuotesService  {

	@Autowired
	QuotesRepository quotesRepository;
	
	public Quote Save(Quote newQuote) {
		Quote savedQuote = quotesRepository.save(newQuote);
		return savedQuote;
	}
	
}
