package psk.bam.entity.tests;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientTestRepository extends JpaRepository<PatientTestEntity, UUID> {
}
