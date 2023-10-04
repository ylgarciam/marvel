package com.consumo.marvel.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.consumo.marvel.entity.Marvel;
import com.consumo.marvel.service.MarvelService;

@Controller
@RequestMapping(value="/marvel")
public class MarvelController {
	@Autowired
	private MarvelService marvelService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/getCharacters")
	public ResponseEntity<String> getCharacters() throws NoSuchAlgorithmException{
		
		return new ResponseEntity<>(marvelService.getCharacters(),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/getCharactersById")
	public ResponseEntity<String> getCharactersById(@RequestParam String idCharacter) throws NoSuchAlgorithmException{
		
		return new ResponseEntity<>(marvelService.getCharactersById(idCharacter),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/getBitacoraH2")
	public ResponseEntity<List<Marvel>> getBitacoraH2(){
		
		return new ResponseEntity<>(marvelService.getBitacoraH2(),HttpStatus.OK);
	}

}
