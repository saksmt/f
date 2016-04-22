package run.smt.f.definition.predicate;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import run.smt.f.definition.predicate.function.Predicate0FTest;
import run.smt.f.definition.predicate.javapredicate.Predicate0JPTest;
import run.smt.f.definition.predicate.predicate.Predicate0PTest;

/**
 * @author Kirill Saksin <kirill.saksin@billing.ru>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Predicate0FTest.class, Predicate0JPTest.class, Predicate0PTest.class})
public class Predicate0Test {
}
