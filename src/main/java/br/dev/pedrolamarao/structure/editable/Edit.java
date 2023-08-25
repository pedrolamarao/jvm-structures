package br.dev.pedrolamarao.structure.editable;

import br.dev.pedrolamarao.structure.iterator.UniIterator;

import java.util.Comparator;
import java.util.function.Function;

/**
 * Structure editing.
 */
public class Edit
{
    /**
     * Bubble-sort the structure.
     *
     * @param structure  editable structure
     * @param order      sort ordering
     * @param <T>        structure element type
     */
    public static <T> void bubbleSort (UniLinearEditable<T> structure, Comparator<T> order)
    {
        boolean sorted;
        do {
            sorted = true;
            for (UniIterator<T> i = structure.forward(), j = i.next(); i != null && j != null; i = i.next(), j = j.next()) {
                if (order.compare(i.value(), j.value()) >= 0) {
                    structure.swap(i, j);
                    sorted = false;
                }
            }
        }
        while (! sorted);
    }

    /**
     * Fill structure with a value.
     *
     * @param structure  editable structure
     * @param value      value
     * @param <T>        structure element type
     */
    public static <T> void fill (UniLinearEditable<T> structure, T value)
    {
        for (var i = structure.forward(); i != null; i = i.next()) {
            structure.set(i,value);
        }
    }

    /**
     * Select-sort the structure.
     *
     * @param structure  editable structure
     * @param order      sort ordering
     * @param <T>        structure element type
     */
    public static <T> void selectSort (UniLinearEditable<T> structure, Comparator<T> order)
    {
        for (var i = structure.forward(); i != null; i = i.next()) {
            for (var j = i.next(); j != null; j = j.next()) {
                if (order.compare(i.value(),j.value()) >= 0)
                    structure.swap(i,j);
            }
        }
    }

    /**
     * Transform structure elements.
     *
     * @param structure  editable structure
     * @param operator   transformation
     * @param <T>        structure element type
     */
    public static <T> void transform (UniLinearEditable<T> structure, Function<T,T> operator)
    {
        for (var i = structure.forward(); i != null; i = i.next()) {
            structure.set(i,operator.apply(i.value()));
        }
    }
}
