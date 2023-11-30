package seminar.tum.fingerprintdb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FingerprintRepository extends JpaRepository<Fingerprint, Long> {
}
