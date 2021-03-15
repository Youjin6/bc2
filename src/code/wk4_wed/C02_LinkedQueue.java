package code.wk4_wed;

public class C02_LinkedQueue {
    class Node {
        private int value;
        private Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /* 1. 因为他是队列 因此一定会有 front 和 rear 来让你操作这个队列.
     *  2. 为什么没有 size ?
     *  */
    private Node front = null;
    private Node rear = null;



    public boolean empty() {
        return rear == null;
    }

    public void enqueue(int value) {
        if (empty()) {
            rear = new Node(value, null);
            front = rear;
        } else {
            rear.next = new Node(value, null);
            rear = rear.next;
        }
    }

    public int dequeue() {
        if (empty()) {
            throw new EmptyQueueException();
        } else {
            int ans = front.value;
            front = front.next; /* 这里没有一个外部的指向 去指向原来的front了, 就会被垃圾回收期回收,
            因此不用像array一样, 手动清理 把front这个变成null*/
            if (front == null) {
                rear = null;
            }
            return ans;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("front: " + front.value + "; ").append("rear: " + rear.value +
                "\n");

        Node p = front;
        while (p != null) {
            sb.append(p.value + " ");
            p = p.next;
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        C02_LinkedQueue linkedQueue = new C02_LinkedQueue();
        int[] ints = {1,2,3};
        for (int i : ints) {linkedQueue.enqueue(i);

        }
        System.out.println(linkedQueue);

        linkedQueue.dequeue();
        linkedQueue.dequeue();

        System.out.println(linkedQueue);

    }
}
