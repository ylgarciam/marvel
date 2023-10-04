package com.consumo.marvel.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.consumo.marvel.entity.Marvel;

public interface MarvelService {
	
	String getCharacters() throws NoSuchAlgorithmException;
	
	String getCharactersById(String idCharacter) throws NoSuchAlgorithmException;
	
	List<Marvel> getBitacoraH2();
	

}
