package run.smt.f.definition.predicate;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import run.smt.f.definition.predicate.function.Predicate1FTest;
import run.smt.f.definition.predicate.javapredicate.Predicate1JPTest;
import run.smt.f.definition.predicate.predicate.Predicate1PTest;

/**
 * @author Kirill Saksin <kirill.saksin@billing.ru>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Predicate1FTest.class, Predicate1JPTest.class, Predicate1PTest.class})
public class Predicate1Test {
}
