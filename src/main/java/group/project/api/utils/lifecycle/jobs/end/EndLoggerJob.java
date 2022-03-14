package group.project.api.utils.lifecycle.jobs.end;

import group.project.api.Application;
import group.project.api.utils.lifecycle.jobs.ApplicationLifecycleJob;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

public class EndLoggerJob implements ApplicationLifecycleJob {

    private static Logger logger = Logger.getLogger(Application.class);

    @Override
    public void doAction() {
        logger.info("Application ended");
        System.err.println("Application ended");
    }
}
