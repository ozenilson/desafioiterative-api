package br.com.arenacode.desafioiterative.config.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import javax.swing.text.MaskFormatter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Normalizer;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    public static String replaceMoneyVal(String money) {
        if (money.isEmpty()) {
            return null;
        }
        if (money.matches("(\\d+\\.?)+,\\d+")) {
            return money.replaceAll("\\.", "").replace(",", ".");
        } else if (money.matches("(\\d+\\,?)+.\\d+")) {
            return money.replaceAll("\\,", "");
        } else {
            return money.replaceAll("\\D", "");
        }
    }

    public static String normalizer(String s) {
        return Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    public static String replacer(String param) {
        String t1 = "áãàâäçéèëêùûüúóôöïîíÁÀÂÄÃÇÉÈËÊÙÛÜÚÓÔÖÏÎÍ";
        String t2 = "aaaaaceeeeuuuuoooiiiAAAAACEEEEUUUUOOOIII";
        String s = param;
        for (int i = 0; i < t1.length(); i++) {
            s = "replace(" + s + ",'" + t1.charAt(i) + "','" + t2.charAt(i) + "')";
        }
        return s;
    }

    public static String objectToJson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return "{\"erro\":\"não foi possível converter objeto para string\"}";
        }
    }

    public static String mapToJson(HashMap<String, String> details) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        String param = details.entrySet().stream().map((entry) -> {
            return (stringToJsonParameter(entry.getKey(), entry.getValue()));
        }).collect(Collectors.joining(", "));
        json.append(param);

        json.append("}");

        return json.toString();
    }

    public static boolean isPresent(String value) {
        if (value == null)
            return false;
        else if (value.isEmpty())
            return false;
        else
            return true;
    }

    private static String stringToJsonParameter(String key, Object value) {
        String finalValue = "";
        if (value != null) {
            if (isNumeric(value.toString()) || isBoolean(value.toString())) {
                finalValue = value.toString();
            } else {
                finalValue = "\"" + value.toString().replaceAll("\"", "\\\\\"") + "\"";
            }
        }
        return "\"" + key + "\":" + finalValue;
    }

    public static boolean isBoolean(String str) {
        String compareStr = str.toLowerCase().trim();
        return compareStr.equals("true") || compareStr.equals("false");
    }

    public static boolean isNumeric(String str) {
        return str.matches("([-+]?)(\\d+)(\\.(\\d+))?");  //match a number with optional '-' and decimal.
    }

    public static String formatString(String value, String pattern) {
        MaskFormatter mf;
        try {
            mf = new MaskFormatter(pattern);
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(value);
        } catch (ParseException ex) {
            return value;
        }
    }

    public static String formatToMonthYear(String value) {
        String month = value.substring(0, 2);
        String year = value.substring(2, 6);

        return month + "/" + year;
    }

    public static String formatToCurrency(BigDecimal value) {
        if (value == null || value.equals(BigDecimal.ZERO)) {
            return "R$ 0,00";
        }
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');

        DecimalFormat df = new DecimalFormat("#,###.00", decimalFormatSymbols);
        return "R$ " + df.format(value);
    }

    public static String formatToPercent(BigDecimal value) {
        if (value == null || value.equals(BigDecimal.ZERO)) {
            return "0%";
        }
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');

        DecimalFormat df = new DecimalFormat("#,###.##", decimalFormatSymbols);
        return df.format(value) + "%";
    }

    public static String parseToUtf8(String message) {
        return StringEscapeUtils.escapeHtml4(message);
    }

    public static String removeCaracteresCpfCnpj(String documento) {

        if(StringUtils.isEmpty(documento))
            return  documento;

        documento = documento.replace("-","")
                .replace(".","").replace("/","");
        return documento;
    }

    public static Long onlyDigits(String str) {
        return Long.valueOf(str.replaceAll("\\D+", ""));
    }

    public static String parseListToString(List<String> list) {
        return null;
    }

}
