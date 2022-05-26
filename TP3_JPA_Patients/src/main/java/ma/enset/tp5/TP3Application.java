package ma.enset.tp5;

import ma.enset.tp5.entities.Patient;
import ma.enset.tp5.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TP3Application implements CommandLineRunner {


    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(TP3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        for (int i =0;i<100;i++){
            patientRepository.save(new Patient(null,"wissale",new Date(),Math.random()>0.5?true:false,(int)(Math.random()*100)));
        }

        Page<Patient> patients = patientRepository.findAll(PageRequest.of(0,5));
        System.out.println("Total elements : "+patients.getTotalElements());
        System.out.println("Total pages : "+patients.getTotalPages());
        System.out.println("Page number : "+patients.getNumber());

        List<Patient>content = patients.getContent();

        List<Patient> patientList = patientRepository.findByMalade(true);
        List<Patient> patients1 = patientRepository.chercherPatients("%h%",88);

        Page<Patient> byMalade = patientRepository.findByMalade(false,PageRequest.of(0,10));
        patients1.forEach(p->{
            System.out.println("_______________________________________");
            System.out.println("Patient = id: "+p.getId()+" name : "+ p.getNom() +" malade : " +p.isMalade()+" score: "+p.getScore());
        });

        System.out.println("_________________________________");
        Patient patient = patientRepository.findById(1L).orElse(null);
        if (patient!= null)
        {
            System.out.println("name : " + patient.getNom());
            System.out.println("malade : " + patient.isMalade());
        }

        patient.setScore(1928);
        patientRepository.save(patient);

    }
}
