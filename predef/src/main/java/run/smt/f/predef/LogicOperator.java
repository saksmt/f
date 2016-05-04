package run.smt.f.predef;

import run.smt.f.definition.predicate.Predicate0;
import run.smt.f.definition.predicate.Predicate1;
import run.smt.f.definition.predicate.Predicate2;

import java.util.function.*;

/**
 * Contains logic operators functional representation
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public interface LogicOperator {
    //region P0

    static Predicate0 not(Predicate0 self) {
        return self.negate();
    }

    //region OR

    //region OR()

    static Predicate0 or(Predicate0 self, Supplier<Boolean> f) {
        return self.or(f);
    }

    static Predicate0 or(Predicate0 self, Predicate0 f) {
        return self.or(f);
    }

    //endregion

    //region OR(A)

    static <A> Predicate1<A> or(Predicate0 self, Function<? super A, Boolean> f) {
        return self.or(f);
    }

    static <A> Predicate1<A> or(Predicate0 self, Predicate1<? super A> f) {
        return self.or(f);
    }

    static <A> Predicate1<A> or(Predicate0 self, Predicate<? super A> f) {
        return self.or(f);
    }

    //endregion

    //region OR(A, B)

    static <A, B> Predicate2<A, B> or(Predicate0 self, Predicate2<? super A, ? super B> f) {
        return self.or(f);
    }

    static <A, B> Predicate2<A, B> or(Predicate0 self, BiPredicate<? super A, ? super B> f) {
        return self.or(f);
    }

    static <A, B> Predicate2<A, B> or(Predicate0 self, BiFunction<? super A, ? super B, Boolean> f) {
        return self.or(f);
    }

    //endregion

    //endregion

    //region AND

    //region AND()

    static Predicate0 and(Predicate0 self, Supplier<Boolean> f) {
        return self.and(f);
    }

    static Predicate0 and(Predicate0 self, Predicate0 f) {
        return self.and(f);
    }

    //endregion

    //region AND(A)

    static <A> Predicate1<A> and(Predicate0 self, Function<? super A, Boolean> f) {
        return self.and(f);
    }

    static <A> Predicate1<A> and(Predicate0 self, Predicate1<? super A> f) {
        return self.and(f);
    }

    static <A> Predicate1<A> and(Predicate0 self, Predicate<? super A> f) {
        return self.and(f);
    }

    //endregion

    //region AND(A, B)

    static <A, B> Predicate2<A, B> and(Predicate0 self, BiFunction<? super A, ? super B, Boolean> f) {
        return self.and(f);
    }

    static <A, B> Predicate2<A, B> and(Predicate0 self, Predicate2<? super A, ? super B> f) {
        return self.and(f);
    }

    static <A, B> Predicate2<A, B> and(Predicate0 self, BiPredicate<? super A, ? super B> f) {
        return self.and(f);
    }

    //endregion

    //endregion

    //region XOR

    //region XOR()

    static Predicate0 xor(Predicate0 self, Supplier<Boolean> f) {
        return self.xor(f);
    }

    static Predicate0 xor(Predicate0 self, Predicate0 f) {
        return self.xor(f);
    }

    //endregion

    //region XOR(A)

    static <A> Predicate1<A> xor(Predicate0 self, Function<? super A, Boolean> f) {
        return self.xor(f);
    }

    static <A> Predicate1<A> xor(Predicate0 self, Predicate<? super A> f) {
        return self.xor(f);
    }

    static <A> Predicate1<A> xor(Predicate0 self, Predicate1<? super A> f) {
        return self.xor(f);
    }

    //endregion

    //region XOR(A, B)

    static <A, B> Predicate2<A, B> xor(Predicate0 self, BiFunction<? super A, ? super B, Boolean> f) {
        return self.xor(f);
    }

    static <A, B> Predicate2<A, B> xor(Predicate0 self, Predicate2<? super A, ? super B> f) {
        return self.xor(f);
    }

    static <A, B> Predicate2<A, B> xor(Predicate0 self, BiPredicate<? super A, ? super B> f) {
        return self.xor(f);
    }

    //endregion

    //endregion

    //region IMPLIES

    //region IMPLIES()

    static Predicate0 implies(Predicate0 self, Supplier<Boolean> f) {
        return self.implies(f);
    }

    static Predicate0 implies(Predicate0 self, Predicate0 f) {
        return self.implies(f);
    }

    //endregion

    //region IMPLIES(A)

    static <A> Predicate1<A> implies(Predicate0 self, Function<? super A, Boolean> f) {
        return self.implies(f);
    }

    static <A> Predicate1<A> implies(Predicate0 self, Predicate1<? super A> f) {
        return self.implies(f);
    }

    static <A> Predicate1<A> implies(Predicate0 self, Predicate<? super A> f) {
        return self.implies(f);
    }

    //endregion

    //region IMPLIES(A, B)

    static <A, B> Predicate2<A, B> implies(Predicate0 self, BiFunction<? super A, ? super B, Boolean> f) {
        return self.implies(f);
    }

    static <A, B> Predicate2<A, B> implies(Predicate0 self, Predicate2<? super A, ? super B> f) {
        return self.implies(f);
    }

    static <A, B> Predicate2<A, B> implies(Predicate0 self, BiPredicate<? super A, ? super B> f) {
        return self.implies(f);
    }

    //endregion

    //endregion

    //region EQUALITY

    //region EQUALITY()

    static Predicate0 equality(Predicate0 self, Supplier<Boolean> f) {
        return self.equality(f);
    }

    static Predicate0 equality(Predicate0 self, Predicate0 f) {
        return self.equality(f);
    }

    //endregion

    //region EQUALITY(A)

    static <A> Predicate1<A> equality(Predicate0 self, Function<? super A, Boolean> f) {
        return self.equality(f);
    }

    static <A> Predicate1<A> equality(Predicate0 self, Predicate1<? super A> f) {
        return self.equality(f);
    }

    static <A> Predicate1<A> equality(Predicate0 self, Predicate<? super A> f) {
        return self.equality(f);
    }

    //endregion

    //region EQUALITY(A, B)

    static <A, B> Predicate2<A, B> equality(Predicate0 self, BiFunction<? super A, ? super B, Boolean> f) {
        return self.equality(f);
    }

    static <A, B> Predicate2<A, B> equality(Predicate0 self, Predicate2<? super A, ? super B> f) {
        return self.equality(f);
    }

    static <A, B> Predicate2<A, B> equality(Predicate0 self, BiPredicate<? super A, ? super B> f) {
        return self.equality(f);
    }

    //endregion

    //endregion

    //endregion

    //region P1

    static <A> Predicate1<A> not(Predicate1<A> self) {
        return self.negate();
    }

    //region OR

    //region OR()

    static <A> Predicate1<A> or(Predicate1<A> self, Supplier<Boolean> f) {
        return self.or(f);
    }

    static <A> Predicate1<A> or(Predicate1<A> self, Predicate0 f) {
        return self.or(f);
    }

    //endregion

    //region OR(A)

    static <A> Predicate1<A> or(Predicate1<A> self, Function<? super A, Boolean> f) {
        return self.or(f);
    }

    static <A> Predicate1<A> or(Predicate1<A> self, Predicate1<? super A> f) {
        return self.or(f);
    }

    static <A> Predicate1<A> or(Predicate1<A> self, Predicate<? super A> f) {
        return self.or(f);
    }

    //endregion

    //region OR(A, B)

    static <A, B> Predicate2<A, B> or(Predicate1<A> self, BiFunction<? super A, ? super B, Boolean> f) {
        return self.or(f);
    }

    static <A, B> Predicate2<A, B> or(Predicate1<A> self, Predicate2<? super A, ? super B> f) {
        return self.or(f);
    }

    static <A, B> Predicate2<A, B> or(Predicate1<A> self, BiPredicate<? super A, ? super B> f) {
        return self.or(f);
    }

    //endregion

    //endregion

    //region AND

    //region AND()

    static <A> Predicate1<A> and(Predicate1<A> self, Supplier<Boolean> f) {
        return self.and(f);
    }

    static <A> Predicate1<A> and(Predicate1<A> self, Predicate0 f) {
        return self.and(f);
    }

    //endregion

    //region AND(A)

    static <A> Predicate1<A> and(Predicate1<A> self, Function<? super A, Boolean> f) {
        return self.and(f);
    }

    static <A> Predicate1<A> and(Predicate1<A> self, Predicate1<? super A> f) {
        return self.and(f);
    }

    static <A> Predicate1<A> and(Predicate1<A> self, Predicate<? super A> f) {
        return self.and(f);
    }

    //endregion

    //region AND(A, B)

    static <A, B> Predicate2<A, B> and(Predicate1<A> self, BiFunction<? super A, ? super B, Boolean> f) {
        return self.and(f);
    }

    static <A, B> Predicate2<A, B> and(Predicate1<A> self, Predicate2<? super A, ? super B> f) {
        return self.and(f);
    }

    static <A, B> Predicate2<A, B> and(Predicate1<A> self, BiPredicate<? super A, ? super B> f) {
        return self.and(f);
    }

    //endregion

    //endregion

    //region XOR

    //region XOR()

    static <A> Predicate1<A> xor(Predicate1<A> self, Supplier<Boolean> f) {
        return self.xor(f);
    }

    static <A> Predicate1<A> xor(Predicate1<A> self, Predicate0 f) {
        return self.xor(f);
    }

    //endregion

    //region XOR(A)

    static <A> Predicate1<A> xor(Predicate1<A> self, Function<? super A, Boolean> f) {
        return self.xor(f);
    }

    static <A> Predicate1<A> xor(Predicate1<A> self, Predicate1<? super A> f) {
        return self.xor(f);
    }

    static <A> Predicate1<A> xor(Predicate1<A> self, Predicate<? super A> f) {
        return self.xor(f);
    }

    //endregion

    //region XOR(A, B)

    static <A, B> Predicate2<A, B> xor(Predicate1<A> self, BiFunction<? super A, ? super B, Boolean> f) {
        return self.xor(f);
    }

    static <A, B> Predicate2<A, B> xor(Predicate1<A> self, Predicate2<? super A, ? super B> f) {
        return self.xor(f);
    }

    static <A, B> Predicate2<A, B> xor(Predicate1<A> self, BiPredicate<? super A, ? super B> f) {
        return self.xor(f);
    }

    //endregion

    //endregion

    //region IMPLIES

    //region IMPLIES()

    static <A> Predicate1<A> implies(Predicate1<A> self, Supplier<Boolean> f) {
        return self.implies(f);
    }

    static <A> Predicate1<A> implies(Predicate1<A> self, Predicate0 f) {
        return self.implies(f);
    }

    //endregion

    //region IMPLIES(A)

    static <A> Predicate1<A> implies(Predicate1<A> self, Function<? super A, Boolean> f) {
        return self.implies(f);
    }

    static <A> Predicate1<A> implies(Predicate1<A> self, Predicate1<? super A> f) {
        return self.implies(f);
    }

    static <A> Predicate1<A> implies(Predicate1<A> self, Predicate<? super A> f) {
        return self.implies(f);
    }

    //endregion

    //region IMPLIES(A, B)

    static <A, B> Predicate2<A, B> implies(Predicate1<A> self, BiFunction<? super A, ? super B, Boolean> f) {
        return self.implies(f);
    }

    static <A, B> Predicate2<A, B> implies(Predicate1<A> self, Predicate2<? super A, ? super B> f) {
        return self.implies(f);
    }

    static <A, B> Predicate2<A, B> implies(Predicate1<A> self, BiPredicate<? super A, ? super B> f) {
        return self.implies(f);
    }

    //endregion

    //endregion

    //region EQUALITY

    //region EQUALITY()

    static <A> Predicate1<A> equality(Predicate1<A> self, Supplier<Boolean> f) {
        return self.equality(f);
    }

    static <A> Predicate1<A> equality(Predicate1<A> self, Predicate0 f) {
        return self.equality(f);
    }

    //endregion

    //region EQUALITY(A)

    static <A> Predicate1<A> equality(Predicate1<A> self, Function<? super A, Boolean> f) {
        return self.equality(f);
    }

    static <A> Predicate1<A> equality(Predicate1<A> self, Predicate1<? super A> f) {
        return self.equality(f);
    }

    static <A> Predicate1<A> equality(Predicate1<A> self, Predicate<? super A> f) {
        return self.equality(f);
    }

    //endregion

    //region EQUALITY(A, B)

    static <A, B> Predicate2<A, B> equality(Predicate1<A> self, BiFunction<? super A, ? super B, Boolean> f) {
        return self.equality(f);
    }

    static <A, B> Predicate2<A, B> equality(Predicate1<A> self, Predicate2<? super A, ? super B> f) {
        return self.equality(f);
    }

    static <A, B> Predicate2<A, B> equality(Predicate1<A> self, BiPredicate<? super A, ? super B> f) {
        return self.equality(f);
    }

    //endregion

    //endregion

    //endregion

    //region P2

    static <A, B> Predicate2<A, B> not(Predicate2<A, B> self) {
        return self.negate();
    }

    //region OR

    //region OR()

    static <A, B> Predicate2<A, B> or(Predicate2<A, B> self, Supplier<Boolean> f) {
        return self.or(f);
    }

    static <A, B> Predicate2<A, B> or(Predicate2<A, B> self, Predicate0 f) {
        return self.or(f);
    }

    //endregion

    //region OR(A)

    static <A, B> Predicate2<A, B> or(Predicate2<A, B> self, Function<? super A, Boolean> f) {
        return self.or(f);
    }

    static <A, B> Predicate2<A, B> or(Predicate2<A, B> self, Predicate1<? super A> f) {
        return self.or(f);
    }

    static <A, B> Predicate2<A, B> or(Predicate2<A, B> self, Predicate<? super A> f) {
        return self.or(f);
    }

    //endregion

    //region OR(A, B)

    static <A, B> Predicate2<A, B> or(Predicate2<A, B> self, BiFunction<? super A, ? super B, Boolean> f) {
        return self.or(f);
    }

    static <A, B> Predicate2<A, B> or(Predicate2<A, B> self, Predicate2<? super A, ? super B> f) {
        return self.or(f);
    }

    static <A, B> Predicate2<A, B> or(Predicate2<A, B> self, BiPredicate<? super A, ? super B> f) {
        return self.or(f);
    }

    //endregion

    //endregion

    //region AND

    //region AND()

    static <A, B> Predicate2<A, B> and(Predicate2<A, B> self, Supplier<Boolean> f) {
        return self.and(f);
    }

    static <A, B> Predicate2<A, B> and(Predicate2<A, B> self, Predicate0 f) {
        return self.and(f);
    }

    //endregion

    //region AND(A)

    static <A, B> Predicate2<A, B> and(Predicate2<A, B> self, Function<? super A, Boolean> f) {
        return self.and(f);
    }

    static <A, B> Predicate2<A, B> and(Predicate2<A, B> self, Predicate1<? super A> f) {
        return self.and(f);
    }

    static <A, B> Predicate2<A, B> and(Predicate2<A, B> self, Predicate<? super A> f) {
        return self.and(f);
    }

    //endregion

    //region AND(A, B)

    static <A, B> Predicate2<A, B> and(Predicate2<A, B> self, BiFunction<? super A, ? super B, Boolean> f) {
        return self.and(f);
    }

    static <A, B> Predicate2<A, B> and(Predicate2<A, B> self, Predicate2<? super A, ? super B> f) {
        return self.and(f);
    }

    static <A, B> Predicate2<A, B> and(Predicate2<A, B> self, BiPredicate<? super A, ? super B> f) {
        return self.and(f);
    }

    //endregion

    //endregion

    //region XOR

    //region XOR()

    static <A, B> Predicate2<A, B> xor(Predicate2<A, B> self, Supplier<Boolean> f) {
        return self.xor(f);
    }

    static <A, B> Predicate2<A, B> xor(Predicate2<A, B> self, Predicate0 f) {
        return self.xor(f);
    }

    //endregion

    //region XOR(A)

    static <A, B> Predicate2<A, B> xor(Predicate2<A, B> self, Function<? super A, Boolean> f) {
        return self.xor(f);
    }

    static <A, B> Predicate2<A, B> xor(Predicate2<A, B> self, Predicate1<? super A> f) {
        return self.xor(f);
    }

    static <A, B> Predicate2<A, B> xor(Predicate2<A, B> self, Predicate<? super A> f) {
        return self.xor(f);
    }

    //endregion

    //region XOR(A, B)

    static <A, B> Predicate2<A, B> xor(Predicate2<A, B> self, BiFunction<? super A, ? super B, Boolean> f) {
        return self.xor(f);
    }

    static <A, B> Predicate2<A, B> xor(Predicate2<A, B> self, Predicate2<? super A, ? super B> f) {
        return self.xor(f);
    }

    static <A, B> Predicate2<A, B> xor(Predicate2<A, B> self, BiPredicate<? super A, ? super B> f) {
        return self.xor(f);
    }

    //endregion

    //endregion

    //region IMPLIES

    //region IMPLIES()

    static <A, B> Predicate2<A, B> implies(Predicate2<A, B> self, Supplier<Boolean> f) {
        return self.implies(f);
    }

    static <A, B> Predicate2<A, B> implies(Predicate2<A, B> self, Predicate0 f) {
        return self.implies(f);
    }

    //endregion

    //region IMPLIES(A)

    static <A, B> Predicate2<A, B> implies(Predicate2<A, B> self, Function<? super A, Boolean> f) {
        return self.implies(f);
    }

    static <A, B> Predicate2<A, B> implies(Predicate2<A, B> self, Predicate1<? super A> f) {
        return self.implies(f);
    }

    static <A, B> Predicate2<A, B> implies(Predicate2<A, B> self, Predicate<? super A> f) {
        return self.implies(f);
    }

    //endregion

    //region IMPLIES(A, B)

    static <A, B> Predicate2<A, B> implies(Predicate2<A, B> self, BiFunction<? super A, ? super B, Boolean> f) {
        return self.implies(f);
    }

    static <A, B> Predicate2<A, B> implies(Predicate2<A, B> self, Predicate2<? super A, ? super B> f) {
        return self.implies(f);
    }

    static <A, B> Predicate2<A, B> implies(Predicate2<A, B> self, BiPredicate<? super A, ? super B> f) {
        return self.implies(f);
    }

    //endregion

    //endregion

    //region EQUALITY

    //region EQUALITY()

    static <A, B> Predicate2<A, B> equality(Predicate2<A, B> self, Supplier<Boolean> f) {
        return self.equality(f);
    }

    static <A, B> Predicate2<A, B> equality(Predicate2<A, B> self, Predicate0 f) {
        return self.equality(f);
    }

    //endregion

    //region EQUALITY(A)

    static <A, B> Predicate2<A, B> equality(Predicate2<A, B> self, Function<? super A, Boolean> f) {
        return self.equality(f);
    }

    static <A, B> Predicate2<A, B> equality(Predicate2<A, B> self, Predicate1<? super A> f) {
        return self.equality(f);
    }

    static <A, B> Predicate2<A, B> equality(Predicate2<A, B> self, Predicate<? super A> f) {
        return self.equality(f);
    }

    //endregion

    //region EQUALITY(A, B)

    static <A, B> Predicate2<A, B> equality(Predicate2<A, B> self, BiFunction<? super A, ? super B, Boolean> f) {
        return self.equality(f);
    }

    static <A, B> Predicate2<A, B> equality(Predicate2<A, B> self, Predicate2<? super A, ? super B> f) {
        return self.equality(f);
    }

    static <A, B> Predicate2<A, B> equality(Predicate2<A, B> self, BiPredicate<? super A, ? super B> f) {
        return self.equality(f);
    }

    //endregion

    //endregion

    //endregion
}
