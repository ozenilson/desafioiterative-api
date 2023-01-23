package br.com.arenacode.desafioiterative.client;

import br.com.arenacode.desafioiterative.dto.CharacterApiDto;
import br.com.arenacode.desafioiterative.dto.EpisodeApiDto;
import br.com.arenacode.desafioiterative.dto.PageApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        url = "${rick-and-morty.url}",
        name = "rick-and-morty-client"
)
public interface RickAndMortyClient {

    @GetMapping("/character/")
    PageApi<CharacterApiDto> getCharacterByFilter(
            @RequestParam(value = "name", required = false) String name, @RequestParam(value = "page", required = false) Long page);

    @GetMapping("/episode/{ids}")
    List<EpisodeApiDto> getEpisodesByIds(@PathVariable("ids") String ids);
}
