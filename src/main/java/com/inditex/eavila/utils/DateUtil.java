package com.inditex.eavila.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.inditex.eavila.utils.constants.GeneralConstants;

public class DateUtil {

    private DateUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static Boolean validateLocalDateTime(String dateTimeString) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(GeneralConstants.FORMAT_DATE);
            simpleDateFormat.parse(dateTimeString);

            return Boolean.TRUE;
        }catch (ParseException e) {
            return Boolean.FALSE;
        }
    }

}
