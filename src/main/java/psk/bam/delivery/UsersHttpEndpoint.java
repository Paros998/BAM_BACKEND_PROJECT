package psk.bam.delivery;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import psk.bam.api.UserModel;
import psk.bam.entity.users.UserRepository;

@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@RestController
public class UsersHttpEndpoint {
    private final UserRepository userRepository;

    @GetMapping("{userId}")
    public UserModel findUser(final @PathVariable("userId") UUID userId) {
        return userRepository.findById(userId)
                .map(user -> UserModel.builder()
                        .userId(user.getUserId())
                        .username(user.getUsername())
                        .enabled(user.isEnabled())
                        .build())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
