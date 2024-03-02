package com.eren.company.impl;


import com.eren.company.CompanyService;
import com.eren.company.entity.Company;
import com.eren.company.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public Company createCompany(Company company) {

        return companyRepository.save(company);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) throws Exception {
        Optional<Company> company = companyRepository.findById(id);
        if(company.isPresent()){
            return company.get();
        }else{
            throw new Exception("Company Not Found");
        }

    }

    @Override
    public Company updateCompany(Company company, Long id) throws Exception {
        Optional<Company> existingCompany = companyRepository.findById(id);
        if(existingCompany.isPresent()){
            Company updateCompany = existingCompany.get();
            updateCompany.setName(company.getName());
            updateCompany.setLocation(company.getLocation());
            return companyRepository.save(updateCompany);
        }
        else{
            throw new Exception("Company Not Found");
        }

    }

    @Override
    public Boolean deleteCompany(Long id) throws Exception {
        Optional<Company> company = companyRepository.findById(id);
        if(company.isPresent()){
            companyRepository.deleteById(id);
            return true;
        }else{
            return false;
        }

    }
}
