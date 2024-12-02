package psk.bam.entity.doctors;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository<DoctorEntity, UUID> {
}

