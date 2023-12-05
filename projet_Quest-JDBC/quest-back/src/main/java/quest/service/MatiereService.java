package quest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.dao.IDAOMatiere;
import quest.model.Matiere;

@Service
public class MatiereService {
	
	@Autowired
	private IDAOMatiere daoMatiere;
	
	
	public Matiere selectById(Integer id) 
	{
		if(!(id==null || id<0)) 
		{
			Optional<Matiere> opt = daoMatiere.findById(id);
			if(!opt.isEmpty()) 
			{
				return opt.get();
			}
		}
		return null;
	}
	
	public List<Matiere> selectAllMatieres()
	{
		return daoMatiere.findAll();
	} 
	
	public Matiere ajouter(Matiere matiere) 
	{
		if(matiere==null) 
		{
			throw new RuntimeException("Matiere a insert est null ?!");
		}
		if(matiere.getLibelle()==null) 
		{
			throw new RuntimeException("Matiere a insert sans libelle !");
		}
		if(matiere.getQuest()==0) 
		{
			throw new RuntimeException("Matiere a insert sans code quest !");
		}
		return daoMatiere.save(matiere);	
	}
	
	public Matiere modifier(Matiere matiere) 
	{
		if(matiere==null) 
		{
			throw new RuntimeException("Matiere a update est null ?!");
		}
		if(matiere.getId()==null) 
		{
			throw new RuntimeException("Matiere a update sans id !");
		}
		if(matiere.getLibelle()==null) 
		{
			throw new RuntimeException("Matiere a update sans libelle !");
		}
		if(matiere.getQuest()==0) 
		{
			throw new RuntimeException("Matiere a update sans code quest !");
		}
		return daoMatiere.save(matiere);	
	}
	
	
	public Matiere modifierPartielle(Matiere matiere) 
	{
		if(matiere==null) 
		{
			throw new RuntimeException("Matiere a update est null ?!");
		}
		Matiere copie = daoMatiere.findById(matiere.getId()).get();
		if(matiere.getLibelle()==null) 
		{
			matiere.setLibelle(copie.getLibelle());
		}
		if(matiere.getQuest()==0) 
		{
			matiere.setQuest(copie.getQuest());
		}
		return daoMatiere.save(matiere);	
	}
	
	public void supprimerParId(Integer id) 
	{
		if(id==null) 
		{
			throw new RuntimeException("Impossible de supprimer avec un id null");
		}
		Matiere matiere = daoMatiere.findById(id).get();
		supprimer(matiere);
	}
	
	public void supprimer(Matiere matiere) 
	{
		matiere = daoMatiere.save(matiere);
		daoMatiere.delete(matiere);
	}
}
