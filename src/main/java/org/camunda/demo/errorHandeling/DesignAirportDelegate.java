package org.camunda.demo.errorHandeling;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("DesignAirportDelegate")
public class DesignAirportDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        String airportCode = (String)execution.getVariable("airportCode");
        Boolean airportNeedsConstruction = null;

        System.out.println("DesignAirportDelegate .....");
        System.out.println("airportCode:" + airportCode);

        if(airportCode.equals("BER")) {
            System.out.println("Berlin Brandenburg Airport -: It needs all the help it can get");
            airportNeedsConstruction = true;
            //throw new BpmnError("Airport_to_small");

        } else if (airportCode.equals("TXL")) {
            System.out.println("Tegal Airport -: It's basically falling appart but thats the way we like it");
            airportNeedsConstruction = false;

        }else if (airportCode.equals("THF")) {
            System.out.println("Tempelhof -: A lovely place to fly a kite, best to leave it that way");
            airportNeedsConstruction = false;

        }else if (airportCode.equals("SXF")) {
            System.out.println("Schönefeld Airport -: Feels like Half airport, half medium security prison");
            airportNeedsConstruction = false;

        }else {
            System.out.println("This airport code doesn't match.... ");
            airportNeedsConstruction = null;
            throw new BpmnError("Wrong_Code");
        }

        execution.setVariable("airportNeedsConstruction", airportNeedsConstruction);

    }

}
