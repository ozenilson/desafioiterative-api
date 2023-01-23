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
public class PageRequest<T> {
    private PageableRequest pageable;
    private List<T> content;

    public PageRequest(InfoApi infoApi, List<T> content) {
        this.pageable = new PageableRequest(infoApi);
        this.content = content;
    }
}
