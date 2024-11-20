package psk.bam.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import psk.bam.entity.users.UserRepository;
import psk.bam.initializers.UsersInitializer;
import psk.bam.initializers.UsersToAddConfig;

@Configuration
@ConditionalOnProperty(prefix = "users.starter", value = "enabled", havingValue = "true")
public class UsersStarterConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "users.starter.data")
    public UsersToAddConfig usersToAddConfig() {
        return new UsersToAddConfig();
    }

    @Bean
    public UsersInitializer usersInitializer(
            final @Lazy PasswordEncoder passwordEncoder,
            final @Lazy UserRepository userRepository) {
        return new UsersInitializer(passwordEncoder, userRepository, usersToAddConfig());
    }
}
