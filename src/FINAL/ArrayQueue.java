package FINAL;

import code.wk4_wed.C01_ArrayQueue;

/**
   The ArrayQueue class uses an array to implement a queue.
*/

class ArrayQueue
{
    // 用数组来实现的 queue, 前后, size
    private String [ ] q; // Holds queue elements
    private int front;    // Next item to be removed
    private int rear;     // Next slot to fill
    private int size;     // Number of items in queue   
    
    /**
       Constructor.
       @param capacity  The capacity of the queue.
    */
    
    ArrayQueue(int capacity)
    {
        q = new String[capacity];
        front = 0; 
        rear = 0;
        size = 0;
    }
    
    /**
       The capacity method returns the length of 
       the array used to implement the queue.
       @return The capacity of the queue.
    */
    
    public int capacity()
    {
        return q.length;
    }
    
    /**
       The enqueue method adds an element to the queue.
       @param s The element to be added to the queue.
       @exception QueueOverFlowException When there
       is no more room in the queue.
	 */
    
    public void enqueue(String s)
    {
       if (size == q.length)
           throw new QueueOverFlowException();
       else
       {
           // Add to rear
           size ++;
           q[rear] = s;  // 尾进
           rear ++; // 头不动, 尾巴一直增长
           if (rear == q.length) // rear 出界了, rear 回去头了.
               rear = 0;
       }
    }
    
    /**
       The peek method returns the item 
       at the front of the queue.
       @return element at front of queue.
       @exception EmptyQueueException When
       the queue is empty.
    */
    
    public String peek()
    {
        if (empty())
             throw new EmptyQueueException();
        else
             return q[front];
    }
    
    /**
       The dequeue method removes and returns 
       the element at the front of the queue.
       @return The element at the front of the queue.
		 @exception EmptyQueueException When 
		 the queue is empty.
    */
    
    public String dequeue()
    {
        if (empty())
            throw new EmptyQueueException();
        else
        {
            size --;
           // Remove from front
           String value = q[front];
			  
			  // Facilitate garbage collection  
           q[front] = null;     //头部 front 指向 null
			  
           // Update front
           front++; // front 往后挪一个
           if (front == q.length) front = 0; // 当 front 出界了. 就回去 0
			         
           return value;        
        }
    }
    
    /**
       The empty method checks to see if 
       this queue is empty.
       @return true if the queue is empty and 
	false otherwise.
    */
    
    public boolean empty()
    {
        return size == 0;
    }
    
    /**
       The toString method returns a 
       readable representation of the 
       contents of the queue.
       @return  The string representation
       of the contents of the queue.
     */
    
    @Override
    public String toString()
    {
      StringBuilder sBuilder = new StringBuilder();
      sBuilder.append("front = " + front + "; ");
      sBuilder.append("rear = " + rear + "\n");
      for (int k = 0; k < q.length; k++)
      {
          if (q[k] != null)
             sBuilder.append(k + " " + q[k] + " ");
          else 
             sBuilder.append(k + " ?");
          if (k != q.length - 1)
			    sBuilder.append("\n");
      }
      return sBuilder.toString();        
    }
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        queue.enqueue("a");
        queue.enqueue("b");
//        int size = queue.getSize();
        String s;

        queue.enqueue("c");
        System.out.println(queue);

        s = queue.dequeue();
        System.out.println(s);
        System.out.println(queue);
    }

}