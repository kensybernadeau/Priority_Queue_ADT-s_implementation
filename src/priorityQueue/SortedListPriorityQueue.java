package priorityQueue;

import java.util.ArrayList;
import java.util.Comparator;

import priorityQueueInterfaces.Entry;

/**
 * Implementation of a PriorityQueue based in an ArrayList<Entry<K, V>>.
 * @author pedroirivera-vega
 *
 * @param <K>
 * @param <V>
 */
public class SortedListPriorityQueue<K, V> extends AbstractListPriorityQueue<K, V> {
	public SortedListPriorityQueue(Comparator<K> cmp) { 
		super(cmp);
		list= new ArrayList<>();
	}
	
	public SortedListPriorityQueue() { 
		super(); 
		list=new ArrayList<>();
	}
	

	@Override
	public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
	   super.validate(key); 
		Entry<K,V> newest = new PQEntry<K,V>(key, value);
		int curr = 0; 
		
			for(Entry<K,V> en : list)
				if(compare(en, newest) < 0) curr++;
			
		
		list.add(curr, newest); 
		
		return newest; 
	}

	@Override
	protected int minEntryIndex() {
		return 0;
	}

}
