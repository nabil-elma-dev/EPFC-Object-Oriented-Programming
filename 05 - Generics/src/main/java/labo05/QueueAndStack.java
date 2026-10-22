//package main.java.labo05;
//
//
//public class QueueAndStack {
//
//// Les Queue sont FIFO (First In First Out - Premier entré, premier sorti).
//// Comme une file d'attente à une caisse de supermarché.
//
//// Les Stacks sont LIFO (Last In First Out - Dernier entré, premier sorti).
//// Comme les assiettes au sommet d'une pile.
//
//    public static void main(String[] args) {
//        MyQueue<Integer> queue = new MyQueue<>();
//        queue.offer(1);
//        queue.offer(2);
//        queue.offer(3);
//        queue.offer(4);
//        queue.offer(5);
//        while(!queue.isEmpty()) {
//            System.out.print(queue.poll() + " ");    // 1 2 3 4 5
//        }
//        System.out.println("");
//
//        MyStack<Integer> stack = new MyStack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        while(!stack.isEmpty()) {
//            System.out.print(stack.peek() + " ");    // 5 4 3 2 1
//            stack.pop();
//        }
//        System.out.println("");
//    }
//}
