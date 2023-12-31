package com.SpringBatch.Config;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.SpringBatch.Repository.Customer_Repository;
import com.SpringBatch.entity.Customer;

@Configuration // this class is representative as batach processing.
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	private Customer_Repository  customerRepository; /// this is repository define by programmer.
	@Autowired
	private StepBuilderFactory stepBuilderFactory;  // this is define by spring boot
	@Autowired
	private JobBuilderFactory jobBuilderFactory;// this is define by spring boot
	
	// item reader bean   ### Step 1 reading the data from the csv file.
	
	@Bean
	public FlatFileItemReader<Customer> customerReader(){
		
		FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource("src/main/resources/customers.csv"));
		itemReader.setName("customer-item-read");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(lineMapper());  // after this line it sugget to create the method. of linemapper.
		// it used to map the data to customer object mean from csv to entity.
		return itemReader;
		
	}

	private LineMapper<Customer> lineMapper() {

		DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();

		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob");

		BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Customer.class);

		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
	
		return lineMapper;
	
		
	}
	
	
	//### Step 2  processig the data after we read the data from the csv file.

	// item processor bean  this is taken from another class where we process the data
	@Bean  // this is deifine by us because processing logic goes here sample have been created and commented 
	public CustomerProcessor customerProcessor() {
		
		return new CustomerProcessor();
		
	}
	
	
	// ### Step 3  Write  the data in to the databse after processign is done.
	
	// item writer bean   // this is predefine class writer.
	@Bean
	public RepositoryItemWriter<Customer> customerWriter(){
		
		RepositoryItemWriter<Customer> itemWriter = new RepositoryItemWriter<>();
		itemWriter.setRepository(customerRepository);
		itemWriter.setMethodName("save"); // save is pre define method to save the data in to the database.
		return itemWriter;
		
	}
	
	//### Step 4  step bean  is used to return step object. . all step such as read, process, write and build steps arr define here.
	// step bean  
	@Bean
	public Step step() {
		
		return stepBuilderFactory.get("step-1").<Customer,Customer>chunk(10) // 10 record will process at a time.
							.reader(customerReader())
							.processor(customerProcessor())
							.writer(customerWriter())
							.build();
	}
	
	//### Step 5  this will create a job in chunk
	
	// job bean
	@Bean
	public Job job() {
		return jobBuilderFactory.get("customer-import")
					.flow(step())  
					//.flow(step-1())
					//.flow(step-2()) if we have multiple steps we can define like this but here i dont have.
					.end()
					.build();
		
		
		
	}
	
	//### Step 6 this will lunch the job.
	
	// for step 6 create one restcontroller class to lunch the job.
	
	
	@Bean
	public TaskExecutor taskExecutor() {
		SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
		taskExecutor.setConcurrencyLimit(10);
		return taskExecutor;
	}

}
