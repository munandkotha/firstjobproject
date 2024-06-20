package com.myspringboot.fristjobproject.job;

import java.util.List;

public interface JobService {
    public List<Job> findAllJobs();

    public Job findById(long id);

    public boolean updateJob(Job job, long id);

    public void createNewJob(Job job);

    public boolean deleteJob(long id);
}
