package classes;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import java.util.Arrays;

public class StackArray implements ArrayMethods {
   int maxSize;
   int [] array;
   private int top;

   Logger logger = Logger.getLogger(StackArray.class.getName());

   public StackArray(int size){
       maxSize = size;
       array = new int[size];
       top = -1;
   }

   public boolean isEmpty(){
       return (top == -1);
   }

   public  void put(int a){
       int i = ++top;
       array[i] = a;
   }

   public int pop(){
       if (isEmpty()){
           BasicConfigurator.configure();
           logger.info("Stack is empty");
            return 0;
       }
       else return array[top--];//потом буде перезапис не потрібно видаляти
   }

   public int get(){
       if (isEmpty()){
           BasicConfigurator.configure();
           logger.info("Stack is empty");
           return 0;
       }
       else return array[top];
   }
    @Override
    public  String toString(){
        return maxSize +" "+ Arrays.toString(array) +" "+top;
    }

    public static void main(String[] args) {
        StackArray s = new StackArray(4);
        s.put(1);
        s.put(3);
        BasicConfigurator.configure();
        Logger logger = Logger.getLogger(StackArray.class.getName());
        logger.info(s.toString());
    }
}
