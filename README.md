# Task Management REST API

A simple Spring Boot REST API for managing tasks with PostgreSQL database.

## Features
- Create, read, update, and delete tasks
- Filter tasks by status (PENDING, IN_PROGRESS, COMPLETED)
- Automatic timestamps for task creation and updates

## Tech Stack
- Spring Boot 4.0.1
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

## API Endpoints

### Base URL: `http://localhost:8081/api/tasks`

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/tasks` | Get all tasks |
| GET | `/api/tasks/{id}` | Get task by ID |
| GET | `/api/tasks/status/{status}` | Get tasks by status |
| POST | `/api/tasks` | Create new task |
| PUT | `/api/tasks/{id}` | Update existing task |
| DELETE | `/api/tasks/{id}` | Delete task |

## Request/Response Examples

### Create Task
```json
POST /api/tasks
{
  "title": "Complete documentation",
  "description": "Write API documentation",
  "status": "PENDING"
}
```

### Response
```json
{
  "id": 1,
  "title": "Complete documentation",
  "description": "Write API documentation",
  "status": "PENDING",
  "createdAt": "2024-01-15T10:30:00",
  "updatedAt": "2024-01-15T10:30:00"
}
```

## Task Status Values
- `PENDING`
- `IN_PROGRESS`
- `COMPLETED`

## Setup
1. Ensure PostgreSQL is running on localhost:5432
2. Create database named `studenDB`
3. Run: `mvn spring-boot:run`
4. API available at: http://localhost:8081

## Database
- Database: PostgreSQL
- Table: `tasks` (auto-created)
- Connection: localhost:5432/studenDB