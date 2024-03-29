# IT 엔지니어를 위한 네트워크 입문 정리
## 1. 네트워크 시작하기
애플리케이션 개발자는 상위 계층부터 다루는 경향이 있고, 네트워크 엔지니어용 교재는 하위 계층부터 설명하는 경향이 있다.</br>
이 교재는 네트워크 엔지니어의 관점으로 진행하지만 네트워크, 서버, 애플리케이션의 입장 모두를 다룰 수 있도록 한다.
### 1.1 네트워크 구성도 살펴보기
네트워크는 크게 서비스 받는 입장과 서비스 제공하는 입장으로 나뉜다.
- **서비스를 받는 입장** : 집에서 인터넷 접속, 회사에서 인터넷 접속 후 업무
- **서비스를 제공하는 입장** : *클라우드* 혹은 *데이터 센터*, *회사 기계실*에 서버를 놓고 고객들이나 회사 내부 직원에 서비스를 제공
  - 네트워크 접속 구성원의 수, 필요한 네트워크의 속도에 따라 여러가지 상황 고려 필요.

간단하게 홈 네트워크 구성과 데이터 센터 네트워크 구성을 예제로 자주 사용되는 물리적인 연결 기술과 구성 요소 살펴보자

#### 1.1.1 홈 네트워크
**인터넷** -> **모뎀** -> **공유기** -> **노트북/스마트폰/태블릿/데스크톱**
- 회선(FTTH, 케이블 인터넷, VDSL)과 무관하게 동일하다.
- 모바일 단말기의 증가와 노트북 사용 보편화로 공유기 활용 증가.
- 홈 네트워크 구성 위해서는 모뎀, 공유기, 단말 간 물리적 연결 필요.
  - **인터넷** -> (케이블) -> **모뎀** -> (케이블) -> **공유기** -> (케이블/매체(공기)) -> **단말**
  - 무선 연결을 위해서는 무선 신호를 위한 매체(공기), 무선 랜 카드 필요
  - 유선 연결을 위해서는 **유선 랜 카드**(이더넷 랜 카드 : 일반적으로 보드에 내장), **랜 케이블** 필요
  
#### 1.1.2 데이터 센터 네트워크
 데이터 센터 네트워크는 안정적이고 빠른 대용량 서비스 제공을 위한 구성이 필요하다. <br>
안정적 서비스 제공을 위해 다양한 이중화 기술 사용하고, 많은 서버와 서비스가 한 네트워크에 연결 되므로, 높은 통신량 수용이 가능해야 한다. <br>
이를 위해서 10G, 25G, 40G, 100G, 400G와 같은 고속 이더넷 기술 사용된다.

<br>

 데이터 센터 3계층 구성이 일반적이었지만, 가상화 기술과 높은 대역폭(통신에서 이용 가능한 최대 전송속도, 단위 bps)을 요구하는 **스케일 아웃(Scale-Out)** 기반의 애플리케이션과 서비스의 등장으로 2계층 구성인 **스파인 리프(Spine-Leaf)** 구조로 데이터 센터 네트워크 구조가 변형되었다.
 
 **스파인-리프** 구조는 서버 간 통신이 증가하는 최근 트래픽 경향 지원 위해 제안되었다. 최근 일반 서버에 10G Base-T* 이더넷 포트가 기본 제공되어 TOR(Top of Rack)* 스위치와 연결되고, 리프(Leaf)* 스위치인 TOR 스위치는 스파인(Spine)* 스위치와 40G, 100G로 연결되는 추세이다.<br>
 더 높은 대역폭을 위해 400G 네트워크도 표준화 되어 더 높은 대역포 사용하는 데이터 센터에 사용 된다.
 
 ### 1.2 프로토콜
 네트워크에서 통신 시 사용하는 **규약**, 여러 복잡하고 산재된 프로토콜이 이더넷 - TCP/IP 기반 프로토콜들로 변경되고 있다. <br>
 - 물리적 측면 : 데이터 전송 매체, 신호 규약, 회선 규격 등. 이더넷이 널리 쓰인다.
 - 논리적 측면 : 장치들끼리 통신하기 위한 프로토콜 규격. TCP/IP가 널리 쓰인다. 
 <br>
 한정적인 자원과 느린 네트워크 속도를 이용해서 통신하기 위해 최대한 적은 데이터를 이용해 효율적인 프로토콜 정의하고 사용해야 했다.(열악한 네트워크 환경으로 인해 자연어 처리 불가)
 
 - 따라서 대부분의 프로토콜이 2진수 비트(bit)기반으로 만들어졌다.
 - 최소한의 비트로 통신하기 위해서 매우 치밀하게 프로토콜을 정의할 필요가 있다.
    - 몇 번째 전기 신호가 보내는 사람 주소이고, 몇 번째 전기 신호가 받는 사람 주소 등등.
 - 이 처럼 **프로토콜을 까다롭게 정의하고 철저하게 지켜야 통신을 할 수 있다.**
 - 애플리케이션 레벨의 프로토콜은 문자 기반의 프로토콜이 많이 사용된다.
    - HTTP, SMTP 
    - 문자 자체를 이용해 헤더와 헤더 값, 데이터를 표현하고 전송
    - 실제 텍스트 파일과 같은 데이터가 전달되므로 효율성은 낮지만 다양한 확장 가능하다.
```
GET /api HTTP/1.1
Accept: text/html, application/xhtml+xml, */*
Referer: http://zigispace.net/
Accept-Language: ko-KR
User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; TC0_20181006113830;
rv:11.0) like Gecko
Accept-Encoding: gzip, deflate
Host: theplmingspace.tistory.com
DNT: 1
Connection: Keep_Alive
```
<HTTP 프로토콜 헤더 : 문자로 정의되어 있어 헤더 정의가 자유롭고 확장 용이>

TCP/IP는 프로토콜 스택(프로토콜 묶음)으로 TCP, IP 뿐만 아니라 ARP, HTTP, SMTP, FTP와 같은 다양한 애플리케이션 프로토콜이 존재한다.

### 1.3 OSI 7계층과 TCP/IP
난립하던 벤더 규격들의 국제적인 표준화가 필요해 책정되었고, **OSI 7계층과 TCP/IP 스택은 네트워크를 단계별로 나누어 이해하기 쉽도록 도와주며, 현재에는 대부분의 프로토콜이 TCP/IP 프로토콜 스택 기반으로 이루어져 있다.**

#### 1.3.1 OSI 7계층
- **복잡한 데이터 전송 과정을 OSI 7계층으로 나누어서 보면 이해하기 쉽다.**
- 계층별 표준화된 템플릿을 통해 네트워크 프로토콜을 전부 개발하지 않고 **계층별로 프로토콜 개발해서 네트워크 구성요소를 모듈화할 수 있다.**
  - 모듈화된 요소는 기존의 프로토콜과 연동해서 사용할 수 있다.
 
|계층|데이터|
|---|---|
|애플리케이션 계층(Application)|Data|
|프레젠테이션 계층(Presentation)|Data|
|세션 계층(Session)|Data|
|트랜스포트 계층(Transport)|Segments|
|네트워크 계층(Network)|Packets|
|데이터 링크 계층(Data Link)|Frames|
|피지컬 계층(Physical)|Bits|

계층의 역할과 분류에 따라 2개의 계층으로 나누기도 한다.
- 1~4 계층, **데이터 플로 계층(Data Flow Layer)** : 데이터를 상대방에게 잘 전달하기 위한 계층, 하위 계층이라고도 한다.
  - 네트워크 엔지니어들은 상위 계층을 심각하게 고려하지 않는다. 
  - 네트워크 엔지니어는 **상향식(Bottom-Up) 형식으로 네트워크를 인식**  
- 5~7 계층, **애플리케이션 계층(Application Layer)** : 데이터를 표현하는 데 초점을 둔 계층, 상위 계층이라고도 한다.
  - 데이터 플로는 고려하지 않는다. 
  - 애플리케이션 개발자는 **하향식(Top-Down) 형식으로 네트워크를 인식**
- TCP/IP 모델은 위의 구분이 더 명확해져 상위 3개를 하나의 애플리케이션 계층으로 묶고 1, 2 계층을 네트워크 계층으로 구분한다.
  - 현실에 쉽게 반영할 수 있다.
  
 ### 1.4 OSI 7계층별 이해하기
 OSI 7계층은 참조형 모델, 실제 사용 프로토콜은 TCP/IP 프로토콜
 
 #### 1.4.1 1계층(피지컬 계층)
 - 주로 전기신호를 전달하는데 초점을 맞추어져 있다.
 - 주요 장비
    - 허브, 리피터 : 네트워크 중재.
    - 케이블 
    - 커넥터 : 케이블 연결하는 장비.
    - 트랜시버 : 컴퓨터의 랜카드와 케이블 연결.
    - 탭 : 네트워크 모니터링과 패킷 분석 위해 전기 신호를 다른 장비로 복제.




 
 
 
 
