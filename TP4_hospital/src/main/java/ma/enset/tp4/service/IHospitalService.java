package ma.enset.tp4.service;

import ma.enset.tp4.entities.Consultation;
import ma.enset.tp4.entities.Medecin;
import ma.enset.tp4.entities.Patient;
import ma.enset.tp4.entities.RendezVous;

public interface IHospitalService {

    Patient savePatient(Patient patient);

    Medecin saveMedecin(Medecin medecin);

    RendezVous saveRendezVous(RendezVous rendezVous);

    Consultation saveConsultation(Consultation consultation);
}
