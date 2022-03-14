package group.project.api.scheduled;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTasks {

    private static Logger logger = Logger.getLogger(TestTasks.class);

    @Scheduled(cron = "0 * * * * *")
    public void testTasks() {
        logger.error("Cron");
    }

}
