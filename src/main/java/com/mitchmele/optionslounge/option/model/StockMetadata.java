package com.mitchmele.optionslounge.option.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class StockMetadata {

	@JsonProperty("50-Day Simple Moving Average")
	private double fiftyDaySimpleMovingAverage;

	@JsonProperty("Company")
	private String company;

	@JsonProperty("Performance (YTD)")
	private double performanceYTD;

	@JsonProperty("50-Day High")
	private double fiftyDayHigh;

	@JsonProperty("Relative Strength Index (14)")
	private double relativeStrengthIndex14;

	@JsonProperty("Average True Range")
	private double averageTrueRange;

	@JsonProperty("Performance (Half Year)")
	private double performanceHalfYear;

	@JsonProperty("Industry")
	private String industry;

	@JsonProperty("Average Volume")
	private double averageVolume;

	@JsonProperty("Performance (Year)")
	private double performanceYear;

	@JsonProperty("200-Day Simple Moving Average")
	private double twoHundredDaySimpleMovingAverage;

	@JsonProperty("Volatility (Month)")
	private double volatilityMonth;

	@JsonProperty("Performance (Week)")
	private double performanceWeek;

	@JsonProperty("52-Week High")
	private double yearlyHigh;

	@JsonProperty("Volatility (Week)")
	private double volatilityWeek;

	@JsonProperty("Change from Open")
	private double changeFromOpen;

	@JsonProperty("Sector")
	private String sector;

	@JsonProperty("Ticker")
	private String ticker;

	@JsonProperty("Change")
	private double change;

	@JsonProperty("Performance (Month)")
	private double performanceMonth;

	@JsonProperty("Price")
	private double price;

	@JsonProperty("Dividend Yield")
	private double dividendYield;

	@JsonProperty("Volume")
	private int volume;

	@JsonProperty("Relative Volume")
	private double relativeVolume;

	@JsonProperty("20-Day Simple Moving Average")
	private double twentyDaySimpleMovingAverage;

	@JsonProperty("Gap")
	private double gap;

	@JsonProperty("Performance (Quarter)")
	private double performanceQuarter;

	@JsonProperty("Country")
	private String country;

	@JsonProperty("52-Week Low")
	private double yearlyLow;
}