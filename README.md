# spring-shell-utils

## Introduction
[Spring Shell](https://spring.io/projects/spring-shell) is a great way for developers to create interactive shell applications. This utility collection provides extra features to help develop Spring Shell solutions.

### Features
- Custom exit command useful when shell commands include reactive code with unexpired threads.
- Progress bar and counter utils for updating user during long running processes.
- Progress services with managed threads for progress notifications during long running processes with non deterministic progress.
- Shell helper for colored output, cursor and line control, and programmatic screen clearing.
- Custom startup banner support.
- Custom prompt support.
- Many options can be configured via application.(yml|properties) file.
