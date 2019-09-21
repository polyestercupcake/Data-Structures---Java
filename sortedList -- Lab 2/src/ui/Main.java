package ui;
 
import java.util.Arrays;
 
import model.MoreListable;
import model.SortedList;
 
public class Main {
 
public static void main(String[] args) {
MoreListable sl = new SortedList();
 
//Should have five random elements with dups potentially
sl.setDuplicatesAllowed(true);
sl.initializeWithRandomData(5);
System.out.println("1: Should have five random elements with dups potentially");
System.out.println(sl);
 
//Should have removed the first '5'
sl.clear();
sl.setDuplicatesAllowed(true);
sl.insert(5);
sl.insert(6);
sl.insert(6);
sl.insert(7);
sl.insert(7);
sl.delete(5);
System.out.println("2: Should have removed the first '5'");
System.out.println(sl);
 
//Should insert two 10s
sl.insert(10);
sl.insert(10);
System.out.println("3: Should insert two 10s");
System.out.println(sl);
 
//Should delete all 10s
sl.deleteAll(10);
System.out.println("4: Should delete all 10s");
System.out.println(sl);
 
//Should have 5 random elements without dups
sl.clear();
sl.setDuplicatesAllowed(false);
sl.initializeWithRandomData(5);
System.out.println("I will probably have to change your random value to be slightly larger than the size.");
System.out.println("5: Should have 5 random elements without dups");
System.out.println(sl);
 
//Should insert a five if possible
sl.insert(5);
System.out.println("6: Should insert a five if possible");
System.out.println(sl);
 
//Should find all fives
System.out.println("7: Should find all fives");
System.out.println(Arrays.toString(sl.findAll(5)));
 
//Should remove all fives
sl.deleteAll(5);
System.out.println("8: Should remove all fives");
System.out.println(sl);
 
//Should be empty
sl.clear();
System.out.println("9: Should be empty");
System.out.println(sl);
 
//Should still be empty -- tried to delete from an empty list
sl.insert(1);
sl.clear();
sl.delete(1);
System.out.println("10: Should still be empty -- tried to delete from an empty list");
System.out.println(sl);
}
}