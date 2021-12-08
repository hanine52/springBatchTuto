package com.haben.springbatch.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class HwStepExecution2Listener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("Before the execution step2 - " + stepExecution.getStepName());
        System.out.println("Before Execution " + stepExecution.getJobExecution().getExecutionContext() );
        System.out.println();
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {

        System.out.println("After the execution step2 - " + stepExecution.getStepName());
        System.out.println("After Execution " + stepExecution.getJobExecution().getExecutionContext() );
        return null;
    }
}
