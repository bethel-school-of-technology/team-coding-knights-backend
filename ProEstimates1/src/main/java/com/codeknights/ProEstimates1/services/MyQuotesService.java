package com.codeknights.ProEstimates1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeknights.ProEstimates1.models.Quote;
import com.codeknights.ProEstimates1.repositories.QuotesRepository;

@Service
public class MyQuotesService {

	@Autowired
	QuotesRepository quotesRepository;
	
	public Quote Save(Quote newQuote) {
		Quote savedQuote = quotesRepository.save(newQuote);
		return savedQuote;
	}

	public Boolean Delete(Integer quote_id) {
		Quote deleteQuote = quotesRepository.findQuoteByQuoteId(quote_id);
		quotesRepository.delete(deleteQuote);
		return true;
	}
	
	
}
