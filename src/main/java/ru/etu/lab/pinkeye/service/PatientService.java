package ru.etu.lab.pinkeye.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.etu.lab.pinkeye.entity.Patient;
import ru.etu.lab.pinkeye.config.ServiceConfig;

import java.util.Map;
import java.util.Locale;

import org.springframework.context.MessageSource;

import ru.etu.lab.pinkeye.repository.PatientRepository;

@Service
public class PatientService
{
    private Boolean FILL_DB = true;

    private Map<Integer, Patient> bd;
    @Autowired
    private MessageSource messages;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ServiceConfig config;

    public String addPatient(Integer patientId, Patient patient, Locale locale)
    {
        gen_db();

        if(bd.containsKey(patientId))
            return messages.getMessage("patient_with_id.message", null, locale) + patientId + " " + messages.getMessage("already_exists.message", null, locale);
        else
        {
            patient.setId(patientId);
            bd.put(patientId, patient);
            return messages.getMessage("added_with_id.message", null, locale) + patientId;
        }
    }

    public Patient getPatient(Integer patientId)
    {
        gen_db();

        Patient res;
        if( bd.containsKey(patientId) )
        {
            res = this.bd.get(patientId);
            return res;
        }
        else
            return null;
    }

    public String replacePatient(Integer patientId, Patient patient, Locale locale)
    {
        gen_db();

        if(bd.containsKey(patientId))
        {
            patient.setId(patientId);
            bd.put(patientId, patient);
            return messages.getMessage("replaced_with_id.message", null, locale) + patientId;
        }
        else
            return messages.getMessage("no_such_patient_with_id.message", null, locale) + patientId;
    }

    public String deletePatient(Integer patientId, Locale locale)
    {
        gen_db();

        if(bd.containsKey(patientId))
        {
            bd.remove(patientId);
            return messages.getMessage("removed_patient_with_id.message", null, locale) + patientId;
        }
        else
            return messages.getMessage("no_such_patient_with_id.message", null, locale) + patientId;
    }

    private void gen_db()
    {
        if(FILL_DB)
        {
            for(int i = 0; i < 10; i++)
            {
                Patient buff = Patient.genPatient();
                patientRepository.save(buff);
            }
            FILL_DB = false;
        }

    }

    public MessageSource get_messages() /*thx spring*/
    {
        return messages;
    }
}
