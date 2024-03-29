# react-spring-aws
리액트, 스프링, AWS를 이용한 Todo 리스트

## 개발 순서

백엔드 -> 프론트엔드 -> AWS 업로드


## 개발 일지

## 2022.7.2
지금까지 프로젝트는 백엔드를 스프링으로 구현하였고 프론트 엔드 부분은 스프링의 템플릿 엔진 타임리프를 통해서 웹서버를 구성했었다.   
하지만 아무래도 스프링으로만 모든 것을 구현하다 보니 프론트엔드와 백엔드 서버가 분리된 아키텍처에 비해 확장성이 떨어지고 불편한 점이 많은 것 같다.  
그래서 이번 기회에 프론트엔드 쪽도 공부하고 AWS를 통해 서비스를 배포하는 것에 그치지 않고 로드 밸런서, 오토스케일링그룹 등 스케일링에 필요한 서비스를 사용하고 HTTPS를 위한 인증서를 발급받아 설치하는 작업까지 공부하려고 한다.

    
요약하자면 조금 더 실제 서비스가 배포되는 전체적인 과정을 공부하기 위해 이번 프로젝트에서는 스프링으로 백엔드를 구성하고 리액트로 프론트엔드를 구성하여 REST API 방식으로 데이터를 교환하고 AWS 서비스를 이용해 실제 서비스를 운영할 예정이다.

## 2022.7.5

지금까지 백엔드 부분을 작성했는데 CRUD 기능을 구현하였다. 이후 프론트엔드 부분을 작성할 계획이다.

## 2022.7.7

리액트를 이용해서 Todo list의 추가, 삭제,  수정 기능을 만들었고 UI는 material-ui을 사용하여 만들었다. 이후 백엔드 서버와 프론트엔드를 통합할 계획이다.

## 2022.7.16

백엔드와 프론트엔드를 통합하였다. CROS 문제가 발생했지만 리액트에서 설정 파일을 만들어 해결했다.    
로그인 기능을 구현하기 위해 백엔드에 사용자 레포지토리, 서비스, 컨트롤러를 추가했다.    
기본적인 틀만 만들었고 세부적인 기능은 작동하지 않는다.

## 2022.7.24

회원가입, 로그인, 로그아웃 기능을 구현하였고 Todo List 모든 기능을 구현했다.    
앞으로는 로컬이 아닌 다른 사람들이 내가 만든 페이지에  접근할 수 있도록 AWS 서비스를 이용할 예정이다.    
데이터베이스, 오토 스케일링 그룹, 로드 밸런서를 구축할 예정인데 어쩔수 없이 도매인을 구매하고 SSL 인증서를 생성하기위해서 약간의 돈이 들지만 스팀 게임 하나 사는 정도의 비용이므로 최대한 실무에서 사용하는 서비스들을 사용해보려고 한다.

## 2022.7.28

 

AWS의 엘라스틱 빈스톡 서비스를 이용해서 로드 밸런싱, 오토 스케일링, 도메인 구입 등 여러가지를 실습하려 했는데 벡엔드 서버는 잘 동작하는데 프론트엔드인 React.js는 동작하지 않는다.    
코드를 빌드해서 올리면 502  Gateway Error가 떠서 3일 동안 문제를 해결하려고 했는데 결국 해결하지 못했다.    
로컬에서 실행하면 AWS에 올린 벡엔드 서버와 통신이 원활하게 되는데 인스턴스로 올리기만 하면 동작하지 않아서 짜증난다.    
아마 설정파일의 어딘가가 잘못된거 같은데 리액트 부분은 지식이 얕아서 해결하기에는 아직 이른 것 같다.   
찝찝하지만 나중에 다시 도전하면 되니깐 조금 더 수련하고 나서 다시 도전해야겠다.
