package br.com.arenacode.desafioiterative.service;

import br.com.arenacode.desafioiterative.client.RickAndMortyClient;
import br.com.arenacode.desafioiterative.config.util.StringUtil;
import br.com.arenacode.desafioiterative.dto.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService implements ICharacterService{

    @Autowired
    RickAndMortyClient client;

    @Override
    public PageRequest<CharacterDto> getCharacterByFilter(String name, Long page) {
        PageApi<CharacterApiDto> characterDtoPageApi = client.getCharacterByFilter(name, page);
        return new PageRequest<CharacterDto>(characterDtoPageApi.getInfo(),getListCharacter(characterDtoPageApi));
    }

    private List<CharacterDto> getListCharacter(PageApi<CharacterApiDto> pageApi) {
        List<CharacterDto> characterDtos = new ArrayList<>();

        pageApi.getResults().forEach(characterApiDto -> characterDtos.add(
                new CharacterDto(characterApiDto, getListEpisodes(characterApiDto))
        ));
        return characterDtos;
    }

    private List<EpisodeApiDto> getListEpisodes(CharacterApiDto characterApiDto) {
        List<Long> idsEpisodes = new ArrayList<>();
        characterApiDto.getEpisode().forEach(s -> idsEpisodes.add(StringUtil.onlyDigits(s)));
        return client.getEpisodesByIds(idsEpisodes.toString());
    }
}
