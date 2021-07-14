package lotto.domain.vending;

public class TicketAmount {
    public static final int TICKET_PRICE = 1000;

    private final int manualCount;
    private final int autoCount;

    public TicketAmount(BuyingPrice buyingPrice, int manualCount) {
        validation(buyingPrice, manualCount);
        this.manualCount = manualCount;
        this.autoCount = (buyingPrice.value() / TICKET_PRICE) - manualCount;
    }

    private void validation(BuyingPrice buyingPrice, int manualCount) {
        if ((buyingPrice.value() / TICKET_PRICE) < manualCount) {
            throw new IllegalArgumentException("수동 구매 티켓이 전체 티켓 보다 많습니다.");
        }
    }

    public TicketAmount(BuyingPrice buyingPrice, String manualCount) {
        this(buyingPrice, Integer.parseInt(manualCount));
    }

    public int manual() {
        return manualCount;
    }

    public int auto() {
        return autoCount;
    }

    public float total() {
        return manualCount + autoCount;
    }
}
