package com.myspringboot.fristjobproject.job.impl;

import com.myspringboot.fristjobproject.job.Job;
import com.myspringboot.fristjobproject.job.JobService;
import com.myspringboot.fristjobproject.job.repos.JobRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    JobRepository jobRepo;

    public JobServiceImpl(JobRepository jobRepo) {
        this.jobRepo = jobRepo;
    }

    @Override
    public List<Job> findAllJobs() {
        return jobRepo.findAll();
        //return jobs;
    }

    @Override
    public Job findById(long id) {
        return jobRepo.findById(id).orElse(null);
        /*for(Job job: jobs) {
            if(job.getId() == id) {
                return job;
            }
        }
        return null;*/
    }

    @Override
    public boolean updateJob(Job updateJob, long id) {
        Job job = jobRepo.findById(id).orElse(null);
        if (job != null) {
            job.setDescription(updateJob.getDescription());
            job.setTitle(updateJob.getTitle());
            job.setMinSal(updateJob.getMinSal());
            job.setMaxSal(updateJob.getMaxSal());
            job.setLocation(updateJob.getLocation());
            jobRepo.save(job);
            return true;
        }
        return false;
    }

    @Override
    public void createNewJob(Job job) {
        jobRepo.save(job);
       /* job.setId(idCounter++);
        jobs.add(job);*/
    }

    @Override
    public boolean deleteJob(long id) {
        jobRepo.deleteById(id);
        return true;
    }
}
