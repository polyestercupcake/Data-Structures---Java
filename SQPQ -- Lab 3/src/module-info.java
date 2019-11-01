module sqpq {
	requires org.junit.jupiter.api;
	requires junit;
}
/*
stack
LIFO = last in, first out
adding to stack = just put it at pointer(0) and increment pointer -- bigO = O(1)
push and pop
push removes the most recent value and pop pulles the pushed value (you don't get to choose the pop)
Peek() = what would be pop if I were to pop? can choose to pop or not to pop

Peek:
Parameters: The method does not take any parameters.
Return Value: The method returns the element at the top of the Stack else returns NULL if the Stack is empty.
Exception: The method throws EmptyStackException if the stack is empty.
https://www.geeksforgeeks.org/stack-peek-method-in-java/

Push:
Parameters: The method accepts one parameter element of type Stack and refers to the element to be pushed into the stack.
Return Value: The method returns the argument passed.
https://www.geeksforgeeks.org/stack-push-method-in-java/

Pop:
Parameters: The method does not take any parameters.
Return Value: This method returns the element present at the top of the stack and then removes it.
Exceptions: The method throws EmptyStackException is thrown if the stack is empty.
https://www.geeksforgeeks.org/stack-pop-method-in-java/

queue
FIFO = first in, first out
enqueue (insert) : smart one
dequeue (remove) : dumb one
____(Rear) ___ ___ ___ ___ ___(Front)
https://www.geeksforgeeks.org/array-implementation-of-queue-simple/

Enqueuing:

add(e): throws exception if it fails to insert the object
offer(e): returns false if it fails to insert the object

Dequeuing:

remove(): throws exception if the queue is empty
poll(): returns null if the queue is empty

Take a look to the first object in the queue:

element(): throws exception if the queue is empty
peek(): returns null if the queue is empty

priority queue
FIFO, but accepts priority
highest priority = 1
lowest priority = 10
multiple values can have the same priority
Once one comes in on the end with a higher priority, shift all values to the right and put priority value first
Don't have to deal with any values of the same priority
sort by priority, don't have to sort by numerical value
https://www.geeksforgeeks.org/priority-queue-class-in-java-2/
 */