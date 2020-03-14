package org.camunda.demo.delegate;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.demo.model.CustomerData;
import org.camunda.spin.impl.json.jackson.JacksonJsonNode;
import org.springframework.stereotype.Component;


@Component("CalculateRating")
public class CalculateRating implements JavaDelegate {

    public void execute(DelegateExecution execution) throws Exception {

        Object obj = execution.getVariable("customerData");
        System.out.println("===> ===>" + obj + ", " + obj.getClass());

        JacksonJsonNode customerDataJson = (JacksonJsonNode) execution.getVariable("customerData");
        CustomerData customerData = customerDataJson.mapTo(CustomerData.class);

        // if the customer is not a VIP customer, the rating can be calculated automatically
        if (!customerData.isVip()) {

            // here we would execute some complex rating logic
            customerData.setRating(0.5f);

            execution.setVariable("ratingCreated", true);

        } else {
            execution.setVariable("ratingCreated", false);
        }

    }

}