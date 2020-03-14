package org.camunda.demo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


/**
 * This is an easy adapter implementation 
 * illustrating how a Java Delegate can be used 
 * from within a BPMN 2.0 Service Task.
 */
@Component("logger")
public class LoggerDelegate implements JavaDelegate {
 
  private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());
  
  public void execute(DelegateExecution execution) throws Exception {
    LOGGER.info("\n\n  ... LoggerDelegate invoked by "
            + "\nprocessDefinitionId=" + execution.getProcessDefinitionId()
            + ", \nactivtyId=" + execution.getCurrentActivityId()
            + ", \nactivtyName='" + execution.getCurrentActivityName() + "'"
            + ", \nprocessInstanceId=" + execution.getProcessInstanceId()
            + ", \nbusinessKey=" + execution.getProcessBusinessKey()
            + ", \nexecutionId=" + execution.getId()
            + " \n\n");

    for(String varName: execution.getVariableNames() ) {
      Object varValue =   execution.getVariable(varName);
      LOGGER.info(String.format("\t%s=%s", varName, varValue));
    }
  }

}
