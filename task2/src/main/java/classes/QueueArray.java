package classes;
import anotation.CallMethod;
public  class QueueArray extends StackArray implements ArrayMethods{
    private int front;
    private int rear;
    private int nElem;

    public QueueArray(int size) {
        super(size);
        maxSize = size;
        front = 0;
        rear = -1;
        nElem = 0;
    }

    @CallMethod
    public int getFront() {
        return array[front];
    }

    public int getRear() {
        return array[rear];
    }

    public boolean isFull() {
        return (nElem == maxSize - 1);
    }

    @Override
    public boolean isEmpty() {
        return (nElem == 0);
    }


    public int getSize() {
        return nElem;
    }

    @Override
    public  void put(int a){
        if (rear == maxSize - 1) {  // циклический перенос
            rear = -1;
        }
        array[++rear] = a;
        nElem++;

    }

    @Override
     public int get() {
        int i = front;
        int temp = array[i]; // получаем первый элемент из очереди
        front++;
        if (front == maxSize) { // циклический перенос
            front = 0;
        }
        nElem--; // уменьшаем количество элементов в очереди
        return temp;
    }

    @Override
    public String toString() {
        return "The last element is " + array[++rear] + "first is " + array[front];
    }


}
