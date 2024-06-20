package com.myspringboot.fristjobproject.company;

import java.util.List;

public interface CompanyService {
    public List<Company> findAllCompanies() ;

    public Company findByCompanyId(long id);

    public boolean createNewCompany(Company newCompany);

    public boolean updateCompany(long id, Company updateComp);

    public boolean deleteCompany(long id);
}
