package githubdfs;
import java.io.*; 
import java.util.*;
class Graph 
{ 
    private int V;
    boolean check = false;
    private LinkedList<Integer> adj[]; 
    private ArrayList<Integer> output = new ArrayList<Integer>();
    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    }
    void addEdge(int v, int w) 
    { 
        adj[v].add(w); 
    }
    public boolean getcheck(){
        return check;
    }
    public void display(){
        for (int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i) + " ");
        }
    }
    void transverse(int value, int v,boolean visited[]) 
    {
        visited[v] = true;
        if(check == false && v!=0){
            output.add(v);
            if(v == value){
                check = true;
            }
        }
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                transverse(value,n,visited); 
        } 
    } 
    void search(int value) 
    { 
        boolean visited[] = new boolean[V]; 
        for (int i=0; i<V; ++i) 
            if (visited[i] == false) 
                transverse(value,i, visited); 
    } 
} 

public class Githubdfs {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter any number: ");
        int num = input.nextInt();
        Graph g = new Graph(8); 
        g.addEdge(1, 2); 
        g.addEdge(1, 3); 
        g.addEdge(1, 4); 
        g.addEdge(2, 5); 
        g.addEdge(2, 6); 
        g.addEdge(4, 7);
        g.search(num);
        if(g.getcheck() == true){
           System.out.println("The Path is: ");
           g.display();
        }
        else{
            System.out.println("Path not found");
        }
   
    }
    
}
