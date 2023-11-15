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
}
