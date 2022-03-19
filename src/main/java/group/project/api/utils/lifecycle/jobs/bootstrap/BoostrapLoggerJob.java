package group.project.api.utils.lifecycle.jobs.bootstrap;

import group.project.api.Application;
import group.project.api.utils.lifecycle.jobs.ApplicationLifecycleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoostrapLoggerJob implements ApplicationLifecycleJob {

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    @Override
    public void doAction() {
        System.err.println("Application Started");
    }
}
