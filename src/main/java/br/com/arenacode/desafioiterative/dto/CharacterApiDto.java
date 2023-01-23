package br.com.arenacode.desafioiterative.dto;

import br.com.arenacode.desafioiterative.enums.CharacterStatusEnum;
import br.com.arenacode.desafioiterative.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterApiDto {
    private Long id;
    private String name;
    private String url;
    private String created;
    private CharacterStatusEnum status;
    private String species;
    private GenderEnum gender;
    private CharacterObjectApiDto origin;
    private CharacterObjectApiDto location;
    private String image;
    private List<String> episode;
}
