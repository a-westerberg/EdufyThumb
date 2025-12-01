# Edufy Thumb
[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen.svg)](https://spring.io/projects/spring-boot)

## 👍Overview:
Edufy Thumb stores and handles records of user interactions on media in the form of **thumbs up**.  
It keeps track of likes on Songs, Video Clips, Video Playlists, Podcast Episodes, and Podcast Seasons.

This service is used by the media microservices when a user interacts with content, and the data can later be used to build recommendations or statistics.

Edufy Thumb is part of a larger microservice system and communicates with other services through  
Docker Compose, Eureka, and the API Gateway. Related projects are linked below.

---

## 🧩 Related projects
### Organisation
- EdufyProjects – All repositories in one place

### Connections
- [Edufy-infra](https://github.com/EudfyProjects/Edufy-infra) - Contains `docker-compose.yml` file and `init.db` file
- [EudfyEurekaServer](https://github.com/Sommar-skog/EdufyEurekaServer) - Server that connects the services instances
- [Gateway](https://github.com/SaraSnail/EdufyGateway) - Funnels all requests with one base endpoint
- [EdufyUser](https://github.com/Jamtgard/EdufyUser) - Holds in the Users and can connect to Keycloak to create new ones
- [EdufyKeycloak](https://github.com/Sommar-skog/EdufyKeycloak) - A pipeline for Azure but had to switch to local container
### Media connections
- [EdufyCreator](https://github.com/Sommar-skog/EdufyCreator) - Holds the Creators for all the media services
- [EdufyGenre](https://github.com/a-westerberg/EdufyGenre) - Holds all the Genres for the microservices
- [EdufyThumb](https://github.com/a-westerberg/EdufyThumb) - Records of thumbs up and down on media
- [EdufyUtility](https://github.com/a-westerberg/EdufyUtility) - No code so far but was created to hold algorithms to extract top 10 for a User
### Media services
- [EdufyMusic](https://github.com/Jamtgard/EdufyMusic) - Service for songs and albums
- [EdufyVideo](https://github.com/Sommar-skog/EdufyVideo) - Service for video clips and video playlists
- [EdufyPod](https://github.com/SaraSnail/EdufyPod) - Service for podcast episodes and seasons
---

## 🚀 Tech Stack

- **Language :** Java 21
- **Build Tool :** Apache Maven
- **Framework :** Spring Boot 3.5.7
    - Spring Data JPA
    - Spring basic security
    - Spring Web
    - Eureka Client
    - Spring Cloud LoadBalancer
- **Databases :**
    - MYSQL 8.0 (Docker Compose)
    - H2 (development)
- **Security :**
    - Spring Security
    - OAuth2 Resource Server

---

## 🏁 Getting started
### Prerequisites

- Java 21
- Maven
- Docker
- Postman
- Keycloak

---

### 🔌 Ports
#### Connections
- **Eureka :** `8761`
- **Gateway :** `4545`
- **MySQL :** `3307`
- **User :** `8686`
- **Keycloak :** `8080`

#### Media connections
- **Creator :** `8787`
- **Genre :** `8585`
- **Thumb :** `8484`
- **Utility :** `8888`

#### Media services
- **Pod :** `8282`
- **Video :** `8383`
- **Music :** `8181`

---

## 🔒 Authentication & Roles

Edufy Thumb uses **OAuth2** and **Keycloak** for authentication and authorization.

### User Roles:
- **edufy_realm_admin** – Can reach all admin endpoints in all microservices
- **thumb_admin** – Reserved for future admin features
- **thumb_user** – Reserved for future user-level access
- **microservice_access** – Used internally between microservices

> _Note: These roles are placeholders and used during development._

| Role                | Username          | Password |
|---------------------|:-----------------:|:--------:|
| edufy_realm_admin   | edufy_realm_admin |  admin   |
| thumb_admin         |   thumb_admin     |  admin   |
| thumb_user          |    thumb_user     |  thumb   |
| microservice_access |                   |          |

> Unauthenticated requests will receive a `401 Unauthorized` response.  
> `microservice_access` is used internally between microservices when exchanging data.

---

## 📚 API Endpoints

### Admin – Roles `thumb_admin` & `edufy_realm_admin`:
(Currently minimal – thumb admin endpoints may be added later)

---

### Client – Role `microservice_access`:
These endpoints are used **internally by media microservices**.

* **POST** `/thumb/media/record`  
  Creates a thumb-up record for a media item (ex. Song / Video / Podcast Episode)

* **GET** `/thumb/media/{mediaType}`  
  Returns thumb-up counts for the given `mediaType`

---

### Common – Authenticated:
* **GET** `/thumb/all` – Lists all thumb records (for future use)

---

## 🐳 Docker
- Use `docker-compose.yml` from Edify-infra to build and run the project
- Docker network: `edufy-network`

---

## 🛢️ MySQL Database

| Name             | Username | Password |   Database    |
|------------------|:--------:|:--------:|:-------------:|
| edufy_mysql      |   assa   |   assa   | main database |
| edufy_thumb_db   |   assa   |   assa   |     thumb     |

- **Version:** 8.0
- **SQL file:**
    - Used by docker-compose to create databases and grant access
- **Default Port:** `3306`
    - Mapped as `3307:3306` by default  
- ---
> _README made by https://github.com/a-westerberg_