package enums;

public enum Rank {
    FIFTH_PLACE(3, 5_000),
    FOURTH_PLACE(4, 50_000),
    THIRD_PLACE(5, 1_500_000),
    SECOND_PLACE(5, 30_000_000),
    FIRST_PLACE(6, 2_000_000_000);

//5등 : 3개 일치 (5000원)- 1개
//4등 : 4개 일치 (50000원)- 0개
//3등 : 5개 일치 (1500000원)- 0개
//2등 : 5개 일치, 보너스 볼 일치(30000000원) - 0개
//1등 : 6개 일치 (2000000000원)- 0개

    private final int matched;
    private final int prize;

    Rank(int matched, int prize) {
        this.matched = matched;
        this.prize = prize;
    }

}
