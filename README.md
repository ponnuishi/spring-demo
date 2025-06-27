# Spring Demo Application

A Spring Boot application demonstrating REST APIs using in-memory collections.

## Project Structure

```
src/main/java/com/java/training/spring/spring_demo/
├── model/
│   └── User.java                    # User entity model
├── service/
│   └── UserService.java             # Business logic with in-memory operations
├── controller/
│   └── UserController.java          # REST API endpoints
├── UsersController.java             # Legacy controller with API info
└── SpringDemoApplication.java       # Main application class
```

## API Endpoints

### Base URL: `http://localhost:8080`

### User Management APIs (`/api/users`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/users` | Get all users |
| GET | `/api/users/{id}` | Get user by ID |
| POST | `/api/users` | Create a new user |
| PUT | `/api/users/{id}` | Update user |
| DELETE | `/api/users/{id}` | Delete user |

### Search and Utility APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/users/search?name={name}` | Search users by name |
| GET | `/api/users/age-range?minAge={min}&maxAge={max}` | Get users by age range |
| GET | `/api/users/count` | Get total user count |
| POST | `/api/users/bulk` | Create multiple users |
| GET | `/api/users/health` | Health check |

## Sample Usage

### Create a User
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Alice Johnson",
    "email": "alice@example.com",
    "age": 28
  }'
```

### Get All Users
```bash
curl http://localhost:8080/api/users
```

### Search Users by Name
```bash
curl "http://localhost:8080/api/users/search?name=john"
```

### Get Users by Age Range
```bash
curl "http://localhost:8080/api/users/age-range?minAge=25&maxAge=35"
```

## Features

- **In-Memory Storage**: Uses HashMap for data persistence during runtime
- **CRUD Operations**: Complete Create, Read, Update, Delete functionality
- **Search Capabilities**: Search by name and filter by age range
- **Bulk Operations**: Create multiple users at once
- **Proper Package Structure**: Organized into model, service, and controller packages
- **RESTful Design**: Follows REST API conventions
- **Error Handling**: Proper HTTP status codes and error responses

## Running the Application

1. Make sure you have Java 8+ and Gradle installed
2. Run the application:
   ```bash
   ./gradlew bootRun
   ```
3. The application will start on `http://localhost:8080`
4. Visit `http://localhost:8080/` to see available APIs

## Sample Data

The application comes pre-loaded with sample users:
- John Doe (john@example.com, age 30)
- Jane Smith (jane@example.com, age 25)
- Bob Johnson (bob@example.com, age 35) 