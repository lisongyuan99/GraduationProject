package cn.lsy99.api.activity.util;

import org.springframework.stereotype.Component;

@Component
public class ArrayUtil {
    private static final String DIVIDER = "|";
    private static final String DIVIDER_REGEXP = "\\|";

    public static String[] StringToStringArray(String string) {
        if (string == null || string.equals("")) {
            return new String[0];
        }
        return string.split(DIVIDER_REGEXP);
    }

    public static String StringArrayToString(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (String s : strings) {
            result.append(s);
            result.append(DIVIDER);
        }
        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    public static String getDivider() {
        return DIVIDER;
    }
}
