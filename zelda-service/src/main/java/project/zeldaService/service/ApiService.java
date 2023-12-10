package project.zeldaService.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ApiService {

    private static final Logger logger = LoggerFactory.getLogger(ApiService.class);

    private final RestTemplate restTemplate;
    private final String baseUrl;

    public ApiService(RestTemplate restTemplate, @Value("${zelda.api.base-url}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    public ResponseEntity<String> getGames(){
        String url = baseUrl + "/games";
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            logger.info("Successfully retrieved games from Zelda API");
            return response;
        } catch (Exception e) {
            logger.error("Error when fetching games from the Zelda API");
            throw new RuntimeException("Failed to fetch games from Zelda API", e);
        }
    }

    public ResponseEntity<String> getGameById(long gameId) {
        String url = baseUrl + "/games/" + gameId;
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            logger.info("Successfully retrieved game with ID {} from Zelda API", gameId);
            return response;
        } catch (Exception e) {
            logger.error("Error while fetching game with ID {} from Zelda API", gameId, e);
            throw new RuntimeException("Failed to fetch game with ID " + gameId + " from Zelda API", e);
        }
    }

}
