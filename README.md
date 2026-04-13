# AI Tutor Learning App 🚀


![Android](https://img.shields.io/badge/Android-Jetpack%20Compose-brightgreen)
![Backend](https://img.shields.io/badge/Backend-FastAPI-blue)
![LLM](https://img.shields.io/badge/LLM-Ollama-orange)
![Architecture](https://img.shields.io/badge/Architecture-MVVM%20%7C%20MCP-purple)
![Python](https://img.shields.io/badge/Python-3.11-yellow)
![Kotlin](https://img.shields.io/badge/Kotlin-2.0-purple)

An intelligent **AI-powered learning application** built using **Android (Jetpack Compose)**, **FastAPI**, **MCP agent workflow**, and **Ollama local LLM server**.

This project is designed to help users learn **Artificial Intelligence topics step-by-step** through an interactive and guided learning journey.

---

## ✨ Current Features

### 📚 AI Topic Selection

Users can select from multiple AI learning topics such as:

* Machine Learning
* Deep Learning
* NLP
* Computer Vision
* Reinforcement Learning
* LLM Systems

### 🧠 Topic Detail Learning Screen

On selecting a topic, the app navigates to a detailed learning screen.
The topic explanation is fetched dynamically from the backend using:

```text
Android App
   ↓
Client Server (FastAPI)
   ↓
Agent Layer
   ↓
MCP Server
   ↓
Ollama / Qdrant
```

The response is shown in structured learning sections:

* Concept Explanation
* Formula / Theory
* Important Concepts
* Key Learning Points

### 🔄 Next Topic Learning Flow

After completing one topic, the application recommends the **next topic** for guided learning.

### 🚧 Upcoming Features

* Dynamic quiz module
* Short-answer conceptual questions
* Adaptive learning path
* Progress tracking

---

## 🏗️ Multi-Server Architecture

### 📱 Android App

Handles:

* topic selection
* detail screen
* next topic navigation
* future quiz UI

### 🌐 [Client Server](https://github.com/sonimishraa/AI_Tutor_Client_Server)

Responsible for: 

* API handling
* prompt generation
* agent orchestration
* response formatting

### ⚙️ [MCP Server architecture](https://github.com/sonimishraa/AI_Tutor_MCP_server)

Responsible for:

* tool execution
* RAG workflow
* vector retrieval
* Qdrant integration
* knowledge augmentation

---

## 📂 Project Structure

```text
AI_TUTOR_PROJECT/
│
├── AI_TUTOR_ANDROID_APP/
│   ├── ui/
│   ├── screens/
│   ├── navigation/
│   ├── viewmodel/
│   ├── repository/
│   └── network/
│
├── AI_TUTOR_CLIENT_SERVER/
│   ├── .venv/
│   ├── __pycache__/
│   ├── agent.py
│   ├── llm_ollama.py
│   ├── main.py
│   ├── master_prompt.txt
│   ├── mcp_client.py
│   ├── prompt.py
│   ├── tutor_model.py
│   ├── requirement.txt
│   └── README.md
├── AI_TUTOR_MCP_SERVER/
│   ├── main.py
│   ├── tool_handler.py
│   └── requirement.txt
```

---

## 🛠️ Tech Stack

### Frontend

* Kotlin
* Jetpack Compose
* Navigation Compose
* Retrofit
* MVVM Architecture

### Backend

* FastAPI
* Python
* Prompt Engine
* Agent Workflow

### AI / LLM

* Ollama
* Local LLM Models
* MCP Integration
* Qdrant

---

## 👩‍💻 Author

**Soni Mishra**
Android | AI/ML | LLM Systems | Research Learning App
