# Deployment Guide for Spring Boot Weather App

## Why not Vercel?
**Vercel** is optimized for frontend frameworks (Next.js, React) and serverless functions. While it *can* run Java, it does not support long-running processes like a standard Spring Boot application with an embedded Tomcat server. Additionally, Vercel does not provide a MySQL database, which your application requires.

## Recommended Platform: Railway
**Railway** is the best alternative. It offers a similar "git-push-to-deploy" experience but has native support for:
1.  **Spring Boot (Java)** applications.
2.  **MySQL Databases** (managed).

---

## Step-by-Step Deployment on Railway

### 1. Prepare your Application
I have already updated your `application.properties` to use environment variables. This allows the cloud platform to inject the correct credentials.

```properties
# Database Configuration
spring.datasource.url=${MYSQL_URL:jdbc:mysql://localhost:3306/weather_app}
spring.datasource.username=${MYSQLUSER:root}
spring.datasource.password=${MYSQLPASSWORD:onkar@123}

# API Key
weather.api.key=${WEATHER_API_KEY:18304d97c5044377b1b175431252011}
```

### 2. Push to GitHub
Make sure your latest code (including the changes to `application.properties`) is pushed to your GitHub repository.

### 3. Deploy on Railway
1.  Go to [Railway.app](https://railway.app/) and log in with GitHub.
2.  Click **"New Project"** -> **"Deploy from GitHub repo"**.
3.  Select your `WeatherApp` repository.
4.  Railway will automatically detect it's a Java project (Maven) and start building.

### 4. Add a Database
1.  In your Railway project dashboard, click **"New"** -> **"Database"** -> **"MySQL"**.
2.  Railway will create a MySQL service for you.

### 5. Connect App to Database
1.  Railway automatically injects environment variables like `MYSQL_URL`, `MYSQLUSER`, etc., into your application if they are in the same project.
2.  **Verify Variables**: Go to your Spring Boot service -> **"Variables"**. You should see the database variables linked.
3.  **Add API Key**: Add a new variable manually:
    -   Key: `WEATHER_API_KEY`
    -   Value: `your_actual_api_key` (or use the default one if you prefer)

### 6. Access your App
1.  Go to your Spring Boot service -> **"Settings"**.
2.  Under **"Networking"**, click **"Generate Domain"**.
3.  Click the generated URL to visit your live app!
