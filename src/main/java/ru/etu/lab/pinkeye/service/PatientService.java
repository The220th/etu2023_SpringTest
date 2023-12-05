package ru.etu.lab.pinkeye.service;

import org.springframework.stereotype.Service;
import ru.etu.lab.pinkeye.entity.Patient;

import java.util.Map;
import java.util.HashMap;
import java.util.Locale;

import org.springframework.context.MessageSource;

@Service
public class PatientService
{
    private Map<Integer, Patient> bd;
    private MessageSource messages;

    public PatientService(MessageSource messages)
    {
        this.messages = messages;
        bd = new HashMap<Integer, Patient>();
        for(int i = 0; i < 5051; i++)
        {
            Patient buff = Patient.genPatient();
            bd.put(buff.getId(), buff);
        }
    }

    public String addPatient(Integer patientId, Patient patient, Locale locale)
    {
        String S = "";
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
        Patient res;
        if( bd.containsKey(patientId) )
        {
            res = this.bd.get(patientId);
            return res;
        }
        else
            return null;
    }

    public String replacePatient(Integer patientId, Patient patient, Locale locale) {
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
        if(bd.containsKey(patientId))
        {
            bd.remove(patientId);
            return messages.getMessage("removed_patient_with_id.message", null, locale) + patientId;
        }
        else
            return messages.getMessage("no_such_patient_with_id.message", null, locale) + patientId;
    }

    public MessageSource get_messages() /*thx spring*/
    {
        return messages;
    }
}
