스프링 데이터 Auditing (시스템컬럼)
하이버네이트 Envers (이력관리)
Hot deploy < spring-boot-devtools
QueryDSL
GraphQL test
DDD, Event

# 엔티티
* User : 회원
  MyVisitStore : 나의 상점 리스트(내가 방문한 상점)
  MyFavorStore : 나의 상점 리스트(즐겨찾기)
* Store : 상점
  MyVisitUser : 나의 고객 리스트(대기표를 한번이라도 끊은 사람)
* Ticket : 대기표
* Push : 푸쉬 발송현황
  PushConfig : 푸쉬 전송 설정
  PushContents : 푸쉬 내용
* 기타
  Error : 에러
  HelpdeskQna : 고객센터 문의사항 (첨부 : HelpdeskQnaFile)
