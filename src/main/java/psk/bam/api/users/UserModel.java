package psk.bam.api.users;

import lombok.*;
import lombok.experimental.SuperBuilder;
import psk.bam.entity.users.UserRole;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
@EqualsAndHashCode
public class UserModel implements Serializable {
    private UUID userId;
    private String username;
    private Boolean enabled;
    private UserRole role;
}
