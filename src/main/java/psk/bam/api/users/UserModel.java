package psk.bam.api.users;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import psk.bam.entity.users.UserRole;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class UserModel implements Serializable {
    private UUID userId;
    private String username;
    private Boolean enabled;
    private UserRole role;
}
