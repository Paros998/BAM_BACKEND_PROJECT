package psk.bam.initializers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import psk.bam.entity.users.UserRepository;

import java.util.stream.Stream;

@Log4j2
@RequiredArgsConstructor
public class UsersInitializer implements ApplicationRunner {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UsersToAddConfig config;

    @Override
    @Transactional
    public void run(final ApplicationArguments args) {
        log.info("{} running", this.getClass().getSimpleName());

        final var usersToInitialize = Stream.concat(Stream.concat(
                config.getPatients().stream()
                        .filter(patientEntity -> userRepository.findByUsername(patientEntity.getUsername()).isEmpty()),
                config.getDoctors().stream()
                        .filter(doctorEntity -> userRepository.findByUsername(doctorEntity.getUsername()).isEmpty())),
                config.getAdmins().stream()
                        .filter(adminEntity -> userRepository.findByUsername(adminEntity.getUsername()).isEmpty())
        ).toList();

        usersToInitialize.forEach(user -> {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        });

        log.info("Initialized users: {}", usersToInitialize);
    }
}
