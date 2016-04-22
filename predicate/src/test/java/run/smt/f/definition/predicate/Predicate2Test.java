package run.smt.f.definition.predicate;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import run.smt.f.definition.predicate.function.Predicate2FTest;
import run.smt.f.definition.predicate.javapredicate.Predicate2JPTest;
import run.smt.f.definition.predicate.predicate.Predicate2PTest;

/**
 * @author Kirill Saksin <kirill.saksin@billing.ru>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Predicate2FTest.class, Predicate2JPTest.class, Predicate2PTest.class})
public class Predicate2Test {
}
