쿠버네티스 용어 정리

노드(Nodes, Minions)
- 쿠버네티스가 설치된 물리적 혹은 가상 머신,

워커 노드
- 컨테이너를 올리는 워커 머신
- 하나의 노드에 문제가 생기면 안되므로 노드를 여러 개 묶어서 클러스터를 만든다.
- 여러 노드는 로드 분산에도 도움이 된다.

클러스터로 묶은 노드 관리, 모니터, 노드 fail 시 다른 노드로 옮기는 등을 위해 마스터 노드 필요 

쿠버네티스 구성 요소
API server
- 프론트 엔드 처럼 동작
- user, 관리 장치, cli 등등
- 클러스터와 interact하기 위해 api server에게 말한다.

etcd keystore
