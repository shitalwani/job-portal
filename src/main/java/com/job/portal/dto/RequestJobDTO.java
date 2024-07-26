package com.job.portal.dto;

import com.job.portal.entity.CompanyEntity;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;
@Data
public class RequestJobDTO {
    private Integer companyId;
    private String jobCode;
    private String jobTitle;
    private String jobDescription;
}
