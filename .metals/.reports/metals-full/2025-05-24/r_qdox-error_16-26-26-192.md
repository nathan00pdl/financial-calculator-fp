error id: file://<WORKSPACE>/src/test/java-gatling/com/example/financial_calculator_fp/performance/CompoundInterestSimulation.java
file://<WORKSPACE>/src/test/java-gatling/com/example/financial_calculator_fp/performance/CompoundInterestSimulation.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[10,1]

error in qdox parser
file content:
```java
offset: 223
uri: file://<WORKSPACE>/src/test/java-gatling/com/example/financial_calculator_fp/performance/CompoundInterestSimulation.java
text:
```scala
package com.example.financial_calculator_fp.performance;

import java.time.Duration;

import io.gatling.core.body.StringBody;
import io.gatling.http.protocol.HttpProtocolBuilder;
import io.gatling.javaapi.core.*;
import 

p@@ublic class CompoundInterestSimulation extends Simulation{
    HttpProtocolBuilder httpProtocolBuilder = http
        .baseUrl("http://localhost/8080")
        .accepHeader("application/json")
        .contentTypeHeader("application/json");

    String requestBody = "{\n" +
        " \"initialAmount\": 1000.0,\n" + 
        " \"annualInterestRate\": 8.0,\n" + 
        " \"years\": 20\n,\n" + 
        "}";

    ScenarioBuilder javaEndpointScenario = scenario("JAVA Endpoint Test")
        .exec(
            http("Calculate Compound Interest - JAVA")
                .post("/api/compound-interest-java/calculate")
                .body(StringBody(requestBody))
                .check(status().is(200))
        )
        .pause(1);
    
    ScenarioBuilder clojureEndpointScenario = scenario("CLOJURE Endpoint Test")
        .exec(
            http("Calculate Compound Interest - CLOJURE")
                .post("/api/compound-interest-clojure/calculate")
                .body(StringBody(requestBody))
                .check(status().is(200))
        )
        .pause(1);

    {
        setUp(
            javaEndpointScenario.injectOpen(
                rampUsers(250).during(Duration.ofSeconds(30)),
                constantUsersPerSec(10).during(Duration.ofMinutes(2))
            ),
            clojureEndpointScenario.injectOpen(
                rampUsers(250).during(Duration.ofSeconds(30)),
                constantUsersPerSec(10).during(Duration.ofMinutes(2))
            )
        ).protocols(httpProtocol);
    }
}

```

```



#### Error stacktrace:

```
com.thoughtworks.qdox.parser.impl.Parser.yyerror(Parser.java:2025)
	com.thoughtworks.qdox.parser.impl.Parser.yyparse(Parser.java:2147)
	com.thoughtworks.qdox.parser.impl.Parser.parse(Parser.java:2006)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:232)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:190)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:94)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:89)
	com.thoughtworks.qdox.library.SortedClassLibraryBuilder.addSource(SortedClassLibraryBuilder.java:162)
	com.thoughtworks.qdox.JavaProjectBuilder.addSource(JavaProjectBuilder.java:174)
	scala.meta.internal.mtags.JavaMtags.indexRoot(JavaMtags.scala:49)
	scala.meta.internal.metals.SemanticdbDefinition$.foreachWithReturnMtags(SemanticdbDefinition.scala:99)
	scala.meta.internal.metals.Indexer.indexSourceFile(Indexer.scala:489)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3(Indexer.scala:587)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3$adapted(Indexer.scala:584)
	scala.collection.IterableOnceOps.foreach(IterableOnce.scala:619)
	scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:617)
	scala.collection.AbstractIterator.foreach(Iterator.scala:1306)
	scala.meta.internal.metals.Indexer.reindexWorkspaceSources(Indexer.scala:584)
	scala.meta.internal.metals.MetalsLspService.$anonfun$onChange$2(MetalsLspService.scala:902)
	scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.scala:18)
	scala.concurrent.Future$.$anonfun$apply$1(Future.scala:687)
	scala.concurrent.impl.Promise$Transformation.run(Promise.scala:467)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
	java.base/java.lang.Thread.run(Thread.java:840)
```
#### Short summary: 

QDox parse error in file://<WORKSPACE>/src/test/java-gatling/com/example/financial_calculator_fp/performance/CompoundInterestSimulation.java