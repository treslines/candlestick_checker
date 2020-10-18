# Candlestick Checker ![](https://travis-ci.org/treslines/candlestick_checker.svg?branch=master) [![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)
Use the most popular candle stick patterns to **reinforce** the signals of your trading indicators.
This tiny library focuses on **simplicity**. 

<p align="left">
  <img src="https://github.com/treslines/candlestick_checker/blob/master/candles.png">
</p>

It groups the patterns into three main sections:

| **Single Candle Pattern** | **Double Candle Pattern**| **Triple Candle Pattern** |
| :---:         |     :---:      |          :---: |
| BullishDoji   | BullishEngolfer     | BullishMorningStar    |
| BullishHammer    | BullishPiercing       | BullishWhiteSoldiers      |
| BearishDoji    | BullishTweezerBottom       | BullishKicker     |
| BearishShotingStar    | BearishEngolfer       | BearishEveningStar      |
|     | BearishDarkCloudCover       | BearishThreeBlackCrows      |
|     | BearishTweezerTop       | BearishKicker      |


But instead of worrying about each one of them or checking it one by one, this tiny lib evaluates all of them returning only a **bullish** or **bearish** signal.

# Simple Usage
I prefer to check for all in one like in the example bellow, but if you prefer, you may check individually.
```java
// CHECK FOR ALL CANDLE STICK PATTERN

// if you are in a downtrend, check for bullish signals
boolean isSingleBullish = CandleStickFactory.single(candles).isBullish();
boolean isDoubleBullish = CandleStickFactory.doubl(candles).isBullish();
boolean isTripleBullish = CandleStickFactory.triple(candles).isBullish();

if(isSingleBullish || isDoubleBullish || isTripleBullish){
  // if you are in a downtrend and your trending signal are indicating
  // a possible turn over to an uptrend, this could be the right moment to 
  // buy a position. It should act as a reinforcement of your indicators
  
  // ... do something here...
}

// if you are in an uptrend, check for bearish signals
boolean isSingleBearish = CandleStickFactory.single(candles).isBearish();
boolean isDoubleBearish = CandleStickFactory.doubl(candles).isBearish();
boolean isTripleBearish = CandleStickFactory.triple(candles).isBearish();

if(isSingleBearish || isDoubleBearish || isTripleBearish){
  // if you are in an uptrend and your trending signal are indicating
  // a possible turn over to a downtrend, this could be the right moment to 
  // sell a position. It should act as a reinforcement of your indicators
  
  // ... do something here...
}
```

# Setup
- Create an eclipse maven java project
- Clone this repo to your local machine using `git clone https://github.com/treslines/candlestick_checker.git`
- Include it in your project and reference it

# Test coverage
All candlestick sections were tested. Those tests can be found at `com.treslines.test.candlestick` and for each one exits a  single test case. But, for **simplicity**, there is a test suite that runs all tests together automatically everytime we accept a pull request.

### CandleStickTestSuite
- SingleCandleStickPatternTest
- DoubleCandleStickPatternTest
- TripleCandleStickPatternTest

# Contributions - Minimal requirements:
  - Classes should follow the same pattern as the model classes with javadoc
  - Fork the project, implement your contribution, make a pull request

## License:
[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)
- **[MIT license](http://opensource.org/licenses/mit-license.php)**
- Copyright 2018-2020 © Ricardo Ferreira

## Author:
<pre>
<b>Ricardo Ferreira</b>
Instagram: ricardo7307
Twitter: ricardo_7307
Needs Driven Development (NDD): <a href="http://codegramm.herokuapp.com/index.html">http://codegramm.herokuapp.com/index.html</a>
</pre>
