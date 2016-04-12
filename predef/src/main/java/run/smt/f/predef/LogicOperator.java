package run.smt.f.predef;

import run.smt.f.definition.predicate.Predicate0;
import run.smt.f.definition.predicate.Predicate1;
import run.smt.f.definition.predicate.Predicate2;

/**
 * Contains logic operators functional representation
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public interface LogicOperator {

    static Predicate0 not(Predicate0 predicate) {
        return predicate.negate();
    }

    static Predicate0 or(Predicate0 a, Predicate0 b) {
        return a.or(b);
    }

    static Predicate0 and(Predicate0 a, Predicate0 b) {
        return a.and(b);
    }

    static Predicate0 xor(Predicate0 a, Predicate0 b) {
        return a.xor(b);
    }

    static Predicate0 implies(Predicate0 a, Predicate0 b) {
        return a.implies(b);
    }

    static Predicate0 equality(Predicate0 a, Predicate0 b) {
        return a.equality(b);
    }


    static <A> Predicate1<A> or(Predicate0 a, Predicate1<A> b) {
        return a.or(b);
    }

    static <A> Predicate1<A> and(Predicate0 a, Predicate1<A> b) {
        return a.and(b);
    }

    static <A> Predicate1<A> xor(Predicate0 a, Predicate1<A> b) {
        return a.xor(b);
    }

    static <A> Predicate1<A> implies(Predicate0 a, Predicate1<A> b) {
        return a.implies(b);
    }

    static <A> Predicate1<A> equality(Predicate0 a, Predicate1<A> b) {
        return a.equality(b);
    }


    static <A, B> Predicate2<A, B> or(Predicate0 a, Predicate2<A, B> b) {
        return a.equality(b);
    }

    static <A, B> Predicate2<A, B> and(Predicate0 a, Predicate2<A, B> b) {
        return a.and(b);
    }

    static <A, B> Predicate2<A, B> xor(Predicate0 a, Predicate2<A, B> b) {
        return a.xor(b);
    }

    static <A, B> Predicate2<A, B> implies(Predicate0 a, Predicate2<A, B> b) {
        return a.implies(b);
    }

    static <A, B> Predicate2<A, B> equality(Predicate0 a, Predicate2<A, B> b) {
        return a.equality(b);
    }


    static <A> Predicate1<A> not(Predicate1<A> predicate) {
        return predicate.negate();
    }

    static <A> Predicate1<A> or(Predicate1<A> a, Predicate0 b) {
        return a.or(b);
    }

    static <A> Predicate1<A> and(Predicate1<A> a, Predicate0 b) {
        return a.and(b);
    }

    static <A> Predicate1<A> xor(Predicate1<A> a, Predicate0 b) {
        return a.xor(b);
    }

    static <A> Predicate1<A> implies(Predicate1<A> a, Predicate0 b) {
        return a.implies(b);
    }

    static <A> Predicate1<A> equality(Predicate1<A> a, Predicate0 b) {
        return a.equality(b);
    }


    static <A> Predicate1<A> or(Predicate1<A> a, Predicate1<A> b) {
        return a.or(b);
    }

    static <A> Predicate1<A> and(Predicate1<A> a, Predicate1<A> b) {
        return a.and(b);
    }

    static <A> Predicate1<A> xor(Predicate1<A> a, Predicate1<A> b) {
        return a.xor(b);
    }

    static <A> Predicate1<A> implies(Predicate1<A> a, Predicate1<A> b) {
        return a.implies(b);
    }

    static <A> Predicate1<A> equality(Predicate1<A> a, Predicate1<A> b) {
        return a.equality(b);
    }


    static <A, B> Predicate2<A, B> or(Predicate1<A> a, Predicate2<A, B> b) {
        return a.or(b);
    }

    static <A, B> Predicate2<A, B> and(Predicate1<A> a, Predicate2<A, B> b) {
        return a.and(b);
    }

    static <A, B> Predicate2<A, B> xor(Predicate1<A> a, Predicate2<A, B> b) {
        return a.xor(b);
    }

    static <A, B> Predicate2<A, B> implies(Predicate1<A> a, Predicate2<A, B> b) {
        return a.implies(b);
    }

    static <A, B> Predicate2<A, B> equality(Predicate1<A> a, Predicate2<A, B> b) {
        return a.equality(b);
    }


    static <A, B> Predicate2<A, B> not(Predicate2<A, B> predicate) {
        return predicate.negate();
    }

    static <A, B> Predicate2<A, B> or(Predicate2<A, B> a, Predicate0 b) {
        return a.equality(b);
    }

    static <A, B> Predicate2<A, B> and(Predicate2<A, B> a, Predicate0 b) {
        return a.and(b);
    }

    static <A, B> Predicate2<A, B> xor(Predicate2<A, B> a, Predicate0 b) {
        return a.xor(b);
    }

    static <A, B> Predicate2<A, B> implies(Predicate2<A, B> a, Predicate0 b) {
        return a.implies(b);
    }

    static <A, B> Predicate2<A, B> equality(Predicate2<A, B> a, Predicate0 b) {
        return a.equality(b);
    }


    static <A, B> Predicate2<A, B> or(Predicate2<A, B> a, Predicate1<A> b) {
        return a.or(b);
    }

    static <A, B> Predicate2<A, B> and(Predicate2<A, B> a, Predicate1<A> b) {
        return a.and(b);
    }

    static <A, B> Predicate2<A, B> xor(Predicate2<A, B> a, Predicate1<A> b) {
        return a.xor(b);
    }

    static <A, B> Predicate2<A, B> implies(Predicate2<A, B> a, Predicate1<A> b) {
        return a.implies(b);
    }

    static <A, B> Predicate2<A, B> equality(Predicate2<A, B> a, Predicate1<A> b) {
        return a.equality(b);
    }


    static <A, B> Predicate2<A, B> or(Predicate2<A, B> a, Predicate2<A, B> b) {
        return a.or(b);
    }

    static <A, B> Predicate2<A, B> and(Predicate2<A, B> a, Predicate2<A, B> b) {
        return a.and(b);
    }

    static <A, B> Predicate2<A, B> xor(Predicate2<A, B> a, Predicate2<A, B> b) {
        return a.xor(b);
    }

    static <A, B> Predicate2<A, B> implies(Predicate2<A, B> a, Predicate2<A, B> b) {
        return a.implies(b);
    }

    static <A, B> Predicate2<A, B> equality(Predicate2<A, B> a, Predicate2<A, B> b) {
        return a.equality(b);
    }
}
