package lotto.domain.vending;

public class TicketAmount {
    private final int manualTicketAmount;
    private final int autoTicketAmount;

    public TicketAmount(int totalTicketAmount, int manualTicketAmount) {
        validation(totalTicketAmount, manualTicketAmount);
        this.manualTicketAmount = manualTicketAmount;
        this.autoTicketAmount = totalTicketAmount - manualTicketAmount;
    }

    private void validation(int totalTicketAmount, int manualCount) {
        if (totalTicketAmount < manualCount) {
            throw new IllegalArgumentException("수동 구매 티켓이 전체 티켓 보다 많습니다.");
        }
    }

    public int manual() {
        return manualTicketAmount;
    }

    public int auto() {
        return autoTicketAmount;
    }

    public int total() {
        return manualTicketAmount + autoTicketAmount;
    }
}
