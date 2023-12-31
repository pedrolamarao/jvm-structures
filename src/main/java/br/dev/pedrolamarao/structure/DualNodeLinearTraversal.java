// Copyright (C) 2023 Pedro Lamarão <pedro.lamarao@gmail.com>
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <http://www.gnu.org/licenses/>.

package br.dev.pedrolamarao.structure;

record DualNodeLinearTraversal<T>(DualNode<T> node) implements BiTraversal<T>
{
    @Override
    public BiTraversal<T> next ()
    {
        return node.first() == null ? null : new DualNodeLinearTraversal<>(node.first());
    }

    @Override
    public BiTraversal<T> previous ()
    {
        return node.second() == null ? null : new DualNodeLinearTraversal<>(node.second());
    }

    @Override
    public T value ()
    {
        return node.value();
    }
}
