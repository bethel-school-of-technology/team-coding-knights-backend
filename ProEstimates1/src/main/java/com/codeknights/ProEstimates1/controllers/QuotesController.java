package com.codeknights.ProEstimates1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeknights.ProEstimates1.models.Quote;
import com.codeknights.ProEstimates1.repositories.QuotesRepository;
import com.codeknights.ProEstimates1.services.MyQuotesService;
import com.codeknights.ProEstimates1.util.DeleteQuoteApiModel;
import com.codeknights.ProEstimates1.util.UpdateQuoteApiModel;



@CrossOrigin
@RestController
@RequestMapping()
public class QuotesController {
	
	@Autowired
	private QuotesRepository quotesRepository;
	@Autowired
	private MyQuotesService myQuotesService;
	
	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;
	
	
	@GetMapping("/quote/{quote_id}")
	public Quote getQuotes(@PathVariable("quote_id") int quote_id) {
		List<Quote> quotes = this.quotesRepository.findQuotesByQuoteId (quote_id);
		return quotes.get(0);
	}
	@PostMapping("/quote")
    public Quote postQuote(@RequestBody Quote quote) {
        quote = this.myQuotesService.Save(quote);
        return quote;
    }
	@DeleteMapping("/quote/{quote_id}")
	public Boolean deleteQuote(@PathVariable("quote_id")int quote_id){
		boolean works;
		works = this.myQuotesService.Delete(quote_id);
		return works;
	}
	@PatchMapping ("/quote/{quote_id}")
	public void updateQuote(@PathVariable("quote_id") int quote_id, @RequestBody UpdateQuoteApiModel quoteUpdate ) {
		List<Quote> quotes = this.quotesRepository.findQuotesByQuoteId (quote_id);
		Quote quote = quotes.get(0);
		quote.setUser_comments(quoteUpdate.getUser_comments());
		quote.setQuote_price(quoteUpdate.getQuote_price());
		quote.setQuote_material(quoteUpdate.getQuote_material());

		quote = this.myQuotesService.Save(quote);
	
	}
}

