package com.tron.rest;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.parameters.InvalidJobParametersException;
import org.springframework.batch.core.job.parameters.JobParameters;
import org.springframework.batch.core.job.parameters.JobParametersBuilder;
import org.springframework.batch.core.launch.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.launch.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	private Job job;
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@GetMapping("/import")
	public void loadData() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, InvalidJobParametersException
	{
		JobParametersBuilder jobParameters = new JobParametersBuilder()
				.addLong("Starts At", System.currentTimeMillis());
		JobParameters jobpara = jobParameters.toJobParameters();
		jobLauncher.run(job, jobpara);
		System.out.println("data loaded");
	}
}
