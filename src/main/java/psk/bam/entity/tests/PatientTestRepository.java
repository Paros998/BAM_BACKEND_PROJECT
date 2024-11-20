package psk.bam.entity.tests;

import org.springframework.data.jpa.repository.JpaRepository;
import psk.bam.entity.tests.cases.BloodPressureTestEntity;

import java.util.UUID;

public interface PatientTestRepository extends JpaRepository<BloodPressureTestEntity, UUID> {
}
