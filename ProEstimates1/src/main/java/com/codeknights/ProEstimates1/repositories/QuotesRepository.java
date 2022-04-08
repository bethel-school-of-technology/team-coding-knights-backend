package com.codeknights.ProEstimates1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codeknights.ProEstimates1.models.Quote;

@Repository
public interface QuotesRepository extends JpaRepository<Quote, String>{
	@Query(value="SELECT pro_estimates.quotes.*  FROM pro_estimates.quotes INNER JOIN pro_estimates.user USING(user_id) WHERE pro_estimates.user.user_id = ?1",nativeQuery=true)
	List<Quote> findQuotesByUserId(int user_id);
}
