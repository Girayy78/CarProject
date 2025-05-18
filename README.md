Car Management System
Description
A comprehensive JavaFX desktop application for managing car service appointments and maintenance tasks. The system allows customers to register, log in, add their vehicles, and select various maintenance and service options. Administrators can view all customer service selections.
Key Features

User authentication with role-based access (Admin/Customer)
Car registration and management
Service selection across multiple categories:

Essential Maintenance (tires, fluids, air filters, etc.)
Oil Change Services
Brake Services
Optional Services (car wash, interior cleaning, polishing)


Service history tracking
Admin dashboard for monitoring customer selections

Technologies Used

Java
JavaFX for UI
SQLite for database management
IntelliJ IDEA development environment
CSS for styling

Prerequisites

Java Development Kit (JDK) 11 or higher
JavaFX SDK 11 or higher
SQLite JDBC driver
IntelliJ IDEA 

Installation

Clone the repository:
git clone https://github.com/Girayy78/CarProject.git

Open the project in IntelliJ IDEA:

Select File > Open and navigate to the project directory
Ensure project is configured correctly with the necessary libraries


Set up JavaFX:

Configure JavaFX SDK in project settings
Add the JavaFX library to the project's dependencies
Add the SQLite JDBC driver to the dependencies



Database Setup
The application uses SQLite for data storage. The database file is automatically created as cars.db in the project root directory when the application is first run.
Database includes:

users table: Stores user credentials and car information
service_selections table: Tracks service choices for each user

Running the Application
From IntelliJ IDEA

Navigate to com.example.carmanagement.HelloApplication.java
Right-click and select Run 'HelloApplication.main()'



Project Structure
com.example.carmanagement/
├── AdminDashboardController.java   # Admin dashboard logic
├── AdminLoginController.java       # Admin authentication
├── BrakeServicesController.java    # Brake service options
├── Car.java                        # Car model class
├── CarRegisterController.java      # Vehicle registration
├── CreateTable.java                # Database initialization
├── CustomerDashboardController.java # Customer views
├── CustomerLoginController.java    # Customer authentication
├── DataBase.java                   # Database connection handler
├── EssentialMaintenanceController.java # Basic maintenance services
├── HelloApplication.java           # Main application entry point
├── HomepageController.java         # Main navigation controller
├── LoggedUser.java                 # User session management
├── OilChangeController.java        # Oil service options
├── OptionalServicesController.java # Additional services
├── RegisterController.java         # User registration
├── RoleSelectController.java       # User role selection
├── SceneController.java            # Scene transition handler
├── ServiceSelectionController.java # Service menu controller
└── Vehicle.java                    # Base vehicle class
Usage

Start the application
Select role (Admin or Customer)
For new customers:

Register an account
Register your car
Select desired services


For existing customers:

Log in with credentials
Select desired services


For admins:

Log in as an admin
View customer service selections and vehicle information



Authentication

Admin Access:

Username: [admin username]
Password: [admin password]


Customer Access:

Username: [customer username]
Password: [customer password]



Authors:

Oğuz Giray Gök
Melih Çelik
Feyza Sapan

