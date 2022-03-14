package group.project.api;

import group.project.api.utils.lifecycle.BootstrapActions;
import group.project.api.utils.lifecycle.EndActions;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Value("${app.profile}")
	private String profile;

	@Autowired
	BootstrapActions bootstrapActions;

	@Autowired
	EndActions endActions;

	@PostConstruct
	public void post() {
		bootstrapActions.executeActions();
	}

	@PreDestroy
	public void pre() {
		endActions.executeActions();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
