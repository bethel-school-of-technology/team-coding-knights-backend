package com.codeknights.ProEstimates1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeknights.ProEstimates1.models.Quotes;

@Repository
public interface QuotesRepository extends JpaRepository<Quotes, String>{

}
