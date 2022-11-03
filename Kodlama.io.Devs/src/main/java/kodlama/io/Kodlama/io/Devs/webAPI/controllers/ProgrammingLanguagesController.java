package kodlama.io.Kodlama.io.Devs.webAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {
	
	private ProgrammingLanguageService languageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService languageService) {
		this.languageService = languageService;
	}
	
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		return languageService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody ProgrammingLanguage language){
		languageService.add(language);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam int id) {
		languageService.delete(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody ProgrammingLanguage language) {
		languageService.update(language);
	}
	
	@GetMapping("/getbyid")
	public ProgrammingLanguage getById(@RequestParam int id) {
		return languageService.getById(id);
	}
	
}
