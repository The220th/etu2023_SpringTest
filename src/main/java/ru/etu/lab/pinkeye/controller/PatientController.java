package ru.etu.lab.pinkeye.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.etu.lab.pinkeye.entity.Patient;
import ru.etu.lab.pinkeye.service.PatientService;

@RestController
@RequestMapping(value="hospital/{hospital_id}/pinkeye")
public class PatientController
{
    @Autowired
    private PatientService patientService;

    @GetMapping("/{patient_id}")
    public ResponseEntity<Patient> getPatient(@PathVariable("hospital_id") Integer hospital_id,
                                              @PathVariable("patient_id") Integer patient_id)
    {
        Patient res = patientService.getPatient(patient_id);
        if(res != null)
            return ResponseEntity.ok(res);
        else
            return ResponseEntity.notFound().build();
            // return ResponseEntity.notFound(null);
    }
}
