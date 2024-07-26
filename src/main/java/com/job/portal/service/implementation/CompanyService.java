package com.job.portal.service.implementation;

import com.job.portal.dto.CompanyDTO;
import com.job.portal.dto.JobDTO;
import com.job.portal.dto.RequestCompanyDTO;
import com.job.portal.dto.RequestJobDTO;
import com.job.portal.entity.CompanyEntity;
import com.job.portal.entity.JobEntity;

import java.util.List;


public interface CompanyService {
    List<CompanyEntity> createCompanyDetails(List<RequestCompanyDTO> requestCompanyDTO);

    List<CompanyDTO> getCompanies();

    CompanyDTO getCompaniesById(Integer companyId);

    String deleteDataByCompanyId(Integer companyId);

    JobEntity storeJobData(RequestJobDTO requestJobDTO);
    JobDTO getDataByJobId(Integer jobId);

    List<JobDTO> getJobDataByCompanyId(Integer companyId);
}
