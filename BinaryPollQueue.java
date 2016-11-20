/* Ryan Madden */


/* Implements a FIFO-Priority Queue using two LIFO Stacks.
 * ----offer: add an element to this queue, return true if element is added successfully, return false otherwise
 * ----priorityPoll: removes and returns the element with the highest priority.
 * ----elementPoll:  removes and returns the element at the front of the queue.
 * ----peek: returns the element at the front of the queue.              
 */

import java.util.*;

public class BinaryPollQueue<E extends Comparable<E>> { // Do not change this line
    
    /* Two LIFO Stacks to act as the container of this BinaryPollQueue. DO NOT CHANGE!!! */
    private Stack<E> stk1;    
    private Stack<E> stk2;
	
	//constructor
	public BinaryPollQueue()
	{
		stk1 = new Stack<>();
		stk2 = new Stack<>();
	}
	
	public void offer(E e)
	{
		stk1.push(e);
	}
	
	//BinaryPollQueue peek......not api stack peek, stack peak is done on our stack containers making my queue.....dont confuse them!
	public E peek()
	{
			while(!stk1.empty())
			{
				stk2.push(stk1.pop());
			}
			E e = stk2.peek();
			
			while(!stk2.empty())
			{
				stk1.push(stk2.pop());
			}
			return e;
	}
	public E poll()
	{
			while(!stk1.empty())
			{
				stk2.push(stk1.pop());
			}
			E e = stk2.pop();
			
			while(!stk2.empty())
			{
				stk1.push(stk2.pop());
			}
			return e;
	}
	
	public E priorityPoll()
	{
		E max;
		boolean popped = false;  //this removes double popping of identical objects
		while(!stk1.empty())
			{
				if(stk1.peek().compareTo(max) > 0)
				{
					max = stk1.peek();
				{					
				stk2.push(stk1.pop());
			}
			
			while(!stk2.empty())
			{
				if(stk2.peek().equals(max) && popped == false)
				{
					stk2.pop();
					popped =  true;
				}
				else
					stk1.push(stk2.pop());					
			}
			
	}
	}
	return max;	
	}
    
}


