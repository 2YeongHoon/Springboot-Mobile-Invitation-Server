# Springboot-Mobile-Invitation-Server

SpringBoot 모바일 청첩장 프로젝트

```
1. LOCAL 설정 ( Docker 기반 )
 1.1 Docker DB 컨테이너 생성
   - docker run --name mobile-invitation-server-spring -e MYSQL_ROOT_PASSWORD=<root password> -d -p <connect port>:3306 mysql:latest
 1.2 Docker 접속 및 Database 생성
   - CREATE DATABASE mobile_invitation
```

```
2. AWS 설정 ( EC2 / RDS )
 2.1 RDS 구축
  2.1.1 보안그룹 설정
    - EC2 -> RDS
    - LOCAL -> RDS ( For Build )
  2.1.2 Database 생성
    - CREATE DATABASE mobile_invitation
 2.2 EC2 구축
  2.2.1 보안그룹 설정
   - PORT http / ssh / https / 8080
  2.2.2 필수 툴 설치 
   - sudo apt-get update
   - sudo apt-get install mysql-client
   - sudo apt-get install openjdk-11-jdk ( 배포 버전에 따라 설치 )
3. 배포
 3.1 Build하기
  - intellij의 gradle build의 build 실행
  - 프로젝트창 build / libs에 jar 생성
  - filezilla로 jar파일 옮기기
 ※ 권한 문제 발생 시 해당 디렉토리에 권한 부여
  - sudo chown -R ubuntu /home/ubuntu/deploy
  - sudo chmod -R 755 /home/ubuntu/deploy
 3.2 배포하기
  - java -jar 파일명.jar
```
- LOCAL swagger 주소
http://localhost:8080/swagger-ui/index.html
```
