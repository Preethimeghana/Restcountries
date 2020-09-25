package com.restcountries.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restcountries.exception.ResourceNotFoundException;
import com.restcountries.model.Country;
import com.restcountries.service.CountryService;

@RestController
@RequestMapping(path = "/rest/v2")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("/all")
	public List<Country> getAllCountries() {
		return countryService.getAllCountries();
	}
	
	@PostMapping("/country")
	public ResponseEntity<Object> createCountry(@RequestBody Country country) {
		Country createdCountry = countryService.addCountry(country);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdCountry.getName()).toUri();

		return ResponseEntity.created(location).build();

	}

	@RequestMapping("/name/{country}")
	public ResponseEntity<Object> getCountry(@RequestParam(defaultValue = "false") String fullText,
			@PathVariable String country) {
		List<Country> existingCountries = countryService.getCountries(fullText, country);
		if (existingCountries.size() > 0) {
			return ResponseEntity.ok(existingCountries);
		} else {
			throw new ResourceNotFoundException("Country not found with Name " + country);
		}

	}

	@RequestMapping("/alpha/{code}")
	public ResponseEntity<Object> getCountryByCode(@PathVariable String code) {
		List<Country> existingCountries = countryService.getCountriesByCode(code);
		if (existingCountries.size() > 0) {
			return ResponseEntity.ok(existingCountries);
		} else {
			throw new ResourceNotFoundException("Country not found with code " + code);
		}

	}

	@RequestMapping("/alpha")
	public ResponseEntity<Object> getCountryByAlphaCodes(@RequestParam String codes) {
		List<Country> existingCountries = countryService.getCountriesByMultipleCode(codes);
		if (existingCountries.size() > 0) {
			return ResponseEntity.ok(existingCountries);
		} else {
			throw new ResourceNotFoundException("Country not found with code " + codes);
		}

	}

	@RequestMapping("/currency/{currency}")
	public ResponseEntity<Object> getCountryByCurrency(@PathVariable String currency) {
		List<Country> existingCountries = countryService.getAllCountriesByCurrency(currency);
		if (existingCountries.size() > 0) {
			return ResponseEntity.ok(existingCountries);
		} else {
			throw new ResourceNotFoundException("Country not found with currency " + currency);
		}

	}

	@RequestMapping("/lang/{language}")
	public ResponseEntity<Object> getCountryByLanguage(@PathVariable String language) {
		List<Country> existingCountries = countryService.getAllCountriesByLanguage(language);
		if (existingCountries.size() > 0) {
			return ResponseEntity.ok(existingCountries);
		} else {
			throw new ResourceNotFoundException("Country not found with language " + language);
		}

	}

	@RequestMapping("/capital/{capital}")
	public ResponseEntity<Object> getCountryByCapital(@PathVariable String capital) {
		List<Country> existingCountries = countryService.getAllCountriesByCapital(capital);
		if (existingCountries.size() > 0) {
			return ResponseEntity.ok(existingCountries);
		} else {
			throw new ResourceNotFoundException("Country not found with capital " + capital);
		}
	}

	@RequestMapping("/region/{region}")
	public ResponseEntity<Object> getCountryByRegion(@PathVariable String region) {
		List<Country> existingCountries = countryService.getAllCountriesByRegion(region);
		if (existingCountries.size() > 0) {
			return ResponseEntity.ok(existingCountries);
		} else {
			throw new ResourceNotFoundException("Country not found with region " + region);
		}
	}

	@RequestMapping("/callingcode/{callingcode}")
	public ResponseEntity<Object> getCountryByCallingCode(@PathVariable String callingcode) {
		List<Country> existingCountries = countryService.getAllCountriesByCallingCode(callingcode);
		if (existingCountries.size() > 0) {
			return ResponseEntity.ok(existingCountries);
		} else {
			throw new ResourceNotFoundException("Country not found with callingcode " + callingcode);
		}

	}

}
