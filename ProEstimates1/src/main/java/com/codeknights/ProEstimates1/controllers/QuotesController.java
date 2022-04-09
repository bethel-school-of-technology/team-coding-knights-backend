package com.codeknights.ProEstimates1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeknights.ProEstimates1.models.Quote;
import com.codeknights.ProEstimates1.repositories.QuotesRepository;
import com.codeknights.ProEstimates1.util.CreateQuoteApiModel;




@RestController
@RequestMapping()
public class QuotesController {

	@Autowired
	private QuotesRepository quotesRepository;
	
	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;
	
	
	@GetMapping("/quote/{quote_id}")
	public List<Quote> getQuotes(@PathVariable("quote_id") int quote_id) {
		List<Quote> quotes = this.quotesRepository.findQuotesByQuoteId (quote_id);
		return quotes;
	}
	@PostMapping("/quote")
    public CreateQuoteApiModel postQuote(@RequestBody Quote quote) {
         this.MyQuotesService.Save(quote);
         CreateQuoteApiModel apiModel = new CreateQuoteApiModel();
        return apiModel;
    }
	
}

