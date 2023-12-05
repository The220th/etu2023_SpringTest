package ru.etu.lab.pinkeye.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import ru.etu.lab.pinkeye.entity.Patient;
import ru.etu.lab.pinkeye.service.PatientService;

@RestController
@RequestMapping(value="hospital/pinkeye")
public class PatientController
{
    @Autowired
    private PatientService patientService;

    @PostMapping("/{patient_id}")  // Добавление
    public ResponseEntity<String> addArthritisCase(@PathVariable("patient_id") Integer patient_id,
                                                   @RequestBody Patient request)
    {
        return ResponseEntity.ok(patientService.addPatient(patient_id, request));
    }


    @GetMapping("/{patient_id}")  // Получение
    public ResponseEntity<Patient> getPatient(@PathVariable("patient_id") Integer patient_id)
    {
        Patient res = patientService.getPatient(patient_id);
        if(res != null)
            return ResponseEntity.ok(res);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            // return ResponseEntity.notFound().build();
            // return ResponseEntity.notFound(null);
    }

    @PutMapping(value = "/{patient_id}")
    public ResponseEntity<String> editArthritisCase(@PathVariable("patient_id") Integer patient_id,
                                                    @RequestBody Patient request)
    {
        return ResponseEntity.ok(patientService.replacePatient(patient_id, request));
    }

    @DeleteMapping(value = "/{patient_id}")
    public ResponseEntity<String> deleteArthritisCase(@PathVariable("patient_id") Integer patient_id)
    {
        return ResponseEntity.ok(patientService.deletePatient(patient_id));
    }

}
