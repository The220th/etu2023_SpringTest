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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.actuate.info.MapInfoContributor;

import org.springframework.http.HttpStatus;
import ru.etu.lab.pinkeye.entity.Patient;
import ru.etu.lab.pinkeye.service.PatientService;
import org.springframework.context.MessageSource;

import java.util.Locale;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value="hospital/pinkeye")
public class PatientController
{
    @Autowired
    private PatientService patientService;

    @PostMapping("/{patient_id}")  // Добавление
    public ResponseEntity<String> addPatient(@PathVariable("patient_id") Integer patient_id,
                                                   @RequestBody Patient request,
                                                   @RequestHeader(value = "Accept-Language",required = false) Locale locale)
    {
        return ResponseEntity.ok(patientService.addPatient(patient_id, request, locale));
    }


//    @GetMapping("/{patient_id}")  // Получение
//    public ResponseEntity<Patient> getPatient(@PathVariable("patient_id") Integer patient_id,
//                                              @RequestHeader(value = "Accept-Language",required = false) Locale locale)
//    {
//        Patient res = patientService.getPatient(patient_id);
//        if(res != null)
//            return ResponseEntity.ok(res);
//        else
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//            // return ResponseEntity.notFound().build();
//            // return ResponseEntity.notFound(null);
//    }

    @GetMapping("/{patient_id}")  // Получение
    public ResponseEntity<Patient> getPatient(@PathVariable("patient_id") Integer patient_id,
                                              @RequestHeader(value = "Accept-Language",required = false) Locale locale)
    {
        MessageSource messages = patientService.get_messages();
        Patient res = patientService.getPatient(patient_id);
        if(res != null)
        {
            res.add(
                linkTo(methodOn(PatientController.class)
                        .getPatient(patient_id, locale))
                        .withSelfRel(),
                linkTo(methodOn(PatientController.class)
                        .addPatient(patient_id, res, locale))
                        .withRel(messages.getMessage("create_link.message", null, locale)),
                linkTo(methodOn(PatientController.class)
                        .modPatient(patient_id, res, locale))
                        .withRel(messages.getMessage("update_link.message", null, locale)),
                linkTo(methodOn(PatientController.class)
                        .deletePatient(patient_id, locale))
                        .withRel(messages.getMessage("delete_link.message", null, locale))
            );
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PutMapping(value = "/{patient_id}")  // Модификация
    public ResponseEntity<String> modPatient(@PathVariable("patient_id") Integer patient_id,
                                                    @RequestBody Patient request,
                                                    @RequestHeader(value = "Accept-Language",required = false) Locale locale)
    {
        return ResponseEntity.ok(patientService.replacePatient(patient_id, request, locale));
    }

    @DeleteMapping(value = "/{patient_id}")  // Удаление
    public ResponseEntity<String> deletePatient(@PathVariable("patient_id") Integer patient_id,
                                                      @RequestHeader(value = "Accept-Language",required = false) Locale locale)
    {
        return ResponseEntity.ok(patientService.deletePatient(patient_id, locale));
    }

    @Bean
    InfoContributor getInfoContributor()
    {
        Map<String, Object> details = new HashMap<>();
        details.put("nameApp", "Pinkeye");
        details.put("developers", "The220th and Victor");
        details.put("group", "9308");
        details.put("email", "exmaple@mail.ru");

        Map<String, Object> wrapper = new HashMap<>();
        wrapper.put("info", details);

        return new MapInfoContributor(wrapper);
    }
}
