package br.dev.pedrolamarao.structure;

/**
 * Editable structure.
 *
 * @param <T>  element type
 */
public interface Editable<T>
{
    /**
     * Set value at position.
     *
     * @param position  position
     * @param value     new value
     */
    void set (Iterator<T> position, T value);

    /**
     * Swap the position of two elements.
     *
     * @param x  element
     * @param y  element
     */
    void swap (Iterator<T> x, Iterator<T> y);
}
