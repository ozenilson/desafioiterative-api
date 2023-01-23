package br.com.arenacode.desafioiterative.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenderEnum {
    FEMALE(1, "Female"),
    MALE(2, "Male"),
    GENDERLESS(3, "Genderless"),
    UNKNOWN(3, "unknown");

    private int id;
    private String descricao;

    @JsonValue
    public String getDescricao() {
        return descricao;
    }
}
