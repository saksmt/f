package run.smt.f.definition.function;

import run.smt.f.definition.procedure.Procedure0;
import run.smt.f.definition.procedure.Procedure1;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
@FunctionalInterface
public interface Function0<R> {
    R apply();

    default <RR> Function0<RR> andThen(Function1<R, RR> g) {
        return () -> g.apply(apply());
    }

    default Procedure0 andThen(Procedure1<R> g) {
        return () -> g.apply(apply());
    }

    default Procedure0 suppressReturn() {
        return this::apply;
    }

    default <A> Function1<A, R> expand() {
        return (a) -> apply();
    }
}
