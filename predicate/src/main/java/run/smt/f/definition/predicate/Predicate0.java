package run.smt.f.definition.predicate;

import run.smt.f.definition.function.Function0;

import java.util.function.*;

import static java.util.Objects.requireNonNull;

/**
 * Represents predicate with no arguments (function with no arguments and boolean return value)
 * and all logic operations (like logical OR, logical AND and so on)
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
@FunctionalInterface
public interface Predicate0 extends Function0<Boolean> {
    default Predicate0 negate() {
        return () -> !apply();
    }

    //region OR

    //region OR()

    default Predicate0 or(Supplier<Boolean> f) {
        requireNonNull(f);
        return () -> apply() || f.get();
    }

    default Predicate0 or(Predicate0 f) {
        requireNonNull(f);
        return () -> apply() || f.apply();
    }

    //endregion

    //region OR(A)

    default <A> Predicate1<A> or(Function<? super A, Boolean> f) {
        requireNonNull(f);
        return a -> apply() || f.apply(a);
    }

    default <A> Predicate1<A> or(Predicate1<? super A> f) {
        requireNonNull(f);
        return a -> apply() || f.apply(a);
    }

    default <A> Predicate1<A> or(Predicate<? super A> f) {
        requireNonNull(f);
        return a -> apply() || f.test(a);
    }

    //endregion

    //region OR(A, B)

    default <A, B> Predicate2<A, B> or(Predicate2<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply() || f.apply(a, b);
    }

    default <A, B> Predicate2<A, B> or(BiPredicate<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply() || f.test(a, b);
    }

    default <A, B> Predicate2<A, B> or(BiFunction<? super A, ? super B, Boolean> f) {
        requireNonNull(f);
        return (a, b) -> apply() || f.apply(a, b);
    }

    //endregion

    //endregion

    //region AND

    //region AND()

    default Predicate0 and(Supplier<Boolean> f) {
        requireNonNull(f);
        return () -> apply() && f.get();
    }

    default Predicate0 and(Predicate0 f) {
        requireNonNull(f);
        return () -> apply() && f.apply();
    }

    //endregion

    //region AND(A)

    default <A> Predicate1<A> and(Function<? super A, Boolean> f) {
        requireNonNull(f);
        return a -> apply() && f.apply(a);
    }

    default <A> Predicate1<A> and(Predicate1<? super A> f) {
        requireNonNull(f);
        return a -> apply() && f.apply(a);
    }

    default <A> Predicate1<A> and(Predicate<? super A> f) {
        requireNonNull(f);
        return a -> apply() && f.test(a);
    }

    //endregion

    //region AND(A, B)
    default <A, B> Predicate2<A, B> and(BiFunction<? super A, ? super B, Boolean> f) {
        requireNonNull(f);
        return (a, b) -> apply() && f.apply(a, b);
    }

    default <A, B> Predicate2<A, B> and(Predicate2<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply() && f.apply(a, b);
    }

    default <A, B> Predicate2<A, B> and(BiPredicate<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply() && f.test(a, b);
    }

    //endregion

    //endregion

    //region XOR

    //region XOR()

    default Predicate0 xor(Supplier<Boolean> f) {
        requireNonNull(f);
        return () -> apply() ^ f.get();
    }

    default Predicate0 xor(Predicate0 f) {
        requireNonNull(f);
        return () -> apply() ^ f.apply();
    }

    //endregion

    //region XOR(A)

    default <A> Predicate1<A> xor(Function<? super A, Boolean> f) {
        requireNonNull(f);
        return a -> apply() ^ f.apply(a);
    }

    default <A> Predicate1<A> xor(Predicate<? super A> f) {
        requireNonNull(f);
        return a -> apply() ^ f.test(a);
    }

    default <A> Predicate1<A> xor(Predicate1<? super A> f) {
        requireNonNull(f);
        return a -> apply() ^ f.apply(a);
    }

    //endregion

    //region XOR(A, B)

    default <A, B> Predicate2<A, B> xor(BiFunction<? super A, ? super B, Boolean> f) {
        requireNonNull(f);
        return (a, b) -> apply() ^ f.apply(a, b);
    }

    default <A, B> Predicate2<A, B> xor(Predicate2<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply() ^ f.apply(a, b);
    }

    default <A, B> Predicate2<A, B> xor(BiPredicate<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply() ^ f.test(a, b);
    }

    //endregion

    //endregion

    //region IMPLIES

    //region IMPLIES()

    default Predicate0 implies(Supplier<Boolean> f) {
        requireNonNull(f);
        return () -> !apply() || f.get();
    }

    default Predicate0 implies(Predicate0 f) {
        requireNonNull(f);
        return () -> !apply() || f.apply();
    }

    //endregion

    //region IMPLIES(A)

    default <A> Predicate1<A> implies(Function<? super A, Boolean> f) {
        requireNonNull(f);
        return a -> !apply() || f.apply(a);
    }

    default <A> Predicate1<A> implies(Predicate1<? super A> f) {
        requireNonNull(f);
        return a -> !apply() || f.apply(a);
    }

    default <A> Predicate1<A> implies(Predicate<? super A> f) {
        requireNonNull(f);
        return a -> !apply() || f.test(a);
    }

    //endregion

    //region IMPLIES(A, B)

    default <A, B> Predicate2<A, B> implies(BiFunction<? super A, ? super B, Boolean> f) {
        requireNonNull(f);
        return (a, b) -> !apply() || f.apply(a, b);
    }

    default <A, B> Predicate2<A, B> implies(Predicate2<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> !apply() || f.apply(a, b);
    }

    default <A, B> Predicate2<A, B> implies(BiPredicate<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> !apply() || f.test(a, b);
    }

    //endregion

    //endregion

    //region EQUALITY

    //region EQUALITY()

    default Predicate0 equality(Supplier<Boolean> f) {
        requireNonNull(f);
        return () -> apply() == f.get();
    }

    default Predicate0 equality(Predicate0 f) {
        requireNonNull(f);
        return () -> apply() == f.apply();
    }

    //endregion

    //region EQUALITY(A)

    default <A> Predicate1<A> equality(Function<? super A, Boolean> f) {
        requireNonNull(f);
        return a -> apply() == f.apply(a);
    }

    default <A> Predicate1<A> equality(Predicate1<? super A> f) {
        requireNonNull(f);
        return a -> apply() == f.apply(a);
    }

    default <A> Predicate1<A> equality(Predicate<? super A> f) {
        requireNonNull(f);
        return a -> apply() == f.test(a);
    }

    //endregion

    //region EQUALITY(A, B)

    default <A, B> Predicate2<A, B> equality(BiFunction<? super A, ? super B, Boolean> f) {
        requireNonNull(f);
        return (a, b) -> apply() == f.apply(a, b);
    }

    default <A, B> Predicate2<A, B> equality(Predicate2<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply() == f.apply(a, b);
    }

    default <A, B> Predicate2<A, B> equality(BiPredicate<? super A, ? super B> f) {
        requireNonNull(f);
        return (a, b) -> apply() == f.test(a, b);
    }

    //endregion

    //endregion
}
