# java-lotto 게임
## Scenario
1. 로또를 산다. (티켓 출력)
   1. buy lotto tickets with the money from lotto market
      1. how many can we buy?
      2. get new ticket (w/ random number)
      3. return tickets
   2. add to my wallet
   3. print the bought tickets
2. 당첨번호를 입력한다. (통계결과 출력)
   1. get the Lotto Result (6 winning numbers)
   2. check my result

## Requirements
### Classes
- LottoMarket
  - lotto price = 1000 won
  - buy tickets (w/ money)
- LottoTicket
  - 6 random numbers (in constructor)
- LottoWallet
  - list of LottoTickets
  - print what I have
- LottoResult
  - 6 winning numbers
  - number of Lottos
  - number of match-3
  - number of match-4
  - number of match-5
  - number of match-6
  - get result (w/ wallet)
  
