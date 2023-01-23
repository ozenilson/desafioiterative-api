package br.com.arenacode.desafioiterative.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InfoApi {
    private Long count;
    private Long pages;
    private String next;
    private String prev;
}
