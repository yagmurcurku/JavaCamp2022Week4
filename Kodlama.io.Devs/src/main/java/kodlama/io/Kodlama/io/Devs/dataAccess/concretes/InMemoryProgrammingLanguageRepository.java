package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;


@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository{

	List<ProgrammingLanguage> programmingLanguages;
	
	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		
		programmingLanguages.add(new ProgrammingLanguage(1, "C#"));
		programmingLanguages.add(new ProgrammingLanguage(2, "JAVA"));
		programmingLanguages.add(new ProgrammingLanguage(3, "Python"));
	}


	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguages;
	}
	
	
	@Override
	public void add(ProgrammingLanguage language) {
		programmingLanguages.add(language);
	}
	

	@Override
	public void delete(int id) {
		programmingLanguages.remove(getById(id));
	}

	
	@Override
	public void update(ProgrammingLanguage language) {
		for (ProgrammingLanguage pl : programmingLanguages) {
			if (pl.getId() == language.getId()) {
				pl.setName(language.getName());
			}
		}
	}

	
	@Override
	public ProgrammingLanguage getById(int id) {
		for (ProgrammingLanguage pl : programmingLanguages) {
			if (pl.getId() == id) {
				return pl;
			}
		}
		return null;
	}
}
