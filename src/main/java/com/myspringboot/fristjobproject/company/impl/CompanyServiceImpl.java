package com.myspringboot.fristjobproject.company.impl;

import com.myspringboot.fristjobproject.company.Company;
import com.myspringboot.fristjobproject.company.CompanyService;
import com.myspringboot.fristjobproject.company.repos.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company findByCompanyId(long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean createNewCompany(Company newCompany) {
        if (companyRepository.save(newCompany) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCompany(long id, Company updateComp) {
        Company company = companyRepository.findById(id).orElse(null);
        if (company != null) {
            company.setName(updateComp.getName());
            company.setDescription(updateComp.getDescription());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompany(long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
