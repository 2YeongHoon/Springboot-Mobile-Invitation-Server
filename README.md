[![Spring Boot & Gradle CI/CD](https://github.com/2YeongHoon/Springboot-Mobile-Invitation-Server/actions/workflows/cicd.yml/badge.svg)](https://github.com/2YeongHoon/Springboot-Mobile-Invitation-Server/actions/workflows/cicd.yml)

# Springboot-Mobile-Invitation-Server

SpringBoot 모바일 청첩장 프로젝트

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

```
4. LOCAL swagger 주소
http://localhost:8080/swagger-ui/index.html
```
