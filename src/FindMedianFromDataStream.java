import java.util.*;

public class FindMedianFromDataStream {
	Queue<Integer> smallQueue;
	Queue<Integer> largeQueue;

	public FindMedianFromDataStream() {
		smallQueue = new PriorityQueue<>(Collections.reverseOrder());
		largeQueue = new PriorityQueue<>();
	}

	public void addNum(int num) {
		if(smallQueue.isEmpty() && largeQueue.isEmpty()) {
			smallQueue.offer(num);
		}else if(largeQueue.isEmpty()){
			smallQueue.offer(num);
			largeQueue.offer(smallQueue.poll());
		}else {
			//int midSmall = smallQueue.peek();
			int midLarge = largeQueue.peek();
			if(num<= midLarge) smallQueue.offer(num);
			else if(num>= midLarge) largeQueue.offer(num);
			if(smallQueue.size()-largeQueue.size() > 1) {
				largeQueue.offer(smallQueue.poll());
			}else if(largeQueue.size()-smallQueue.size()>1) {
				smallQueue.offer(largeQueue.poll());
			}
			
		}

	}

	public double findMedian() {
		if(smallQueue.size()>largeQueue.size())
			return smallQueue.peek();
		else if(smallQueue.size()<largeQueue.size())
			return largeQueue.peek();
		else{
			return (smallQueue.peek() + largeQueue.peek())/2.0;
		}
	}
	public static void main(String[] args) {
		FindMedianFromDataStream obj = new FindMedianFromDataStream();
		obj.addNum(1);obj.addNum(8);
		obj.addNum(2);obj.addNum(5);obj.addNum(3);obj.addNum(4);
		double mid = obj.findMedian();
		System.out.println(mid);
	}

}
