RxProperty
---

A library for observe value of property using RxJava.

[![GitHub release](https://img.shields.io/github/release/kubode/RxProperty.svg?maxAge=2592000)]()
[![Build Status](https://travis-ci.org/kubode/RxProperty.svg?branch=master)](https://travis-ci.org/kubode/RxProperty)


Usage
---

Add dependency notation to `build.gradle`.

```gradle
dependencies {
    compile "com.github.kubode.rxproperty:rxproperty:$latestVersion"
}
```

RxProperty has following extensible classes.

| Class Name | Extensible | Description |
| --- | --- | --- |
| `ReadOnlyObservableProperty` | true | Read only. |
| `Constant` | false | Unmodifiable. |
| `ObservableProperty` | true | Rewritable. |
| `Variable` | false | Rewritable. |
| `EmptyVariable` | false | Lazy initialization `Variable`. |

This is an example of `Variable`.

```java
class Sample {
    final Variable<Integer> aInt = new Variable<>(0);
    public static void main(String... args) {
        Sample sample = new Sample();
        // emits value when subscribed.
        // print: value is 0
        sample.aInt.subscribe(aInt -> System.out.println("value is " + aInt));
        // emits value when changed.
        // print: value is 1
        sample.aInt.value = 1;
    }
}
```

`ReadOnlyObservableProperty` and `ObservableProperty` are extensible by implementing `State`.

```java
public class TickState implements ReadOnlyObservableProperty.State<Long> {
    @Override public Observable<Long> getObservable() {
        return Observable.interval(0, 1, TimeUnit.SECONDS).map(tick -> getValue());
    }
    @Override public Long getValue() {
        return System.currentTimeMillis();
    }
    public static void main(String... args) throws InterruptedException {
        ReadOnlyObservableProperty<Long> p = new ReadOnlyObservableProperty<>(new TickState());
        System.out.println(p.getValue());
        p.subscribe(System.out::println);
        Thread.sleep(10000);
    }
}
```


License
---

```
Copyright 2016 Masatoshi Kubode

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```