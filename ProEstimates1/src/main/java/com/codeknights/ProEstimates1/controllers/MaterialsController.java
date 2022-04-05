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