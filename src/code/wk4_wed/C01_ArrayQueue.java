package code.wk4_wed;

/*
 * 技能点:
 *  1. rear 和 front 的初始化: 0
 *  2. 在enqueue和dequeue的 front++ 和 rear++ 之后判断
 *           if (front == q.length) front = 0;
 *           if (rear == q.length) rear = 0;
 *  3. 注意: 当append进去数据了之后, 这个数组就写好了, dequeue不会remove掉数组里的数据只是
 *  把front 和rear的指向变了, 因此打印这个queue(数组)的时候， 还是会把他们全部打印出来，
 *
 *
 * bug:
 * 在dequeue, 出去一个front 就要释放一个地址,
 * 1. /* 这一步漏掉了， 要把当前 q[front] 上的 地址释放掉.
 * */

public class C01_ArrayQueue {
    private int front;
    private int rear;
    private int size;
    private String[] q;

    C01_ArrayQueue(int capacity) {
        q = new String[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean empty() {
        return size == 0;
    }

    public void enqueue(String s) {
        if (size == q.length) {
            throw new QueueOverFlowException();
        } else {
            size++;
            q[rear++] = s;
            if (rear == q.length) {
                rear = 0;
            }
        }
    }

    public String dequeue() {
        if (empty()) {
            throw new EmptyQueueException();
        } else {
            size--;
            String value = q[front];
            q[front] = null;  /* 这一步漏掉了， 要把当前 q[front] 上的 地址释放掉 */
            front++;
            if (front == q.length) {
                front = 0;

            }
            return value;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("front: " + front + "; ");
        stringBuilder.append("rear: " + rear + "\n");

        for (int i = 0; i < q.length; i++) {
            if (q[i] != null) {
                stringBuilder.append(i + " " + q[i]).append("\n");
            } else {
                stringBuilder.append(i + " ?").append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public int getSize() {
        return size;
    }
    public int capacity(){
        return q.length;
    }


    public static void main(String [] args)
    {
        C01_ArrayQueue queue = new C01_ArrayQueue(3);
        queue.enqueue("h");
        queue.enqueue("f");
        queue.enqueue("q");
        System.out.println(queue);
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
    }
}
