# Maven + Jenkins Demo

This repository is a simple Spring Boot application that exposes a `/time` REST endpoint returning the current server time (ISO instant). It is designed to teach how Maven fits into a Jenkins CI pipeline.

## What is included
- A Maven `pom.xml` configured for Spring Boot and JUnit 5 tests.
- A simple controller `/time` returning the current timestamp.
- A JUnit test that exercises the endpoint.
- A `Jenkinsfile` demonstrating a simple pipeline:
  - Checkout
  - Build & Test (`mvn verify`)
  - Package and archive artifact

## Run locally
Requirements: Java 17+, Maven 3.6+
```bash
mvn -B clean package
java -jar target/maven-jenkins-demo-0.0.1-SNAPSHOT.jar
# then visit http://localhost:8080/time
```

## Setup in Jenkins
1. Create a new pipeline job and point it to this repo.
2. Ensure Jenkins has a JDK and Maven tool configured (names must match the Jenkinsfile tool names).
3. Run the pipeline; it will run `mvn verify` (tests) then package and archive the jar.
4. Configure post-build actions or downstream jobs as needed (e.g., Docker build or deployment).

## Notes
- The `Jenkinsfile` uses shell commands; on Windows agents switch to `bat` steps.
- Adjust Maven tool name in `tools { maven 'Maven3' }` to match your Jenkins global tools config.
