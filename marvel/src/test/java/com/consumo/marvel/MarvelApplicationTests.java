package com.consumo.marvel;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.consumo.marvel.repository.MarvelRepository;
import com.consumo.marvel.service.MarvelService;

@WebMvcTest
class MarvelApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private  MarvelService marvelService;
	
	@MockBean
	private  MarvelRepository marvelRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testMarvelCharacters() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/marvel/getCharacters").contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());

	}
	
	@Test
	void testMarvelCharactersById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/marvel/getCharactersById?idCharacter=1011334").contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());

	}
	
	@Test
	void testMarvelCharactersSave() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/marvel/getCharacters").contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
		
		Mockito.verify(marvelService).getCharacters();
		

	}
	
	@Test
	void testMarvelCharactersByIdSave() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/marvel/getCharactersById?idCharacter=1011334").contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
		
		Mockito.verify(marvelService).getCharactersById("1011334");
	}
}
