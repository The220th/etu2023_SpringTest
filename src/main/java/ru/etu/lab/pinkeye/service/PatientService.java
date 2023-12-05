package ru.etu.lab.pinkeye.service;

import org.springframework.stereotype.Service;
import ru.etu.lab.pinkeye.entity.Patient;

import java.util.Map;
import java.util.HashMap;

@Service
public class PatientService
{
    private Map<Integer, Patient> bd;
    public PatientService()
    {
        bd = new HashMap<Integer, Patient>();
        for(int i = 0; i < 5051; i++)
        {
            Patient buff = Patient.genPatient();
            bd.put(buff.getId(), buff);
        }
    }

    public String addPatient(Integer patientId, Patient patient)
    {
        String S = "";
        if(bd.containsKey(patientId))
            return "Patient with id=" + patientId + " already exists";
        else
        {
            patient.setId(patientId);
            bd.put(patientId, patient);
            return "Added with id=" + patientId;
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

    public String replacePatient(Integer patientId, Patient patient) {
        String S = "";
        if(bd.containsKey(patientId))
        {
            patient.setId(patientId);
            bd.put(patientId, patient);
            S += "Replaced with id=" + patientId;
        }
        else
            return "No such patient with id=" + patientId;
        return S;
    }

    public String deletePatient(Integer patientId)
    {
        if(bd.containsKey(patientId))
        {
            bd.remove(patientId);
            return "Removed patient with id=" + patientId;
        }
        else
            return "No such patient with id=" + patientId;
    }
}
