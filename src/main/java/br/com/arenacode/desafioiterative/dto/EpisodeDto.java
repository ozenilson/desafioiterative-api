package br.com.arenacode.desafioiterative.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeDto {
    private Long id;
    private String name;
    @JsonProperty(value = "air_date")
    private String airDate;
    private String episode;
    private String url;
    private String created;

    public EpisodeDto(EpisodeApiDto episodeApiDto) {
        this.id = episodeApiDto.getId();
        this.name = episodeApiDto.getName();
        this.airDate = episodeApiDto.getAirDate();
        this.episode = episodeApiDto.getEpisode();
        this.url = episodeApiDto.getUrl();
        this.created = episodeApiDto.getCreated();
    }
}
