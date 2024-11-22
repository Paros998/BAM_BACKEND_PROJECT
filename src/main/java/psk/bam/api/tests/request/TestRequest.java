package psk.bam.api.tests.request;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@ToString
@EqualsAndHashCode
@SuperBuilder
@NoArgsConstructor
public abstract class TestRequest {
    @NonNull
    private UUID patientId;
    private LocalDateTime dateOfTest;
    private String note;
}
