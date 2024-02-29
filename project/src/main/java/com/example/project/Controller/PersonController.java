package com.example.project.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


//import com.example.project.PersonErrorResponse;
//import com.example.project.PersonNotFoundException;
import com.example.project.Model.Person;
import com.example.project.serviceImpl.PersonImpl;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/person")
@AllArgsConstructor
@NoArgsConstructor

public class PersonController {
	@Autowired
	PersonImpl personService;
	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webApp/images";

	// public ResponseEntity<List<Person>> getAllpersons(){
	// return ResponseEntity.ok(personService.getAllPersons());
	// }
	@GetMapping
	public ResponseEntity<List<Person>> getPersons() {
		List<Person> person = personService.getAllPersons();
		return new ResponseEntity<>(person, HttpStatus.OK);
	}

	@DeleteMapping("/person/delete/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable Long id) {
		personService.deletePerson(id);
		return ResponseEntity.ok("Person Details deleted successfully!");
	}

	@GetMapping("/person/{id}")

	public ResponseEntity<Person> getPersonById(@PathVariable Long id) {

		Person persona = personService.getPersonById(id);
		return ResponseEntity.ok(persona);

	}

	@PostMapping
	public ResponseEntity<Person> createPerson(@Valid @ModelAttribute Person persona,
			@RequestParam("image") MultipartFile file) throws IOException {
		String originalFilename = file.getOriginalFilename();
		Path fileNameAndPath = Paths.get(uploadDirectory, originalFilename);
		Files.write(fileNameAndPath, file.getBytes());
		persona.setImgUploader(originalFilename);
		Person createdPerson = personService.createPerson(persona);
		return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
	}

	@PutMapping("/person/{id}")
	public ResponseEntity<Optional<Person>> updatePersona(@PathVariable Long id, @RequestBody Person updatedPerson) {
		Optional<Person> updatePersona = personService.updatePersonById(id, updatedPerson);
		return ResponseEntity.ok(updatePersona);
	}

	public String savePerson(@RequestBody Person person) {
		return "Person data saved succesfully";
	}

}
