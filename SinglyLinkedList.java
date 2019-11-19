public class SinglyLinkedList<E>{

  private static class Node<E>{
    private E data;
    private Node<E> next;
    public Node(E e, Node<E> n){
      data = e;
      next = n;
    }
    public E getElement(){
      return data;
    }
    public Node<E> getNext(){
      return next;
    }
    public void setNext(Node<E> n){
      next = n;
    }
  }
  private Node<E> first;
  private Node<E> last;
  private int size;

  public SinglyLinkedList(){
    first = null;
    last = null;
    size = 0;
  }
  
  public int size(){
    return size;
  }
  
  public boolean isEmpty(){
    if(size == 0){  //Checks if its empty
      return true;
    } else{
      return false;
    }
  }
  
  public E first(){
    return first.getElement();
  }
  
  public E last(){
    return last.getElement();
  }
  
  public void addFirst(E element){
    if(isEmpty() == true){
      Node<E> current = new Node<E>(element, first);
      first = current;
      last = current;
      size++;
    }else{
      Node<E> current = new Node<E>(element, first);
      first = current;
      size++;
    }
  }
  
  public void addLast(E element){
    if(isEmpty() == true){
      Node<E> current = new Node<E>(element, null);
      first = current;
      last = current;
      size++;
    }else{
      Node<E> current = new Node<E>(element, null);
      last.setNext(current);
      last = current;
      size++;
    }
  }
  
  public E removeFirst(){
    if(isEmpty() == true){  //if its empty returns nothing
      return null;
    }else{    //Returns linked list with first element removed
      E removeF = first.getElement();
      first = first.getNext();
      size--;
      return removeF;
    }
  }
}