package com.study.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public  class InputValidation {

    private static final String COMMA = ",";
    private static final String ALERT_CHECK_COMMA = String.format("구분자를 \"%s\"로 입력하셨는지 확인해주세요.", COMMA);
    private static final String ALERT_CHECK_NULL_OR_EMPTY = String.format("\"%s\"로 구분한 지난 주 당첨번호를 입력해주세요.", COMMA);

    public static List<Integer> toIntegers(List<String> input) {
        return new ArrayList<>(Collections.unmodifiableList(input.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList())));
    }

    public static List<String> splitByComma(String input) {
        if (!input.contains(COMMA)) {
            throw new IllegalArgumentException(ALERT_CHECK_COMMA);
        }
        return Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public void checkNullOrEmpty(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(ALERT_CHECK_NULL_OR_EMPTY);
        }
    }

    public String removeBlank(String input) {
        return input.replace(" ", "");
    }
}
