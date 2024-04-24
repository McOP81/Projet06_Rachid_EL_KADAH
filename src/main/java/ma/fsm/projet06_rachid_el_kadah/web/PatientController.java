package ma.fsm.projet06_rachid_el_kadah.web;

import lombok.AllArgsConstructor;
import ma.fsm.projet06_rachid_el_kadah.entities.Patient;
import ma.fsm.projet06_rachid_el_kadah.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model, @RequestParam(name = "page",defaultValue = "0") int page,
                        @RequestParam(name = "size",defaultValue = "3") int size ){
        Page<Patient> pagePatient = patientRepository.findAll(PageRequest.of(page,size));
        model.addAttribute("listPatients", pagePatient.getContent());
        return "patients";
    }
}
