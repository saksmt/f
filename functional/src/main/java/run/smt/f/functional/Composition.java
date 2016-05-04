package run.smt.f.functional;

import run.smt.f.definition.function.Function0;
import run.smt.f.definition.function.Function1;
import run.smt.f.definition.function.Function2;
import run.smt.f.definition.procedure.Procedure0;
import run.smt.f.definition.procedure.Procedure1;
import run.smt.f.definition.procedure.Procedure2;

import java.util.function.*;

import static run.smt.f.functional.Cast.f;

/**
 * Contains all possible combinations for functional composition
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public interface Composition {
    static <A, R> Function0<R> compose(Function<A, R> f, Supplier<? extends A> g) {
        return f(f).compose(g);
    }

    static <A, AA, R> Function1<AA, R> compose(Function<A, R> f, Function<? super AA, ? extends A> g) {
        return f(f).compose(g);
    }

    static <A, AA, B, R> Function2<AA, B, R> compose(Function<A, R> f, BiFunction<? super AA, ? super B, ? extends A> g) {
        return f(f).compose(g);
    }


    static <A, AA, B, R> Function2<AA, B, R> composeLeft(BiFunction<A, B, R> f, BiFunction<? super AA, ? super B, ? extends A> g) {
        return f(f).composeLeft(g);
    }

    static <A, B, BB, R> Function2<A, BB, R> composeRight(BiFunction<A, B, R> f, Function2<? super A, ? super BB, ? extends B> g) {
        return f(f).composeRight(g);
    }

    static <A, AA, B, BB, R> Function2<AA, BB, R> compose(BiFunction<A, B, R> f, Function<? super AA, ? extends A> gA, Function<? super BB, ? extends B> gB) {
        return f(f).compose(gA, gB);
    }

    static <A, AA, B, R> Function1<AA, R> compose(BiFunction<A, B, R> f, Function<? super AA, ? extends A> gA, Supplier<? extends B> gB) {
        return f(f).compose(gA, gB);
    }

    static <A, B, BB, R> Function1<BB, R> compose(BiFunction<A, B, R> f, Supplier<? extends A> gA, Function<? super BB, ? extends B> gB) {
        return f(f).compose(gA, gB);
    }

    static <A, B, R> Function0<R> compose(BiFunction<A, B, R> f, Supplier<? extends A> gA, Supplier<? extends B> gB) {
        return f(f).compose(gA, gB);
    }


    static <A> Procedure0 compose(Consumer<A> f, Supplier<? extends A> g) {
        return f(f).compose(g);
    }

    static <A, AA> Procedure1<AA> compose(Consumer<A> f, Function<? super AA, ? extends A> g) {
        return f(f).compose(g);
    }

    static <A, AA, B> Procedure2<AA, B> compose(Consumer<A> f, BiFunction<? super AA, ? super B, ? extends A> g) {
        return f(f).compose(g);
    }


    static <A, AA, B, BB> Procedure2<AA, BB> compose(BiConsumer<A, B> f, Function<? super AA, ? extends A> gA, Function<? super BB, ? extends B> gB) {
        return f(f).compose(gA, gB);
    }

    static <A, B, BB> Procedure1<BB> compose(BiConsumer<A, B> f, Supplier<? extends A> gA, Function<? super BB, ? extends B> gB) {
        return f(f).compose(gA, gB);
    }

    static <A, AA, B> Procedure1<AA> compose(BiConsumer<A, B> f, Function<? super AA, ? extends A> gA, Supplier<? extends B> gB) {
        return f(f).compose(gA, gB);
    }

    static <A, B> Procedure0 compose(BiConsumer<A, B> f, Supplier<? extends A> gA, Supplier<? extends B> gB) {
        return f(f).compose(gA, gB);
    }

    static <A, B, BB> Procedure2<A, BB> composeRight(BiConsumer<A, B> f, BiFunction<? super A, ? super BB, ? extends B> g) {
        return f(f).composeRight(g);
    }

    static <A, AA, B> Procedure2<AA, B> composeLeft(BiConsumer<A, B> f, BiFunction<? super AA, ? super B, ? extends A> g) {
        return f(f).composeLeft(g);
    }
}
