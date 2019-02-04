package be.deltis.documentarchiver11;

import org.apache.camel.spring.boot.CamelSpringBootApplicationController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DocumentArchiver11Application {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(DocumentArchiver11Application.class);
		springApplication.setHeadless(false);
		ApplicationContext applicationContext = springApplication.run(args);
		CamelSpringBootApplicationController applicationController = applicationContext.getBean(CamelSpringBootApplicationController.class);
		applicationController.run();
	}

}

