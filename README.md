# InsureFlow
[Deutsch](#deutsch) | [English](#english)

---
## Deutsch

### 🚀 Projektübersicht
InsureFlow ist eine moderne Demo-Plattform für Versicherungsvertrags- und Schadensmanagement. Als **Greenfield-Projekt** konzipiert, liegt der Fokus auf einer sauberen Microservice-Architektur und der Nutzung des aktuellsten stabilen Java-Ökosystems.

**Status:** 🏗️ In der Initialphase (Architektur-Setup & Core-Module)

### 🐳 Schnellstart mit Docker

**Voraussetzungen:** Docker Desktop installiert

```bash
git clone https://github.com/dein-user/insureflow.git
cd insureflow
docker compose up
```
Beim ersten Start werden alle Images gebaut und die Datenbank mit Testdaten befüllt. Das dauert ca. 2–3 Minuten.

| Service | URL | Beschreibung |
|---|---|---|
| Customer Service API | http://localhost:8080 | REST API |
| Swagger UI | http://localhost:8080/swagger-ui.html | API Dokumentation |

### 📖 API Dokumentation (Swagger)
Nach dem Start ist die komplette API-Dokumentation unter folgender URL erreichbar:
http://localhost:8080/swagger-ui.html

Dort kannst du alle Endpoints direkt im Browser ausprobieren — inklusive vorausgefüllter Beispiele. Testdaten (3 Kunden mit Adressen) sind beim Start bereits vorhanden.

**Schnelltest:**
1. Swagger UI öffnen
2. `GET /customers` aufklappen → Execute
3. Die drei Seed-Kunden werden angezeigt

---

### 🛠️ Tech Stack
* **Backend:** Java 21 (LTS), Spring Boot 3.3.x
* **Security & Data:** Spring Security, Spring Data JPA, PostgreSQL
* **Processing:** Spring Batch (Prämienläufe), LiteParse (PDF-Policen)
* **Testing:** JUnit 5, Mockito, Testcontainers, H2
* **Architektur:** Microservices

### 🎯 Kern-Features
* **Vertragsanlage:** Digitale Verwaltung von Versicherungspolicen.
* **Schadenmeldung:** Effiziente Workflows für die Bearbeitung von Schadensfällen.
* **Batch-Processing:** Automatisierte Prämienläufe über Spring Batch.

## 🏗️ Architektur-Ansatz
* **Microservice-First:** Entwickelt für unabhängige Skalierbarkeit und Deployment.
* **Clean Code:** Fokus auf Wartbarkeit und die Einhaltung von SOLID-Prinzipien.
* **Production-Ready:** Einsatz von Testcontainers für realitätsnahe Integrationstests und PostgreSQL für zuverlässige Datenpersistenz.
---
## English

### 🚀 Project Overview
InsureFlow is a demo platform designed for insurance contract and claims management. Built as a **greenfield project**, it focuses on a clean microservice architecture and a modern enterprise tech stack.

**Status:** 🏗️ Early Development (Architecture setup & core modules)

### 🐳 Quick Start with Docker

**Requirements:** Docker Desktop installed — nothing else needed.

```bash
git clone https://github.com/your-user/insureflow.git
cd insureflow
docker compose up
```

On first start, all images are built and the database is seeded with test data. This takes approximately 2–3 minutes.

| Service | URL | Description |
|---|---|---|
| Customer Service API | http://localhost:8080 | REST API |
| Swagger UI | http://localhost:8080/swagger-ui.html | API Documentation |

### 📖 API Documentation (Swagger)

After startup, the full API documentation is available at:
http://localhost:8080/swagger-ui.html

All endpoints can be tested directly in the browser — including prefilled examples. Test data (3 customers with addresses) is already available on startup.

**Quick test:**
1. Open Swagger UI
2. Expand `GET /customers` → Execute
3. The three seed customers are returned

---


### 🛠️ Tech Stack
* **Backend:** Java 21 (LTS), Spring Boot 3.3.x
* **Security & Data:** Spring Security, Spring Data JPA, PostgreSQL
* **Processing:** Spring Batch (Premium runs), LiteParse (Document processing)
* **Testing:** JUnit 5, Mockito, Testcontainers, H2
* **Architecture:** Microservices-based

### 🎯 Key Features
* **Contract Management:** End-to-end lifecycle of insurance policies.
* **Claims Handling:** Streamlined reporting and validation of claims.
* **High-Volume Processing:** Efficient premium run handling via Spring Batch.

---

## 🏗️ Architecture Approach
* **Microservice-First:** Designed for independent scalability and deployment.
* **Clean Code:** Focus on maintainability and SOLID principles.
* **Production-Ready:** Using Testcontainers for realistic integration tests and PostgreSQL for reliable data persistence.
