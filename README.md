# AWS RestAPI DB Setup Project

A simple Kotlin-based Android app built in **Android Studio** to handle basic user input and connect to a backend powered by **AWS services**.  
The main goal of this project was to learn how to set up and integrate AWS resources into a mobile application for the first time.

---

## 📖 Project Overview
This project demonstrates:
- Building a basic Android application in **Kotlin**.
- Handling user input in the app’s UI.
- Setting up a backend using **AWS services**:
  - **AWS Lambda** functions to process requests.
  - **Amazon API Gateway** to expose REST APIs.
  - **Amazon RDS** for relational database storage and queries.

By connecting the Android client with AWS, the app demonstrates a full-stack workflow where data can be sent from a mobile app, processed in the cloud, and persisted in a database.

---

## ⚙️ Tech Stack
### Frontend (Mobile App)
- Kotlin
- Android Studio

### Backend (AWS)
- AWS Lambda (serverless compute)
- Amazon API Gateway (REST API)
- Amazon RDS (database setup and management)

---

## 🚀 Features
- Accepts user input from the Android application.
- Sends requests to the AWS-hosted REST API.
- Stores and retrieves data from an RDS database.
- Provides a foundation for scaling to more complex applications with authentication, validation, and richer UI.

---

## 📂 Project Structure
- `app/` – Kotlin Android Studio project files (UI + logic).
- `aws/` – Backend setup details (Lambda function code, API Gateway config, RDS setup notes).

---

## 🧑‍💻 Getting Started

### Prerequisites
- Android Studio installed (latest version recommended).
- AWS account with permissions for Lambda, API Gateway, and RDS.
- Basic knowledge of Kotlin and Android development.
