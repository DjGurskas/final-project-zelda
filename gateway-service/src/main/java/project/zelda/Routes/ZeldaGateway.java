package project.zelda.Routes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.RouteLocator;

@Configuration
public class ZeldaGateway {
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("ZeldaAllGames", r -> r.path("/api/games")
						.uri("http://localhost:8082"))
				.route("/api/games/5f6ce9d805615a85623ec2b7", r -> r.path("/api/games/*")
						.filters(f -> f.rewritePath("/<id>.*", "/${id}"))
						.uri("http://localhost:8082"))
				.route("/users", r -> r.path("/api/users")
						.uri("http://localhost:8080"))
				.route("/create", r -> r.path("/api/create")
						.uri("http://localhost:8080"))
				.route("/update", r -> r.path("/api/update/*")
						.filters(f -> f.rewritePath("/<idUser>.*", "/${idUser}"))
						.uri("http://localhost:8080"))
				.route("/delete", r -> r.path("/api/delete/*")
						.filters(f -> f.rewritePath("/<idUser>.*", "/${idUser}"))
						.uri("http://localhost:8080"))
				.build();
	}
}
