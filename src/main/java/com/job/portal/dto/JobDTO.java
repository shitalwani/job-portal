package com.job.portal.dto;


import com.job.portal.entity.CompanyEntity;

public class JobDTO {
    private Integer jobId;
    private String jobCode;
    private String jobTitle;
    private String jobDescription;
    private CompanyEntity companyId;



    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public CompanyEntity getCompanyId() {
        return companyId;
    }

    public void setCompanyId(CompanyEntity companyId) {
        this.companyId = companyId;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}
