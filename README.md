#  Sopkathon 🚀

> ## HAPPY DEATH DAY
> HDD(Happy Death Day)는 당신이 사랑하는 이들의 죽음에 슬퍼하는 대신 당신을 행복하게 추억할 수 있도록 미리 보내두는 편지 서비스입니다.

## Contributors ✨
| [@SunwoongH](https://github.com/SunwoongH) | [@tkdwns414](https://github.com/tkdwns414) |
| :---: | :---: |
|케이크(유저, 대리인) 도메인 API|편지 도메인 API|

<br>

## API Docs 🎁
[솝커톤 웹 1조 서버 팀의 API 명세서가 궁금하다면? ✔️](https://devjoy.notion.site/API-29eed9bf8186469889d7e0a7429f31a7?pvs=4)

<br>

## Git Convention 📝
[솝커톤 웹 1조 서버 팀의 깃 컨벤션이 궁금하다면? ✔️](https://devjoy.notion.site/Git-Convention-676eeb605e6243e9a30b83676ebba6c8?pvs=4)

<br>

## Code Convention 📝
[솝커톤 웹 1조 서버 팀의 코드 컨벤션이 궁금하다면? ✔️](https://devjoy.notion.site/Code-Convention-a60bc5fe46ed461a87edd07bf4858b64?pvs=4)

<br>

## Architecture ✨

<div align=center>
  
<img width="850" src="https://github.com/DO-SOPT-SOPKATHON-Web-1/Server/assets/81796317/9daf6189-91b0-447c-b982-b56a40c4ae99">

</div>

<br>

## ERD ✨

<div align=center>
  
<img width="850" src="https://github.com/DO-SOPT-SOPKATHON-Web-1/Server/assets/81796317/31a27b15-0c62-4c89-94ed-07c4e5a0d4eb">

</div>

<br>

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- AWS EC2
- AWS RDS
- Nginx
- Docker
- Github Action
- Gmail SMTP
- Certbot

<br>

## Foldering 📂
```
📂 src
┣ 📂 java.org.sopt.sopkathon
┃  ┣ 📂 domain
┃  ┃  ┣ 📂 sample
┃  ┃     ┣ 📂 api
┃  ┃     ┣ 📂 dto
┃  ┃     ┃  ┣ 📂 request
┃  ┃     ┃  ┣ 📂 response
┃  ┃     ┣ 📂 service
┃  ┃     ┣ 📂 domain
┃  ┃     ┣ 📂 repository
┃  ┣ 📂 global
┃     ┣ 📂 common
┃     ┃  ┣ ApiResponse.class
┃     ┃  ┣ SuccessStatus.class
┃     ┣ 📂 config
┃     ┣ 📂 error
┃        ┣ BusinessException.class
┃        ┣ ErrorStatus.class
┃        ┣ GlobalExceptionHandler.class
┣ 📂 resources
┃  ┣ 📂 static
┃  ┣ 📂 templates
┃  ┣ application.yml
┣ SopkathonApplication.class
```
