# OOP Logger Interface

Simple extensible logger implementation in Java.

## Features
- Logger interface
- ConsoleLogger
- FileLogger
- LogLevel support (INFO, WARN, ERROR)
- Level-based filtering (Decorator pattern)
- Full JUnit 5 test coverage
- Maven build

## Example
```java
Logger c = LoggerFactory.withMinLevel(
    LoggerFactory.console(),
    LogLevel.WARN
);

c.log(LogLevel.INFO, "not printed");
c.log(LogLevel.ERROR, "printed");

## Build & Test

```bash
mvn clean test

