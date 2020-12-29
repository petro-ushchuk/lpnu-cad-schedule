package ua.com.lpnu.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.com.lpnu.demo.dto.UserDto;
import ua.com.lpnu.demo.model.enums.Role;
import ua.com.lpnu.demo.service.AuthService;

@SpringBootApplication
public class LpnuCadScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(LpnuCadScheduleApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoAdmin(AuthService authService,
                                       @Value("${app.auth.admin.password}") String password,
                                       @Value("${app.auth.admin.email}") String email) {
        return args -> {
            UserDto userDto = new UserDto();
            userDto.setFirstName("Admin");
            userDto.setSecondName("Admin");
            userDto.setEmail(email);
            userDto.setPassword(password);
           // authService.signUp(userDto, Role.ADMIN);
            authService.signIn(userDto);
        };
    }
}
