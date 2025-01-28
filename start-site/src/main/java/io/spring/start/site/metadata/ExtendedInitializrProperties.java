package io.spring.start.site.metadata;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.spring.initializr.metadata.InitializrProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "extend.initializr")
public class ExtendedInitializrProperties  {

    @NestedConfigurationProperty
    private InitializrProperties env;

    @JsonIgnore
    private boolean dockerizable;

    public ExtendedInitializrProperties(InitializrProperties env,boolean dockerizable) {
        this.env = env;
        this.dockerizable = dockerizable;
    }

    public boolean isDockerizable() {
        return dockerizable;
    }

    public InitializrProperties getEnv() {
        return env;
    }

    public void merge(ExtendedInitializrProperties other) {
        this.dockerizable = this.dockerizable || other.dockerizable;
    }

    @Override
    public String toString() {
        return "ExtendedInitializrProperties{" +
                "env=" + getEnv() +
                ", dockerizable=" + dockerizable +
                '}';
    }
}
