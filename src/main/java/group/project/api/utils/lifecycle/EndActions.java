package group.project.api.utils.lifecycle;

import group.project.api.utils.lifecycle.jobs.ApplicationLifecycleJob;
import group.project.api.utils.lifecycle.jobs.end.EndLoggerJob;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EndActions extends ApplicationLifecycleActions {

    public EndActions() {
        super();
        List<ApplicationLifecycleJob> jobs = new ArrayList<>();

        jobs.add(new EndLoggerJob());

        this.jobs = jobs;
    }


}
