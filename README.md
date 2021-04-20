[![Maven Central](https://img.shields.io/maven-central/v/net.griffiti/spring-shell-utils.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22net.griffiti%22%20AND%20a:%22spring-shell-utils%22)

# spring-shell-utils

## Introduction
Spring Shell Utils library provides extra features to help develop Spring Shell applications.

### Features
- Custom exit command with forced system exit. This is useful when shell commands include reactive code with unexpired threads.
- Progress bar and counter utils for updating user during long running processes.
- Progress services with managed threads for progress notifications during long running processes with non deterministic progress.
- Shell helper for colored output, cursor and line control, and programmatic screen clearing.
- Custom startup banner support.
- Custom prompt support.
- Many options can be configured via application.(yml|properties) file.

### Getting Started
This project is built with [maven](https://maven.apache.org/). Simply clone the repo and run `mvn clean install` to get a build in your local repository. Future versions will be available via [Maven Central](https://search.maven.org/).

### Project Origin
This project was inspired by the original work of [Domagoj Madunic](https://github.com/dmadunic) and the [ag04-shell-utils](https://github.com/ag04/ag04-shell-utils) project.
