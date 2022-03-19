package group.project.api.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTasks {

    private static Logger logger = LoggerFactory.getLogger(TestTasks.class);

    @Scheduled(cron = "0 * * * * *")
    public void testTasks() {
        logger.error("Cron");
    }

}
