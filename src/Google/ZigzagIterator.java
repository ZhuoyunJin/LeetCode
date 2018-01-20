package Google;

import java.util.List;
/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
 */
public class ZigzagIterator {
	List<Integer> v1;
	List<Integer> v2;
	int ptr1=0, ptr2=0;
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		this.v1 = v1;
		this.v2 = v2;
	}

	public int next() {
		if((ptr1==v1.size()) || (ptr1==(ptr2+1) && ptr2 < v2.size())){
			ptr2++;
			return v2.get(ptr2-1);
		}else{
			ptr1++;
			return v1.get(ptr1-1);
		}
	}

	public boolean hasNext() {
		if(v1.size()==0 && v2.size()==0) return false;
		else return !(ptr1>= v1.size() && ptr2 >= v2.size()); 
	}
}

