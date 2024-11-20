package psk.bam.initializers;

import lombok.Data;
import lombok.NoArgsConstructor;
import psk.bam.entity.users.UserEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UsersToAddConfig {
    private List<UserEntity> users = new ArrayList<>();
}
