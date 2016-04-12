package run.smt.f.functional.signaturemanip;

import run.smt.f.definition.function.Function0;
import run.smt.f.definition.function.Function1;
import run.smt.f.definition.function.Function2;
import run.smt.f.definition.procedure.Procedure0;
import run.smt.f.definition.procedure.Procedure1;
import run.smt.f.definition.procedure.Procedure2;

/**
 * Contains methods for binding and expanding functions
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public interface ArgumentManipulation {
    static <A, R> Function0<R> bind(Function1<A, R> f, A arg) {
        return f.bind(arg);
    }

    static <A, B, R> Function0<R> bind(Function2<A, B, R> f, A a, B b) {
        return f.bind(a, b);
    }

    static <A, B, R> Function1<B, R> bind(Function2<A, B, R> f, A arg) {
        return f.bind(arg);
    }

    static <A, B, R> Function1<A, R> bindLast(Function2<A, B, R> f, B arg) {
        return f.bindLast(arg);
    }


    static <A> Procedure0 bind(Procedure1<A> f, A arg) {
        return f.bind(arg);
    }

    static <A, B> Procedure0 bind(Procedure2<A, B> f, A a, B b) {
        return f.bind(a, b);
    }

    static <A, B> Procedure1<B> bind(Procedure2<A, B> f, A arg) {
        return f.bind(arg);
    }

    static <A, B> Procedure1<A> bindLast(Procedure2<A, B> f, B arg) {
        return f.bindLast(arg);
    }


    static <A, R> Function1<A, R> expand(Function0<R> f) {
        return f.expand();
    }

    static <A, B, R> Function2<A, B, R> expand(Function1<A, R> f) {
        return f.expand();
    }


    static <A> Procedure1<A> expand(Procedure0 f) {
        return f.expand();
    }

    static <A, B> Procedure2<A, B> expand(Procedure1<A> f) {
        return f.expand();
    }


    static <A, B> Procedure2<B, A> flip(Procedure2<A, B> f) {
        return f.flip();
    }

    static <A, B, R> Function2<B, A, R> flip(Function2<A, B, R> f) {
        return f.flip();
    }
}
