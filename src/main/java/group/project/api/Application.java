package group.project.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@EnableScheduling
@SpringBootApplication
public class Application {

	private static Logger logger = Logger.getLogger(Application.class);

	@Value("${app.name}")
	private String appName;

	@Value("${app.name}")
	private String profile;

	@PostConstruct
	public void post() {
		logger.info("Application" + appName + " Started with profile '" + profile + "'");
	}

	@PreDestroy
	public void pre() {

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
