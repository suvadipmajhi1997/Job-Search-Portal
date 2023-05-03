package com.geekster.JobEntity.repository;

import com.geekster.JobEntity.model.Job;
import com.geekster.JobEntity.model.JobType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends CrudRepository<Job,Long> {
    List<Job> findByCompanyName(String companyName);

    List<Job> findByJobType(JobType jobType);

    List<Job> findBySalaryGreaterThanEqual(Double salary);

   @Query(value = "SELECT * FROM JOB  WHERE EMPLOYER_NAME = :employerName" , nativeQuery = true)
    List<Job> findJobsByEmployerName(String employerName);

   @Modifying
    @Query(value="UPDATE JOB  SET TITLE = :title WHERE id = :id", nativeQuery = true)
    void updateTitleById(String title,Long id);

    @Modifying
    @Query(value = "DELETE FROM JOB  WHERE ID = :id",nativeQuery = true)
    void deleteById(Long id);
}
