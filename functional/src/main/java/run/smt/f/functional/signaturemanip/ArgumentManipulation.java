package run.smt.f.functional.signaturemanip;

import run.smt.f.definition.function.Function0;
import run.smt.f.definition.function.Function1;
import run.smt.f.definition.function.Function2;
import run.smt.f.definition.procedure.Procedure0;
import run.smt.f.definition.procedure.Procedure1;
import run.smt.f.definition.procedure.Procedure2;

import java.util.function.*;

import static run.smt.f.functional.Cast.f;

/**
 * Contains methods for binding and expanding functions
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public interface ArgumentManipulation {
    static <A, R> Function0<R> bind(Function<A, R> f, A arg) {
        return f(f).bind(arg);
    }

    static <A, B, R> Function0<R> bind(BiFunction<A, B, R> f, A a, B b) {
        return f(f).bind(a, b);
    }

    static <A, B, R> Function1<B, R> bind(BiFunction<A, B, R> f, A arg) {
        return f(f).bind(arg);
    }

    static <A, B, R> Function1<A, R> bindLast(BiFunction<A, B, R> f, B arg) {
        return f(f).bindLast(arg);
    }


    static <A> Procedure0 bind(Consumer<A> f, A arg) {
        return f(f).bind(arg);
    }

    static <A, B> Procedure0 bind(BiConsumer<A, B> f, A a, B b) {
        return f(f).bind(a, b);
    }

    static <A, B> Procedure1<B> bind(BiConsumer<A, B> f, A arg) {
        return f(f).bind(arg);
    }

    static <A, B> Procedure1<A> bindLast(BiConsumer<A, B> f, B arg) {
        return f(f).bindLast(arg);
    }


    static <A, R> Function1<A, R> expand(Supplier<R> f) {
        return f(f).expand();
    }

    static <A, B, R> Function2<A, B, R> expand(Function<A, R> f) {
        return f(f).expand();
    }


    static <A> Procedure1<A> expand(Runnable f) {
        return f(f).expand();
    }

    static <A, B> Procedure2<A, B> expand(Consumer<A> f) {
        return f(f).expand();
    }


    static <A, B> Procedure2<B, A> flip(BiConsumer<A, B> f) {
        return f(f).flip();
    }

    static <A, B, R> Function2<B, A, R> flip(BiFunction<A, B, R> f) {
        return f(f).flip();
    }
}
