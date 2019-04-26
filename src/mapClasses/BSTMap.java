package mapClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import treeClasses.LinkedBST;
import interfaces.Entry;
import interfaces.Map;
import positionalStructures.Position;

public class BSTMap<K, V> implements Map<K, V> {
	// the binary search tree supporting this implementation of the map
	private LinkedBST<K, V> tree;   	
	
	/**
	 * Creates an instance of BSTMap. 
	 * @param cmp the comparator of keys that is received and which shall
	 * be used to compare keys of entries. 
	 */
	public BSTMap(Comparator<K> cmp) { 
		tree = new LinkedBST<>(cmp); 
	}
	
	@Override
	/**
	 * the size of the map is the size of the tree. 
	 */
	public int size() {
		return tree.size();
	}

	@Override
	/** 
	 * the map is empty iff the tree is empry
	 */
	public boolean isEmpty() {
		return tree.isEmpty();
	}

	@Override
	/**
	 * Get operation of the map. 
	 */
	public V get(K key) {
		// for for the entry having given key in the tree, if any
		Entry<K, V> result = tree.get(key); 
		
		// if not found, return null
		if (result == null) return null; 
		
		// if found, the value of the element that matches the search.
		return result.getValue();
	}

	@Override
	/**
	 * put of the map...
	 */
	public V put(K key, V value) {
		ModifiableEntry<K, V> result = (ModifiableEntry<K, V>) tree.get(key); 
		if(result!=null) {
			V vtr = result.getValue();
			result.setValue(value);
			return vtr;
		}
		else {
			tree.add(key, value);
			
		}
		return null;
	}

	@Override
	/**
	 * remove of the map
	 */
	public V remove(K key) {
		return tree.isEmpty()? null: tree.remove(key).getValue();    // SUBSTITUE THIS STATEMENT WITH YOUR CODE NEEDED FOR THIS OPERATION
		                 // AS PART OF EXERCISE 1.
	}

	@Override
	public Iterable<K> keySet() {
		ArrayList<K> kList = new ArrayList<>(); 
        
	    for (Position<Entry<K, V>> p : tree.positions())    // positions in inorder for binary tree
	         kList.add(p.getElement().getKey()); 
	        
	    return kList;
	}

	@Override
	public Iterable<V> values() {
		ArrayList<V> vList = new ArrayList<>(); 
        
	    for (Position<Entry<K, V>> p : tree.positions())    // positions in inorder for binary tree
	         vList.add(p.getElement().getValue()); 
	        
	    return vList;
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
	    ArrayList<Entry<K, V>> eList = new ArrayList<>(); 
	        
	    for (Position<Entry<K, V>> p : tree.positions())    // positions in inorder for binary tree
	         eList.add(p.getElement()); 
	        
	    return eList;
	}


	public void displayMAPTree() {   // This operation has been added just for testing
		this.tree.display();
	}
		
}
