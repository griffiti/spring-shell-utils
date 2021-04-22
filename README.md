# Spring Shell Utils  [![Maven Central](https://img.shields.io/maven-central/v/net.griffiti/spring-shell-utils.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22net.griffiti%22%20AND%20a:%22spring-shell-utils%22)

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

## Getting Started
This project is built with [maven](https://maven.apache.org/) and is [published](https://search.maven.org/search?q=g:%22net.griffiti%22%20AND%20a:%22spring-shell-utils%22) to Maven Central. To get started you can either include as a maven dependency or clone this repo and build locally.

### Maven
Including as a maven dependency is the quickest and easiest way to get started. Just edit your `pom.xml` file and add the following to your dependencies section.

```xml
<dependencies>
  ...
  <dependency>
    <groupId>net.griffiti</groupId>
    <artifactId>spring-shell-utils</artifactId>
    <version>1.0.4</version>
  </dependency>
</dependencies>
```
### Clone Locally
You can also clone this repo locally and build the package. You can then reference the jar file or install to your local maven repo.

```console
git clone https://github.com/griffiti/spring-shell-utils.git
cd spring-shell-utils
mvn clean install -DskipTests
```

## Project Origin
This project was inspired by the original work of [Domagoj Madunic](https://github.com/dmadunic) and the [ag04-shell-utils](https://github.com/ag04/ag04-shell-utils) project.

## License
Spring Shell Utils is open source software released under the [Apache 2.0 license](https://www.apache.org/licenses/LICENSE-2.0.html).
