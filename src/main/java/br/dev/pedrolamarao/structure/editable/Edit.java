package br.dev.pedrolamarao.structure.editable;

import br.dev.pedrolamarao.structure.iterator.UniIterator;

import java.util.Comparator;

/**
 * Structure editing.
 */
public class Edit
{
    /**
     * Bubble-sort the structure.
     *
     * @param editable  editable structure
     * @param order     sort ordering
     * @param <T>       element type
     */
    public static <T> void bubbleSort (UniEditable<T> editable, Comparator<T> order)
    {
        boolean sorted;
        do {
            sorted = true;
            for (UniIterator<T> i = editable.forward(), j = i.next(); i != null && j != null; i = i.next(), j = j.next()) {
                if (order.compare(i.value(), j.value()) >= 0) {
                    editable.swap(i, j);
                    sorted = false;
                }
            }
        }
        while (! sorted);
    }

    /**
     * Select-sort the structure.
     *
     * @param editable  editable structure
     * @param order     sort ordering
     * @param <T>       element type
     */
    public static <T> void selectSort (UniEditable<T> editable, Comparator<T> order)
    {
        for (var i = editable.forward(); i != null; i = i.next()) {
            for (var j = i.next(); j != null; j = j.next()) {
                if (order.compare(i.value(),j.value()) >= 0)
                    editable.swap(i,j);
            }
        }
    }
}
