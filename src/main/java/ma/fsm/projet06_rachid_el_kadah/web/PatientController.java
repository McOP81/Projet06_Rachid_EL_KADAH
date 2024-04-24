package ma.fsm.projet06_rachid_el_kadah.web;

import lombok.AllArgsConstructor;
import ma.fsm.projet06_rachid_el_kadah.entities.Patient;
import ma.fsm.projet06_rachid_el_kadah.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model){
        List<Patient> patientList = patientRepository.findAll();
        model.addAttribute("listPatients", patientList);
        return "patients";
    }
}
