package br.com.arenacode.desafioiterative.config.util;

import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class ExcessaoUtil {

    public static String criar(HttpStatus status, String mensagem) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"timestamp\": \"" + DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(OffsetDateTime.now()) + "\"");
        json.append(",\"message\":\"" + (mensagem == null ? ("") : (mensagem.replaceAll("\"", "\\\\\""))) + "\"");
        json.append(",\"status\":" + status.value());


        json.append(",\"ok\":" + isOk(status));
        json.append("}");

        return json.toString();
    }

    private static Boolean isOk(HttpStatus status) {
        return status.is1xxInformational() || status.is2xxSuccessful() || status.is3xxRedirection();
    }
}
