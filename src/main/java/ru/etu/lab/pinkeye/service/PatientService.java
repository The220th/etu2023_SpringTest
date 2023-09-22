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
        Patient buff;
        buff = new Patient();
        buff.setId(Integer.valueOf(1)); buff.setTemp(367); buff.setHospitalId(0); buff.setType(Boolean.valueOf(true));
        bd.put(buff.getId(), buff);
    }
    public Patient getPatient(Integer patientId)
    {
        Patient res;
        if(bd.containsKey(patientId) == true)
        {
            res = this.bd.get(patientId);
            return res;
        }
        else
            return null;
    }
}
