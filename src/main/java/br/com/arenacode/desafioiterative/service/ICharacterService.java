package br.com.arenacode.desafioiterative.service;

import br.com.arenacode.desafioiterative.dto.CharacterDto;
import br.com.arenacode.desafioiterative.dto.PageRequest;

import java.util.List;

public interface ICharacterService {
    PageRequest<CharacterDto> getCharacterByFilter(String name, Long page);
}
