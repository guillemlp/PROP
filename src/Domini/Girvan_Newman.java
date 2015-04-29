package Domini;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by falc on 2/04/15.
 */
public class Girvan_Newman extends Algoritmo{


    //protected Entrada in
    //protected Salida out
    private Grafo data_graph;
    private Grafo alg_graph;
    private int alg_cc;

    private class Node {
        boolean visited;
        int component;
        boolean leaf;
        ArrayList<Integer> parent;
        double weight;
        double distance;
        double down_total;

        Node() {
            visited = false;
            component = -1;
            leaf = false;
            parent = new ArrayList<Integer>(1);
            distance = Double.POSITIVE_INFINITY;
            weight = 0;
            down_total = 0;
        }
    }

    class Eix {
        int orig;
        double weight;
        int dest;
    }

    class AristaComparator implements Comparator<Arista> {
        @Override
        public int compare(Arista o1, Arista o2) {

            return (int) (o1.peso()-o2.peso());
        }
    }

    ArrayList<Node> node;

    public Girvan_Newman(Entrada i, Salida o)
    {
        super(i, o);
        data_graph = in.obtGrafo();
        alg_graph = data_graph;
    }

    @Override
    public Grafo ejecutar_algoritmo() {

        int limit = (int) in.obtParam1();
        while(alg_cc < limit) alg_graph = ejecutar_iteración(alg_graph);
        return alg_graph;
    }

    public void ejecutar_iteración()
    {
        alg_graph = ejecutar_iteración(alg_graph);
    }

    @Override
    public Grafo ejecutar_iteración(Grafo g) {
        int N = g.V(); //Número de vértices del grafo
        int cc = 0; //Número componentes conexos
        int cc2 = 0;
        node = new ArrayList<Node> (N);

        Eix victim = new Eix(); // La arista que se irá
        victim.weight = -1;
        //Comparador para aristas
        AristaComparator comp = new AristaComparator();

        //Dijkstra por cada nodo del grafo
        for (int i = 0; i < N; ++i)
        {
            //Lista para mantener guardada la ruta realizada durante Dijkstra
            LinkedList<Integer> route = new LinkedList<Integer>();
            //Cola de prioridades para aristas
            PriorityQueue<Arista<Integer>> Q = new PriorityQueue<Arista<Integer>>(N, comp);

            //Inicializar los nodos
            node.clear();
            for (int ii = 0; ii < N; ++ii) {
                Node n = new Node();
                n.visited = false;
                n.component = -1;
                n.leaf = false;
                n.distance = Double.POSITIVE_INFINITY;
                n.parent.clear();
                n.weight = 0;
                n.down_total = 0;
                node.add(n);
            }

            Q.add(new Arista<Integer>(i, 0));

            System.out.println("node source: " + data_graph.consultarVertice(i));
            Node uno = node.get(i);
            uno.distance = 0;
            uno.weight = 1;
            //Si no pertanece el nodo a un componente conexo, sumamos 1 a cc y le asignamos un componente al nodo
            if (uno.component == -1)
            {
                ++cc;
                uno.component = cc;
            }

            //Mientras la cola no esté vacía
            while(!Q.isEmpty())
            {
                Arista<Integer> a = Q.poll();
                int v = a.fin();
                System.out.println("    node: " + data_graph.consultarVertice(v));

                Node ref_v = node.get(v);
                if (!ref_v.visited) {
                    ref_v.visited = true;
                    ref_v.component = cc;
                    route.add(v);
                    int leaf_index = 0;
                    ArrayList<Integer> al = g.nodosSucesores(v);
                    System.out.print("      adj:");
                    for (int aux : al) { //Para todos los nodos adyacentes a v
                        Node ref_aux = node.get(aux);
                        double dist = data_graph.pesoAristaVertices(v, aux); //dist es el peso de v -> aux
                        if (!ref_aux.visited) {
                            System.out.print(" "+data_graph.consultarVertice(aux));
                            if (ref_aux.distance == 0) {
                                ref_aux.distance = ref_v.distance + dist;
                                ref_aux.weight = ref_v.weight;
                            } else if (ref_aux.distance > ref_aux.distance + dist){
                                ref_aux.distance = ref_v.distance + dist;
                            } else if (ref_aux.distance == ref_v.distance + dist) {
                                ref_aux.weight += ref_v.weight;
                            }

                            leaf_index += 1;
                            ref_aux.parent.add(v);


                            Q.add(new Arista<Integer>(aux, dist));

                        }

                    }

                    System.out.print("\n");

                    if (leaf_index == 0) {
                        ref_v.leaf = true;
                        ref_v.down_total = 0;
                    }
                }

            }

            //Pesos en grafo
            for (int p : route)
            {
                Node golf = node.get(p);
                if (golf.parent.size() > 0) {
                    System.out.println(data_graph.consultarVertice(p) + ": " + golf.parent);
                    for (int inode : golf.parent) {

                        Node up = node.get(inode);
                        double multiplier = up.weight/golf.weight;
                        double myWeight = (1 + golf.down_total) * multiplier / data_graph.pesoAristaVertices(inode, p);
                        double rel = g.pesoAristaVertices(inode, p) + myWeight;
                        g.modPesoAristaVertices(inode, p, rel);
                        up.down_total += myWeight;

                        if (victim.weight < myWeight) {
                            victim.orig = inode;
                            victim.dest = p;
                            victim.weight = myWeight;
                        }

                    }
                }

            }


        }

        out.agregarMensaje("Arista eliminada: " + data_graph.consultarVertice(victim.orig) + "--" + data_graph.consultarVertice(victim.dest));
        alg_graph.eliminarAristas(victim.orig, victim.dest);//, data_graph.pesoAristaVertices(victim.orig, victim.dest));
        alg_graph.eliminarAristas(victim.dest, victim.orig);//, data_graph.pesoAristaVertices(victim.dest, victim.orig));

        //Segundo pase del algoritmo de Girvan-Newman
        for (int i = 0; i < N; ++i)
        {
            //Lista para mantener guardada la ruta realizada durante Dijkstra
            LinkedList<Integer> route = new LinkedList<Integer>();
            //Cola de prioridades para aristas
            PriorityQueue<Arista<Integer>> Q = new PriorityQueue<Arista<Integer>>(N, comp);

            //Inicializar los nodos
            for (int ii = 0; ii < N; ++ii) {
                Node n = node.get(i);
                n.visited = false;
                n.component = -1;
                n.leaf = false;
                n.distance = Double.POSITIVE_INFINITY;
                n.parent.clear();
                n.weight = 0;
                n.down_total = 0;
            }

            Q.add(new Arista<Integer>(i, 0));

            Node uno = node.get(i);
            uno.distance = 0;
            uno.weight = 1;
            //Si no pertanece el nodo a un componente conexo, sumamos 1 a cc y le asignamos un componente al nodo
            if (uno.component == -1)
            {
                ++cc2;
                uno.component = cc2;
            }

            //Mientras la cola no esté vacía
            while(!Q.isEmpty())
            {
                Arista<Integer> a = Q.poll();
                int v = a.fin();

                Node ref_v = node.get(v);
                if (!ref_v.visited) {
                    ref_v.visited = true;
                    ref_v.component = cc2;
                    route.add(v);
                    int leaf_index = 0;
                    ArrayList<Integer> al = g.nodosSucesores(v);
                    for (int aux : al) { //Para todos los nodos adyacentes a V[v]

                        Node ref_aux = node.get(aux);
                        double dist = data_graph.pesoAristaVertices(v, aux); //dist es el peso de v -> aux
                        if (!ref_aux.visited) {
                            if (ref_aux.distance == 0) {
                                ref_aux.distance = ref_v.distance + dist;
                            } else if (ref_aux.distance > ref_v.distance + dist){
                                ref_aux.distance = ref_v.distance + dist;
                            } else if (ref_aux.distance == ref_v.distance + dist) {
                                ref_aux.weight += ref_v.weight;
                            }

                            leaf_index += 1;
                            ref_aux.parent.add(v);


                            Q.add(new Arista<Integer>(aux, dist));

                        }

                    }

                    if (leaf_index == 0) {
                        ref_v.leaf = true;
                        ref_v.down_total = 0;
                    }
                }

            }

            //Pesos en grafo
            for (int p : route)
            {
                Node golf = node.get(p);
                if (golf.parent.size() > 0) {
                    System.out.println(p + ": " + golf.parent);
                    for (int inode : golf.parent) {

                        Node up = node.get(inode);
                        double multiplier = up.weight/golf.weight;
                        double myWeight = (1 + golf.down_total) * multiplier / data_graph.pesoAristaVertices(inode, p);
                        double rel = g.pesoAristaVertices(inode, p) + myWeight;
                        g.modPesoAristaVertices(inode, p, rel);
                        up.down_total += myWeight;

                        if (victim.weight < myWeight) {
                            victim.orig = inode;
                            victim.dest = p;
                            victim.weight = myWeight;
                        }

                    }
                }

            }


        }

        //Mensajes de salida
        if (cc2 > cc)
        {
            int d_cc = cc2 - cc;
            if (d_cc == 1 && alg_cc != 0) out.agregarMensaje("Ha surgido una nueva comunidad.");
            else if (d_cc > 1) out.agregarMensaje("Han surgido "+ d_cc +" nuevas comunidades.");
        }

        alg_cc = cc2;

        return super.ejecutar_iteración(g);
    }



}

