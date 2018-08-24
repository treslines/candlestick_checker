# Candlestick Checker
Use the most popular candle stick patterns to **reinforce** the signals of your trading indicators.
This tiny library focuses on **practicality** and **simplicity**. It groups the patterns into three main sections:

- **Single Candle Pattern**
  - BullishDoji
  - BullishHammer
  - BearishDoji
  - BearishShotingStar
- **Double Candle Pattern**
  - BullishEngolfer
  - BullishPiercing
  - BullishTweezerBottom
  - BearishEngolfer
  - BearishDarkCloudCover
  - BearishTweezerTop
- **Triple Candle Pattern**
  - BullishMorningStar
  - BullishWhiteSoldiers
  - BullishKicker
  - BearishEveningStar
  - BearishThreeBlackCrows
  - BearishKicker

But instead of worrying about each one of them or checking it one by one, this tiny lib evaluates all of them returning only a **bullish** or **bearish** signal.

# Usage Example
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


```java
// SINGLE CANDLE STICK PATTERN

// if you are in a downtrend, check for bullish signals
CandleStickFactory.single(candles).isBullish();

// if you are in a uptrend, check for bearish signals
CandleStickFactory.single(candles).isBearish();
```
```java
// DOUBLE CANDLE STICK PATTERN

// if you are in a downtrend, check for bullish signals
CandleStickFactory.doubl(candles).isBullish();

// if you are in a uptrend, check for bearish signals
CandleStickFactory.doubl(candles).isBearish();
```
```java
// TRIPLE CANDLE STICK PATTERN

// if you are in a downtrend, check for bullish signals
CandleStickFactory.triple(candles).isBullish();

// if you are in a uptrend, check for bearish signals
CandleStickFactory.triple(candles).isBearish();
```

# Setup
- Create an eclipse maven java project
- Clone this repo to your local machine using `git clone https://github.com/treslines/candlestick_checker.git`
- Include it in your project and reference it

# Test cases
All candlestick sections were tested. Those tests can be found at `com.treslines.test.candlestick` and for each one exits a  test case.

### SingleCandleStickPatternTest
  - testBullishDoji
  - testBullishHammer
  - testBearishDoji
  - testBearishShotingStar
### DoubleCandleStickPatternTest
  - testBullishEngolfer
  - testBullishPiercing
  - testBullishTweezerBottom
  - testBearishEngolfer
  - testBearishDarkCloudCover
  - testBearishTweezerTop
### TripleCandleStickPatternTest
  - testBullishMorningStar
  - testBullishWhiteSoldiers
  - testBullishKicker
  - testBearishEveningStar
  - testBearishThreeBlackCrows
  - testBearishKicker

# Contributions - The requirements are minimal:
  - Classes should follow the same pattern as the model classes with javadoc
  - Fork the project, implement your contribution, make a pull request

## License:
[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)
- **[MIT license](http://opensource.org/licenses/mit-license.php)**
- Copyright 2018 © Ricardo Ferreira

## Author:
<pre>
<b>Ricardo Ferreira</b>
Software Engineer at CESAR <a href="http://www.cesar.org.br">http://www.cesar.org.br</a>
Instagram: ricardo7307
Twitter: ricardo_7307
Blog: <a href="http://www.cleancodedevelopment-qualityseal.blogspot.com.br">http://www.cleancodedevelopment-qualityseal.blogspot.com.br</a>
</pre>



