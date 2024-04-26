# Pulse

Welcome to Pulse, a Reddit clone built with Spring! Pulse aims to provide a platform for users to discover, share, and discuss content on various topics.

## Features
- **User Authentication and Authorization**: Allow users to register, login, and manage their accounts.
- **Post Creation and Voting**: Enable users to create posts, vote on posts, and comment on posts.
- **Community Creation**: Allow users to create and manage communities for specific topics.


## Technologies Used
- Spring Boot
- Spring Security
- Rest Template
- MySQL DB (or your preferred database)
- Hibernate (or your preferred ORM)
- Maven (or Gradle) for dependency management
- Git for version control

## Prerequisites
Before you begin, ensure you have met the following requirements:
- Java Development Kit (JDK) 8 or later installed on your machine.
- Maven installed on your machine for building and managing dependencies.
- MySQL DB or a compatible relational database installed and configured.
- Git installed on your machine for version control.


## Installation
Follow these steps to set up and run Pulse on your local machine:

1. **Clone the repository:**
   ```sh
   git clone https://github.com/i-am-tj/Pulse.git
   
2. **Navigate to the project directory:**
    ```sh
   cd Pulse
3. **Configure the database:** \
   Open src/main/resources/application.properties and modify the database settings as needed.
4. **Build the project:**
    ```sh
   mvn clean install
5. **Run the application:**
    ```sh
   mvn spring-boot:run
6. **Access Pulse in your browser:** \
   Open a web browser and go to http://localhost:8080 to access Pulse.

## Docker
This project is also Dockerized. Below are the instructions to pull and use the Docker image from Docker Hub.

### Prerequisites

Before you begin, ensure you have Docker installed on your system. If not, you can download and install it from [here](https://docs.docker.com/get-docker/)

### Pulling the Docker Image

You can pull the Docker image for this project from Docker Hub using the following command:

```bash
docker pull tanujchakraborty21/pulse:1.0
```

### Running the Docker Container

Once you have pulled the image, you can run a container using the following command:

```bash
docker run -p 8080:8080 tanujchakraborty21/pulse:1.0
```

This will start the Spring Boot application inside a Docker container, and you can access it at http://localhost:8080 in your web browser.

## Swagger UI
Pulse includes Swagger UI for interactive API documentation. To access Swagger UI, follow these steps:

1. Run the application as described in the installation instructions.
2. Open a web browser and go to http://localhost:8080/swagger-ui.html.
3. Explore the available API endpoints and test them directly from the Swagger UI interface.


## Contribution Guidelines

Please read our [Contribution Guidelines](CONTRIBUTING.md) to learn how to contribute to this project.

## Code of Conduct

We expect all contributors to adhere to our [Code of Conduct](CODE_OF_CONDUCT.md) to ensure a welcoming and inclusive community.

## License

This project is licensed under the [MIT License](LICENSE) - see the [LICENSE](LICENSE) file for details.


## Contact

If you have any questions, suggestions, or need assistance, feel free to reach out:

- **Name:** Tanuj Chakraborty
- **Email:** tanuj.chakraborty21@gmail.com
- **GitHub:** [github.com/i-am-tj](https://github.com/i-am-tj)
- **LinkedIn:** [linkedin.com/in/i-am-tj](https://www.linkedin.com/in/i-am-tj/)