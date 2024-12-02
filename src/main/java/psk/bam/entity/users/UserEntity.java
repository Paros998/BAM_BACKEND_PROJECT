package psk.bam.entity.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@Entity(name = "users")
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public class UserEntity implements UserDetails {
    private static final String ROLE_PREFIX = "ROLE_";

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            nullable = false,
            updatable = false
    )
    protected UUID userId;

    @ToString.Exclude
    @JsonIgnore
    protected String password;

    @Column(unique = true, nullable = false)
    protected String email;

    @Column(unique = true, nullable = false)
    protected String username;

    protected String firstName;

    protected String lastName;

    protected String phoneNumber;

    protected String nationalId;

    protected Boolean enabled;

    protected LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    protected UserRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(ROLE_PREFIX + role.name()));
    }

    @Override
    public boolean isAccountNonLocked() {
        return !enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserEntity that = (UserEntity) o;
        return Objects.equals(userId, that.userId) && Objects.equals(password, that.password)
                && Objects.equals(email, that.email) && Objects.equals(username, that.username)
                && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName)
                && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(nationalId, that.nationalId)
                && Objects.equals(enabled, that.enabled) && Objects.equals(dateOfBirth, that.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this)
                .getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

}
