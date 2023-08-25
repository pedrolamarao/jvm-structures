package br.dev.pedrolamarao.structure.editable;

import br.dev.pedrolamarao.structure.traversable.BiLinearTraversable;

/**
 * Editable bidirectional structure.
 *
 * @param <T>  element type
 */
public interface BiLinearEditable<T> extends BiLinearTraversable<T>, UniLinearEditable<T>
{
}
