package ma.enset.tp4.service;

import ma.enset.tp4.entities.Consultation;
import ma.enset.tp4.entities.Medecin;
import ma.enset.tp4.repositories.ConsultationRepository;
import ma.enset.tp4.repositories.MedecinRepository;
import ma.enset.tp4.repositories.PatientRepository;
import ma.enset.tp4.repositories.RendezVousRepository;
import ma.enset.tp4.entities.Patient;
import ma.enset.tp4.entities.RendezVous;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {

   private PatientRepository patientRepository;
   private MedecinRepository medecinRepository;
   private RendezVousRepository rendezVousRepository;
   private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository,
                               RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository)
    {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {

        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {

        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation)
    {
        return consultationRepository.save(consultation);
    }
}
