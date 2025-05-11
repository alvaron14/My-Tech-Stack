# My Tech Stack

> **⚠️ Work in Progress**  
> This repository is currently under development. Features and structure might change as work progresses.


Welcome to my **Tech Stack** repository! This repository serves as a showcase of my Java development journey, tools, frameworks, and technologies I commonly use.

## 📚 About

This project is a collection of resources and examples that highlight my expertise in Java programming. It showcases:
- Core Java concepts and applications.
- Frameworks and tools I actively use in my projects.
- Best practices and design patterns I follow.
- Code samples and project highlights.

## 🛠️ Tools and Frameworks

Here are some of the tools and frameworks that are part of my Java tech stack:
- **Spring Framework**: For building robust and scalable applications.
- **Maven**: For dependency management and build automation.
- **JUnit**: For unit testing and ensuring code quality.
- **SonarCloud**: For continuous code quality and static code analysis.
- **GitHub Actions**: For automating workflows, CI/CD pipelines, and deployment processes.

## 🚀 Getting Started

### Requirements
  - Java 23
  - Maven 3.9.9

### Installation

#### Clone the repository

```bash
git clone https://github.com/alvaron14/My-Tech-Stack.git
```

#### Build the app & generate resources

```bash
mvn clean install -DskipTests
```

#### Run the app

```bash
cd boot
mvn spring-boot:run
```

## 📂 Project Structure

This repository follows the **Domain-Driven Design (DDD)** principle to organize its structure. The key components include:

- `/domain`: Contains core business logic and domain models.
- `/application`: Handles application-level logic, such as use cases and service orchestration.
- `/api-rest`: Handles the controllers of the app to manage REST API calls. Technically is part of the infrastructure
- `/infrastructure`: Includes database interaction, external APIs, and other infrastructure-related concerns.
- `/boot`: Configuration of the **Spring Boot** framework.
- `/framework`: Enables the implementation of design patterns such as **CQRS** and **DDD notations**.
- `/api-definitions`: Contains the `openapi.yml` definition of the API contract and is used to build REST APIs in `/api-rest`.

## 📈 Future Plans

In the future, I plan to:

    Implement two new codebases that will interact between eachothers using REST protocol and Kafka
