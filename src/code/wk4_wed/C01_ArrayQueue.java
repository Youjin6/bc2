package code.wk4_wed;

public class C01_ArrayQueue {

    private int size;
    private int front;
    private int rear;
    private String[] queue; /* 定义了一个 queue 的数组, heap 还没开辟空间 */

    public C01_ArrayQueue(int capacity) {
        /* 构造器里新建了一个数组 */
        queue = new String[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public int capacity() {
        return queue.length;
    }

    public void enqueue(String s) {
        if (size == queue.length) {
            throw new QueueOverFlowException();
        } else {
            // Add to rear
            size++; // 先增加 size
            queue[rear] = s; // 赋值
            rear++; // rear 一直是下一次要放数字的地方. rear++
            if (rear == queue.length)  /* 这里注意, 可以在这里来一次判断, 如果rear 到头了,
            就返回他的初始值*/
                rear = 0;
        }
    }


    public boolean empty() {
        return size == 0;
    }

    public String dequeue() {
        if (empty()) {
            throw new EmptyQueueException();
        }
        size--;
        String value = queue[front];
        queue[front] = null; // front指向空是必要的么?
        front++;
        if (front == queue.length) front = 0;
        return value;

    }

}
