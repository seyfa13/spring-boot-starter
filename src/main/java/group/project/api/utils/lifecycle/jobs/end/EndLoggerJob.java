package group.project.api.utils.lifecycle.jobs.end;

import group.project.api.Application;
import group.project.api.utils.lifecycle.jobs.ApplicationLifecycleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndLoggerJob implements ApplicationLifecycleJob {

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    @Override
    public void doAction() {
        logger.info("Application ended");
        System.err.println("Application ended");
    }
}
