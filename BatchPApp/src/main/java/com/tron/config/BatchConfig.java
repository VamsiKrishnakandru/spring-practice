package com.tron.config;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.data.RepositoryItemWriter;
import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.LineMapper;
import org.springframework.batch.infrastructure.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.infrastructure.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.infrastructure.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.tron.model.Customer;
import com.tron.repo.ICustomerRepo;

@Configuration
public class BatchConfig {
	
	@Autowired
	private ICustomerRepo repo;
	
	@Autowired
	private JobRepository jobRepo;
	
	//ItemReader
	//Here we are reading from file so returning a file related reader
	//we can change the source and destination
	@Bean
	public FlatFileItemReader<Customer> itemReader()
	{
		FlatFileItemReader<Customer> reader = new FlatFileItemReader<>(lineMapper());
		reader.setResource(new FileSystemResource("src/main/resources/customer_data.csv"));
		reader.setName("csv-reader");
		reader.setLinesToSkip(1); //skips the column headers
		return reader;
	}

	private LineMapper<Customer> lineMapper() {
		DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter(",");
		tokenizer.setStrict(false);
		tokenizer.setNames("customerId", "firstName", "lastName", "email", "phoneNumber", "city", "state", "zipCode", "country");
		
		BeanWrapperFieldSetMapper<Customer> beanWrapper = new BeanWrapperFieldSetMapper<>();
		beanWrapper.setTargetType(Customer.class);
		
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(beanWrapper);
		return lineMapper;
	}
	
	//ItemProcessor
	@Bean
	public CustomerProcessor processCxData()
	{
		return new CustomerProcessor();
	}
	
	//ItemWriter
	//since we are writing to repo so we are returning repo related obj 
	@Bean
	public RepositoryItemWriter<Customer> itemWriter()
	{
		RepositoryItemWriter<Customer> writer = new RepositoryItemWriter<>(repo);
		writer.setMethodName("save");
		return writer;
	}
	
	//Step
	@Bean
	public Step step()
	{
		return new StepBuilder("step-1", jobRepo).<Customer,Customer>chunk(10)
				.reader(itemReader())
				.processor(processCxData())
				.writer(itemWriter())
				.build();
	}
	
	//Job
	@Bean
	public Job job()
	{
		return (Job) new JobBuilder("customer-import", jobRepo)
				.start(step())
				.build();
	}
}
