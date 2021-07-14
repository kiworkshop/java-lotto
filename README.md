# java-lotto 게임

- [x] 입력
  - [x] 구입 금액을 입력한다.
  - [x] 수동으로 구매할 로또 수를 입력한다.
  - [x] 수동으로 구매할 번호를 입력한다. 
  - [x] 지난 주 당첨 번호를 입력한다.
  - [x] 보너스 볼을 입력한다.

- [x] 출력
  - [] 구입 금액에 따라 수동 구매 장수와 자동 구매 장수를 출력한다. 
  - [x] 구매 금액에 따른 각 로또 티켓의 번호를 출력한다.
  - [x] 당첨 번호와 일치하는 로또 티켓 개수를 출력한다.
  - [x] 총 수익률을 출력한다.
  
***

- [x] 구입 금액
  - [x] 구입 금액은 1000원 단위의 정수값이다.
  - [x] ERROR : 음수일 경우 예외가 발생한다.
  - [x] ERROR : 1000원 단위가 아닐 경우 예외가 발생한다.
    
- [x] 티켓 장수
  - [x] 구입 금액을 1000원 단위로 나누어 로또 티켓 장수를 반환한다.
  - [x] ERROR : 전체 티켓 장수 보다 수동 구매 장수가 많은 경우 예외가 발생한다.

- [] 로또 게임
  - [] 전체 로또 티켓을 생성한다.
  
***

- [x] 로또 번호 생성기
  - [x] 1 ~ 45 사이의 난수로 로또 번호를 생성한다.
  - [x] 6개의 로또 번호를 반환한다.

- [x] 로또 번호
  - [x] ERROR : 1 ~ 45가 아닐 경우 예외가 발생한다.
  
- [x] 로또 티켓
  - [x] 6개의 로또 번호를 가진다.
  
- [x] 로또 티켓 머신
  - [x] 수동으로 로또 티켓을 생성한다.
  - [x] 자동으로 로또 티켓을 생성한다.
  
***

- [x] 당첨 번호
  - [x] ERROR: 중복되는 로또 번호가 있을 경우 예외가 발생한다.
  - [x] 당첨 번호와 중복되지 않는 1 ~ 45 중 하나는 보너스 볼이다.
  - [x] 당첨 번호와 일치하는 로또 번호 개수를 반환한다.

- [] 당첨 결과
  - [] 당첨 번호와 일치하는 갯수를 반환한다.
  - [] 보너스 번호 일치 여부를 반환하다.
  
- [x] 로또 당첨 순위
  - [x] 로또 티켓의 당첨 갯수에 따른 순위를 반환한다.
  
- [x] 로또 통계
  - [x] 당첨 번호 개수가 같은 로또 티켓 개수를 반환한다.
  - [x] 당첨 순위의 수익률을 계산한다.
