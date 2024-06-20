package com.myspringboot.fristjobproject.company;

import com.myspringboot.fristjobproject.company.impl.CompanyServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    CompanyServiceImpl compServ;

    public CompanyController(CompanyServiceImpl compServ) {
        this.compServ = compServ;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = compServ.findAllCompanies();
        if (companies != null) {
            return new ResponseEntity<>(companies, HttpStatus.OK);
        }
        return new ResponseEntity<>(companies, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company) {
        if (compServ.createNewCompany(company)) {
            return new ResponseEntity<>("Company created successfully!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Couldn't Create Company!", HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Company company = compServ.findByCompanyId(id);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        if(compServ.deleteCompany(id)) {
            return new ResponseEntity<>("Deleted company successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Coundn't find the company!", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,
                                @RequestBody Company updateComp) {
        if(compServ.updateCompany(id, updateComp)) {
            return new ResponseEntity<>("Updated company successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Couldn't find the company!", HttpStatus.NOT_FOUND);
    }

}
