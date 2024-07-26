package com.job.portal.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Entity
@Table(name = "job_table")
public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity companyId;

    @Column(name = "jobCode")
    private String jobCode;

    @Column(name = "jobTitle")
    private String jobTitle;

    @Column(name = "jobDescription")
    private String jobDescription;

    @Column(name = "createdAt")
    @CreationTimestamp
    private Date createdAt;
}
