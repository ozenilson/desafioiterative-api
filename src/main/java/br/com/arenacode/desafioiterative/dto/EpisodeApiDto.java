package br.com.arenacode.desafioiterative.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeApiDto {
    private Long id;
    private String name;
    private String url;
    private String created;
    @JsonAlias("air_date")
    private String airDate;
    private String episode;
    private List<String> characters;
}
