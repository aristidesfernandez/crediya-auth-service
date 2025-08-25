package co.com.powerup.api;

import co.com.powerup.api.config.UserPath;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {

    private final UserPath userPath;

    private final Handler userHandler;

    public RouterRest(UserPath userPath, Handler userHandler) {
        this.userPath = userPath;
        this.userHandler = userHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route(POST(userPath.getUsers()), userHandler::listenSaveUser)
                .andRoute(PUT(userPath.getUsers()), userHandler::listenUpdateUser)
                .andRoute(DELETE(userPath.getUserById()), userHandler::listenDeleteUser)
                .andRoute(GET(userPath.getUsers()), userHandler::listenGetAllUsers)
                .andRoute(GET(userPath.getUserById()), userHandler::listenGetUserById);
    }
}
