package hopital.dao;

import java.util.List;

import hopital.model.Patient;
import hopital.model.Visite;

public interface IDAOVisite extends IDAO<Visite,Integer> {

	public List<Visite> findAllByPatient(Patient patient);
}
