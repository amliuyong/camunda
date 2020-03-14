package org.camunda.demo.errorHandeling;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("PurchaseMaterialsDelegate")
public class PurchaseMaterialsDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        System.out.println("PurchaseMaterialsDelegate ....");

        Long cost = (Long)execution.getVariable("cost");
        Long buget = (Long)execution.getVariable("buget");

        if (cost == null) {
            cost = 0L;
        }

        cost = cost + 10000000L;

        System.out.println("cost:" + cost);
        System.out.println("buget:" + buget);

        execution.setVariable("cost", cost);
    }

}