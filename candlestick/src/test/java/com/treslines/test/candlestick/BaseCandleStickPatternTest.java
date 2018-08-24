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

package com.treslines.test.candlestick;

import java.util.ArrayList;
import java.util.List;

import com.treslines.data.model.Candle;

/**
 * Base Candle mock to be used in all tests
 * @author Ricardo Ferreira, 01/08/2018
 * @version 1.0.0
 */
public class BaseCandleStickPatternTest {

	protected List<Candle> candles = new ArrayList<Candle>();
	protected String close = "";
	protected String open = "";
	protected String high = "";
	protected String low = "";
	
	protected Candle createCandle(String close, String open, String high, String low) {
		Candle clone = new Candle();
		try {
			clone = getBaseCandle().clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		clone.setClose(close);
		clone.setOpen(open);
		clone.setMax(high);
		clone.setMin(low);
		return clone;
	}
	
	private static Candle base = new Candle();
	private Candle getBaseCandle() {
		if(base.isEmpty()) {
			base.setClose("7666");
			base.setOpen("7663");
			base.setMax("7680");
			base.setMin("7306");
			base.setId(1);
			base.setTime("17:00");
			base.setMarket("BTC-ETH");
			base.setDate("2018-01-01");
			base.setInterval("fiveMin");
			base.setBaseVolume("123456");
			base.setVolume("123456");
		}
		return base;
	}

}
