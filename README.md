# TodoApp

TodoApp is a full-stack application for managing tasks effectively. The application features a responsive frontend built with React and TypeScript and a robust backend powered by Java and Spring Boot. With features like CRUD operations for todos, and a clean user interface, TodoApp is designed to make task management simple and intuitive.

## Features

- Create, Read, Update, and Delete (CRUD) operations for tasks.
- Responsive design for seamless use across devices.
- Backend API developed with Spring Boot.
- Frontend built with React and TypeScript.
- Persistent storage using MySQL/PostgreSQL.

## Tech Stack

### Frontend
- React
- TypeScript
- Axios (for API calls)
- Material-UI (for styling, optional)

### Backend
- Java
- Spring Boot
- Spring Security (for authentication and authorization)
- Hibernate (for ORM)
- MySQL/PostgreSQL (for database)

### Other Tools
- Maven (for build automation)
- Node.js & npm (for frontend package management)

## Prerequisites

- Node.js (v16 or later)
- Java (JDK 17 or later)
- Maven (v3.8 or later)
- MySQL/PostgreSQL (latest version preferred)

## Setup Instructions

### Backend Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/TodoApp.git
   cd TodoApp/todo_app
   ```

2. Configure the database:
   - Update `application.properties` or `application.yml` in `src/main/resources` with your database credentials:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/todoapp
     spring.datasource.username=yourusername
     spring.datasource.password=yourpassword

     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     ```

3. Build and run the backend:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. The backend API will be available at `http://localhost:8080`.

### Frontend Setup

1. Navigate to the frontend directory:
   ```bash
   cd ../frontend
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Configure the API endpoint:
   - Update the API base URL in `src/config/api.ts`:
     ```typescript
     export const API_BASE_URL = "http://localhost:8080/api";
     ```

4. Start the frontend:
   ```bash
   npm start
   ```

5. The frontend will be available at `http://localhost:3000`.

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-name`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature-name`).
5. Open a pull request.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.

---

Happy coding!

