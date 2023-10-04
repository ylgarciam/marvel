package com.consumo.marvel.service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.consumo.marvel.entity.Marvel;
import com.consumo.marvel.repository.MarvelRepository;
import ConsumoApiMarvel.ConsumoApi;

@Service
public class MarvelServiceImpl implements MarvelService{

	@Autowired 
	MarvelRepository marvelRepository;

	@Override
	public String getCharacters() throws NoSuchAlgorithmException {
		ConsumoApi consumoApi = new ConsumoApi();
		this.insertaHora();
		return consumoApi.getCharacters();
	}
	
	@Override
	public String getCharactersById(String idCharacter) throws NoSuchAlgorithmException {
		ConsumoApi consumoApi = new ConsumoApi();
		this.insertaHora();
		return consumoApi.getCharactersById(idCharacter);
	}
	public List<Marvel> getBitacoraH2( ) {
		return marvelRepository.findAll();
	}
	private void insertaHora() {
		Marvel marvel = new Marvel();
		marvel.setHoraConsulta(LocalTime.now());
		marvelRepository.save(marvel);
	}
	

	

}
