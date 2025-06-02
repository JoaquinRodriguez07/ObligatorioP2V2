/**
 * 
 */
package um.edu.uy.tad.binarytree;

import um.edu.uy.tad.linkedlist.MyList;

public interface MySearchBinaryTree<K extends Comparable<K>, V> {

	void add(K key, V value);

	void remove(K key);

	boolean contains(K key);

	V find(K key);

	MyList<K> inOrder();

	TreeNode<K, V> getRoot();

	MyList<V> inOrderValues();

}
