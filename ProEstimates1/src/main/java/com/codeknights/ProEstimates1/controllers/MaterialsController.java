package com.codeknights.ProEstimates1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.codeknights.ProEstimates1.models.Materials;
import com.codeknights.ProEstimates1.repositories.MaterialsRepository;

@RestController
public class MaterialsController {

    @Autowired
    private MaterialsRepository materialsRepository;

    @GetMapping("/materials")
    public List<Materials> GetAllMaterials(){
        List<Materials> mats = materialsRepository.findAll();

        return mats;
    }
}

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
//import com.codeknights.ProEstimates1.models.Materials;
//
//
//
//@Controller
//@RequestMapping({"/","/materials"})
//public class MaterialsController {
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
//	public String getAllMaterials(Model model) {
//		List<Materials> materials = new ArrayList<Materials> ();
//		
//		Connection con;
//		try {
//		con = DriverManager.getConnection(url, username, password);
//		Statement stmt = con.createStatement();
//		ResultSet rs = stmt.executeQuery("SELECT * FROM materials");
//		
//		while (rs.next()) {
//
//		    // create a new materials object
//		    Materials newMaterials = new Materials();
//
//		    // get the values from each column of the current row and add them to the new materials
//		    newMaterials.setMaterial_id(rs.getInt("material_id"));
//			newMaterials.setMaterial_price(rs.getInt("material_price"));
//			newMaterials.setMaterial_name(rs.getString("material_name"));
//			newMaterials.setMaterial_set_date(rs.getDate("material_set_date"));
//			
//		    // add the new material to the materials list
//		    materials.add(newMaterials);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		model.addAttribute("materials", materials);
//		return "materials";
//	}
//	
//}