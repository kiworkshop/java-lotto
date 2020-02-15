package lotto.domain;

import lotto.exception.ManualNumberExceedLimitException;

public class LottoPurchase {
  private static final int TICKET_PRICE = 1000;
  private int totalPrice;
  private int numOfManualLottos;

  private LottoPurchase(int totalPrice) {
    this.totalPrice = totalPrice;
  }

  public static LottoPurchase of(int totalPrice) {
    return new LottoPurchase(totalPrice);
  }

  public void setNumOfManualLottos(int numOfManualLottos) {
    if (numOfTotalTickets() < numOfManualLottos) {
      throw new ManualNumberExceedLimitException();
    }
    this.numOfManualLottos = numOfManualLottos;
  }

  private int numOfTotalTickets() {
    return totalPrice / TICKET_PRICE;
  }

  public int numOfAutoTickets() {
    return numOfTotalTickets() - numOfManualLottos;
  }

  public int getNumOfManualLottos() {
    return numOfManualLottos;
  }
}
