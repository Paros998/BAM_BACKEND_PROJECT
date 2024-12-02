package psk.bam.entity.admins;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import psk.bam.entity.users.UserEntity;
import psk.bam.entity.users.UserRole;

@Getter
@Setter
@Entity(name = "administrators")
@Table(name = "administrators")
@ToString(callSuper = true)
@SuperBuilder
public class AdminEntity extends UserEntity {
    public AdminEntity() {
        this.role = UserRole.ADMIN;
    }
}
