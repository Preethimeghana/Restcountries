package com.restcountries.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.restcountries.dao.CountryRepository;
import com.restcountries.model.Country;

public class CountryServiceTest {

	@InjectMocks
	CountryServiceImpl countryService;

	@Mock
	private CountryRepository countryRepository;

	private Country country1;

	private Country country2;

	private Country country3;

	private List<Country> countries;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		country1 = new Country();
		country1.setName("USA");
		List<String> altSpellings = new ArrayList<>();
		altSpellings.add("united");
		country1.setAltSpellings(altSpellings);
		country2 = new Country();
		country2.setName("Afghanistan");
		country2.setAltSpellings(altSpellings);
		country3 = new Country();
		country3.setName("Germany");
		country3.setAltSpellings(altSpellings);
		countries = new ArrayList<Country>();
		countries.add(country1);
		countries.add(country2);
		countries.add(country3);
	}

	@Test
	public void getAllCountriesTest() throws ParseException {

		when(countryRepository.findAll()).thenReturn(countries);
		List<Country> countries = countryService.getAllCountries();
		assertEquals(3, countries.size());
		verify(countryRepository, times(1)).findAll();

	}

	@Test
	public void creatCountryTest() throws ParseException {

		when(countryRepository.save(country1)).thenReturn(country1);
		countryService.addCountry(country1);
		verify(countryRepository, times(1)).save(country1);
	}

	@Test
	public void getAllCountriesByNameTest() {
		when(countryRepository.findAllByNameContainingIgnoreCase(country1.getName())).thenReturn(countries);
		List<Country> countries = countryService.getAllCountriesByName(country1.getName());
		assertEquals(3, countries.size());
		verify(countryRepository, times(1)).findAllByNameContainingIgnoreCase(country1.getName());
	}

	@Test
	public void getAllCountriesByPartialNameTest() {
		when(countryRepository.findAllByNameContainingIgnoreCase(country1.getName())).thenReturn(countries);
		List<Country> countries = countryService.getAllCountriesByPartialName(country1.getName());
		assertEquals(3, countries.size());
		verify(countryRepository, times(1)).findAllByNameContainingIgnoreCase(country1.getName());
	}

	@Test
	public void getAllCountriesByAltNameTest() {
		when(countryRepository.findAll()).thenReturn(countries);
		List<Country> countries = countryService.getAllCountriesByAltName("united");
		assertEquals(3, countries.size());
		verify(countryRepository, times(1)).findAll();
	} // countryRepository.findAllByNameContainingIgnoreCase(countryName);

	@Test
	public void getCountriesTest() {
		when(countryRepository.findAllByNameContainingIgnoreCase("united")).thenReturn(countries);
		List<Country> countries = countryService.getCountries("true", "united");
		assertEquals(3, countries.size());
		verify(countryRepository, times(1)).findAllByNameContainingIgnoreCase("united");
	}

	@Test
	public void getCountriesByCodeTest() {
		when(countryRepository.findAllByAlpha3CodeContainingIgnoreCase("co")).thenReturn(countries);
		List<Country> countries = countryService.getCountriesByCode("co");
		assertEquals(3, countries.size());
		verify(countryRepository, times(1)).findAllByAlpha3CodeContainingIgnoreCase("co");
	}

	@Test
	public void getCountriesByMultipleCodeTest() {
		when(countryRepository.findAllByAlpha3CodeIgnoreCase("co")).thenReturn(countries);
		when(countryRepository.findAllByAlpha2CodeIgnoreCase("co")).thenReturn(countries);
		List<Country> countries = countryService.getCountriesByMultipleCode("co");
		assertEquals(6, countries.size());
		verify(countryRepository, times(1)).findAllByAlpha3CodeIgnoreCase("co");
		verify(countryRepository, times(1)).findAllByAlpha2CodeIgnoreCase("co");
	}

	@Test
	public void getAllCountriesByCapitalTest() {
		when(countryRepository.findAllByCapitalIgnoreCase("tallinn")).thenReturn(countries);
		List<Country> countries = countryService.getAllCountriesByCapital("tallinn");
		assertEquals(3, countries.size());
		verify(countryRepository, times(1)).findAllByCapitalIgnoreCase("tallinn");
	}

	@Test
	public void getAllCountriesByRegionTest() {
		when(countryRepository.findAllByRegionIgnoreCase("Asia")).thenReturn(countries);
		List<Country> countries = countryService.getAllCountriesByRegion("Asia");
		assertEquals(3, countries.size());
		verify(countryRepository, times(1)).findAllByRegionIgnoreCase("Asia");
	}

}
