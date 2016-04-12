package run.smt.f.functional;

import run.smt.f.definition.function.Function0;
import run.smt.f.definition.function.Function1;
import run.smt.f.definition.function.Function2;
import run.smt.f.definition.procedure.Procedure0;
import run.smt.f.definition.procedure.Procedure1;
import run.smt.f.definition.procedure.Procedure2;

/**
 * Contains all possible combinations for functional composition
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
public interface Composition {
    static <A, R> Function0<R> compose(Function1<A, R> f, Function0<A> g) {
        return f.compose(g);
    }

    static <A, AA, R> Function1<AA, R> compose(Function1<A, R> f, Function1<AA, A> g) {
        return f.compose(g);
    }

    static <A, AA, B, R> Function2<AA, B, R> compose(Function1<A, R> f, Function2<AA, B, A> g) {
        return f.compose(g);
    }


    static <A, AA, B, R> Function2<AA, B, R> composeLeft(Function2<A, B, R> f, Function2<AA, B, A> g) {
        return f.composeLeft(g);
    }

    static <A, B, BB, R> Function2<A, BB, R> composeRight(Function2<A, B, R> f, Function2<A, BB, B> g) {
        return f.composeRight(g);
    }

    static <A, AA, B, BB, R> Function2<AA, BB, R> compose(Function2<A, B, R> f, Function1<AA, A> gA, Function1<BB, B> gB) {
        return f.compose(gA, gB);
    }

    static <A, AA, B, R> Function1<AA, R> compose(Function2<A, B, R> f, Function1<AA, A> gA, Function0<B> gB) {
        return f.compose(gA, gB);
    }

    static <A, B, BB, R> Function1<BB, R> compose(Function2<A, B, R> f, Function0<A> gA, Function1<BB, B> gB) {
        return f.compose(gA, gB);
    }

    static <A, B, R> Function0<R> compose(Function2<A, B, R> f, Function0<A> gA, Function0<B> gB) {
        return f.compose(gA, gB);
    }


    static <A> Procedure0 compose(Procedure1<A> f, Function0<A> g) {
        return f.compose(g);
    }

    static <A, AA> Procedure1<AA> compose(Procedure1<A> f, Function1<AA, A> g) {
        return f.compose(g);
    }

    static <A, AA, B> Procedure2<AA, B> compose(Procedure1<A> f, Function2<AA, B, A> g) {
        return f.compose(g);
    }


    static <A, AA, B, BB> Procedure2<AA, BB> compose(Procedure2<A, B> f, Function1<AA, A> gA, Function1<BB, B> gB) {
        return f.compose(gA, gB);
    }

    static <A, B, BB> Procedure1<BB> compose(Procedure2<A, B> f, Function0<A> gA, Function1<BB, B> gB) {
        return f.compose(gA, gB);
    }

    static <A, AA, B> Procedure1<AA> compose(Procedure2<A, B> f, Function1<AA, A> gA, Function0<B> gB) {
        return f.compose(gA, gB);
    }

    static <A, B> Procedure0 compose(Procedure2<A, B> f, Function0<A> gA, Function0<B> gB) {
        return f.compose(gA, gB);
    }

    static <A, B, BB> Procedure2<A, BB> composeRight(Procedure2<A, B> f, Function2<A, BB, B> g) {
        return f.composeRight(g);
    }

    static <A, AA, B> Procedure2<AA, B> composeLeft(Procedure2<A, B> f, Function2<AA, B, A> g) {
        return f.composeLeft(g);
    }
}
