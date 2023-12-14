package seminar.tum.fingerprintdb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fingerprints")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class FingerprintController {

    private final FingerprintService fingerprintService;

    @Autowired
    public FingerprintController(FingerprintService fingerprintService) {
        this.fingerprintService = fingerprintService;
    }

    @GetMapping
    public List<Fingerprint> getAllFingerprints() {
        return fingerprintService.getAllFingerprints();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fingerprint> getFingerprintById(@PathVariable Long id) {
        Optional<Fingerprint> fingerprint = fingerprintService.getFingerprintById(id);
        return fingerprint.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Fingerprint> createFingerprint(@RequestBody Fingerprint fingerprint) {
        Fingerprint createdFingerprint = fingerprintService.saveFingerprint(fingerprint);
        return ResponseEntity.ok(createdFingerprint);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFingerprint(@PathVariable Long id) {
        fingerprintService.deleteFingerprint(id);
        return ResponseEntity.noContent().build();
    }
}