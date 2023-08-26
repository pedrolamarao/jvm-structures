package br.dev.pedrolamarao.structure2;

import java.util.Comparator;

class BiTrees
{
    static <T> BiTreeNode<T> findSorted (BiTreeNode<T> first, T value, Comparator<T> comparator)
    {
        var i = first;
        while (i != null) {
            final int ci = comparator.compare(value,i.value());
            if (ci == 0) break;
            else if (ci < 0) i = i.left();
            else /* ci > 0 */ i = i.right();
        }
        return i;
    }
}
