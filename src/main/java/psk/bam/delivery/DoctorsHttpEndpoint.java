package psk.bam.delivery;

import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.web.bind.annotation.*;
import psk.bam.api.tests.request.AddDoctorRequest;
import psk.bam.api.users.DoctorModel;
import psk.bam.mapper.DoctorMapper;
import psk.bam.service.DoctorService;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/doctors")
@RequiredArgsConstructor
@RestController
public class DoctorsHttpEndpoint {
    private final DoctorService doctorService;
    private final DoctorMapper doctorMapper;

    @GetMapping("/for-assignment")
    public List<DoctorModel> findAvailableDoctors() {
        return doctorService.findAvailableDoctors().stream()
                .map(doctorMapper::mapToDoctorModel)
                .toList();
    }

    @PostMapping("/new-doctor")
    public UUID createNewDoctor(final @NonNull @Valid @RequestBody AddDoctorRequest request) {
        throw new NotImplementedException();
    }
}
