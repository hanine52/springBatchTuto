package com.haben.springbatch.config;

import com.haben.springbatch.listener.HwJobExecutionListener;
import com.haben.springbatch.listener.HwStepExecution2Listener;
import com.haben.springbatch.listener.HwStepExecutionListener;
import com.haben.springbatch.processor.InMemeItemProcessor;
import com.haben.springbatch.reader.InMemReader;
import com.haben.springbatch.writer.ConsoleItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

    @Autowired
    private InMemeItemProcessor inMemeItemProcessor;
    @Bean
    public Job job1() {
        return jobBuilderFactory.get("First Job")
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
                .reader(reader())
                .processor(inMemeItemProcessor)

                .writer(new ConsoleItemWriter())

                .build();
    }

    @Bean
    public InMemReader reader(){
        return new InMemReader();
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


}
