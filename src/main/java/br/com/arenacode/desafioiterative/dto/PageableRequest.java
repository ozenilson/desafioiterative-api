package br.com.arenacode.desafioiterative.dto;

import br.com.arenacode.desafioiterative.config.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageableRequest {
    private Long totalElements;
    private Long totalPages;
    private Long pageNumber;
    private Long pageSize;

    public PageableRequest(InfoApi infoApi) {
        this.totalElements = infoApi.getCount();
        this.totalPages = infoApi.getPages();
        this.pageNumber = infoApi.getNext() != null ? StringUtil.onlyDigits(infoApi.getNext()) - 1 : 1;
    }

    public Long getPageSize() {
        return 20L;
    }
}
