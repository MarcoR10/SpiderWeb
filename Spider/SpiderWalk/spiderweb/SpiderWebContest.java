package spiderweb;
import java.util.*;




/**
 * Write a description of class SpiderWebContest here.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpiderWebContest{
    
    public int[] solve(int strands, int favorite, int[][] bridgeInfo) {
        // Crear un mapa para almacenar las conexiones entre cada par de hebras
        Map<Integer, List<Integer>> graph = createGraph(strands, bridgeInfo);
        // Calcular el número mínimo de puentes utilizando el algoritmo de BFS
        int[] result = bfs(strands, favorite, graph);
        return result;
    }
    
    private Map<Integer, List<Integer>> createGraph(int strands, int[][] bridgeInfo) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= strands; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] bridge : bridgeInfo) {
            int t = bridge[1];
            int nextStrand = t == strands ? 1 : t + 1;
            graph.get(t).add(nextStrand);
            if (!graph.containsKey(nextStrand)) {
                graph.put(nextStrand, new ArrayList<>());
            }
            graph.get(nextStrand).add(t);
        }
        return graph;
    }
    
    private int[] bfs(int strands, int favorite, Map<Integer, List<Integer>> graph) {
        int[] bridges = new int[strands + 1];
        Arrays.fill(bridges, -1);
        bridges[favorite] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(favorite);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (bridges[neighbor] == -1) {
                    bridges[neighbor] = bridges[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        return Arrays.copyOfRange(bridges, 1, strands + 1);
    }


    /**
     * Realiza una simulacion del problema propuesto.
     * @param strands  El número de cuerdas.
     * @param favorite La cuerda favorita de Charlotte.
     * @param bridges  Los puentes entre las cuerdas.
     */
    public void simulate(int strands, int favorite, int[][] bridges, int strand) throws SpiderException{
        SpiderWeb simulacion = new SpiderWeb(strands,favorite ,bridges);
        simulacion.makeVisible();
        simulacion.spiderSit(strand);
        simulacion.spiderWalk(true);
    }
}
