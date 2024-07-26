package com.job.portal.service.implementation;

import com.job.portal.dto.CompanyDTO;
import com.job.portal.dto.JobDTO;
import com.job.portal.dto.RequestCompanyDTO;
import com.job.portal.dto.RequestJobDTO;
import com.job.portal.entity.CompanyEntity;
import com.job.portal.entity.JobEntity;
import com.job.portal.repository.CompanyRepository;
import com.job.portal.repository.JobRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImplementation implements CompanyService{

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    JobRepository jobRepository;

    @Override
    public List<CompanyEntity> createCompanyDetails(List<RequestCompanyDTO> requestCompanyDTOList) {

        ArrayList<CompanyEntity> responseCompanyDtoList = new ArrayList<>();
        requestCompanyDTOList.forEach(data ->{

            CompanyEntity companyEntity = new CompanyEntity();

            companyEntity.setCompanyName(data.getCompanyName());
            companyEntity.setCompanyAddress(data.getCompanyAddress());
            companyRepository.save(companyEntity);
            responseCompanyDtoList.add(companyEntity);

        });
        return responseCompanyDtoList;
    }

    @Override
    public List<CompanyDTO> getCompanies() {
          List<CompanyEntity> companyEntities = companyRepository.findAll();
          List<CompanyDTO> companyDTOList = new ArrayList<>();

          companyEntities.forEach(data -> {
              CompanyDTO companyDTO = new CompanyDTO();
              companyDTO.setCompanyName(data.getCompanyName());
              companyDTO.setCompanyAddress(data.getCompanyAddress());
              companyDTOList.add(companyDTO);
          });
          return companyDTOList;
    }

    @Override
    public CompanyDTO getCompaniesById(Integer companyId) {
        Optional<CompanyEntity> companyEntity = companyRepository.findById(companyId);
        if(companyEntity.isEmpty()){
            throw new IllegalArgumentException("no data found for companyId" +companyId);
        }
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setCompanyName(companyEntity.get().getCompanyName());
         companyDTO.setCompanyAddress(companyEntity.get().getCompanyAddress());
        return companyDTO;
    }

    @Override
    public String deleteDataByCompanyId(Integer companyId) {
         companyRepository.deleteById(companyId);
        return "record deleted successfully";
    }

    @Override
    public JobEntity storeJobData(RequestJobDTO requestJobDTO) {
        JobEntity jobEntity = new JobEntity();
        Optional<CompanyEntity> companyEntity = companyRepository.findById(requestJobDTO.getCompanyId());
        if(companyEntity.isEmpty()){
            throw new RuntimeException("Company id not found!");
        }
        jobEntity.setCompanyId(companyEntity.get());
        jobEntity.setJobCode(generateRandomChar());
        jobEntity.setJobTitle(requestJobDTO.getJobTitle());
        jobEntity.setJobDescription(requestJobDTO.getJobDescription());
        return jobRepository.save(jobEntity);
    }

    @Override
    public JobDTO getDataByJobId(Integer jobId) {
        Optional<JobEntity> jobEntity = jobRepository.findById(jobId);
        if(jobEntity.isEmpty()){
            throw new RuntimeException("no record found for jobId :" +jobId);
        }

        JobDTO jobDTO = new JobDTO();
        jobDTO.setJobCode(jobEntity.get().getJobCode());
        jobDTO.setJobDescription(jobEntity.get().getJobDescription());
        jobDTO.setJobTitle(jobEntity.get().getJobTitle());

        jobDTO.setCompanyId(jobEntity.get().getCompanyId());
        return jobDTO;
    }

    @Override
    public List<JobDTO> getJobDataByCompanyId(Integer companyId) {
        List<JobEntity> jobEntityList = jobRepository.findByCompanyId(companyId);
        if(jobEntityList.isEmpty()){
            throw new RuntimeException("no record found for companyId :"+companyId);
        }
        List<JobDTO> jobDTOList = new ArrayList<>();
        jobEntityList.forEach(data -> {
            JobDTO jobDTO = new JobDTO();
            jobDTO.setJobId(data.getJobId());
            jobDTO.setJobCode(data.getJobCode());
            jobDTO.setJobDescription(data.getJobDescription());
            jobDTO.setJobTitle(data.getJobTitle());
            jobDTO.setCompanyId(data.getCompanyId());
            jobDTOList.add(jobDTO);
        });

        return jobDTOList;
    }

    public String generateRandomChar(){
        String generatedString = RandomStringUtils.random(10, true, false);
        return generatedString;
    }


}
