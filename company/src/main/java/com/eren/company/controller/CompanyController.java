package com.eren.company.controller;


import com.eren.company.CompanyService;
import com.eren.company.entity.Company;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/companies")
@AllArgsConstructor
public class CompanyController {

    private final CompanyService companyService;


    @PostMapping("/company")
    public ResponseEntity<Company> createCompany(@RequestBody Company company){
        Company response =companyService.createCompany(company);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<Company>> findAll(){
        List<Company> response =companyService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/company/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) throws Exception {
        Company response =companyService.getCompanyById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity<Company> updateCompany(@RequestParam Long id,@RequestBody Company company) throws Exception {
        Company response =companyService.updateCompany(company,id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCompany(@RequestParam Long id) throws Exception {
        Boolean response =companyService.deleteCompany(id);
        return new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);

    }


}
