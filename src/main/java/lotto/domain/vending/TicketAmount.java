package lotto.domain.vending;

public class TicketAmount {
    public static final int TICKET_PRICE = 1000;

    private final int manualCount;
    private final int autoCount;

    public TicketAmount(BuyingPrice buyingPrice, int manualCount) {
        this.manualCount = manualCount;
        this.autoCount = (buyingPrice.value() / TICKET_PRICE) - manualCount;
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
