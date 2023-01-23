package br.com.arenacode.desafioiterative.dto;

import br.com.arenacode.desafioiterative.enums.CharacterStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDto {
    private Long id;
    private String name;
    private CharacterStatusEnum status;
    private String url;
    private String created;
    @JsonProperty(value = "Episodes")
    private List<EpisodeDto> episodes;

    public CharacterDto(CharacterApiDto characterApiDto, List<EpisodeApiDto> episodeApiDtoList) {
        this.id = characterApiDto.getId();
        this.name = characterApiDto.getName();
        this.status = characterApiDto.getStatus();
        this.url = characterApiDto.getUrl();
        this.created = characterApiDto.getCreated();
        List<EpisodeDto> episodeDtoList = new ArrayList<>();
        episodeApiDtoList.forEach(episodeApiDto -> episodeDtoList.add(new EpisodeDto(episodeApiDto)));
        this.episodes = episodeDtoList;
    }
}
