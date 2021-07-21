package com.study.enums;

import java.util.EnumMap;

public class RankMap extends EnumMap<Rank, Integer> {

    {
        put(Rank.FIRST_PLACE, 0);
        put(Rank.SECOND_PLACE, 0);
        put(Rank.THIRD_PLACE, 0);
        put(Rank.FOURTH_PLACE, 0);
        put(Rank.FIFTH_PLACE, 0);
        put(Rank.ETC, 0);
    }
    public RankMap(Class<Rank> keyType) {
        super(keyType);
    }
}
