package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{
	private ProgrammingLanguageRepository repository;
	
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository repository) {
		this.repository = repository;
	}

	
	@Override
	public List<ProgrammingLanguage> getAll() {
		return repository.getAll();
	}

	
	@Override
	public void add(ProgrammingLanguage language) {
		if (checkIfExits(language)) {
			return;
		} else {
			if (!language.getName().isBlank()) {
				repository.add(language);
			}
		}
	}

	
	@Override
	public void delete(int id) {
		repository.delete(id);	
	}

	
	@Override
	public void update(ProgrammingLanguage language) {
		repository.update(language);	
	}

	
	@Override
	public ProgrammingLanguage getById(int id) {
		return repository.getById(id);
	}


	@Override
	public boolean checkIfExits(ProgrammingLanguage language) {
		for (ProgrammingLanguage pl : repository.getAll()) {
			if (pl.getName().equals(language.getName())) {
				return true;
			}
		}
		return false;
	}
}
