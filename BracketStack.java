

import java.util.*;
class Main{
  static Scanner kbd = new Scanner(System.in);
  static int top = -1,n = 20;
  static char st[] = new char[n];

  public static boolean isFull() {
    return (top==n-1) ? true : false;
  }

  public static boolean isEmpty() {
    return (top==-1) ? true : false;
  }
  
  public static char peek() {
    return st[top];
  }

  public static void push(char val) {
   if(isFull())
      System.out.println("Stack overFlow!");
   else {
      top++;
      st[top] = val;
   }
  }
  public static void pop(){
    if(isEmpty())
      System.out.println("Stack underflow!");
    else{
      int v = st[top];
      top--;
    }
  }
  public static void Show(){
    for(int i= top;i >= 0;i--){
      System.out.println(st[i]);
    }
  }
  public static void main(String[] args){
  try{
     ArrayList<Character> arr_l = new ArrayList<Character>();
     ArrayList<Character> arr_r = new ArrayList<Character>();                        
     arr_l.add('['); arr_l.add('{');
     arr_l.add('<'); arr_l.add('(');
     arr_r.add(']'); arr_r.add('}');
     arr_r.add('>'); arr_r.add(')');

     System.out.println("Enter the String?");
     String input = kbd.nextLine();
     char[] ch = new char[input.length()];
     for(int i = 0;i < input.length();i++)
       ch[i]=input.charAt(i);
     for(int i = 0;i < input.length();i++){
       int index;
       char element;
       char v;
       if(arr_l.contains(ch[i])){
         push(ch[i]);
       }
       else {
         if(!isEmpty()){
           v = peek();
          index = arr_r.indexOf(ch[i]);
          element = arr_l.get(index);
          if(element == v)
            pop();
          else
            break;
         }
         else 
            System.out.println("Stack is empty! No Value to Peek!");
       }
     }
     if(isEmpty())
       System.out.println("Matched!");
     else 
       System.out.println("Mismatched!");
  }catch(Exception e){
     System.out.println("Oops,Something went wrong!");
     e.printStackTrace();
  }
 }
}

