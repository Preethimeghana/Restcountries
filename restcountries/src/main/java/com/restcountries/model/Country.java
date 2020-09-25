package com.restcountries.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Country implements Serializable {

	private static final long serialVersionUID = 1043853426968534459L;

	@Id
	@Column(name = "name", unique = true)
	private String name;

	@ElementCollection
	@CollectionTable(name = "domain_list", joinColumns = @JoinColumn(name = "name"))
	@Column(name = "topLevelDomain")
	private List<String> topLevelDomain;

	private String alpha2Code;

	private String alpha3Code;

	@ElementCollection
	@CollectionTable(name = "calling_codes_list", joinColumns = @JoinColumn(name = "name"))
	@Column(name = "callingCodes")
	private List<String> callingCodes;

	private String capital;

	@ElementCollection
	@CollectionTable(name = "alt_spellings_list", joinColumns = @JoinColumn(name = "name"))
	@Column(name = "altSpellings")
	private List<String> altSpellings;

	private String region;

	private String subregion;

	private Long population;

	@ElementCollection
	@CollectionTable(name = "latlng_list", joinColumns = @JoinColumn(name = "name"))
	@Column(name = "latlng")
	private List<BigDecimal> latlng;

	private String demonym;

	private BigDecimal area;

	private BigDecimal gini;

	@ElementCollection
	@CollectionTable(name = "timezone_list", joinColumns = @JoinColumn(name = "name"))
	@Column(name = "timezones")
	private List<String> timezones;

	@ElementCollection
	@CollectionTable(name = "borders_list", joinColumns = @JoinColumn(name = "name"))
	@Column(name = "borders") // 3
	private List<String> borders;

	private String nativeName;

	private String numericCode;

	@ElementCollection
	@CollectionTable(name = "currency_list", joinColumns = @JoinColumn(name = "name"))
	@Column(name = "currency")
	private List<String> currency;

	@ElementCollection
	@CollectionTable(name = "languages_list", joinColumns = @JoinColumn(name = "name"))
	@Column(name = "languages")
	private Map<String, String> languages;

	@ElementCollection
	@CollectionTable(name = "translations_list", joinColumns = @JoinColumn(name = "name"))
	@Column(name = "translations")
	private Map<String, String> translations;

	private String flag;

	private String cioc;

	public Country() {
	}

	public Country(String name, List<String> topLevelDomain, String alpha2Code, String alpha3Code,
			List<String> callingCodes, String capital, List<String> altSpellings, String region, String subregion,
			Long population, List<BigDecimal> latlng, String demonym, BigDecimal area, BigDecimal gini,
			List<String> timezones, List<String> borders, String nativeName, String numericCode, List<String> currency,
			Map<String, String> languages, Map<String, String> translations, String flag, String cioc) {
		this.name = name;
		this.topLevelDomain = topLevelDomain;
		this.alpha2Code = alpha2Code;
		this.alpha3Code = alpha3Code;
		this.callingCodes = callingCodes;
		this.capital = capital;
		this.altSpellings = altSpellings;
		this.region = region;
		this.subregion = subregion;
		this.population = population;
		this.latlng = latlng;
		this.demonym = demonym;
		this.area = area;
		this.gini = gini;
		this.timezones = timezones;
		this.borders = borders;
		this.nativeName = nativeName;
		this.numericCode = numericCode;
		this.currency = currency;
		this.languages = languages;
		this.translations = translations;
		this.flag = flag;
		this.cioc = cioc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTopLevelDomain() {
		return topLevelDomain;
	}

	public void setTopLevelDomain(List<String> topLevelDomain) {
		this.topLevelDomain = topLevelDomain;
	}

	public String getAlpha2Code() {
		return alpha2Code;
	}

	public void setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
	}

	public String getAlpha3Code() {
		return alpha3Code;
	}

	public void setAlpha3Code(String alpha3Code) {
		this.alpha3Code = alpha3Code;
	}

	public List<String> getCallingCodes() {
		return callingCodes;
	}

	public void setCallingCodes(List<String> callingCodes) {
		this.callingCodes = callingCodes;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public List<String> getAltSpellings() {
		return altSpellings;
	}

	public void setAltSpellings(List<String> altSpellings) {
		this.altSpellings = altSpellings;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSubregion() {
		return subregion;
	}

	public void setSubregion(String subregion) {
		this.subregion = subregion;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public List<BigDecimal> getLatlng() {
		return latlng;
	}

	public void setLatlng(List<BigDecimal> latlng) {
		this.latlng = latlng;
	}

	public String getDemonym() {
		return demonym;
	}

	public void setDemonym(String demonym) {
		this.demonym = demonym;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public BigDecimal getGini() {
		return gini;
	}

	public void setGini(BigDecimal gini) {
		this.gini = gini;
	}

	public List<String> getTimezones() {
		return timezones;
	}

	public void setTimezones(List<String> timezones) {
		this.timezones = timezones;
	}

	public List<String> getBorders() {
		return borders;
	}

	public void setBorders(List<String> borders) {
		this.borders = borders;
	}

	public String getNativeName() {
		return nativeName;
	}

	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}

	public String getNumericCode() {
		return numericCode;
	}

	public void setNumericCode(String numericCode) {
		this.numericCode = numericCode;
	}

	public List<String> getCurrency() {
		return currency;
	}

	public void setCurrency(List<String> currency) {
		this.currency = currency;
	}

	public Map<String, String> getLanguages() {
		return languages;
	}

	public void setLanguages(Map<String, String> languages) {
		this.languages = languages;
	}

	public Map<String, String> getTranslations() {
		return translations;
	}

	public void setTranslations(Map<String, String> translations) {
		this.translations = translations;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getCioc() {
		return cioc;
	}

	public void setCioc(String cioc) {
		this.cioc = cioc;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", topLevelDomain=" + topLevelDomain + ", alpha2Code=" + alpha2Code
				+ ", alpha3Code=" + alpha3Code + ", callingCodes=" + callingCodes + ", capital=" + capital
				+ ", altSpellings=" + altSpellings + ", region=" + region + ", subregion=" + subregion + ", population="
				+ population + ", latlng=" + latlng + ", demonym=" + demonym + ", area=" + area + ", gini=" + gini
				+ ", timezones=" + timezones + ", borders=" + borders + ", nativeName=" + nativeName + ", numericCode="
				+ numericCode + ", currency=" + currency + ", languages=" + languages + ", translations=" + translations
				+ ", flag=" + flag + ", cioc=" + cioc + "]";
	}

}
