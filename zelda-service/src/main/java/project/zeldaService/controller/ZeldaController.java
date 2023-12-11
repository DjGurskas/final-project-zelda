package project.zeldaService.controller;

import project.zeldaService.service.ApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/zelda")
public class ZeldaController {
    private final ApiService apiService;

    public ZeldaController(ApiService apiService) {

        this.apiService = apiService;
    }

    @GetMapping("/games")
    public ResponseEntity<String> getGames(){

        return apiService.getGames();
    }

    @GetMapping("/games/{gameId}")
    public ResponseEntity<String> getGamesById(@PathVariable long gameId) {

        return apiService.getGameById(gameId);
    }

    @GetMapping
    public ResponseEntity<String> getZeldaData() {
        String zeldaData = apiService.getZeldaData();
        return ResponseEntity.ok(zeldaData);
    }

}

