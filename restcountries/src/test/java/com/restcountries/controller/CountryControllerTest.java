package com.restcountries.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restcountries.model.Country;
import com.restcountries.service.CountryService;

@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath*:spring-test.xml" })
public class CountryControllerTest {

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Mock
	private CountryService countryService;

	private MockMvc mockMvc;

	private Country country1;

	private Country country2;

	private Country country3;

	private List<Country> countries;

	@InjectMocks
	private CountryController countryController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(countryController).build();
		country1 = new Country();
		country1.setName("USA");
		country2 = new Country();
		country2.setName("Afghanistan");
		country3 = new Country();
		country3.setName("Germany");
		countries = new ArrayList<Country>();
		countries.add(country1);
		countries.add(country2);
		countries.add(country3);
	}

	@Test
	public void getAllCountries() throws IOException, ParseException, Exception {

		when(countryService.getAllCountries()).thenReturn(countries);
		mockMvc.perform(get("/rest/v2/all")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andDo(print());
		verify(countryService, times(1)).getAllCountries();
		verifyNoMoreInteractions(countryService);
	}

	@Test
	public void getAllCountriesByName() throws Exception {
		when(countryService.getCountries("false", "Argentina")).thenReturn(countries);
		mockMvc.perform(get("/rest/v2/name/{country}", "Argentina")).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void getAllCountriesByAlphaCode() throws Exception {
		when(countryService.getCountriesByCode("co")).thenReturn(countries);
		mockMvc.perform(get("/rest/v2/alpha/{codes}", "co")).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void getAllCountriesByMutipleAlphaCode() throws Exception {
		when(countryService.getCountriesByMultipleCode("col;no;ee")).thenReturn(countries);
		mockMvc.perform(get("/rest/v2/alpha?codes=col;no;ee")).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void getAllCountriesByCurrency() throws Exception {
		when(countryService.getAllCountriesByCurrency("EUR")).thenReturn(countries);
		mockMvc.perform(get("/rest/v2/currency/{currency}", "EUR")).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void getAllCountriesByLanguage() throws Exception {
		when(countryService.getAllCountriesByLanguage("es")).thenReturn(countries);
		mockMvc.perform(get("/rest/v2/lang/{language}", "es")).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void getAllCountriesByCapital() throws Exception {
		when(countryService.getAllCountriesByCapital("tallinn")).thenReturn(countries);
		mockMvc.perform(get("/rest/v2/capital/{capital}", "tallinn")).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void getAllCountriesByRegion() throws Exception {
		when(countryService.getAllCountriesByRegion("Africa")).thenReturn(countries);
		mockMvc.perform(get("/rest/v2/region/{region}", "Africa")).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void getAllCountriesByCallingCode() throws Exception {
		when(countryService.getAllCountriesByCallingCode("372")).thenReturn(countries);
		mockMvc.perform(get("/rest/v2/callingcode/{callingcode}", "372")).andExpect(status().isOk()).andDo(print());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
