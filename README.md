# AI Tutor Android App

An AI-powered **chat-based tutoring Android application** built using modern Android development tools and architecture.

The app currently supports **common question-answer chat functionality**, and is designed to scale into a **subject-wise AI tutoring platform** with **PDF-based learning support** in future releases.

---

## Features

- Chat-based AI question-answer system
- Modern UI with Jetpack Compose
- MVVM architecture
- Dependency Injection using Hilt
- Coroutines + Flow for async state handling
- Retrofit for backend API communication
- Clean modular package structure
- Scalable for AI tutoring features

---

## Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Hilt**
- **Coroutines**
- **Flow / StateFlow**
- **Retrofit**
- **MVVM Architecture**
- **REST API**
- **FastAPI Backend Support**

---

## Project Structure

```text
com.sonimishra.aitutor
│
├── api/                # Retrofit API services and network layer
├── chat/               # Chat UI screen, message models, components
├── data/               # Repository and data handling
├── di/                 # Hilt dependency injection modules
├── navigation/         # Navigation routes and NavHost
├── ui.theme/           # Compose theme, typography, colors
├── utils/              # Utility classes and helpers
│
├── AppApplication.kt   # Application class for Hilt setup
└── MainActivity.kt     # App entry point
```

---

## Architecture

```text
Compose UI
    │
    ▼
ViewModel
    │
    ▼
Repository
    │
    ▼
Retrofit API
    │
    ▼
AI Tutor Backend Server
```

---

## Current Functionality

The app currently supports:

- user question input
- chat UI conversation
- API-based answer retrieval
- loading state handling
- error state handling

Example use case:

```text
User → "What is Newton's second law?"
AI → "Force = mass × acceleration"
```

---

## Future Roadmap

### Subject-Wise Tutor Support

Planned learning modules:

- Mathematics
- English
- Science
- Geography
- History

Example:

```text
Class 5 → Basic Math
Class 8 → Algebra
Class 10 → Physics
```

---

### PDF-Based Query Support

Future implementation includes:

- upload study notes / books
- ask questions from PDF
- chapter-wise learning
- semantic search support

Example:

```text
Upload PDF → Ask question → AI answers from document
```

---

### Personalized Learning

Planned features:

- class-wise tutoring
- difficulty levels
- student learning progress
- previous question history
- quiz generation

---

## Why This Project

This app is built as a scalable **AI tutoring platform**, combining modern Android development with future AI-powered education features.

---

## Installation

```bash
git clone https://github.com/yourusername/ai-tutor-app.git
```

Open in Android Studio and run.

---

## Requirements

- Android Studio
- Kotlin 1.9+
- Min SDK 24+
- Internet Permission

---

## Author

**Soni Mishra**

Android Developer | AI/ML Learner | Backend + LLM Systems  
Focused on scalable AI-powered educational applications.
