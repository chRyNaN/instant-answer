# instant-answer
A crude implementation of the DuckDuckGo Instant Answer API for Kotlin

This library provides simple Kotlin models for [DuckDuckGo's Instant Answer API](https://duckduckgo.com/api). All fields in the models are considered nullable since the results seem to vary greatly depending on the request.

The DuckDuckGo Instant Answer API and Results from using the API are provided by DuckDuckGo and subject to their terms and conditions. Please refer to their [documentation](https://duckduckgo.com/api) for more information on using their API. This library is not a product of DuckDuckGo and is independent from them. This library just provides data classes that can be used with results from the DuckDuckGo Instant Answer API.

## Building

[![](https://jitpack.io/v/chRyNaN/instant-answer.svg)](https://jitpack.io/#chRyNaN/instant-answer)

**Core Kotlin Models:**
```groovy
implementation 'com.github.chRyNaN.instant-answer:core:VERSION'
```

**Core Kotlin Models for JVM:**
```groovy
implementation 'com.github.chRyNaN.instant-answer:core-jvm:VERSION'
```

**Core Kotlin Models for JS:**
```groovy
implementation 'com.github.chRyNaN.instant-answer:core-js:VERSION'
```

**Serialization:**
```groovy
implementation 'com.github.chRyNaN.instant-answer:serialization:VERSION'
```

**Serialization for JVM:**
```groovy
implementation 'com.github.chRyNaN.instant-answer:serialization-jvm:VERSION'
```

**Serialization for JS:**
```groovy
implementation 'com.github.chRyNaN.instant-answer:serialization-js:VERSION'
```
