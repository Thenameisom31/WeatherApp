# Spring Boot Weather App

A full-stack Spring Boot application that allows users to register, log in, and check the current weather for any city.

## Features

*   **User Authentication**: Secure registration and login using Spring Security and MySQL.
*   **Weather Reporting**: Fetches real-time weather data (Temperature, Humidity, Wind Speed, Condition) from [WeatherAPI.com](https://www.weatherapi.com/).
*   **Dynamic UI**: Server-side rendering with Thymeleaf and Bootstrap styling.
*   **Error Handling**: Graceful handling of invalid cities or API errors.

## Tech Stack

*   **Backend**: Java 17, Spring Boot 3 (Web, Data JPA, Security, Validation)
*   **Database**: MySQL
*   **Frontend**: Thymeleaf, Bootstrap 5
*   **Build Tool**: Maven

## Prerequisites

*   Java 17 or higher
*   Maven
*   MySQL Server

## Setup & Running

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/Thenameisom31/WeatherApp.git
    cd WeatherApp
    ```

2.  **Configure Database:**
    *   Create a MySQL database named `weather_app`.
    *   Update `src/main/resources/application.properties` with your MySQL username and password:
        ```properties
        spring.datasource.username=root
        spring.datasource.password=your_password
        ```

3.  **Configure API Key:**
    *   Get a free API key from [WeatherAPI.com](https://www.weatherapi.com/).
    *   Update `src/main/resources/application.properties`:
        ```properties
        weather.api.key=YOUR_API_KEY
        ```

4.  **Run the App:**
    ```bash
    mvn spring-boot:run
    ```

5.  **Access the App:**
    *   Open your browser and go to `http://localhost:8080`.
    *   Register a new user and log in to check the weather!
