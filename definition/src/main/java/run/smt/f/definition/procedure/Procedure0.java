package run.smt.f.definition.procedure;

import run.smt.f.definition.function.Function0;

/**
 * @author Kirill Saksin <kirillsaksin@yandex.ru>
 */
@FunctionalInterface
public interface Procedure0 {
    void apply();

    default <A> Procedure1<A> expand() {
        return (a) -> apply();
    }

    default <R> Function0<R> provideReturn(R value) {
        return () -> {
            apply();
            return value;
        };
    }
}
