package com.restcountries.service;

import java.util.List;

import com.restcountries.model.Country;

public interface CountryService {

	Country addCountry(Country country);

	List<Country> getAllCountries();

	List<Country> getAllCountriesByName(String countryName);

	List<Country> getAllCountriesByPartialName(String countryName);

	List<Country> getAllCountriesByAltName(String countryName);
	
	List<Country> getCountries(String fullText, String countryName);
	
	List<Country> getCountriesByCode(String code);

	List<Country> getCountriesByMultipleCode(String code);

	List<Country> getAllCountriesByCurrency(String currency);
	
	List<Country> getAllCountriesByLanguage(String language);
	
	List<Country> getAllCountriesByCapital(String capital);
	
	List<Country> getAllCountriesByRegion(String region);

	List<Country> getAllCountriesByCallingCode(String callingcode);

}
