package com.job.portal.controller;

import com.job.portal.dto.CompanyDTO;
import com.job.portal.dto.JobDTO;
import com.job.portal.dto.RequestCompanyDTO;
import com.job.portal.dto.RequestJobDTO;
import com.job.portal.entity.CompanyEntity;
import com.job.portal.entity.JobEntity;
import com.job.portal.service.implementation.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")

public class CompanyController {

    @Autowired
    CompanyService companyService;
    @PostMapping("/create")
    public ResponseEntity<List<CompanyEntity>> StoreCompanyDetails(@RequestBody List<RequestCompanyDTO> requestCompanyDTO){
        List<CompanyEntity> createData = companyService.createCompanyDetails(requestCompanyDTO);
       return new ResponseEntity<>(createData, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> fetchCompanyLists(){
        List<CompanyDTO> companyEntities = companyService.getCompanies();
        return new ResponseEntity<>(companyEntities,HttpStatus.OK);
    }

    @GetMapping("/{company_id}")
    public ResponseEntity<CompanyDTO> fetchCompanyByCompanyId(@PathVariable("company_id") Integer companyId){
       CompanyDTO companyDTO = companyService.getCompaniesById(companyId);
       return new ResponseEntity<>(companyDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{company_id}")
    public ResponseEntity<String> deleteByCompanyId(@PathVariable("company_id") Integer companyId){
       String deletedData = companyService.deleteDataByCompanyId(companyId);
       return new ResponseEntity<>(deletedData,HttpStatus.OK);
    }

    @PostMapping("/create/job")
    public ResponseEntity<JobEntity> createJobData(@RequestBody RequestJobDTO requestJobDTO){
      JobEntity storeData = companyService.storeJobData(requestJobDTO);
      return new ResponseEntity<>(storeData,HttpStatus.CREATED);
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<JobDTO> getByJobId(@PathVariable("jobId")  Integer jobId){
        JobDTO jobDTO = companyService.getDataByJobId(jobId);
        return new ResponseEntity<>(jobDTO,HttpStatus.OK);
    }

    @GetMapping("/jobs/{companyId}")
    public ResponseEntity<List<JobDTO>> getJobByCompanyId(@PathVariable("companyId")  Integer companyId){
        List<JobDTO> jobDTO = companyService.getJobDataByCompanyId(companyId);
        return new ResponseEntity<>(jobDTO,HttpStatus.OK);
    }
}
