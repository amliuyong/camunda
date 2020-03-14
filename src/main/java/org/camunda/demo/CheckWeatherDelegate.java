package org.camunda.demo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.logging.Logger;

@Component("CheckWeather")
public class CheckWeatherDelegate implements JavaDelegate {
    private final Logger LOGGER = Logger.getLogger(CheckWeatherDelegate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("CheckWeatherDelegate ....");
        LOGGER.info("\n\n  ... CheckWeatherDelegate invoked by "
                + "\nprocessDefinitionId=" + delegateExecution.getProcessDefinitionId()
                + ", \nactivtyId=" + delegateExecution.getCurrentActivityId()
                + ", \nactivtyName='" + delegateExecution.getCurrentActivityName() + "'"
                + ", \nprocessInstanceId=" + delegateExecution.getProcessInstanceId()
                + ", \nbusinessKey=" + delegateExecution.getProcessBusinessKey()
                + ", \nexecutionId=" + delegateExecution.getId()
                + " \n\n");
        boolean ok = new Random().nextBoolean();
        LOGGER.info("isWeatherOk: " + ok);
        delegateExecution.setVariable("isWeatherOk", ok);

       for(String varName: delegateExecution.getVariableNames() ) {
          Object varValue =   delegateExecution.getVariable(varName);
          LOGGER.info(String.format("\t%s=%s", varName, varValue));
       }
    }
}
