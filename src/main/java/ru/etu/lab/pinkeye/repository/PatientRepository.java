package ru.etu.lab.pinkeye.repository;

import ru.etu.lab.pinkeye.entity.Patient;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;



@Repository
public interface PatientRepository extends CrudRepository<Patient, String>
{
    public List<Patient> findByKind(Integer kind);

    public Patient findByCause(String cause);
}