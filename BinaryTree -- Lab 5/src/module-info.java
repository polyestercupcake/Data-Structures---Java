module binaryTree {
	requires org.junit.jupiter.api;
	requires junit;
}
/*
Binary Tree (Big-O = log(n))
	13
       /  \
 (< 13)7   (>=13) OR (> 13)

insert: order of log(n); everytime you determine whether your numberToInsert is <, >, =, you cut the tree in half
remove: (Ex. remove the 13: put the number at the top who's side has the least child elements and re-insert the numbers below the new top number)
find: utilize <, >, =
left-most node = smallest number
right-most node = highest number
toString: make it sorted
*/   