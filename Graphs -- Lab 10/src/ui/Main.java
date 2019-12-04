package ui;

import model.Edge;
import model.Graph;
import model.IVertex;
import model.Vertex;

public class Main {
    public static void main(String[] args) {
        // instantiate a graph
    	Graph megaGraph = new Graph();
    	IVertex a = new Vertex('A');
    	IVertex b = new Vertex('B');
    	IVertex c = new Vertex('C');
//    	IVertex d = new Vertex('D');
//    	IVertex e = new Vertex('E');
//    	IVertex f = new Vertex('F');
//    	IVertex g = new Vertex('G');
//    	IVertex h = new Vertex('H');
//    	IVertex i = new Vertex('I');
//    	IVertex j = new Vertex('J');
//    	IVertex k = new Vertex('K');
//    	IVertex l = new Vertex('L');
//    	IVertex m = new Vertex('M');
//    	IVertex n = new Vertex('N');
//    	IVertex o = new Vertex('O');
//    	IVertex p = new Vertex('P');
//    	IVertex q = new Vertex('Q');
//    	IVertex r = new Vertex('R');
//    	IVertex s = new Vertex('S');
//    	IVertex t = new Vertex('T');
//    	IVertex u = new Vertex('U');
//    	IVertex v = new Vertex('V');
//    	IVertex w = new Vertex('W');
//    	IVertex x = new Vertex('X');
//    	IVertex y = new Vertex('Y');
//    	IVertex z = new Vertex('Z');
    	megaGraph.addVertex(a);
    	megaGraph.addVertex(b);
    	megaGraph.addVertex(c);
//    	megaGraph.addVertex(d);
//    	megaGraph.addVertex(e);
//    	megaGraph.addVertex(f);
//    	megaGraph.addVertex(g);
//    	megaGraph.addVertex(h);
//    	megaGraph.addVertex(i);
//    	megaGraph.addVertex(j);
//    	megaGraph.addVertex(k);
//    	megaGraph.addVertex(l);
//    	megaGraph.addVertex(m);
//    	megaGraph.addVertex(n);
//    	megaGraph.addVertex(o);
//    	megaGraph.addVertex(p);
//    	megaGraph.addVertex(q);
//    	megaGraph.addVertex(r);
//    	megaGraph.addVertex(s);
//    	megaGraph.addVertex(t);
//    	megaGraph.addVertex(u);
//    	megaGraph.addVertex(v);
//    	megaGraph.addVertex(w);
//    	megaGraph.addVertex(x);
//    	megaGraph.addVertex(y);
//    	megaGraph.addVertex(z);

    	megaGraph.addEdge(new Edge(a, b, 1));
    	megaGraph.addEdge(new Edge(a, c, 5));
    	megaGraph.addEdge(new Edge(b, c, 1));
//    	megaGraph.addEdge(new Edge(c, d, 1));
//    	megaGraph.addEdge(new Edge(d, e, 1));
//    	megaGraph.addEdge(new Edge(a, e, 5));
//    	megaGraph.addEdge(new Edge(a, c, 1));
//    	megaGraph.addEdge(new Edge(a, d, 6));
//    	megaGraph.addEdge(new Edge(a, e, 9));
//    	megaGraph.addEdge(new Edge(a, m, 4));
//    	megaGraph.addEdge(new Edge(a, p, 3));
//    	megaGraph.addEdge(new Edge(a, k, 5));
//    	megaGraph.addEdge(new Edge(b, g, 4));
//    	megaGraph.addEdge(new Edge(b, f, 2));
//    	megaGraph.addEdge(new Edge(c, i, 1));
//    	megaGraph.addEdge(new Edge(c, d, 1));
//    	megaGraph.addEdge(new Edge(c, j, 3));
//    	megaGraph.addEdge(new Edge(c, k, 6));
//    	megaGraph.addEdge(new Edge(d, l, 7));
//    	megaGraph.addEdge(new Edge(d, t, 3));
//    	megaGraph.addEdge(new Edge(e, m, 8));
//    	megaGraph.addEdge(new Edge(e, n, 3));
//    	megaGraph.addEdge(new Edge(e, o, 1));
//    	megaGraph.addEdge(new Edge(p, s, 9));
//    	megaGraph.addEdge(new Edge(g, f, 5));
//    	megaGraph.addEdge(new Edge(f, x, 9));
//    	megaGraph.addEdge(new Edge(f, r, 5));
//    	megaGraph.addEdge(new Edge(r, u, 2));
//    	megaGraph.addEdge(new Edge(n, o, 1));
//    	megaGraph.addEdge(new Edge(l, k, 7));
//    	megaGraph.addEdge(new Edge(l, q, 2));
//    	megaGraph.addEdge(new Edge(l, y, 1));
//    	megaGraph.addEdge(new Edge(q, v, 6));
    	
        // REQUIRED METHODS
      System.out.println("Complete: " + megaGraph.isComplete()); // works
      System.out.println("Shortest Path: " + megaGraph.getShortestPath(a, c)); // works
      System.out.println("Strongly: " + megaGraph.isStronglyConnected()); // works
      System.out.println("Weakly: " + megaGraph.isWeaklyConnected()); // works
      // BOUNS METHODS
      System.out.println("Has Euler: " + megaGraph.hasStrongEulerCycle()); // works
//      System.out.println(megaGraph.getStrongEulerCycle(a));
      // Hamiltonian is very similar to getShortestPath...end where I start
    }
}