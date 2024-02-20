# Programming Exercise

This project is a Spring Boot application that provides RESTful APIs for managing orders.

## Technologies Used

- Spring Boot
- Spring Data JPA
- Hibernate
- Postgres DB
- Maven

## Prerequisites

- Java Development Kit (JDK) version 17 or higher
- Maven
- IDE (like IntelliJ IDEA or Eclipse)
- Docker/Docker-compose

## Getting Started

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/programming-exercise.git
    ```

2. Navigate to the project directory:

    ```bash
    cd programming-exercise
    ```

3. Build the project:

    ```bash
    mvn clean install
    ```

4. build the container.
   ```bash
    docker-compose build
    ```
4. Run the application:

    ```bash
    docker-compose up
    ```

5. The application will start running at `http://localhost:8080`.

## API Endpoints

- **GET /api/orders**: Get a list of all orders.
- **POST /api/orders**: Create a new order.
- **GET /api/orders/{id}**: Get an order by ID.
- **PUT /api/orders/{id}**: Update an existing order.
- **DELETE /api/orders/{id}**: Delete an order by ID.
- **GET /api/products**: Get a list of all orders.
- **POST /api/products**: Create a new order.
- **GET /api/products/{id}**: Get an order by ID.
- **PUT /api/products/{id}**: Update an existing order.
- **DELETE /api/products/{id}**: Delete an order by ID.
- **GET /api/orderitems**: Get a list of all orders.
- **POST /api/orderitems**: Create a new order.
- **GET /api/orderitems/{id}**: Get an order by ID.
- **PUT /api/orderitems/{id}**: Update an existing order.
- **DELETE /api/orderitems/{id}**: Delete an order by ID.
- 
## Testing

To run tests, execute:

```bash
mvn test
