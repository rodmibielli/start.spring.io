package io.spring.start.site.web.project;

import io.spring.initializr.web.project.WebProjectRequest;

public class ExtendProjectRequest extends WebProjectRequest {

    private boolean dockerizable;

    public boolean isDockerizable() {
        return dockerizable;
    }

    public void setDockerizable(boolean dockerizable) {
        this.dockerizable = dockerizable;
    }
}
