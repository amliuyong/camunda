package org.camunda.demo.errorHandeling;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("IncreaseBugetDelegate")
public class IncreaseBugetDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        Long buget = (Long)execution.getVariable("buget");

        // 500 million
        buget = buget + 500000000L;

        execution.setVariable("buget", buget);


    }

}