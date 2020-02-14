package lotto.domain;

import lotto.exception.ManualNumberExceedLimitException;

public class LottoPurchase {
  private static final int TICKET_PRICE = 1000;
  private int totalPrice;
  private int numOfManualLottos;

  private LottoPurchase(int totalPrice, int numOfManualLottos) {
    this.totalPrice = totalPrice;
    if (numOfTotalTickets() < numOfManualLottos) {
      throw new ManualNumberExceedLimitException();
    }
    this.numOfManualLottos = numOfManualLottos;
  }

  public static LottoPurchase of(int totalPrice, int numOfManualLottos) {
    return new LottoPurchase(totalPrice, numOfManualLottos);
  }

  private int numOfTotalTickets() {
    return totalPrice / TICKET_PRICE;
  }

  public int numOfAutoTickets() {
    return numOfTotalTickets() - numOfManualLottos;
  }
}
