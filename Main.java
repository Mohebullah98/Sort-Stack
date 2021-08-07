import java.util.*;
class Main {
  public static void sort (Stack<Integer> s){
    Stack<Integer> s2 = new Stack<Integer>();
    while(!s.isEmpty()){
      if(s2.isEmpty()) s2.push(s.pop());
      if(s.peek()>s2.peek()){
        s2.push(s.pop());//s2 will keep biggest numbers at top
      }
      else{//if the number is smaller than s2's top. push s2's items back into s until the number is > than s2's top.
        int top = s.pop();
        while(s2.size()>0 && s2.peek()>top){
          s.push(s2.pop());
        }
        s2.push(top); //then push the number into s2
      }
    }
    while(!s2.isEmpty()){
      s.push(s2.pop());// pushing elemnts from s2 to s1 will store smallest items on top
    }
  }
  public static void main(String[] args) {
    Stack<Integer> s = new Stack<Integer>();
    s.push(5);
    s.push(1);
    s.push(6);
    s.push(11);
    s.push(3);
    s.push(4);
    System.out.println("Unsorted Stack: "+ s.toString());
    sort(s);
    System.out.println("Sorted Stack: "+ s.toString());
    /*Smallest items will be on top of sorted stack*/
  }
}