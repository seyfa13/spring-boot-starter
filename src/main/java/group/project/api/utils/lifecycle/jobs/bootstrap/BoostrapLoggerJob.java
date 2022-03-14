package group.project.api.utils.lifecycle.jobs.bootstrap;

import group.project.api.Application;
import group.project.api.utils.lifecycle.jobs.ApplicationLifecycleJob;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

public class BoostrapLoggerJob implements ApplicationLifecycleJob {

    private static Logger logger = Logger.getLogger(Application.class);

    @Override
    public void doAction() {
        System.err.println("Application Started");
    }
}
