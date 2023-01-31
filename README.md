
# Springboot-Mobile-Invitation-Server


![Java](https://img.shields.io/badge/Java-11-red.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7.6-green.svg)
![JPA](https://img.shields.io/badge/Jpa-2.7.6-green.svg)
![Hibernate](https://img.shields.io/badge/Hibernate-5.6.14-orange.svg)
[![Spring Boot & Gradle CI/CD](https://github.com/2YeongHoon/Springboot-Mobile-Invitation-Server/actions/workflows/cicd.yml/badge.svg)](https://github.com/2YeongHoon/Springboot-Mobile-Invitation-Server/actions/workflows/cicd.yml)

모바일 청첩장 API서버업니다.

# Swagger
```
- local
http://localhost:8080/swagger-ui/index.html
```
# Branch
기본적으로 git-flow 전략을 따릅니다.
```
- `master`: 기준이 되는 브랜치로 제품을 배포하는 브랜치 입니다.

- `main`: refactoring 이전 브랜치 입니다.

- `develop`: 개발 브랜치로 개발자들이 이 브랜치를 기준으로 각자 작업한 기능들을 합칩니다(Merge).

- `feature/`: 단위 기능을 개발하는 브랜치로 기능 개발이 완료되면 "develop" 브랜치에 합칩니다.
  - `${taskNum}`: 네이밍 규칙은 깃허브의 이슈번호로 생성합니다. 기능 개발 완료 후 "develop" 브랜치에 병합 후 제거됩니다.
```
# Commit Rules
```
NEW: 신규 파일 및 기능 추가
IMP: 기능 개선
SCH: 설정 변경
CLN: 코드 정리 및 리팩토링
BUG: 버그 픽스
TST: 테스트
DOC: 문서작업
RMV: 삭제
```
# Build
```
1. LOCAL 기반 설정 ( Docker 기반 )
 1.1 Docker DB 컨테이너 생성
   - docker run --name mobile-invitation-server-spring -e MYSQL_ROOT_PASSWORD=<root password> -d -p <connect port>:3306 mysql:latest
 1.2 Docker 접속 및 Database 생성
   - CREATE DATABASE mobile_invitation
```

```
2. AWS 기반 설정 ( EC2 / RDS )
 2.1 RDS 구축
  2.1.1 보안그룹 설정
    - EC2 -> RDS
    - LOCAL -> RDS ( For Build )
  2.1.2 Database 생성
    - CREATE DATABASE mobile_invitation
 ※rds 접속방법 mysql -u <id> -p -h <rds endpoint>
 2.2 EC2 구축
  2.2.1 보안그룹 설정
   - PORT http / ssh / https / 8080
  2.2.2 필수 툴 설치 
   - sudo apt-get update
   - sudo apt-get install mysql-client
   - sudo apt-get install openjdk-11-jdk ( 배포 버전에 따라 설치 )
```

```
3. 배포
 3.1 수동배포
  3.1.1 Build하기
   - intellij의 gradle build의 build 실행
   - 프로젝트창 build / libs에 jar 생성
   - filezilla로 jar파일 옮기기
  ※ 권한 문제 발생 시 해당 디렉토리에 권한 부여
   - sudo chown -R ubuntu /home/ubuntu/deploy
   - sudo chmod -R 755 /home/ubuntu/deploy
  3.1.2 배포하기
   - java -jar 파일명.jar
   ※ putty를 통해 접속하여 실행시키면 해당 putty종료시 해당 프로세스 종료
   ※ nohup  java -jar 파일명.jar 1>/dev/null 2>&1 &
   
 3.2 CI/CD
 ※ 배포과정
 ※ github main branch에 Push -> actions빌드 -> s3에 zip형태로 빌드파일 저장 -> CodeDeploy -> Deploy Server에 배포
  3.2.1 git actions 설정
   // TODO 설정 설명 추가.
```
