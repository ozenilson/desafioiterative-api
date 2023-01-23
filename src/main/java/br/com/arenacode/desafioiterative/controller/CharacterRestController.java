package br.com.arenacode.desafioiterative.controller;

import br.com.arenacode.desafioiterative.dto.CharacterDto;
import br.com.arenacode.desafioiterative.dto.PageRequest;
import br.com.arenacode.desafioiterative.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "CharacterRestController")
@RequestMapping("character")
public class CharacterRestController {

    @Autowired
    private ICharacterService service;

    @GetMapping
    public ResponseEntity<PageRequest<CharacterDto>> listFilter(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "page", required = false) Long page) {
        return ResponseEntity.ok(service.getCharacterByFilter(name, page));
    }
}
