# Country Routing Service

This is a Spring Boot application that calculates the shortest land route between two countries based on their borders. The service exposes a REST endpoint that returns the route from the origin country to the destination country.

## Features

- Calculates the shortest land route between two countries.
- Returns the route as a list of country codes (`cca3`).
- If no route exists, returns an HTTP 400 error.

## Requirements

- Java 11 or higher
- No need to install Maven; the project uses the Maven Wrapper (`mvnw`).

## Running the Application

You can build and run the application directly using the Maven Wrapper. Follow these steps:

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/your-username/country-routing-service.git
    cd country-routing-service
    ```

2. **Run the Application:**

   Use the Maven Wrapper to run the application:

   On Unix-based systems (Linux, macOS):

    ```bash
    ./mvnw spring-boot:run
    ```

   On Windows:

    ```bash
    .\mvnw spring-boot:run
    ```

   This command will compile the source code and start the Spring Boot application on the default port `8080`.

3. **Accessing the REST Endpoint:**

   The service exposes the following endpoint:

    - **GET /routing/{origin}/{destination}**

        - `origin`: The `cca3` code of the origin country (e.g., `CZE`).
        - `destination`: The `cca3` code of the destination country (e.g., `ITA`).

   Example request:

    ```bash
    curl -X GET "http://localhost:8080/routing/CZE/ITA"
    ```

   Example response:

    ```json
    {
      "route": ["CZE", "AUT", "ITA"]
    }
    ```

   If no route exists, the service will return a `400 Bad Request` response.

## Testing the Application

The application includes unit tests that can be run with the Maven Wrapper:

On Unix-based systems:

```bash
./mvnw test
```

On Windows:

bash

```bash
.\mvnw test
```

This will execute the test suite and provide feedback on the application's correctness.

## Configuration

The country data is loaded from a JSON file located in the src/main/resources/countries.json file. Ensure this file is correctly populated with the necessary country data.

## Deployment

To deploy the application, you can build and run the JAR file on any server with Java 11+ installed. Alternatively, you can create a Docker image or deploy it to a cloud platform like AWS, Azure, or Google Cloud.

## Contributing

Contributions are welcome! Please fork the repository, create a feature branch, and submit a pull request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.