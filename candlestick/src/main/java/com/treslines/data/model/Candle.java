/*
Copyright 2018 Ricardo Ferreira

Permission is hereby granted, free of charge, to any person obtaining a copy 
of this software and associated documentation files (the "Software"), to deal 
in the Software without restriction, including without limitation the rights 
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies 
of the Software, and to permit persons to whom the Software is furnished to do 
so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all 
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package com.treslines.data.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

// CREATE TABLE `candles` (
//	  `id` INTEGER AUTO_INCREMENT,
//	  `date` VARCHAR(30) DEFAULT NULL,
//	  `market` VARCHAR(10) DEFAULT NULL,
//	  `open` VARCHAR (100) DEFAULT NULL,
//	  `close` VARCHAR (100) DEFAULT NULL,
//	  `min` VARCHAR (100) DEFAULT NULL,
//	  `max` VARCHAR (100) DEFAULT NULL,
//	  `volume` VARCHAR (100) DEFAULT NULL,
//	  `base_volume` VARCHAR (100) DEFAULT NULL,
//	  PRIMARY KEY (`id`)
// );

/**
 * Database model data.
 * @author Ricardo Ferreira
 * @since 31/07/2018
 * @version 1.0.0
 */

@DatabaseTable(tableName = "candles")
public class Candle extends Entity implements Cloneable{

	/**
	 * date in which those values has been recorded. 
	 * This field is indexed to speed up the search
	 */
	@DatabaseField(/* indexName="index_date" */)
	private String date;

	/**
	 * time interval in which those values has been recorded.
	 * This field is indexed to speed up the search
	 */
	@DatabaseField(/* indexName="index_time" */)
	private String time;

	/**
	 * time interval constant which this candle used to recorded. 
	 * This field is indexed to speed up the search
	 */
	@DatabaseField(/* indexName="index_interval" */)
	private String interval;

	/**
	 * the name of the market BTC-ETH
	 * This field is indexed to speed up the search
	 */
	@DatabaseField(/* indexName="index_market" */)
	private String market;

	/** the price which it opened */
	@DatabaseField
	private String open;

	/** the price which it closed */
	@DatabaseField
	private String close;

	/** min price */
	@DatabaseField
	private String min;

	/** max price */
	@DatabaseField
	private String max;

	/** traded volume in this date */
	@DatabaseField
	private String volume;

	/** traded base volume in this date */
	@DatabaseField
	private String baseVolume;

	public Candle() {
		// ORMLite needs a no-arg constructor
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getBaseVolume() {
		return baseVolume;
	}

	public void setBaseVolume(String baseVolume) {
		this.baseVolume = baseVolume;
	}

	public String getTime() {
		return time;
	}

	public String getInterval() {
		return interval;
	}

	/**
	 * Checks if this entity has valid attributes
	 * @return true if all attributes are non null and not empty.
	 */
	public boolean isEmpty() {
		if(hasNullity()) {
			return true;
		}else {
			if(hasEmtpiness()) {
				return true;
			}
		}
		return false;
	}

	private boolean hasNullity() {
		return market == null || date == null || time == null || interval == null || open == null || close == null
				|| min == null || max == null || volume == null || baseVolume == null;
	}

	private boolean hasEmtpiness() {
		return market.isEmpty() || date.isEmpty() || time.isEmpty() || interval.isEmpty() || open.isEmpty()
				|| close.isEmpty() || min.isEmpty() || max.isEmpty() || volume.isEmpty() || baseVolume.isEmpty();
	}
	
	/** Use it to print out this entity's values whenever needed */
	public String toString() {
		return "date:"+this.date + ", market:"+this.market+", :open"+this.open+", close:"+this.close+", min:"+this.min+", max:"+this.max;
	}
	
	/**
	 * Use it to test/clone this entity while running your tests 
	 */
	@Override
	public Candle clone() throws CloneNotSupportedException {
		Candle clone = new Candle();
		clone.setClose(getClose());
		clone.setOpen(getOpen());
		clone.setMax(getMax());
		clone.setMin(getMin());
		clone.setId(getId());
		clone.setTime(getTime());
		clone.setMarket(getMarket());
		clone.setDate(getDate());
		clone.setInterval(getInterval());
		clone.setBaseVolume(getBaseVolume());
		clone.setVolume(getVolume());
		return clone;
	}


}
