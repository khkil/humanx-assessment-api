package com.octagnosis.util;

import org.springframework.util.AntPathMatcher;

public class StringUtil {
    /**
     * 문자열에서 숫자만 추출하여 반환하는 메서드.
     *
     * @param input 입력 문자열
     * @return 숫자만 포함된 문자열
     */
    public static String extractNumbers(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        return input.replaceAll("[^0-9]", "");
    }

    /**
     * 비교군 문자열 목록에서 문자열과의 매칭 여부 확인
     *
     * @param target         입력 문자열
     * @param compareStrings 비교군 목록
     * @return 매칭 여부
     */
    public static boolean isMatchString(String target, String... compareStrings) {
        AntPathMatcher pathMatcher = new AntPathMatcher();
        for (String compare : compareStrings) {
            if (pathMatcher.match(compare, target)) {
                return true;
            }
        }
        return false;
    }
}
