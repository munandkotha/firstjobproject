package com.myspringboot.fristjobproject.job.repos;

import com.myspringboot.fristjobproject.job.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
