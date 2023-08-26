package br.dev.pedrolamarao.structure2;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Lines
{
    static <T> long count (UniLineNode<T> first)
    {
        long counter = 0;
        for (var i = first; i != null; i = i.next()) {
            ++counter;
        }
        return counter;
    }

    static <T> long countIf (UniLineNode<T> first, Predicate<T> predicate)
    {
        long counter = 0;
        for (var i = first; i != null; i = i.next()) {
            if (predicate.test(i.value()))
                ++counter;
        }
        return counter;
    }

    static <T> UniLineNode<T> find (UniLineNode<T> first, T value)
    {
        for (var i = first; i != null; i = i.next()) {
            if (Objects.equals(i.value(),value))
                return i;
        }
        return null;
    }

    static <T> UniLineNode<T> findIf (UniLineNode<T> first, Predicate<T> predicate)
    {
        for (var i = first; i != null; i = i.next()) {
            if (predicate.test(i.value()))
                return i;
        }
        return null;
    }

    static <T> void visit (UniLineNode<T> first, Consumer<T> visitor)
    {
        for (var i = first; i != null; i = i.next()) {
            visitor.accept(i.value());
        }
    }
}
