package ru.etu.lab.pinkeye.repository;

//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import ru.etu.lab.pinkeye.entity.Patient;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;



@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer>
{
//    @Modifying
//    @Query("delete from patient b where b.id=:id")
//    public void deletePatient(@Param("id") Integer id);


    // public void deleteById(Integer id);
    // public Patient findById(Integer id);
    public List<Patient> findByKind(Integer kind);

    public Patient findByCause(String cause);
}