package com.restcountries.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.restcountries.dao.CountryRepository;
import com.restcountries.model.Country;

@Component
public class DataService {

	@Autowired
	CountryRepository countryRepository;

	@EventListener(ApplicationReadyEvent.class)
	private void readJSON() {
		JSONParser parser = new JSONParser();
		try {
			File file = new ClassPathResource("data/country.json").getFile();
			Reader reader = new FileReader(file);

			JSONArray jsonArray = (JSONArray) parser.parse(reader);

			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				String name = (String) jsonObject.get("name");
				Country country = buildCountry(jsonObject);
				countryRepository.save(country);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private Country buildCountry(JSONObject countryFromJson) {
		Country country = new Country();
		country.setName((String) countryFromJson.get("name"));
		country.setTopLevelDomain((List<String>) countryFromJson.get("topLevelDomain"));
		country.setAlpha2Code((String) countryFromJson.get("alpha2Code"));
		country.setAlpha3Code((String) countryFromJson.get("alpha3Code"));
		country.setName((String) countryFromJson.get("name"));
		country.setCallingCodes((List<String>) countryFromJson.get("callingCodes"));
		country.setCapital((String) countryFromJson.get("capital"));
		country.setAltSpellings((List<String>) countryFromJson.get("altSpellings"));
		country.setRegion((String) countryFromJson.get("region"));
		country.setSubregion((String) countryFromJson.get("subregion"));
		country.setPopulation((Long) countryFromJson.get("population"));
		List<BigDecimal> latLang = new ArrayList<BigDecimal>();
		List<Double> lat = (List<Double>) countryFromJson.get("latlng");
		lat.forEach(latitude -> latLang.add(BigDecimal.valueOf(latitude)));
		country.setLatlng(latLang);
		country.setDemonym((String) countryFromJson.get("demonym"));
		Double area = (Double) countryFromJson.get("area");
		if (area != null) {
			country.setArea(BigDecimal.valueOf(area));
		}
		Double gini = (Double) countryFromJson.get("gini");
		if (gini != null) {
			country.setGini(BigDecimal.valueOf(gini));
		}
		JSONArray currency = (JSONArray) countryFromJson.get("currencies");
		List<String> currencies = new ArrayList<>();
		for (int i = 0; i < currency.size(); i++) {
			JSONObject jsonObject = (JSONObject) currency.get(i);
			String currCode = (String) jsonObject.get("code");
			currencies.add(currCode);
		}
		country.setCurrency(currencies);
		JSONArray language = (JSONArray) countryFromJson.get("languages");
		if (language != null) {
			Map<String, String> lang = (Map<String, String>) language.get(0);
			country.setLanguages(lang);
		}
		country.setTimezones((List<String>) countryFromJson.get("timezones"));
		country.setBorders((List<String>) countryFromJson.get("borders"));
		country.setNativeName((String) countryFromJson.get("nativeName"));
		country.setNumericCode((String) countryFromJson.get("numericCode"));
		country.setTranslations((Map<String, String>) countryFromJson.get("translations"));
		country.setFlag((String) countryFromJson.get("flag"));
		country.setCioc((String) countryFromJson.get("cioc"));
		return country;
	}
}
