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
    public String index(Model model, @RequestParam(name = "page",defaultValue = "0") int p,
                        @RequestParam(name = "size",defaultValue = "3") int s,
                        @RequestParam(name = "keyword",defaultValue = "") String kw ){
        Page<Patient> pagePatient = patientRepository.findByNomContains(kw,PageRequest.of(p,s));
        model.addAttribute("listPatients", pagePatient.getContent());
        model.addAttribute("pages",new int[pagePatient.getTotalPages()]);
        model.addAttribute("currentPage",p);
        model.addAttribute("keyword",kw);
        return "patients";
    }
}
