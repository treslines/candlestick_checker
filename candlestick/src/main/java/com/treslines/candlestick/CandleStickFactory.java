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

package com.treslines.candlestick;

import java.util.ArrayList;
import java.util.List;

import com.treslines.data.model.Candle;

/**
 * Candle stick pattern checker factory
 * @author Ricardo Ferreira, 31/07/2018
 * @version 1.0.0
 */
public class CandleStickFactory {

	private CandleStickFactory() {
		// Factory
	}
	
	/**
	 * Use it to check for single candle stick pattern signals.
	 * @param candles the most recent last two ticks
	 * @return SingleCandleStickPattern on which you call isBullish() or isBearish() on it.
	 */
	public static CandleStick single(List<Candle> candles) {
		return new SingleCandleStickPattern(candles);
	}
	
	/**
	 * Use it to check for double candle stick pattern signals.
	 * @param candles the most recent last three ticks
	 * @return DoubleCandleStickPattern on which you call isBullish() or isBearish() on it.
	 */
	public static CandleStick doubl(List<Candle> candles) {
		return new DoubleCandleStickPattern(candles);
	}
	
	/**
	 * Use it to check for triple candle stick pattern signals.
	 * @param candles the most recent last four ticks
	 * @return TripleCandleStickPattern on which you call isBullish() or isBearish() on it.
	 */
	public static CandleStick triple(List<Candle> candles) {
		return new TripleCandleStickPattern(candles);
	}
	
	public static class SingleCandleStickPattern implements CandleStick{
		private List<Candle> candles = new ArrayList<>();
		private SingleCandleStickPattern(List<Candle> candles) {
			if(Pattern.isCandleListValid(candles)) {
				this.candles = candles;
			}
		}

		public boolean isBullish() {
			return isBullishDoji() || isBullishHammer(); 
		}
		
		public boolean isBearish() {
			return isBearishDoji() || isBearishShootingStar(); 
		}
		
		private boolean isBullishDoji() {
			boolean result = false;
			if(Pattern.isCandleListValid(this.candles)) {
				if((Pattern.isCandleBullish(this.candles.get(0)) || 
				   Pattern.isCandleNeitherBullishNorBearish(this.candles.get(0))) &&
				   Pattern.hasLittleOrNoRealBody(this.candles.get(0)) && 
				   Pattern.hasLittleOrNoUpperShadow(this.candles.get(0)) && 
				   Pattern.hasLongLowerShadow(this.candles.get(0))) {
					result = true;
				}
			}
			return result;
		}
		private boolean isBullishHammer() {
			boolean result = false;
			if(Pattern.isCandleListValid(this.candles)) {
				if(Pattern.isCandleBullish(this.candles.get(0)) &&
				   Pattern.hasLittleOrNoUpperShadow(this.candles.get(0)) && 
				   Pattern.isLowerShadow2xLongerThanBody(this.candles.get(0))) {
					result = true;
				}
			}
			return result;
		}
		private boolean isBearishDoji() {
			boolean result = false;
			if(Pattern.isCandleListValid(this.candles)) {
				if((Pattern.isCandleBearish(this.candles.get(0)) || 
				   Pattern.isCandleNeitherBullishNorBearish(this.candles.get(0))) &&  
				   Pattern.hasLittleOrNoRealBody(this.candles.get(0)) && 
				   Pattern.hasLittleOrNoLowerShadow(this.candles.get(0)) && 
				   Pattern.hasLongUpperShadow(this.candles.get(0))) {
					result = true;
				}
			}
			return result;
		}
		private boolean isBearishShootingStar() {
			boolean result = false;
			if(Pattern.isCandleListValid(this.candles)) {
				if(Pattern.isCandleBearish(this.candles.get(0)) && 
				   Pattern.hasLittleOrNoLowerShadow(this.candles.get(0)) && 
				   Pattern.isUpperShadow2xLongerThanBody(this.candles.get(0))) {
					result = true;
				}
			}
			return result;
		}
	}
	
	/**
	 * Use it to check for double candle stick pattern signals
	 * @param candles the most recent last three ticks.
	 * @return DoubleCandleStickPattern on which you call isBullish() or isBearish() on it.
	 */
	public static class DoubleCandleStickPattern implements CandleStick{
		private List<Candle> candles = new ArrayList<>();
		private DoubleCandleStickPattern(List<Candle> candles) {
			if(candles != null && !candles.isEmpty() && candles.size() > 1) {
				this.candles = candles;
			}
		}
		
		public boolean isBullish() {
			return isBullishEngolfer() || isBullishPiercing() || isBullishTweezerBottom(); 
		}
		
		public boolean isBearish() {
			return isBearishEngolfer() || isBearishDarkCloudCover() || isBearishTweezerTop(); 
		}
		
		private boolean isBullishEngolfer() {
			boolean result = false;
			if(Pattern.isCandleListValid(this.candles)) {
				if(Pattern.isCandleBullish(this.candles.get(0)) &&
				   Pattern.isCandleBearish(this.candles.get(1)) &&
				   Pattern.isPreviousCandleShorterThanCurrent(this.candles) &&
				   Pattern.isPreviousCandleEntirelyContainedInBodyOfCurrent(this.candles)) {
					result = true;
				}
			}
			return result;
		}
		private boolean isBullishTweezerBottom() {
			boolean result = false;
			if(Pattern.isCandleListValid(this.candles)) {
				if(Pattern.isCandleBullish(this.candles.get(0)) &&
				   Pattern.isCandleBearish(this.candles.get(1)) &&
				   Pattern.doBothCandlesShareSameOrAlmostSameBody(this.candles) &&
				   Pattern.doBothCandlesShareSameOrAlmostSameLow(this.candles)) {
					result = true;
				}
			}
			return result;
		}
		private boolean isBullishPiercing() {
			boolean result = false;
			if(Pattern.isCandleListValid(this.candles)) {
				if(Pattern.isCandleBullish(this.candles.get(0)) &&
				   Pattern.isCandleBearish(this.candles.get(1)) &&
				   Pattern.openedCurrentCandleBellowOrAtClosingFromPrevious(this.candles) &&
				   Pattern.closedCurrentCandleAt50PercentOrAboveOfBodyFromPrevious(this.candles)) {
					result = true;
				}
			}
			return result;
		}
		private boolean isBearishEngolfer() {
			boolean result = false;
			if(Pattern.isCandleListValid(this.candles)) {
				if(Pattern.isCandleBullish(this.candles.get(1)) &&
				   Pattern.isCandleBearish(this.candles.get(0)) &&
				   Pattern.isPreviousCandleShorterThanCurrent(this.candles) &&
				   Pattern.isPreviousCandleEntirelyContainedInBodyOfCurrent(this.candles)) {
					result = true;
				}
			}
			return result;
		}
		private boolean isBearishDarkCloudCover() {
			boolean result = false;
			if(Pattern.isCandleListValid(this.candles)) {
				if(Pattern.isCandleBullish(this.candles.get(1)) &&
				   Pattern.isCandleBearish(this.candles.get(0)) &&
				   Pattern.openedCurrentCandleAboveOrAtClosingFromPrevious(this.candles) &&
				   Pattern.closedCurrentCandleAt50PercentOrBellowOfBodyFromPrevious(this.candles)) {
					result = true;
				}
			}
			return result;
		}
		private boolean isBearishTweezerTop() {
			boolean result = false;
			if(Pattern.isCandleListValid(this.candles)) {
				if(Pattern.isCandleBullish(this.candles.get(1)) &&
				   Pattern.isCandleBearish(this.candles.get(0)) &&
				   Pattern.doBothCandlesShareSameOrAlmostSameBody(this.candles) &&
				   Pattern.doBothCandlesShareSameOrAlmostSameHigh(this.candles)) {
					result = true;
				}
			}
			return result;
		}
	}
	
	/**
	 * Use it to check for triple candle stick pattern signals
	 * @param candles the most recent last four ticks.
	 * @return TripleCandleStickPattern on which you call isBullish() or isBearish() on it.
	 */
	public static class TripleCandleStickPattern implements CandleStick{
		private List<Candle> candles = new ArrayList<>();
		
		private TripleCandleStickPattern(List<Candle> candles) {
			if(candles != null && !candles.isEmpty() && candles.size() > 2) {
				this.candles = candles;
			}
		}
		
		public boolean isBearish() {
			return isBearishEveningStar() || isBearishThreeBlackCrows() || isBearishKicker();
		}
		
		public boolean isBullish() {
			return isBullishMorningStar() || isBullishWhiteSoldiers() || isBullishKicker();
		}
		
		private boolean isBullishWhiteSoldiers() {
			boolean result = false;
			if(Pattern.isCandleListValid(this.candles)) {
				if(Pattern.isCandleBullish(this.candles.get(0)) &&
				   Pattern.isCandleBullish(this.candles.get(1)) &&
				   Pattern.isCandleBullish(this.candles.get(2)) &&
				   Pattern.formedThreeConsecutiveLongCandles(this.candles) &&
				   Pattern.eachCandleClosedSuccessivelyHigher(this.candles)) {
					result = true;
				}
			}
			return result;
		}
		
		private boolean isBullishKicker() {
			boolean result = false;
			if(Pattern.isCandleListValid(this.candles)) {
				if(Pattern.isCandleBearish(this.candles.get(0)) &&
				   Pattern.isCandleBearish(this.candles.get(1)) &&
				   Pattern.isCandleBearish(this.candles.get(2)) &&
				   Pattern.eachCandleClosedAtSuccessivelyLowerShadow(this.candles)) {
					result = true;
				}
			}
			return result;
		}
		
		private boolean isBullishMorningStar() {
			boolean result = false;
			if(Pattern.isCandleListValid(this.candles)) {
				if(Pattern.isCandleBullish(this.candles.get(0)) &&
				   Pattern.isCandleBullish(this.candles.get(1)) &&
				   Pattern.isCandleBearish(this.candles.get(2)) &&
				   Pattern.formedTinyMiddleCandle(this.candles) &&
				   Pattern.currentBodySmallerThanLast(this.candles) &&
				   Pattern.tinyClosedBelowCurrentAndLast(this.candles) &&
				   Pattern.closedCurrentCandleAt50PercentOrMoreOfBodyFromLast(this.candles)) {
					result = true;
				}
			}
			return result;
		}
		
		private boolean isBearishThreeBlackCrows() {
			boolean result = false;
			if(Pattern.isCandleListValid(this.candles)) {
				if(Pattern.isCandleBearish(this.candles.get(0)) &&
				   Pattern.isCandleBearish(this.candles.get(1)) &&
				   Pattern.isCandleBearish(this.candles.get(2)) &&
				   Pattern.formedThreeConsecutiveLongCandles(this.candles) &&
				   Pattern.eachCandleClosedSuccessivelyLower(this.candles)) {
					result = true;
				}
			}
			return result;
		}
		
		public boolean isBearishEveningStar() {
			boolean result = false;
			if(Pattern.isCandleListValid(this.candles)) {
				if(Pattern.isCandleBearish(this.candles.get(0)) &&
				   Pattern.isCandleBearish(this.candles.get(1)) &&
				   Pattern.isCandleBullish(this.candles.get(2)) &&
				   Pattern.formedTinyMiddleCandle(this.candles) &&
				   Pattern.currentBodySmallerThanLast(this.candles) &&
				   Pattern.tinyClosedAboveCurrentAndLast(this.candles) &&
				   Pattern.closedLastCandleAt50PercentOrMoreOfBodyFromCurrent(this.candles)) {
					result = true;
				}
			}
			return result;
		}
		
		private boolean isBearishKicker() {
			boolean result = false;
			if(Pattern.isCandleListValid(this.candles)) {
				if(Pattern.isCandleBullish(this.candles.get(0)) &&
				   Pattern.isCandleBullish(this.candles.get(1)) &&
				   Pattern.isCandleBullish(this.candles.get(2)) &&
				   Pattern.eachCandleClosedAtSuccessivelyHigherShadow(this.candles)) {
					result = true;
				}
			}
			return result;
		}
	}
	
	public interface CandleStick{
		/**
		 * Call it only, if you are in a <b>downtrend.</b><p>
		 * <b>Suggestion:</b> Overlap EMA's. <b>Example:</b> EMA8, EMA13 and EMA21.</br>
		 * If EMA13 is over EMA8 and EMA21 is over EMA13, than you are in a downtrend.
		 * </p>
		 * @return true if bullish, false otherwise.
		 */
		public boolean isBullish();
		/**
		 * Call it only, if you are in a <b>uptrend.</b><p>
		 * <b>Suggestion:</b> Overlap EMA's. <b>Example:</b> EMA8, EMA13 and EMA21.</br>
		 * If EMA13 is over EMA21 and EMA8 is over EMA13, than you are in a uptrend.
		 * </p>
		 * @return true if bearish, false otherwise.
		 */
		public boolean isBearish();
	}
	
	private static class Pattern{
		private static boolean isCandleBullish(Candle candle) {
			return Double.valueOf(candle.getClose()) > Double.valueOf(candle.getOpen());
		}
		
		public static boolean closedLastCandleAt50PercentOrMoreOfBodyFromCurrent(List<Candle> candles) {
			Candle current = candles.get(0);
			Candle last = candles.get(2);
			double lastBodyTop = getCandleBodyTop(last);
			double curBodyTop = getCandleBodyTop(current);
			double currentBodyTop50Percent = curBodyTop - (getCandleBody(current)/2);
			return lastBodyTop >= currentBodyTop50Percent;
		}

		public static boolean tinyClosedAboveCurrentAndLast(List<Candle> candles) {
			double curBodyTop = getCandleBodyTop(candles.get(0));
			double middleBodyBottom = getCandleBodyBottom(candles.get(1));
			double lastBodyTop = getCandleBodyTop(candles.get(2));
			return middleBodyBottom > curBodyTop && middleBodyBottom > lastBodyTop && curBodyTop > lastBodyTop;
		}

		public static boolean tinyClosedBelowCurrentAndLast(List<Candle> candles) {
			double curBodyBottom = getCandleBodyBottom(candles.get(0));
			double middleBodyTop = getCandleBodyTop(candles.get(1));
			double lastBodyBottom = getCandleBodyBottom(candles.get(2));
			return middleBodyTop < curBodyBottom && middleBodyTop < lastBodyBottom && lastBodyBottom > curBodyBottom;
		}

		public static boolean currentBodySmallerThanLast(List<Candle> candles) {
			double curBody = getCandleBody(candles.get(0));
			double lastBody = getCandleBody(candles.get(2));
			return curBody < lastBody;
		}

		public static boolean doBothCandlesShareSameOrAlmostSameBody(List<Candle> candles) {
			double curBody = getCandleBody(candles.get(0));
			double prevBody = getCandleBody(candles.get(0));
			double percentage = 0.5;
			return curBody == prevBody || valuePlusMinus(percentage, curBody, prevBody);
		}

		public static boolean closedCurrentCandleAt50PercentOrBellowOfBodyFromPrevious(List<Candle> candles) {
			Candle current = candles.get(0);
			Candle previous = candles.get(1);
			double curBodyBottom = getCandleBodyBottom(current);
			double prevBodyBottom = getCandleBodyBottom(previous);
			double prevBodyBottom50Percent = prevBodyBottom + (getCandleBody(previous)/2);
			return curBodyBottom < prevBodyBottom50Percent || curBodyBottom == prevBodyBottom50Percent;
		}

		public static boolean eachCandleClosedAtSuccessivelyHigherShadow(List<Candle> candles) {
			double lastUpperShadow = Double.valueOf(candles.get(2).getMax());
			double midBottom = getCandleBodyBottom(candles.get(1));
			double midLowerShadow = Double.valueOf(candles.get(1).getMin());
			double midUpperShadow = Double.valueOf(candles.get(1).getMax());
			double curBottom = getCandleBodyBottom(candles.get(0));
			double curLowerShadow = Double.valueOf(candles.get(0).getMin());
			return lastUpperShadow <= midBottom && lastUpperShadow >= midLowerShadow && midUpperShadow <= curBottom && midUpperShadow >= curLowerShadow;
		}

		public static boolean eachCandleClosedAtSuccessivelyLowerShadow(List<Candle> candles) {
			double curUpperShadow = Double.valueOf(candles.get(0).getMax());
			double midBottom = getCandleBodyBottom(candles.get(1));
			double midLowerShadow = Double.valueOf(candles.get(1).getMin());
			double midUpperShadow = Double.valueOf(candles.get(1).getMax());
			double lastBottom = getCandleBodyBottom(candles.get(2));
			double lastLowerShadow = Double.valueOf(candles.get(2).getMin());
			return curUpperShadow <= midBottom && curUpperShadow >= midLowerShadow &&  midUpperShadow <= lastBottom && midUpperShadow >= lastLowerShadow;
		}


		public static boolean closedCurrentCandleAt50PercentOrMoreOfBodyFromLast(List<Candle> candles) {
			Candle current = candles.get(0);
			Candle last = candles.get(2);
			double curBodyTop = getCandleBodyTop(current);
			double lastBodyBottom = getCandleBodyBottom(last);
			double lastBodyBottom50Percent = lastBodyBottom + (getCandleBody(last)/2);
			return curBodyTop >= lastBodyBottom50Percent;
		}

		public static boolean formedTinyMiddleCandle(List<Candle> candles) {
			double curBody = getCandleBody(candles.get(0));
			double prevBody = getCandleBody(candles.get(1));
			double lastBody = getCandleBody(candles.get(2));
			return prevBody < curBody && prevBody < lastBody;
		}

		public static boolean openedCurrentCandleBellowOrAtClosingFromPrevious(List<Candle> candles) {
			Candle current = candles.get(0);
			Candle previous = candles.get(1);
			double curBodyTop = getCandleBodyTop(current);
			double prevBodyTop = getCandleBodyTop(previous);
			return curBodyTop < prevBodyTop || curBodyTop == prevBodyTop;
		}

		public static boolean doBothCandlesShareSameOrAlmostSameHigh(List<Candle> candles) {
			double curShadowUpper = getCandleUpperShadow(candles.get(0));
			double prevShadowUpper = getCandleUpperShadow(candles.get(0));
			double percentage = 0.5; 
			return curShadowUpper == prevShadowUpper || valuePlusMinus(percentage, curShadowUpper, prevShadowUpper);
		}

		private static boolean eachCandleClosedSuccessivelyLower(List<Candle> candles) {
			double curTop = getCandleBodyTop(candles.get(0));
			double midTop = getCandleBodyTop(candles.get(1));
			double lastTop = getCandleBodyTop(candles.get(2));
			return lastTop > midTop && midTop > curTop;
		}

		private static boolean eachCandleClosedSuccessivelyHigher(List<Candle> candles) {
			double curTop = getCandleBodyTop(candles.get(0));
			double midTop = getCandleBodyTop(candles.get(1));
			double lastTop = getCandleBodyTop(candles.get(2));
			return lastTop < midTop && midTop < curTop;
		}

		private static boolean formedThreeConsecutiveLongCandles(List<Candle> candles) {
			double coef1 = Pattern.getCandleBody(candles.get(0))/Pattern.getCandleUpperShadow(candles.get(0));
			double coef2 = Pattern.getCandleBody(candles.get(0))/Pattern.getCandleLowerShadow(candles.get(0));
			double coef3 = Pattern.getCandleBody(candles.get(1))/Pattern.getCandleUpperShadow(candles.get(1));
			double coef4 = Pattern.getCandleBody(candles.get(1))/Pattern.getCandleLowerShadow(candles.get(1));
			double coef5 = Pattern.getCandleBody(candles.get(2))/Pattern.getCandleUpperShadow(candles.get(2));
			double coef6 = Pattern.getCandleBody(candles.get(2))/Pattern.getCandleLowerShadow(candles.get(2));
			return coef1 >= 5 && coef2 >= 5 && coef3 >= 5 && coef4 >= 5 && coef5 >= 5 && coef6 >= 5; 
		}

		private static boolean closedCurrentCandleAt50PercentOrAboveOfBodyFromPrevious(List<Candle> candles) {
			Candle current = candles.get(0);
			Candle previous = candles.get(1);
			double curBodyTop = getCandleBodyTop(current);
			double prevBodyBottom = getCandleBodyBottom(previous);
			double prevBodyBottom50Percent = prevBodyBottom + (getCandleBody(previous)/2);
			return curBodyTop > prevBodyBottom50Percent || curBodyTop == prevBodyBottom50Percent;
		}

		private static boolean openedCurrentCandleAboveOrAtClosingFromPrevious(List<Candle> candles) {
			Candle current = candles.get(0);
			Candle previous = candles.get(1);
			double curBodyTop = getCandleBodyTop(current);
			double prevBodyTop = getCandleBodyTop(previous);
			return curBodyTop > prevBodyTop || curBodyTop == prevBodyTop;
		}

		private static boolean doBothCandlesShareSameOrAlmostSameLow(List<Candle> candles) {
			double curShadowLow = getCandleLowerShadow(candles.get(0));
			double prevShadowLow = getCandleLowerShadow(candles.get(0));
			double percentage = 0.5; 
			return curShadowLow == prevShadowLow || valuePlusMinus(percentage, curShadowLow, prevShadowLow);
		}

		private static boolean valuePlusMinus(double percentage, double current, double previous) {
			double drift = ((current*percentage)/100);
			double high = current + drift;
			double low = current - drift;
			return previous <= high && previous >= low;
		}

		private static boolean isPreviousCandleEntirelyContainedInBodyOfCurrent(List<Candle> candles) {
			Candle current = candles.get(0);
			Candle previous = candles.get(1);
			double curBodyTop = getCandleBodyTop(current);
			double curBodyBottom = getCandleBodyBottom(current);
			double prevBodyTop = getCandleBodyTop(previous);
			double prevBodyBottom = getCandleBodyBottom(previous);
			return curBodyTop > prevBodyTop && curBodyBottom < prevBodyBottom;
		}

		private static boolean isPreviousCandleShorterThanCurrent(List<Candle> candles) {
			Candle current = candles.get(0);
			Candle previous = candles.get(1);
			double curBody = getCandleBody(current);
			double prevBody = getCandleBody(previous);
			return prevBody < curBody;
		}

		private static boolean hasLittleOrNoLowerShadow(Candle candle) {
			double coefficient = Pattern.getCandleLowerShadow(candle)/Pattern.getCandleBody(candle);
			return coefficient <= 2; // lower shadow <= 2x body size
		}

		private static boolean hasLittleOrNoUpperShadow(Candle candle) {
			double coefficient = Pattern.getCandleUpperShadow(candle)/Pattern.getCandleBody(candle);
			return coefficient <= 2; // upper shadow <= 2x body size
		}

		private static boolean isCandleBearish(Candle candle) {
			return Double.valueOf(candle.getClose()) < Double.valueOf(candle.getOpen());
		}
		
		private static boolean isCandleNeitherBullishNorBearish(Candle candle) {
			return Double.valueOf(candle.getClose()) == Double.valueOf(candle.getOpen());
		}
		
		private static boolean hasLongUpperShadow(Candle candle) {
			double coefficient = Pattern.getCandleUpperShadow(candle)/Pattern.getCandleBody(candle);
			return coefficient >= 5; // upper shadow >= 5x body size
		}
		
		private static boolean hasLongLowerShadow(Candle candle) {
			double coefficient = Pattern.getCandleLowerShadow(candle)/Pattern.getCandleBody(candle);
			return coefficient >= 5; // lower shadow >= 5x body size
		}
		
		private static boolean isUpperShadow2xLongerThanBody(Candle candle) {
			double coefficient = Pattern.getCandleUpperShadow(candle)/Pattern.getCandleBody(candle);
			return coefficient >= 2; // upper shadow >= 2x body size
		}
		
		private static boolean isLowerShadow2xLongerThanBody(Candle candle) {
			double coefficient = Pattern.getCandleLowerShadow(candle)/Pattern.getCandleBody(candle);
			return coefficient >= 2; // lower shadow >= 2x body size
		}
		
		private static boolean hasLittleOrNoRealBody(Candle candle) {
			boolean result = false;
			if(Pattern.isCandleNeitherBullishNorBearish(candle)) {
				result = true;
			}else {
				double coefficient = Pattern.getCandleFullSize(candle)/Pattern.getCandleBody(candle);
				result =  coefficient >= 7;
			}
			return result;
		}
		
		private static double getCandleBody(Candle candle) {
			double candleBody = Double.valueOf(candle.getClose()) - Double.valueOf(candle.getOpen());
			if(candleBody<0) {
				candleBody = candleBody * (-1);
			}
			return candleBody;
		}
		
		private static double getCandleBodyTop(Candle candle) {
			double candleBodyTop = 0;
			if(Pattern.isCandleBullish(candle)) {
				candleBodyTop = Double.valueOf(candle.getClose());
			}else if(Pattern.isCandleBearish(candle)) {
				candleBodyTop = Double.valueOf(candle.getOpen());
			}else {
				// neither bullish nor bearish
				candleBodyTop = Double.valueOf(candle.getClose());
			}
			return candleBodyTop;
		}
		
		private static double getCandleBodyBottom(Candle candle) {
			double candleBodyBottom = 0;
			if(Pattern.isCandleBullish(candle)) {
				candleBodyBottom = Double.valueOf(candle.getOpen());
			}else if(Pattern.isCandleBearish(candle)) {
				candleBodyBottom = Double.valueOf(candle.getClose());
			}else {
				// neither bullish nor bearish
				candleBodyBottom = Double.valueOf(candle.getClose());
			}
			return candleBodyBottom;
		}
		
		private static double getCandleUpperShadow(Candle candle) {
			double candleUpperShadow = 0;
			if(Pattern.isCandleBullish(candle)) {
				candleUpperShadow = Double.valueOf(candle.getMax()) - Double.valueOf(candle.getClose());
			}else if(Pattern.isCandleBearish(candle)) {
				candleUpperShadow = Double.valueOf(candle.getMax()) - Double.valueOf(candle.getOpen());
			}else {
				// neither bullish nor bearish
				candleUpperShadow = Double.valueOf(candle.getMax()) - Double.valueOf(candle.getClose());
			}
			return candleUpperShadow;
		}
		
		private static double getCandleLowerShadow(Candle candle) {
			double candleLowerShadow = 0;
			if(Pattern.isCandleBullish(candle)) {
				candleLowerShadow = Double.valueOf(candle.getOpen()) - Double.valueOf(candle.getMin());
			}else if(Pattern.isCandleBearish(candle)) {
				candleLowerShadow = Double.valueOf(candle.getClose()) - Double.valueOf(candle.getMin());
			}else {
				// neither bullish nor bearish
				candleLowerShadow = Double.valueOf(candle.getOpen()) - Double.valueOf(candle.getMin());
			}
			return candleLowerShadow;
		}
		
		private static double getCandleFullSize(Candle candle) {
			return Double.valueOf(candle.getMax()) - Double.valueOf(candle.getMin());
		}
		
		private static boolean isCandleListValid(List<Candle> candles) {
			if(candles.isEmpty()) {
				return false;
			}else {
				for (Candle candle : candles) {
					if(candle.isEmpty()) {
						return false;
					}
				}
			}
			return true;
		}
	}
	

}
