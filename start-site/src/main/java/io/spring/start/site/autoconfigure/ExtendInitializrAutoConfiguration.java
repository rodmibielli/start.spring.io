package io.spring.start.site.autoconfigure;

import com.rodmibielli.initializr.metadata.InitializrMetadata;
import com.rodmibielli.initializr.metadata.InitializrMetadataProvider;
import com.rodmibielli.spring.initializr.web.autoconfigure.InitializrWebAutoConfiguration;
import io.spring.initializr.metadata.InitializrProperties;
import io.spring.initializr.web.project.ProjectGenerationInvoker;
import io.spring.initializr.web.project.ProjectRequestPlatformVersionTransformer;
import io.spring.start.site.metadata.DockerizableCapability;
import io.spring.start.site.metadata.ExtendedInitializrProperties;
import io.spring.start.site.web.ExtendProjectGenerationController;
import io.spring.start.site.web.project.ExtendProjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({ExtendedInitializrProperties.class})
@AutoConfigureBefore({InitializrWebAutoConfiguration.class})
public class ExtendInitializrAutoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(ExtendInitializrAutoConfiguration.class);

    /*
    @Bean("projectGenerationController")
    ExtendProjectGenerationController projectGenerationController(InitializrMetadataProvider metadataProvider,
                                                                  ObjectProvider<ProjectRequestPlatformVersionTransformer> platformVersionTransformer,
                                                                  ApplicationContext applicationContext) {

        logger.info("Instantiating ExtendProjectGenerationController... ");

        ExtendProjectRequestToDescriptionConverter converter = new ExtendProjectRequestToDescriptionConverter(
                platformVersionTransformer.getIfAvailable(DefaultProjectRequestPlatformVersionTransformer::new));

        ProjectGenerationInvoker<ExtendProjectRequest> projectGenerationInvoker = new ProjectGenerationInvoker<>(
                applicationContext, null);

        return new ExtendProjectGenerationController(metadataProvider, projectGenerationInvoker);
    }

     */

    @Bean
    public InitializrMetadata initializrMetadata(InitializrProperties initializrProperties,
                                                 ExtendedInitializrProperties extendedInitializrProperties) {

        logger.info("Creating initializr metadata...");

        InitializrMetadata extendedInitializrMetadata = InitializrMetadata.builder(new DockerizableCapability(),initializrProperties)
                                                                .addInitializrProperties(extendedInitializrProperties)
                                                                .build()
                                                                ;

        return extendedInitializrMetadata;
    }

}
