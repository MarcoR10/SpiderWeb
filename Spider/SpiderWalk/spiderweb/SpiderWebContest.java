package spiderweb;

import java.util.*;

/**
 * Write a description of class SpiderWebContest here.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpiderWebContest{
    
    private static class Bridge implements Comparable<Bridge> {
        int strand;
        int distance;
        public Bridge(int strand, int distance) {
            this.strand = strand;
            this.distance = distance;
        }
        @Override
        public int compareTo(Bridge other) {
            return this.distance - other.distance;
        }
    }

    public int[] solve(int strands, int favorite, int[][] bridgeInfo) {
        List<Bridge> bridges = new ArrayList<>();
        for (int[] bridge : bridgeInfo) {
            int d = bridge[0];
            int t = bridge[1];
            bridges.add(new Bridge(t, d));
            bridges.add(new Bridge(t == strands ? 1 : t + 1, d));
        }
        Collections.sort(bridges);
        int[] result = new int[strands + 1];
        Arrays.fill(result, strands + 1);
        result[favorite] = 0;
        for (Bridge bridge : bridges) {
            result[bridge.strand] = Math.min(result[bridge.strand], result[bridge.strand == 1 ? strands : bridge.strand - 1] + 1);
        }
        for (int i = 1; i <= strands; i++) {
            result[i] = Math.min(result[i], result[i == 1 ? strands : i - 1] + 1);
        }
        for (int i = strands; i >= 1; i--) {
            result[i] = Math.min(result[i], result[i == strands ? 1 : i + 1] + 1);
        }
        return Arrays.copyOfRange(result, 1, strands + 1);
    }

    /**
     * Realiza una simulacion del problema propuesto.
     * @param strands  El número de cuerdas.
     * @param favorite La cuerda favorita de Charlotte.
     * @param bridges  Los puentes entre las cuerdas.
     */
    public void simulate(int strands, int favorite, int[][] bridges, int strand) {
        SpiderWeb simulacion = new SpiderWeb(strands,favorite ,bridges);
        simulacion.makeVisible();
        simulacion.spiderSit(strand);
    }
}
