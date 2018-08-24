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
 * Triple Candlestick tests
 * @author Ricardo Ferreira, 01/08/2018
 * @version 1.0.0
 */
public class TripleCandleStickPatternTest extends BaseCandleStickPatternTest {

	@Test
	public void testBullishMorningStar() {
		candles.clear();
		close = "600";
		open = "500";
		high = "566";
		low = "499";
		Candle first = createCandle(close, open, high, low);
		candles.add(first);
		close = "492";
		open = "488";
		high = "498";
		low = "480";
		Candle second = createCandle(close, open, high, low);
		candles.add(second);
		close = "545";
		open = "650";
		high = "577";
		low = "540";
		Candle thrid = createCandle(close, open, high, low);
		candles.add(thrid);
		assertTrue(CandleStickFactory.triple(candles).isBullish());
		assertFalse(CandleStickFactory.triple(candles).isBearish());
	}
	
	@Test
	public void testBearishEveningStar() {
		candles.clear();
		close = "400";
		open = "470";
		high = "481";
		low = "399";
		Candle first = createCandle(close, open, high, low);
		candles.add(first);
		close = "480";
		open = "500";
		high = "501";
		low = "480";
		Candle second = createCandle(close, open, high, low);
		candles.add(second);
		close = "436";
		open = "200";
		high = "437";
		low = "199";
		Candle thrid = createCandle(close, open, high, low);
		candles.add(thrid);
		assertFalse(CandleStickFactory.triple(candles).isBullish());
		assertTrue(CandleStickFactory.triple(candles).isBearish());
	}
	
	@Test
	public void testBullishWhiteSoldiers() {
		candles.clear();
		close = "850";
		open = "750";
		high = "855";
		low = "745";
		Candle first = createCandle(close, open, high, low);
		candles.add(first);
		close = "750";
		open = "650";
		high = "755";
		low = "645";
		Candle second = createCandle(close, open, high, low);
		candles.add(second);
		close = "600";
		open = "500";
		high = "610";
		low = "490";
		Candle thrid = createCandle(close, open, high, low);
		candles.add(thrid);
		assertTrue(CandleStickFactory.triple(candles).isBullish());
		assertFalse(CandleStickFactory.triple(candles).isBearish());
	}
	
	@Test
	public void testBearishThreeBlackCrows() {
		candles.clear();
		close = "500";
		open = "600";
		high = "610";
		low = "490";
		Candle first = createCandle(close, open, high, low);
		candles.add(first);
		close = "650";
		open = "750";
		high = "755";
		low = "645";
		Candle second = createCandle(close, open, high, low);
		candles.add(second);
		close = "750";
		open = "850";
		high = "855";
		low = "745";
		Candle thrid = createCandle(close, open, high, low);
		candles.add(thrid);
		assertFalse(CandleStickFactory.triple(candles).isBullish());
		assertTrue(CandleStickFactory.triple(candles).isBearish());
	}
	
	@Test
	public void testBullishKicker() {
		candles.clear();
		close = "400";
		open = "500";
		high = "545";
		low = "380";
		Candle first = createCandle(close, open, high, low);
		candles.add(first);
		close = "550";
		open = "680";
		high = "695";
		low = "540";
		Candle second = createCandle(close, open, high, low);
		candles.add(second);
		close = "700";
		open = "800";
		high = "855";
		low = "690";
		Candle thrid = createCandle(close, open, high, low);
		candles.add(thrid);
		assertTrue(CandleStickFactory.triple(candles).isBullish());
		assertFalse(CandleStickFactory.triple(candles).isBearish());
	}
	
	@Test
	public void testBearishKicker() {
		candles.clear();
		close = "800";
		open = "700";
		high = "855";
		low = "690";
		Candle first = createCandle(close, open, high, low);
		candles.add(first);
		close = "680";
		open = "550";
		high = "695";
		low = "540";
		Candle second = createCandle(close, open, high, low);
		candles.add(second);
		close = "500";
		open = "400";
		high = "545";
		low = "380";
		Candle thrid = createCandle(close, open, high, low);
		candles.add(thrid);
		assertFalse(CandleStickFactory.triple(candles).isBullish());
		assertTrue(CandleStickFactory.triple(candles).isBearish());
	}
	
	
	
}
