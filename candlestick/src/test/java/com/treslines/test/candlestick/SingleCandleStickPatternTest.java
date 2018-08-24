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
 * Single Candlestick tests
 * @author Ricardo Ferreira, 01/08/2018
 * @version 1.0.0
 */
public class SingleCandleStickPatternTest extends BaseCandleStickPatternTest {

	@Test
	public void testBullishDoji() {
		candles.clear();
		close = "7666";
		open = "7663";
		high = "7670";
		low = "7306";
		Candle bullishDoji = createCandle(close, open, high, low);
		candles.add(bullishDoji);
		assertTrue(CandleStickFactory.single(candles).isBullish());
		assertFalse(CandleStickFactory.single(candles).isBearish());
	}
	
	@Test
	public void testBearishDoji() {
		candles.clear();
		close = "7046";
		open = "7050";
		high = "7060";
		low = "7051";
		Candle bearichDoji = createCandle(close, open, high, low);
		candles.add(bearichDoji);
		assertFalse(CandleStickFactory.single(candles).isBullish());
		assertTrue(CandleStickFactory.single(candles).isBearish());
	}
	
	@Test
	public void testBullishHammer() {
		candles.clear();
		close = "8126";
		open = "8103";
		high = "8126";
		low = "8021";
		Candle bullishHammer = createCandle(close, open, high, low);
		candles.add(bullishHammer);
		assertTrue(CandleStickFactory.single(candles).isBullish());
		assertFalse(CandleStickFactory.single(candles).isBearish());
	}
	
	@Test
	public void testBearishShotingStar() {
		candles.clear();
		close = "8103";
		open = "8126";
		high = "8176";
		low = "8101";
		Candle bullishHammer = createCandle(close, open, high, low);
		candles.add(bullishHammer);
		assertFalse(CandleStickFactory.single(candles).isBullish());
		assertTrue(CandleStickFactory.single(candles).isBearish());
	}
	
}
