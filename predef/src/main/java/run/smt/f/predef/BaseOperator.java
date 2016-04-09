package run.smt.f.predef;

import run.smt.f.definition.function.Function0;
import run.smt.f.definition.function.Function1;
import run.smt.f.definition.function.Function2;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public interface BaseOperator {

    static <R> Function0<R> constant(R value) {
        return () -> value;
    }

    static <A extends Number, B extends Number> Function2<A, B, Long> integralSum() {
        return (a, b) -> a.longValue() + b.longValue();
    }

    static <A extends Number, B extends Number> Function2<A, B, Double> floatingSum() {
        return (a, b) -> a.doubleValue() + b.doubleValue();
    }


    static <A extends Number, B extends Number> Function2<A, B, Long> integralDifference() {
        return (a, b) -> a.longValue() - b.longValue();
    }

    static <A extends Number, B extends Number> Function2<A, B, Double> floatingDifference() {
        return (a, b) -> a.doubleValue() - b.doubleValue();
    }


    static <A extends Number, B extends Number> Function2<A, B, Long> integralMultiplection() {
        return (a, b) -> a.longValue() * b.longValue();
    }

    static <A extends Number, B extends Number> Function2<A, B, Double> floatingMultiplection() {
        return (a, b) -> a.doubleValue() * b.doubleValue();
    }


    static <A extends Number, B extends Number> Function2<A, B, Long> integralDivision() {
        return (a, b) -> a.longValue() / b.longValue();
    }

    static <A extends Number, B extends Number> Function2<A, B, Double> floatingDivision() {
        return (a, b) -> a.doubleValue() / b.doubleValue();
    }


    static Function1<? extends Number, Long> plus(long value) {
        return (a) -> a.longValue() + value;
    }

    static Function1<? extends Number, Integer> plus(int value) {
        return (a) -> a.intValue() + value;
    }

    static Function1<? extends Number, Float> plus(float value) {
        return (a) -> a.floatValue() + value;
    }

    static Function1<? extends Number, Double> plus(double value) {
        return (a) -> a.doubleValue() + value;
    }


    static Function1<? extends Number, Long> minus(long value) {
        return (a) -> a.longValue() - value;
    }

    static Function1<? extends Number, Integer> minus(int value) {
        return (a) -> a.intValue() - value;
    }

    static Function1<? extends Number, Float> minus(float value) {
        return (a) -> a.floatValue() - value;
    }

    static Function1<? extends Number, Double> minus(double value) {
        return (a) -> a.doubleValue() - value;
    }


    static Function1<? extends Number, Long> divide(long value) {
        return (a) -> a.longValue() / value;
    }

    static Function1<? extends Number, Integer> divide(int value) {
        return (a) -> a.intValue() / value;
    }

    static Function1<? extends Number, Float> divide(float value) {
        return (a) -> a.floatValue() / value;
    }

    static Function1<? extends Number, Double> divide(double value) {
        return (a) -> a.doubleValue() / value;
    }


    static Function1<? extends Number, Long> multiply(long value) {
        return (a) -> a.longValue() * value;
    }

    static Function1<? extends Number, Integer> multiply(int value) {
        return (a) -> a.intValue() * value;
    }

    static Function1<? extends Number, Float> multiply(float value) {
        return (a) -> a.floatValue() * value;
    }

    static Function1<? extends Number, Double> multiply(double value) {
        return (a) -> a.doubleValue() * value;
    }


    static <R> Function1<?, R> castTo(Class<R> clazz) {
        return (a) -> (R) a;
    }
}
