ArrayList<Integer> arr - take Integer not int
  init: 
  Dont' be confused with 
  String[] ss = {"cat", "dog"}; //cannot do this with ArrayList<String>
  
  arr.size(); compare int[] x; we can do x.length
  arr.get(index); cannot do arr[]; have to do get(index)
  arr.add(object o): add o to the end of the list
  arr.remove(index): remove index object from list. shifts any subsequent elements to the left (subtracts one from their indices).
  arr.remove(object o): remove first occurance of object o from list. Shift left
  arr.add(index, object o): insert o to index i; shift subsequent to right.
  arr.set(index, object o): set index's object to o. ###DO NOT MISTAKE add for set###
  arr.toArray(): return an array of Object[]
  public Iterator<E> iterator()
  
  Iterator for an ArrayList<String>
  Iterator<String> arrIterator = arr.iterator();
		while (arr.hasNext()) {
			System.out.println(arr.next());
		}
  
  Or:
  arr.forEach((temp) -> {
			System.out.println(temp);
	});
  
Queue<Integer> q = new LinkedList<Integer>(); 
  Queue<Intger> q = new LinkedList<Integer>();
  q.offer(Object o) - add to queue
  q.poll() - remove head
  q.size() - size of the queue
  q.peek() - return head of queue
  
Deque<Integer> q = new LinkedList<Integer>(); 
  LinkedList also implement deque
  q.offerFirst(Object o)
  q.offerLast(Object o)
  q.pollFirst() 
  q.pollLast()
  
Stack<Intger> stack = new LinkedList<Integer>();
LinkedList implements stack
q.push(Object o)
q.pop()
q.peek() - return top of stack

HashMap - (k, v)
HashSet - set
TreeMap - ordered k
all do: contains(Object) get(); put()
