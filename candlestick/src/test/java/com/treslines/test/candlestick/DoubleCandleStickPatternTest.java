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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.treslines.candlestick.CandleStickFactory;
import com.treslines.data.model.Candle;

/**
 * Double Candlestick tests
 * @author Ricardo Ferreira, 01/08/2018
 * @version 1.0.0
 */
public class DoubleCandleStickPatternTest extends BaseCandleStickPatternTest {

	@Test
	public void testBullishEngolfer() {
		candles.clear();
		close = "7054";
		open = "6942";
		high = "7055";
		low = "6940";
		Candle first = createCandle(close, open, high, low);
		candles.add(first);
		close = "6965";
		open = "7017";
		high = "7019";
		low = "6942";
		Candle second = createCandle(close, open, high, low);
		candles.add(second);
		assertTrue(CandleStickFactory.doubl(candles).isBullish());
		assertFalse(CandleStickFactory.doubl(candles).isBearish());
	}
	
	@Test
	public void testBearishEngolfer() {
		candles.clear();
		close = "7887";
		open = "8001";
		high = "8046";
		low = "7883";
		Candle first = createCandle(close, open, high, low);
		candles.add(first);
		close = "7985";
		open = "7940";
		high = "8004";
		low = "7938";
		Candle second = createCandle(close, open, high, low);
		candles.add(second);
		assertFalse(CandleStickFactory.doubl(candles).isBullish());
		assertTrue(CandleStickFactory.doubl(candles).isBearish());
	}
	
	@Test
	public void testBullishPiercing() {
		candles.clear();
		close = "7456";
		open = "7254";
		high = "7644";
		low = "7253";
		Candle first = createCandle(close, open, high, low);
		candles.add(first);
		close = "7377";
		open = "7535";
		high = "7535";
		low = "7256";
		Candle second = createCandle(close, open, high, low);
		candles.add(second);
		assertTrue(CandleStickFactory.doubl(candles).isBullish());
		assertFalse(CandleStickFactory.doubl(candles).isBearish());
	}
	
	@Test
	public void testBearishDarkCloudCover() {
		candles.clear();
		close = "476";
		open = "480";
		high = "484";
		low = "471";
		Candle first = createCandle(close, open, high, low);
		candles.add(first);
		close = "478";
		open = "475";
		high = "480";
		low = "474";
		Candle second = createCandle(close, open, high, low);
		candles.add(second);
		assertFalse(CandleStickFactory.doubl(candles).isBullish());
		assertTrue(CandleStickFactory.doubl(candles).isBearish());
	}
	
	@Test
	public void testBullishTweezerBottom() {
		candles.clear();
		close = "1806";
		open = "1800";
		high = "1810";
		low = "1780";
		Candle first = createCandle(close, open, high, low);
		candles.add(first);
		close = "1800";
		open = "1806";
		high = "1808";
		low = "1778";
		Candle second = createCandle(close, open, high, low);
		candles.add(second);
		assertTrue(CandleStickFactory.doubl(candles).isBullish());
		assertFalse(CandleStickFactory.doubl(candles).isBearish());
	}
	
	@Test
	public void testBearishTweezerTop() {
		candles.clear();
		close = "1800";
		open = "1806";
		high = "1810";
		low = "1780";
		Candle first = createCandle(close, open, high, low);
		candles.add(first);
		close = "1806";
		open = "1800";
		high = "1808";
		low = "1778";
		Candle second = createCandle(close, open, high, low);
		candles.add(second);
		assertFalse(CandleStickFactory.doubl(candles).isBullish());
		assertTrue(CandleStickFactory.doubl(candles).isBearish());
	}
	
}
