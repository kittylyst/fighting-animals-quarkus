FROM registry.access.redhat.com/ubi8/openjdk-17:1.19

ENV LANGUAGE='en_US:en'


# We make four distinct layers so if there are application changes the library layers can be re-used
COPY --chown=185 target/quarkus-app/lib/ /deployments/lib/
COPY --chown=185 target/quarkus-app/*.jar /deployments/
COPY --chown=185 target/quarkus-app/app/ /deployments/app/
COPY --chown=185 target/quarkus-app/quarkus/ /deployments/quarkus/

EXPOSE 8083
USER 185

WORKDIR /app
CMD ["java", "-Dotel.traces.exporter=none", "-Dotel.service.name=fish-app", "-Dquarkus.http.port=8083", "-Dquarkus.package.main-class=io.opentelemetry.examples.fish.FishApplication", "-jar" , "/deployments/quarkus-run.jar"]
