//package com.deployment.deployment;
//
//import io.camunda.zeebe.client.ZeebeClient;
//import io.camunda.zeebe.client.api.response.ProcessInstanceEvent;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ZeebeDeployerEngine {
//
////    public void zeebeDeployerEngine() {
////        ZeebeClient zeebeClient = ZeebeClient.newClientBuilder().build();
////
////        //Deploy the process
////        zeebeClient.newDeployResourceCommand()
////                .addResourceFromClasspath("newDiagram.bpmn")
////                .send()
////                .join();
////        System.out.println("deployed successfully");
////    }
//
////    public void zeebeProcessEngine(){
////        ZeebeClient zeebeClient = ZeebeClient.newClientBuilder().build();
////
////        // Start the process instance
////        final ProcessInstanceEvent event = zeebeClient.newCreateInstanceCommand()
////                .bpmnProcessId("zeebeEngineTest")
////                .latestVersion()
////                .send()
////                .join();
////    }
//}
