import java.util.Arrays;

class MyCircularDeque {
    int[] dequeue;
    int size;
    int front;
    int back;
    int capacity;

    public MyCircularDeque(int k) {
        dequeue = new int[k];
        size = 0;
        capacity = k;
        Arrays.fill(dequeue, -1);
        front = 0;
        back = 0;
    }
    
    public boolean insertFront(int value) {
        if (!isFull()) {
            front = (front - 1 + capacity) % capacity; // Move front pointer back
            dequeue[front] = value;
            size++;
            return true;
        }
        return false;
    }
    
    public boolean insertLast(int value) {
        if (!isFull()) {
            dequeue[back] = value;
            back = (back + 1) % capacity; // Move back pointer forward
            size++;
            return true;
        }
        return false;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;
        dequeue[front] = -1; // Clear the value
        front = (front + 1) % capacity; // Move front pointer forward
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
        back = (back - 1 + capacity) % capacity; // Move back pointer back
        dequeue[back] = -1; // Clear the value
        size--;
        return true;
    }
    
    public int getFront() {
        return isEmpty() ? -1 : dequeue[front];
    }
    
    public int getRear() {
        return isEmpty() ? -1 : dequeue[(back - 1 + capacity) % capacity]; // Get last valid element
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}
