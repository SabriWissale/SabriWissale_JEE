package ma.enset.tp4;

import ma.enset.tp4.entities.*;
import ma.enset.tp4.repositories.ConsultationRepository;
import ma.enset.tp4.repositories.MedecinRepository;
import ma.enset.tp4.repositories.PatientRepository;
import ma.enset.tp4.repositories.RendezVousRepository;
import me.enset.hospital.entities.*;
import ma.enset.tp4.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class TP4Application {

    public static void main(String[] args) {
        SpringApplication.run(TP4Application.class, args);
    }
    @Bean
    CommandLineRunner start(IHospitalService hospitalService,
                            PatientRepository patientRepository,
                            RendezVousRepository rendezVousRepository,
                            ConsultationRepository consultationRepository,
                            MedecinRepository medecinRepository){
        return args -> {

            Stream.of("wissale","basma","salma")
                    .forEach(name ->{
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });

            Stream.of("imane","sara","nouhaila")
                    .forEach(name ->{
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"chirurgie");
                        hospitalService.saveMedecin(medecin);
                    });



            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("wissale");

            Medecin medecin = medecinRepository.findByNom("sara");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDateCreation(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);

            RendezVous savedRDV = hospitalService.saveRendezVous(rendezVous);
            System.out.println("rendez vous : " + savedRDV.getId());

            RendezVous rdv = rendezVousRepository.findAll().get(0);


            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rdv);
            consultation.setRapportConsultation("rapport consultation ");
            hospitalService.saveConsultation(consultation);
        };
    }

}
