package io.spring.start.site.web.generator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import io.spring.initializr.web.project.*;
import io.spring.start.site.web.project.ExtendProjectRequest;
import org.apache.commons.lang3.StringUtils;

import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.metadata.InitializrMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Converts the extended project request to description converter.
 * @author rodrigo
 *
 */
public class ExtendProjectRequestToDescriptionConverter implements ProjectRequestToDescriptionConverter<ExtendProjectRequest> {

    private static final Logger log = LoggerFactory.getLogger(ExtendProjectRequestToDescriptionConverter.class);
    private final ProjectRequestPlatformVersionTransformer platformVersionTransformer;

    private final DefaultProjectRequestToDescriptionConverter delegate;

    public ExtendProjectRequestToDescriptionConverter(ProjectRequestPlatformVersionTransformer platformVersionTransformer) {
        this.platformVersionTransformer = platformVersionTransformer;
        this.delegate = new DefaultProjectRequestToDescriptionConverter(platformVersionTransformer);
    }

    @Override
    public ProjectDescription convert(ExtendProjectRequest request, InitializrMetadata metadata) {

        log.info("Dockerizable: "+request.isDockerizable());

        /*
        ExtendInitializrMetadata extendedMetadata = (ExtendInitializrMetadata) metadata;

        validate(request, extendedMetadata);

        addArchitectureImplicitDependencies(request, extendedMetadata);

         */

        ProjectDescription description = delegate.convert(request, metadata);

        return description;

    }

    /*
    private void validate(ExtendProjectRequest request, ExtendInitializrMetadata metadata) {
        validateArchitecture(request.getArchitecture(), metadata);
    }

    private void validateArchitecture(String architectureId, ExtendInitializrMetadata metadata) {

        if (StringUtils.isNotBlank(architectureId)) {

            var architecture = metadata.getArchitecture().get(architectureId);

            if (architecture == null) {
                throw new InvalidProjectRequestException("Unknown architecture id '" + architectureId + "' check project metadata");
            }

        }

    }

    private void addArchitectureImplicitDependencies(final ExtendProjectRequest request, final ExtendInitializrMetadata metadata) {

        var architecture = metadata.getArchitecture().get(request.getArchitecture());

        List<String> implicitDependenciesIds =  metadata.getDependencies().getAll().stream().filter( dependency -> !Collections.disjoint(dependency.getFacets(), architecture.getFacets())).map(Dependency::getId).collect(Collectors.toList());

        if (!implicitDependenciesIds.isEmpty()) {

            log.info("Adding {} implicit dependencies to request for architecture facets {}",implicitDependenciesIds,architecture.getFacets());

            var resolvedDependencies = request.getDependencies();

            resolvedDependencies.addAll(implicitDependenciesIds);

        } else {

            log.warn("No implicit dependency was found for facets {}",architecture.getFacets());
        }

    }

    private Version getSpringBootPlatformVersion(final ExtendProjectRequest request, final InitializrMetadata metadata) {
        var versionText = request.getBootVersion() != null ? request.getBootVersion()
                : metadata.getBootVersions().getDefault().getId();
        return this.platformVersionTransformer.transform(VersionUtils.parse(versionText), metadata);
    }
*/
}
