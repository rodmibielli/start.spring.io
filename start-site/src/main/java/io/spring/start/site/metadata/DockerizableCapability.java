package io.spring.start.site.metadata;

import io.spring.initializr.metadata.Defaultable;
import io.spring.initializr.metadata.ServiceCapability;
import io.spring.initializr.metadata.ServiceCapabilityType;

/**
 * Capability to check whether it will be dockerizable.
 */
public class DockerizableCapability extends ServiceCapability<Boolean> implements Defaultable<Boolean> {

    private boolean toDocker;

    public DockerizableCapability() {
        super("dockerizable", ServiceCapabilityType.SINGLE_SELECT,"Docker","It will create a docker-compose project.");
    }

    @Override
    public Boolean getDefault() {
        return true;
    }

    @Override
    public Boolean getContent() {
        return toDocker;
    }

    @Override
    public void merge(Boolean otherContent) {

        if (otherContent!=null) {
            this.toDocker = toDocker || otherContent;
        }
    }
}
