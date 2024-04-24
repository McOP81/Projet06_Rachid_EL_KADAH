package ma.fsm.projet06_rachid_el_kadah.repository;

import ma.fsm.projet06_rachid_el_kadah.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
