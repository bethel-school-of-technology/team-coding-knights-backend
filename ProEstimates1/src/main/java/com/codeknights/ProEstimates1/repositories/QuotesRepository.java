package com.codeknights.ProEstimates1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codeknights.ProEstimates1.models.Quote;

@Repository
public interface QuotesRepository extends JpaRepository<Quote, String>{
	@Query(value="SELECT pro_estimates.quotes.* FROM pro_estimates.quotes INNER JOIN pro_estimates.user USING(user_id) WHERE pro_estimates.user.user_id = ?1",nativeQuery=true)
	List<Quote> findQuotesByUserId(int user_id);
	
	@Query(value="SELECT pro_estimates.quotes.*  FROM pro_estimates.quotes WHERE pro_estimates.quotes.quote_id = ?1",nativeQuery=true)
	List<Quote> findQuotesByQuoteId(int quote_id);
	
	@Query(value="SELECT pro_estimates.quotes.*  FROM pro_estimates.quotes WHERE pro_estimates.quotes.quote_id = ?1 LIMIT 1",nativeQuery=true)
	Quote findQuoteByQuoteId(int quote_id);
	
	@Modifying
	@Query(value="Delete FROM pro_estimates.quotes WHERE quote_id = ?1", nativeQuery=true)
	void deleteByQuoteId(Integer quote_id);
}
