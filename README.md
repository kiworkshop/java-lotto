# java-lotto 게임

- [x] 입력
  - [x] 구입 금액을 입력한다.
  - [x] 지난 주 당첨 번호를 입력한다.
  - [x] 보너스 볼을 입력한다.

- [] 출력
  - [] 구매 금액에 따른 로또 티켓 장수를 출력한다.
  - [] 구매 금액에 따른 각 로또 티켓의 번호를 출력한다.
  - [] 당첨 번호 일치하는 로또 티켓 개수를 출력한다.
  - [] 총 수익률을 출력한다.

- [x] 구입 금액
  - [x] ERROR : 음수일 경우 예외가 발생한다.
  - [x] ERROR : 1000원 단위가 아닐 경우 예외가 발생한다.

- [] 로또 티켓 머신
  - [x] 구입 금액을 1000원 단위로 나누어 로또 티켓 장수를 반환한다.
  - [] 로또 티켓 장수만큼 로또 티켓을 생성한다.

- 로또 티켓
  - [x] 6개의 로또 번호를 가진다.

- [x] 로또 번호 생성기
  - [x] 1 ~ 45 사이의 난수로 로또 번호를 생성한다.
  - [x] 6개의 로또 번호를 반환한다.

- [x] 로또 번호
  - [x] ERROR : 1 ~ 45가 아닐 경우 예외가 발생한다.

- [] 당첨 번호
  - [] ERROR: 중복되는 로또 번호가 있을 경우 예외가 발생한다.
  - [] 당첨 번호와 중복되지 않는 1 ~ 45 중 하나는 보너스 볼이다.

- [] 로또 통계
  - [] 로또 티켓의 당첨 순위를 계산한다.
  - [] 당첨 순위의 수익률을 계산한다.
