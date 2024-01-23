# PortfolioPilot 

---

## Table of Contents

1. **Project Setup:**
   - Initialize a new Spring Boot project using the latest version.
   - Use Gradle for build automation.
   - Set up your project structure with packages for controllers, services, models, etc.

2. **Database Setup:**
   - Connect Spring Boot with MySQL using Spring Data JPA for easy database interactions.
   - Design the database schema to store user portfolios, stock holdings, and related information.

3. **User Interface:**
   - Develop the user interface using React or your chosen frontend framework.
   - Create intuitive forms for users to input and manage their stock holdings.

4. **Backend Logic:**
   - Implement the backend logic for portfolio tracking and calculations.
   - Utilize Spring Boot controllers and services to handle user requests and business logic.

5. **Graphical Projections:**
   - Integrate Chart.js or your preferred charting library to visualize potential returns.
   - Implement features to show graphical projections over various periods.

6. **Key Statistics:**
   - Calculate and display key financial metrics, such as % interest P.A., for each portfolio.

7. **Documentation:**
   - Document the project setup, database schema, and codebase.
   - Write clear instructions for setting up and running the project locally.
   - Include details about the technologies used, libraries, and their versions.

8. **Version Control:**
   - Use Git for version control and regularly commit your changes.
   - Host your project on GitHub to showcase it in your portfolio.

9. **Testing:**
   - Implement unit tests to ensure the reliability of your code.
   - Test the application thoroughly to identify and fix any bugs.

10. **Deployment:**
    - Consider deploying your project to a platform like Heroku for live testing.
    - Include deployment instructions in your documentation.

---

## Project Setup

### Connecting to GitHub in Visual Studio Code:

1. Open your project in Visual Studio Code.

2. Install the Git extension if you haven't already. You can do this by searching for "GitLens" in the Extensions view and installing it.

3. Initialize a new Git repository in your project by running the following commands in the terminal:

```bash
git init
```

4. Create a new repository on GitHub (let's say it's named "PortfolioPilot").

5. Copy the repository URL provided by GitHub.

6. Add the remote repository to your local project:

```bash
git remote add origin <repository_url>
```

7. Now, you can stage and commit your changes:

```bash
git add .
git commit -m "Initial commit"
```

8. Push your code to GitHub:

```bash
git push -u origin master
```

Your project is now connected to GitHub.

---

### Initialize a new Spring Boot project:

```bash
spring init --dependencies=web,data-jpa,mysql --language=java --package-name=com.yourname.portfoliopilot PortfolioPilot
```

Replace "com.yourname" with your actual package structure.

2. **Add necessary dependencies in `build.gradle` for Chart.js, React, and other frontend tools.**

```gradle
dependencies {
    // other dependencies...

    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'mysql:mysql-connector-java'
}
```

---

### Create the project structure:

   - Under `src/main/java`, create packages like `com.yourname.portfoliopilot.controllers`, `com.yourname.portfoliopilot.services`, etc.
   - Under `src/main/resources`, add an `application.properties` file for Spring Boot configuration.

1. **Controllers:**
   - Create a package `com.yourname.portfoliopilot.controllers` to store your Spring MVC controllers.
   - Controllers handle incoming HTTP requests and define the endpoints of your application.

2. **Services:**
   - Establish a package `com.yourname.portfoliopilot.services` for your business logic and service classes.
   - Services contain the core functionality of your application, handling data processing and business rules.

3. **Models:**
   - Add a package `com.yourname.portfoliopilot.models` for your data models.
   - Models represent the structure of your data entities, such as User, Portfolio, Stock, etc.

4. **Repositories:**
   - Create a package `com.yourname.portfoliopilot.repositories` to host Spring Data JPA repositories.
   - Repositories provide an interface for database operations on your entities.

5. **Views (if using server-side rendering):**
   - If you are using server-side rendering, create a package `com.yourname.portfoliopilot.views` for your HTML templates.

6. **Static Resources:**
   - Include a `static` folder under `src/main/resources` to store static resources like CSS, JavaScript, or images for your frontend.

7. **Configuration:**
   - If you have specific configurations, create a package `com.yourname.portfoliopilot.config` to house configuration classes.

8. **Application Entry Point:**
   - Add a main class, typically named `PortfolioPilotApplication`, in the root package (`com.yourname.portfoliopilot`) annotated with `@SpringBootApplication`. This class will serve as the entry point for your Spring Boot application.

Here's a simplified directory structure for better visualization:

```
src
|-- main
|   |-- java
|   |   |-- com
|   |       |-- yourname
|   |           |-- portfoliopilot
|   |               |-- controllers
|   |               |-- services
|   |               |-- models
|   |               |-- repositories
|   |               |-- views
|   |               |-- config
|   |               |-- PortfolioPilotApplication.java
|   |-- resources
|       |-- static
|       |-- templates  // if using server-side rendering
|       |-- application.properties
```

---

### Database Creation:

1. **Install MySQL:**
   - Install MySQL on your local machine or use a cloud-based service.

2. **Create a Database:**
   - Open a MySQL client (like MySQL Workbench or command line) and create a new database:

   ```sql
   CREATE DATABASE your_database_name;
   ```

   Replace `your_database_name` with the desired name for your database.

3. **Database User:**
   - Create a user and grant necessary privileges:

   ```sql
   CREATE USER 'your_username'@'localhost' IDENTIFIED BY 'your_password';
   GRANT ALL PRIVILEGES ON your_database_name.* TO 'your_username'@'localhost';
   FLUSH PRIVILEGES;
   ```

   Replace `your_username` and `your_password` with your preferred credentials.

4. **Set up your MySQL database in `application.properties`:**
   - In your `application.properties` file, set the database URL, username, and password:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

   - Replace `your_database_name`, `your_username`, and `your_password` with your actual database details.

   - The JDBC URL in your `application.properties` specifies how to connect to your MySQL database. Update the URL based on your MySQL setup:

     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
     ```

### Write a simple controller to check if everything is working:

```java
// PortfolioController.java
package com.yourname.portfoliopilot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, PortfolioPilot!";
    }
}
```

---

### Application Entry Point:
   - Add a main class (e.g., `PortfolioPilotApplication.java`) in the root package annotated with `@SpringBootApplication`. This serves as the entry point for your Spring Boot application.

   ```java
   // PortfolioPilotApplication.java
   package com.yourname.portfoliopilot;

   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;

   @SpringBootApplication
   public class PortfolioPilotApplication {

       public static void main(String[] args) {
           SpringApplication.run(PortfolioPilotApplication.class, args);
       }
   ```

---

### Start MySQL Server:

1. **Using MySQL Installer:**
   - Open the MySQL Installer.
   - Click on "MySQL Server" in the product list.
   - Click "Start" to launch the MySQL Server.

2. **Using Command Prompt:**
   - Open Command Prompt as an administrator.
   - Navigate to the MySQL bin directory. It's usually something like:

     ```bash
     cd "C:\Program Files\MySQL\MySQL Server 8.0\bin"
     ```

   - Run the following command:

     ```bash
     mysqld
     ```

---

### Verifying MySQL Server is Running:

Regardless of your operating system, you can verify that your MySQL server is running by checking the MySQL status.

- **Using Terminal or Command Prompt:**
  - Run the following command:

    ```bash
    mysqladmin -u root -p status
    ```

  - You will be prompted to enter your MySQL root password.

If your MySQL server is running, you should see information about the server status.

Remember to stop your MySQL server when you're done working with it. You can use the `mysql.server stop` command on macOS, `brew services stop mysql` if installed with Homebrew, `mysqladmin -u root -p shutdown` on Linux, or stop the MySQL service through the MySQL Installer on Windows.

---

### Run the Spring Boot Application Using Terminal:

1. **Using Command Line:**
   - Navigate to your project directory:
   - Open a terminal (Command Prompt, PowerShell, or Terminal) and change your current directory to your Spring Boot project's root folder.

2. **Build the project:**
   - If you are using Gradle, run:

     ```bash
     ./gradlew build
     ```

3. **Run the application:**
   - Once the build is successful, run the application with the following command:

     ```bash
     ./gradlew bootRun   # for Gradle
     ```

4. **Access the application:**
   - Open your web browser and go to `http://localhost:8080`. If your application is configured differently, adjust the URL accordingly.

---

### Using IDE (e.g., Visual Studio Code, IntelliJ, Eclipse):

1. **Import the project:**
   - Open your IDE and import your Spring Boot project.

2. **Build the project:**
   - Use the built-in tools to build the project. In most IDEs, this involves right-clicking on the project and selecting "Build" or "Rebuild."

3. **Run the application:**
   - Navigate to the main class (e.g., `PortfolioPilotApplication.java`), right-click on it, and select "Run" or "Run As" > "Spring Boot App."

4. **Access the application:**
   - Once the application has started, open your web browser and go to `http://localhost:8080`. Adjust the URL if your application is configured differently.

---

### Note:
- If the default port `8080` is already in use, Spring Boot will automatically try the next available port (e.g., `8081`).
- Make sure your MySQL server is running if your application relies on it.
- Always check the console or terminal for any error messages or logs during the startup process.