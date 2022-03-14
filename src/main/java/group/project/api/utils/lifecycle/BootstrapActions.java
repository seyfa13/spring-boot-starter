package group.project.api.utils.lifecycle;

import group.project.api.utils.lifecycle.jobs.ApplicationLifecycleJob;
import group.project.api.utils.lifecycle.jobs.bootstrap.BoostrapLoggerJob;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Called at the construction of the application
 */
@Service
public class BootstrapActions extends ApplicationLifecycleActions {

    public BootstrapActions() {
        super();
        List<ApplicationLifecycleJob> jobs = new ArrayList<>();

        jobs.add(new BoostrapLoggerJob());

        this.jobs = jobs;
    }

}
