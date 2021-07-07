# java-Lotto 게임

# 구현 기능 목록

- [x] 구입금액 입력받기
    - [x] 1000원 미만 입력 시 처리
    - [x] 1000의 배수 아닌 값 입력 시 처리
    - [x] 숫자가 아닌 값 (문자열)
    - [x] 정상값 처리
    - [x] 공백 처리
- [x] 구매 개수 구하기
- [x] 랜덤 로또번호 구매 개수만큼 만들기
    - [ ] defaultNumberSet 1번만 생성되도록 변경
    - [x] RandomLottoTest 상수 리팩토링
    - [x] PurchaseCount의 1000 접근
- [x] 지난 주 당첨 번호 입력받기
    - [x] WinningNumbers 멤버변수 ArrayList 클래스 확인
    - [x] 숫자 개수 6개 확인
    - [x] 숫자가 아닌 값 포함
    - [x] 범위 (1~45) 확인
    - [x] 공백 처리
- [x] 보너스 볼 입력받기
- [x] 당첨 통계
    - [x] 당첨 조건을 enum 처리
    - [x] 일치 개수 찾기
    - [x] 5개 일치 시 보너스 볼 일치 여부 확인
    - [x] 로또 당첨 개수 구하기
    - [x] 당첨값의 합 구하기
    - [x] 수익률 구하기
    - [x] 결과 출력