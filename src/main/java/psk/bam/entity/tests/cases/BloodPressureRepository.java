package psk.bam.entity.tests.cases;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BloodPressureRepository extends JpaRepository<BloodPressureEntity, UUID> {
}
