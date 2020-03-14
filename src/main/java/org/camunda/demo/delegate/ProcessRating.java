package org.camunda.demo.delegate;

import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.demo.model.CustomerData;
import org.camunda.spin.impl.json.jackson.JacksonJsonNode;
import org.camunda.spin.plugin.variable.value.JsonValue;
import org.springframework.stereotype.Component;



@Component("ProcessRating")

public class ProcessRating implements JavaDelegate {

  private final static Logger LOG = Logger.getLogger(ProcessRating.class.getName());

  public void execute(DelegateExecution execution) throws Exception {

   // CustomerData customerData = (CustomerData) execution.getVariable("customerData");

    JacksonJsonNode customerDataJson = (JacksonJsonNode) execution.getVariable("customerData");
    CustomerData customerData = customerDataJson.mapTo(CustomerData.class);

    LOG.info("\n\n\n    processing rating for customer "+customerData+"\n\n\n");

  }

}