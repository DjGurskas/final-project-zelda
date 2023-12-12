package project.zeldaService.controller;

import project.zeldaService.model.GamesIdModel;
import project.zeldaService.model.GamesModel;
import project.zeldaService.service.ApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

    @RestController
    @RequestMapping("api")
    public class ZeldaController {
    private final ApiService apiService;

    public ZeldaController(ApiService apiService) {

        this.apiService = apiService;
    }

    @GetMapping("games")
    public ResponseEntity<GamesModel> getGames(){

        return apiService.getGames();
    }

    @GetMapping("/games/{gameId}")
    public ResponseEntity<GamesIdModel> getGamesById(@PathVariable String gameId) {

        return apiService.getGameById(gameId);
    }

}

