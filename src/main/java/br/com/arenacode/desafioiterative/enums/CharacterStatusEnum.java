package br.com.arenacode.desafioiterative.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CharacterStatusEnum {
    ALIVE(1, "Alive"),
    DEAD(2, "Dead"),
    UNKNOWN(3, "unknown");

    private int id;
    private String descricao;

    @JsonValue
    public String getDescricao() {
        return descricao;
    }
}
