# 📌Schedule Management API
이 프로젝트는 사용자(User)와 일정(Schedule)을 관리하는 RESTful API입니다.

사용자는 유저 생성, 조회, 삭제, 비밀번호 수정기능과 일정 생성, 조회, 수정 및 삭제 기능을 사용할 수 있습니다.

🚀  ***기술 스택***
- 언어:Java 17
- 프레임워크:Spring Boot
- 데이터베이스:MySQL
- 빌드 도구:Gradle

📂 ***프로젝트 구조***
```
📦 src/main/java/com/example/schedule
┣ 📂 controller  # API 요청 처리
┣ 📂 service     # 비즈니스 로직
┣ 📂 repository  # 데이터 접근
┣ 📂 entity      # DB 모델
┣ 📂 dto         # 요청/응답 객체
┗ 📂 config      # 설정 파일 (추후 보안 추가 가능)
```

📌 ***주요 기능***
|기능|설명|
|---|---|
|사용자 등록| 새로운 사용자를 등록합니다.|
|사용자 조회| 전체 또는 특정 사용자를 조회합니다.|
|비밀번호 수정| 사용자의 비밀번호를 변경할 수 있습니다.|
|사용자 삭제| 사용자를 삭제합니다.|
|일정 생성| 일정 정보를 등록합니다.|
|일정 조회| 전체 일정 또는 특정 사용자의 일정을 조회합니다.|
|일정 수정| 사용자의 이름이 일치할 경우 일정 수정이 가능합니다.|
|일정 삭제| 특정 일정을 삭제합니다.|


# API 명세서

## User API

| HTTP Method | URI      | Description        | Request Body | Response |
|-------------|--------------|--------------------|--------------|----------|
| POST        | /users/signup | 사용자 회원가입 | {<br>"userName": "string",<br>"email": "string",<br>"password": "string"<br> }| 201 Created |
| GET         | /users      | 모든 사용자 조회 | -            | 200 OK |
| GET         | /users/{id} | 특정 사용자 조회 | -            | 200 OK |
| PATCH       | /users/{id} | 사용자 비밀번호 변경 | {<br>"oldPassword": "string",<br> "newPassword": "string"<br> } | 200 OK |
| DELETE      | /users/{id} | 사용자 삭제      | -            | 200 OK |

## Schedule API

| HTTP Method | URI       | Description        | Request Body | Response |
|-------------|--------------|--------------------|--------------|----------|
| POST        | /schedules | 일정 생성         | {<br> "todoTitle": "string",<br> "contents": "string",<br> "userName": "string"<br> }| 201 Created |
| GET         | /schedules  | 모든 일정 조회    | -            | 200 OK |
| GET         | /schedules/{id}| 특정 일정 조회 | -            | 200 OK |
| PUT         | /schedules/{id} | 일정 수정       | { <br>"userName": "string"<br>"todoTitle": "string",<br> "contents": "string"<br> } | 200 OK |
| DELETE      | /schedules/{id} | 일정 삭제       | -            | 200 OK| 




# API ERD

![ERD](https://github.com/kangdalho/ScheduleDevelop/blob/main/ERD.PNG?raw=true)






