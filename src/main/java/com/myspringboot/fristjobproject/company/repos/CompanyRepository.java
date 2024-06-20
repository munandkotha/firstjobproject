package com.myspringboot.fristjobproject.company.repos;

import com.myspringboot.fristjobproject.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
