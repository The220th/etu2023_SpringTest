package ru.etu.lab.pinkeye.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.etu.lab.pinkeye.entity.Patient;
import ru.etu.lab.pinkeye.config.ServiceConfig;

import java.util.*;

import org.springframework.context.MessageSource;

import ru.etu.lab.pinkeye.repository.PatientRepository;

@Service
public class PatientService
{
    private Boolean FILL_DB = true;

    private HashSet<Integer> ids = new HashSet<Integer>();
    private Boolean IDS_INITED = false;
    @Autowired
    private MessageSource messages;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ServiceConfig config;

    public String addPatient(Integer patientId, Patient patient, Locale locale)
    {
        gen_db(); init_ids();

        if(this.ids.contains(patientId))
            return messages.getMessage("patient_with_id.message", null, locale) + patientId + " " + messages.getMessage("already_exists.message", null, locale);
        else
        {
            patient.setId(patientId);
            patientRepository.save(patient);
            this.ids.add(patientId);
            return messages.getMessage("added_with_id.message", null, locale) + patientId;
        }
    }

    public Patient getPatient(Integer patientId)
    {
        gen_db(); init_ids();

        Patient res;
        if( this.ids.contains(patientId) )
        {

            Optional<Patient> tried = patientRepository.findById(patientId);
            if(!tried.isPresent())
                return null;
            res = tried.get();
            return res;
        }
        else
            return null;
    }

    public String replacePatient(Integer patientId, Patient patient, Locale locale)
    {
        gen_db(); init_ids();

        if(this.ids.contains(patientId))
        {
            patient.setId(patientId);
            patientRepository.save(patient);
            return messages.getMessage("replaced_with_id.message", null, locale) + patientId;
        }
        else
            return messages.getMessage("no_such_patient_with_id.message", null, locale) + patientId;
    }

    public String deletePatient(Integer patientId, Locale locale)
    {
        gen_db(); init_ids();

        if(this.ids.contains(patientId))
        {
            // bd.remove(patientId);
            patientRepository.deleteById(patientId);
            this.ids.remove(patientId);
            return messages.getMessage("removed_patient_with_id.message", null, locale) + patientId;
        }
        else
            return messages.getMessage("no_such_patient_with_id.message", null, locale) + patientId;
    }

    private void init_ids()
    {
        if(IDS_INITED == false)
        {
            Iterable<Patient> getted = patientRepository.findAll();
            for (Patient p : getted)
            {
                this.ids.add(p.getId());
                // System.out.println(p);
            }
            this.IDS_INITED = true;
        }
    }

    private void gen_db()
    {
        if(FILL_DB)
        {
            List<Patient> buffs = new ArrayList<Patient>();
            for(int i = 0; i < 5051; i++)
            {
                Patient buff = Patient.genPatient();
                buffs.add(buff);
                // patientRepository.save(buff);
            }
            patientRepository.saveAll(buffs);
            FILL_DB = false;
        }

    }

    public MessageSource get_messages() /*thx spring*/
    {
        return messages;
    }
}
