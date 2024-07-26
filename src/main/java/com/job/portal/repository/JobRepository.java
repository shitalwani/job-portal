package com.job.portal.repository;

import com.job.portal.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<JobEntity,Integer> {

    @Query(value = "select jobentity from JobEntity as jobentity where jobentity.companyId.companyId = :companyId")
    List<JobEntity> findByCompanyId(Integer companyId);

}
