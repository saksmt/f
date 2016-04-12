# f

Provides some useful (especially for method references) functional methods for Java 8

## Example

```java
import static run.smt.f.functional.Pipes.*;
import static run.smt.f.functional.signaturemanip.ArgumentManipulation.*;
import static run.smt.f.functional.signaturemanip.ReturnManipulation.*;
import static run.smt.f.predef.LogicChecks.*;
import static run.smt.f.predef.LogicOperator.*;

class Example {
    public void usage() {
        getSomeStream()
            .filter(and(this::isUseful, this::isGood))
            .filter(not(this::isWrong))
            .filter(isNotNull())
            .map(pipe(bind(this::convertToPojo, getArg()), Pojo::getField))
            .foreach(expand(this::dontNeedArgs));
    }

    private Stream getSomeStream() {}
    private boolean isUseful(Object elem) {}
    private boolean isGood(Object elem) {}
    private boolean isWrong(Object elem) {}
    private Arg getArg() {}
    private Pojo convertToPojoWithArg(Object elem, Arg arg) {}
    private void dontNeedArgs() {}

}
```

## Modules

 - `definition` - Definition of functional interfaces
 - `functional` - Wrapper for easier usage with method references, contains all methods of functional interfaces as static methods
 - `predicate` - Definition of predicates, extended methods in functional interfaces for easier usage with functions returning boolean values
 - `predef` - Predefined operations and checks for both simple functional interfaces from `definition` and `predicate`

## Download (WIP: need to publish to sonatype)

```xml
<dependency>
    <groupId>run.smt.f</groupId>
    <artifactId>all</artifactId>
    <version>1.0.0</version>
</dependency>
```