# 마루 (Maru)

> K-pop · K-drama 영상 기반 AI 한국어 학습 플랫폼

K-pop · K-drama 콘텐츠에서 단어를 자동 추출하고, 개인의 관심사와 수준에 맞춰 한국어를 학습할 수 있는 AI 어학 애플리케이션입니다.

<br>

## 프로젝트 개요

| 항목 | 내용 |
|------|------|
| 개발 기간 | 2025 |
| 개발 인원 | 팀 프로젝트 |
| 담당 역할 | Backend 개발 |
| GitHub | [lucky-biky/maru](https://github.com/lucky-biky/maru) |

<br>

## 핵심 기능

#### AI 기반 단어 추출
- K-pop · K-drama 영상에서 핵심 단어 자동 추출
- AWS BedRock을 활용한 AI 학습 콘텐츠 생성

#### 개인 맞춤 학습
- 학습자 관심사 · 수준별 커리큘럼 제공
- 학습 이력 기반 콘텐츠 추천

#### 음성 합성 (TTS)
- AWS Polly를 활용한 한국어 발음 음성 제공
- 원어민 발음으로 단어 · 문장 학습

#### 회원 인증
- JWT 기반 Access / Refresh Token 인증
- 보안 강화를 위한 다중 JWT 라이브러리 활용

<br>

## 기술 스택

**Backend**
- Java 17, Spring Boot 3.3.1
- Spring Data JPA, MariaDB
- JWT (JJWT, Auth0, Nimbus JOSE)
- Gradle

**Cloud (AWS)**
- AWS BedRock — AI 모델 연동
- AWS Polly — 한국어 TTS 음성 합성

**Infra**
- Docker

**Docs**
- SpringDoc OpenAPI (Swagger UI)

<br>

## 아키텍처

```
Client (React)
    │
    ▼
Spring Boot API Server
    ├── AWS BedRock  (AI 단어 추출 · 콘텐츠 생성)
    ├── AWS Polly    (한국어 TTS 음성 합성)
    └── MariaDB      (사용자 · 학습 데이터)
```

<br>

## 주요 구현 사항

- **AWS BedRock 연동** — AI API를 활용한 영상 기반 단어 추출 파이프라인 구현
- **AWS Polly TTS** — 추출된 단어 · 문장에 대한 음성 자동 생성
- **JWT 인증 체계** — Access Token + Refresh Token 이중 인증 구현
- **REST API 설계** — Swagger 기반 API 명세 작성 및 문서화
- **Docker 컨테이너화** — 개발 · 배포 환경 일관성 확보

<br>

## 실행 방법

```bash
# 1. 클론
git clone https://github.com/lucky-biky/maru.git
cd maru

# 2. Git hook 설정
sh init_config

# 3. 환경변수 설정
cp .env.example .env
# AWS 자격증명, DB, JWT Secret 입력

# 4. 실행
./gradlew bootRun
```

**Docker**
```bash
docker build -t maru .
docker run -p 8080:8080 --env-file .env maru
```

**API 문서**
```
http://localhost:8080/swagger-ui.html
```
