package com.deployment.deployment;

import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/v1/deployment-service")
public class DeploymentController {

    private final ZeebeClient zeebeClient;

    public DeploymentController() {
        this.zeebeClient = ZeebeClient.newClientBuilder()
                .usePlaintext()
                .build();
    }

    @PostMapping("/start-deployment")
    public ResponseEntity<String> deployZeebeClient() {
        try {
            zeebeDeployerEngine();
            return ResponseEntity.ok("Deployment started successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Deployment failed: " + e.getMessage());
        }
    }

    @PostMapping("/start-process")
    public ResponseEntity<String> startProcess() {
        try {
            zeebeStartProcess();
            return ResponseEntity.ok("Process started successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Process start failed: " + e.getMessage());
        }
    }

    public void zeebeDeployerEngine() {
        zeebeClient.newDeployResourceCommand()
                .addResourceFromClasspath("newDiagram.bpmn")
                .send()
                .join();
        System.out.println("Deployed successfully");
    }

    public void zeebeStartProcess() {
        zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId("zeebeEngineTest")
                .latestVersion()
                .send()
                .join();
        System.out.println("Process started successfully");
    }
}
