package seminar.tum.fingerprintdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FingerprintService {

    private final FingerprintRepository fingerprintRepository;

    @Autowired
    public FingerprintService(FingerprintRepository fingerPrintRepository) {
        this.fingerprintRepository = fingerPrintRepository;
    }

    public List<Fingerprint> getAllFingerprints() {
        return fingerprintRepository.findAll();
    }

    public Optional<Fingerprint> getFingerprintById(Long id) {
        return fingerprintRepository.findById(id);
    }

    public Fingerprint saveFingerprint(Fingerprint fingerprintEntity) {
        return fingerprintRepository.save(fingerprintEntity);
    }

    public void deleteFingerprint(Long id) {
        fingerprintRepository.deleteById(id);
    }
}
