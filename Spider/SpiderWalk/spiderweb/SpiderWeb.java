package spiderweb;

import canvas.Canvas;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.lang.String;

/**
 * Write a description of class SpiderWeb here.
 * @author (Marco Alvarez-Paula Paez) 
 * @version (1.3)
 */
public class SpiderWeb{
    
    public String[] supportedColors = {"red","blue","yellow","green","magenta","white","cyan","orange","pink","gray"};
    public ArrayList<Line> totalStrand = new ArrayList<Line>();
    private ArrayList<String> reachableSpots = new ArrayList<>();
    private ArrayList<String> spots = new ArrayList<String>();
    private HashMap<String,Bridge> bridge = new HashMap<>();
    private ArrayList<Point[]> ultimoRecorrido = new ArrayList();
    private boolean ultimaAccion,advance;
    private int strand,radio,favorite;
    private Spider araña;
    private String color;
    
     /**
     * Constructor para objetos de la clase SpiderWeb.
     * 
     * @param strands Número de hilos en la tela de araña.
     * @param radio   Radio de la tela de araña.
     */
    public SpiderWeb(int strands, int radio){
        this.strand = strands;
        this.radio = radio;
        this.ultimaAccion = true;
        draw(strands,radio);
    }
    
    /**
     * Constructor para la clase SpiderWeb que inicializa una nueva tela de araña con ciertos parámetros.
     *
     * @param strands  Número de hilos en la tela de araña.
     * @param favorite Índice del hilo favorito.
     * @param bridges  Matriz bidimensional que contiene la información de los puentes.
     */
    public SpiderWeb(int strands,int favorite ,int[][] bridges) throws SpiderException {
        this.strand = strands;
        radio = 300;
        this.favorite = favorite;
        this.ultimaAccion = true;
        draw(strands,radio);
        for(int i = 0; i < bridges.length ; i++){
            addBridge(supportedColors[i], bridges[i][0]*20, bridges[i][1]);
        }
    }
    
     /**
     * Aumenta el número de hebra en 1 y redibuja el objeto.
     * Hace invisible al objeto actual antes de redibujarlo.
     */
    public void addStrand() {
        this.makeInvisible();
        draw(strand+1,radio);
    }
    
    /**
     * Aumenta el radio del objeto en un porcentaje dado y redibuja el objeto.
     * Hace invisible al objeto actual antes de redibujarlo.
     * 
     * @param percentage porcentaje de aumento del radio.
     */
    public void enlarge(int percentage) {
        this.makeInvisible();
        double aumento = (radio * percentage) / 100.0;
        double numeroAumentado = radio + aumento;
        draw(strand,(int)numeroAumentado);
    }
    
    /**
     * Agrega un puente a la tela de araña.
     * 
     * @param color      Color del puente.
     * @param distance   Distancia desde el primer hilo.
     * @param firstStand Índice del primer hilo.
     */
    public void addBridge(String color, int distance, int firstStand) throws SpiderException{
        if (distance < radio && firstStand < strand) {
            Point a = getPointAtDistance(firstStand - 1, distance);
            Point b = getPointAtDistance(firstStand, distance);
            Normal bridg = new Normal(a.x, a.y, b.x, b.y, color, firstStand);
            bridg.makeVisible();
            bridge.put(color, bridg);
        } else if (distance < radio && firstStand == strand) {
            Point a = getPointAtDistance(firstStand - 1, distance);
            Point b = getPointAtDistance(0, distance);
            Normal bridg = new Normal(a.x, a.y, b.x, b.y, color, firstStand);
            bridg.makeVisible();
            bridge.put(color, bridg);
        }
    }
    
    /**
     * Agrega un puente a la tela de araña.
     * 
     * @param type       Tipo de puente (normal, walk, fixed, mobile).
     * @param color      Color del puente.
     * @param distance   Distancia desde el primer hilo.
     * @param firstStand Índice del primer hilo.
     */
    public void addBridge(String type, String color, int distance, int firstStand) throws SpiderException {
        if (distance < radio && firstStand <= strand) {
            Point a = getPointAtDistance(firstStand - 1, distance);
            Point b = (firstStand == strand) ? getPointAtDistance(0, distance) : getPointAtDistance(firstStand, distance);
            Bridge bridge;
            switch (type.toLowerCase()) {
                case "normal":
                    bridge = new Normal(a.x, a.y, b.x, b.y, color, firstStand);
                    break;
                case "weak":
                    bridge = new Weak(a.x, a.y, b.x, b.y, color, firstStand);
                    break;
                case "fixed":
                    bridge = new Fixed(a.x, a.y, b.x, b.y, color, firstStand);
                    break;
                case "mobile":
                    bridge = new Mobile(a.x, a.y, b.x, b.y, color, firstStand);
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de puente desconocido: " + type);
            }
            bridge.makeVisible();
            this.bridge.put(color, bridge);
        }
    }
    
    /**
     * Mueve un puente existente en la tela de araña.
     * 
     * @param color    Color del puente a mover.
     * @param distance Nueva distancia desde el primer hilo.
     */
    public void relocateBridge(String color, int distance) throws SpiderException{
        Bridge Obridge = bridge.get(color);
        Obridge.makeInvisible();
        int Stand = Obridge.getStand();
        delBridge(color);
        addBridge(color, distance, Stand);
    }

    /**
     * Elimina un puente de la tela de araña.
     * 
     * @param color Color del puente a eliminar.
     */
    public void delBridge(String color) {
        Bridge bridgeremove = bridge.get(color);
        if(!(bridgeremove instanceof Fixed)){
            bridgeremove.makeInvisible();
            bridge.remove(color);
        }else{
            bridgeremove.makeInvisible();
        }
    }

    /**
     * Agrega un punto de descanso en un hilo específico.
     * 
     * @param color       Color del punto de descanso.
     * @param strandIndex Índice del hilo donde se desea agregar el punto.
     */
    public void addSpot(String color, int strandIndex) {
        if (strandIndex > 0 && strandIndex <= totalStrand.size()) {
            Line strand = totalStrand.get(strandIndex - 1);
            strand.makeInvisible();
            strand.setColor(color);
            spots.add(color);
            strand.makeVisible();
        } else {
            System.out.println("El número de hilo no es válido.");
        }
    }

    /**
     * Elimina un punto de descanso de la tela de araña.
     * 
     * @param color Color del punto de descanso a eliminar.
     */
    public void delSpot(String color) {
        for (Line line : totalStrand) {
            if (line.color.equals(color)) {
                line.makeInvisible();
                line.setColor("black");
                spots.remove(color);
                line.makeVisible();
            }
        }
    }
    
     /**
     * Posiciona la araña en un hilo específico.
     * 
     * @param strand Índice del hilo donde se desea posicionar la araña.
     */
    public void spiderSit(int strand) {
        if (strand > 0 && strand <= totalStrand.size()) {
            Line strandToSitOn = totalStrand.get(strand - 1);
            Point coordenadas = strandToSitOn.getInitial();
            araña = new Spider((int)coordenadas.getX(),(int)coordenadas.getY(),strand);
        } else {
            System.out.println("Índice de hilo inválido.");
        }
    }

    /**
     * Hace caminar a la araña en la tela de araña.
     * 
     * @param advance Indica si la araña debe avanzar o no.
     */
    public void spiderWalk(boolean advance) {
        // Obtener el índice del hilo en el que se encuentra la araña
        int Strand = araña.getStrand();
        //Line elemento = totalStrand.get(Strand);
        Point[] Camino = getCamino(Strand);
        // Hacer que la araña camine avanzando o retrocediendo según el parámetro advance
        araña.spiderWalk(advance,Camino);
    }
    
    /**
     * Método que devuelve el último camino de la araña.
     * Este método está vacío y siempre devuelve null, y debería ser implementado para devolver el último camino registrado.
     *
     * @return un array de enteros que representa el último camino de la araña.
     */
    public int[] spiderLasthPath() {
        // Indicador para avanzar en el recorrido (por ahora se deja como true)
        boolean advance = true;
         // Verifica si hay algún recorrido registrado
        if (ultimoRecorrido.isEmpty()) {
            return null;
        } else {
            // Obtiene el índice del hilo en el que se encuentra la araña
            int Strand = araña.getStrand();
            // Obtiene el camino correspondiente al hilo donde se encuentra la araña
            Point[] Camino = getCamino(Strand);
             // Crea un array para almacenar las coordenadas X e Y del último camino
            int[] lastPath = new int[Camino.length * 2];
            for (int i = 0; i < Camino.length; i++) {
                Point punto = Camino[i];
                lastPath[i * 2] = punto.x; // Coordenada X
                lastPath[i * 2 + 1] = punto.y; // Coordenada Y
            }
             // Devuelve el array que representa el último camino de la araña
            return lastPath;
        }
    }
    
    /**
     * Método que devuelve los puntos de descanso alcanzables en la tela de araña.
     * 
     * Este método calcula y devuelve los puntos de descanso en la tela de araña que pueden ser alcanzados por la araña en su posición actual. 
     * Un punto de descanso es alcanzable si la araña puede llegar a él moviéndose a través de los hilos y puentes disponibles.
     * 
     * @return Un array de cadenas que representa los puntos de descanso alcanzables. Si no hay puntos alcanzables, se devuelve un array vacío.
     */
    public String[] reachableSpots() {
        ArrayList<String> reachableSpots = new ArrayList<>();
        Point currentPosition = getCurrentPosition();
        if (currentPosition != null) {
            for (String spot : spots) {
                Point spotPosition = getSpotPosition(spot);
                if (spotPosition != null && currentPosition.equals(spotPosition)) {
                    reachableSpots.add(spot);
                }
            }
        }
        return reachableSpots.toArray(new String[0]);
    }

    /**
     * Método que devuelve los puentes no utilizados en la tela de araña.
     * 
     * Este método calcula y devuelve los puentes que aún no han sido utilizados por la araña en su recorrido. 
     * Un puente se considera no utilizado si la araña no ha pasado por él durante su movimiento en la tela de araña.
     * 
     * @return Un array de cadenas que representa los puentes no utilizados. Si no hay puentes no utilizados, se devuelve null.
     */
    public String[] unusedBridges() {
        ArrayList<String> unusedBridges = new ArrayList<>();
        for (String bridgeName : bridge.keySet()) {
            Bridge currentBridge = bridge.get(bridgeName);
            if (!currentBridge.isUsed()) {
                unusedBridges.add(bridgeName);
            }
        }
        if (unusedBridges.isEmpty()) {
            return null;
        } else {
            return unusedBridges.toArray(new String[0]);
        }
    }
    
    /**
     * Método que devuelve los nombres de todos los puentes disponibles.
     * @return un array de cadenas que contiene los nombres de todos los puentes.
     */
    public String[] bridges() {
        Set<String> bridges = bridge.keySet();
        String[] totalBridges = new String[bridges.size()];
        bridges.toArray(totalBridges);
        return totalBridges;
    }

    /**
     * Método que devuelve todos los puntos o lugares disponibles.
     * @return un array de cadenas que contiene los nombres de todos los puntos o lugares.
     */
    public String[] spots() {
        String[] totalSpots = spots.toArray(new String[0]);
        return totalSpots;
    }

    /**
     * Hace visible la tela de araña, los puentes y la araña.
     */
    public void makeVisible() throws spiderweb.SpiderException {
        for (int i = 0; i < totalStrand.size(); i++) {
            Line elemento = totalStrand.get(i);
            elemento.makeVisible();
        }
        for (String key : bridge.keySet()) {
            Bridge bridg = bridge.get(key);
            bridg.makeVisible();
        }
        if (araña != null && araña.getVisibilidad() == false) {
            araña.makeVisible();
        }
    }

    /**
     * Hace invisible la tela de araña y los puentes.
     */
    public void makeInvisible() {
        for (int i = 0; i < totalStrand.size(); i++) {
            Line elemento = totalStrand.get(i);
            elemento.makeInvisible();
        }
        for (String key : bridge.keySet()) {
            Bridge bridg = bridge.get(key);
            bridg.makeInvisible();
        }
        if (araña != null && araña.getVisibilidad() == true) {
            araña.makeInvisible();
        }
    }

    /**
     * Verifica si la última acción fue exitosa.
     * 
     * @return true si la última acción fue exitosa, false en caso contrario.
     */
    public boolean ok() {
        return ultimaAccion;
    }

    /**
     * Finaliza el programa.
     */
    public void finish() {
        System.exit(0);
    }
    
     /**
     * Método privado que obtiene la posición de un punto de descanso en la tela de araña.
     * 
     * @return Un objeto Point que representa las coordenadas (x, y) del punto de descanso. Si el punto no se encuentra, devuelve null.
     */
    private Point getSpotPosition(String spot) {
        for (Line line : totalStrand) {
            if (line.color.equals(spot)) {
                return line.getInitial();
            }
        }
        return null;
    }
    
    /**
     * Obtiene la posición actual de la araña en la tela de araña.
     * 
     * @return Un objeto Point que representa las coordenadas (x, y) de la posición actual de la araña.
     */
    public Point getCurrentPosition() {
        Line currentLine = totalStrand.get(strand - 1);
        Point coordenadasIniciales = currentLine.getInitial();
        if (araña != null) {
            return new Point((int)coordenadasIniciales.getX(), (int)coordenadasIniciales.getY());
        } 
        return null;
    }
    
    /**
     * Dibuja líneas para representar hebras alrededor de un punto central.
     *
     * @param strandIndex El número de hebras que se van a dibujar.
     * @param distance    La distancia desde el punto central hasta el extremo de cada hebra.
     */
    private void draw(int strandIndex, int distance) {
        this.strand = strandIndex;
        this.radio = distance;
        if(totalStrand.isEmpty() == false){
            totalStrand.clear();
        }
        double angleIncrement = 2 * Math.PI / strand;
        for (int i = strand; 0 < i; i--) {
            double angle = i * angleIncrement;
            int x = (int) (400 + radio * Math.cos(angle));
            int y = (int) (400 + radio * Math.sin(angle));
            Line Stand = new Line(400, 400, x, y, "black");
            totalStrand.add(Stand);
        }
    }
   
    /**
     * Obtiene las coordenadas de un punto a una distancia específica de un hilo.
     * 
     * @param strandIndex Índice del hilo.
     * @param distance    Distancia desde el punto inicial del hilo.
     * @return Punto con las coordenadas calculadas.
     */
    private Point getPointAtDistance(int strandIndex, int distance) {
        if (strandIndex >= 0 && strandIndex < totalStrand.size()) {
            Line strand = totalStrand.get(strandIndex);
            double angle = Math.atan2(strand.y - strand.centerY, strand.x - strand.centerX);
            int x = (int) (strand.centerX + distance * Math.cos(angle));
            int y = (int) (strand.centerY + distance * Math.sin(angle));
            return new Point(x, y);
        } else {
            System.out.println("Índice de hilo inválido.");
            return null;
        }
    }
    
    private Point[] getCamino(int strand){
        int segmento = radio / 10;
        int[] segmentos = new int[10];
        for (int i = 0; i < 10; i++) {
            segmentos[i] = i * segmento;
        }
        Point[] coordenadas = new Point[10];
        for (int n = 0; n < 10; n++) {
            coordenadas[n] = getPointAtDistance(strand,segmentos[n]);
        }
        return coordenadas;
    }
    
}
