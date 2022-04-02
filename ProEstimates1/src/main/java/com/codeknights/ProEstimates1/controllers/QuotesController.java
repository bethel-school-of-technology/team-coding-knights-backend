//package com.codeknights.ProEstimates1.controllers;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.codeknights.ProEstimates1.models.Quotes;
//
//
//
//@Controller
//@RequestMapping({"/","/quotes"})
//public class QuotesController {
//	
//	
//	@Value("${spring.datasource.url}")
//	private String url;
//
//	@Value("${spring.datasource.username}")
//	private String username;
//
//	@Value("${spring.datasource.password}")
//	private String password;
//	
//	
//	@GetMapping()
//	public String getAllQuotes(Model model) {
//		List<Quotes> quotes = new ArrayList<Quotes> ();
//		
//		Connection con;
//		try {
//		con = DriverManager.getConnection(url, username, password);
//		Statement stmt = con.createStatement();
//		ResultSet rs = stmt.executeQuery("SELECT * FROM quotes");
//		
//		while (rs.next()) {
//
//		    // create a new Quotes object
//		    Quotes newQuotes = new Quotes();
//
//		    // get the values from each column of the current row and add them to the new Quotes
//		    newQuotes.setUser_id(rs.getInt("user_id"));
//			newQuotes.setQuote_id(rs.getInt("quote_id"));
//			newQuotes.setMaterial_name(rs.getString("material_name"));
//			newQuotes.setQuote_measurement(rs.getInt("quote_measurement"));
//			newQuotes.setQuote_price(rs.getInt("quote_price"));
//			newQuotes.setQuote_material(rs.getString("quote_material"));
//			newQuotes.setUser_comments(rs.getString("user_comments"));
//		    // add the new quotes to the quotes list
//		    quotes.add(newQuotes);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		model.addAttribute("quotes", quotes);
//		return "quotes";
//	}
//	
//}
//
