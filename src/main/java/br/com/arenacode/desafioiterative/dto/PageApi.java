package br.com.arenacode.desafioiterative.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageApi<T> {
    private InfoApi info;
    private List<T> results;
}
