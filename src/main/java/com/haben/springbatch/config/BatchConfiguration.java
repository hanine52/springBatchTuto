package com.haben.springbatch.config;

import com.haben.springbatch.listener.HwJobExecutionListener;
import com.haben.springbatch.listener.HwStepExecution2Listener;
import com.haben.springbatch.listener.HwStepExecutionListener;
import com.haben.springbatch.model.Product;
import com.haben.springbatch.processor.InMemeItemProcessor;
import com.haben.springbatch.reader.InMemReader;
import com.haben.springbatch.writer.ConsoleItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@EnableBatchProcessing
@Configuration
public class BatchConfiguration {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private HwJobExecutionListener hwJobExecutionListener;
    @Autowired
    private HwStepExecutionListener hwStepExecutionListener;
    @Autowired
    private HwStepExecution2Listener hwStepExecution2Listener;

//    @Autowired
//    private InMemeItemProcessor inMemeItemProcessor;
    @Bean
    public Job job1() {
        return jobBuilderFactory.get("First Job")
                .incrementer(new RunIdIncrementer())
                .listener(hwJobExecutionListener)
                .start(step1())
                .next(step2())
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("Step num 1")
                .tasklet(helloWorldTK())
                .listener(hwStepExecutionListener)
                .build();
    }


    @Bean
    public Step step2(){
        return stepBuilderFactory.get("step2")
                .listener(hwStepExecution2Listener)

                .<Integer,Integer>chunk(3)
                //.reader(reader())
                //.processor(inMemeItemProcessor)
                .reader(flatFileItemReader(null))

                .writer(new ConsoleItemWriter())

                .build();
    }

    @Bean
    public InMemReader reader(){
        return new InMemReader();
    }

//    @StepScope  @Value( "#{jobParameters['fileInput']}" )
//                    FileSystemResource inputFile
    @StepScope @Bean
    public FlatFileItemReader flatFileItemReader(@Value( "#{jobParameters['fileInput']}")  FileSystemResource inputFile){
        FlatFileItemReader reader = new FlatFileItemReader();
        // step 1 let reader know where is the file
        reader.setResource( inputFile );
//        reader.setResource( new FileSystemResource("input/product.csv") );

        //create the line Mapper
        reader.setLineMapper(
                new DefaultLineMapper<Product>(){
                    {
                        setLineTokenizer( new DelimitedLineTokenizer() {
                            {
                                setNames("productID","productName","ProductDesc","price","unit");
//                                setDelimiter("|");
                            }
                        });

                        setFieldSetMapper( new BeanWrapperFieldSetMapper<Product>(){
                            {
                                setTargetType(Product.class);
                            }
                        });
                    }
                }

        );
        //step 3 tell reader to skip the header
        reader.setLinesToSkip(1);
        return reader;

    }




    public Tasklet helloWorldTK() {
        return (new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("Hello world");
                return RepeatStatus.FINISHED;
            }
        });
    }
    public Tasklet helloWorldTK2() {
        return (new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("Hello world");
                return RepeatStatus.FINISHED;
            }
        });
    }


}
