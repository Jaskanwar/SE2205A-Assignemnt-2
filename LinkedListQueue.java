public class LinkedListQueue<E> implements Queue<E>{
  private SinglyLinkedList<E> linkList;
  public LinkedListQueue(){
    linkList = new SinglyLinkedList<E>();
  }
  public int size(){
    return linkList.size(); //returns size of the linked list
  }
  public boolean isEmpty(){
    return linkList.isEmpty();  //Checks if linked list is empty
  }
  public E first(){
    return linkList.first();  //returns the first element of linked list
  }
  public void enqueue(E node){
    linkList.addLast(node); //Adds element to linked list
  }
  public E dequeue(){
    return linkList.removeFirst();  //removes first element from linked list
  }
}
