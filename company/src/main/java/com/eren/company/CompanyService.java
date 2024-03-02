package com.eren.company;

import com.eren.company.entity.Company;

import java.util.List;

public interface CompanyService {

    Company createCompany(Company company);
    List<Company> findAll();
    Company getCompanyById(Long id) throws Exception;
    Company updateCompany(Company company,Long id) throws Exception;
    Boolean deleteCompany(Long id) throws Exception;

}
