package org.exemplo.main;

import org.exemplo.algoritmos.FIFO;
import org.exemplo.algoritmos.LRU;
import org.exemplo.algoritmos.Optimal;
import org.exemplo.algoritmos.NFU;

import javax.swing.*;
import java.util.Scanner;

public class Simulador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe uma cadeia de números inteiros separados por espaço:");
        String[] entrada = sc.nextLine().split(" ");
        int[] paginas = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            paginas[i] = Integer.parseInt(entrada[i]);
        }

        System.out.println("Informe o número de quadros:");
        int quadros = sc.nextInt();

        FIFO fifo = new FIFO(paginas, quadros);
        LRU lru = new LRU(paginas, quadros);
        Optimal optimal = new Optimal(paginas, quadros);
        NFU nfu = new NFU(paginas, quadros);

        int faltasFifo = fifo.calcularFaltas();
        int faltasLru = lru.calcularFaltas();
        int faltasOptimal = optimal.calcularFaltas();
        int faltasNfu = nfu.calcularFaltas();

        System.out.println("\nResultado da simulação de faltas de página:");
        System.out.println("FIFO: " + faltasFifo + " faltas de página");
        System.out.println("LRU: " + faltasLru + " faltas de página");
        System.out.println("Ótimo: " + faltasOptimal + " faltas de página");
        System.out.println("NFU: " + faltasNfu + " faltas de página");

        // Exibir gráfico
        JFrame frame = new JFrame("Gráfico de Faltas de Página");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.add(new GraficoFaltas(faltasFifo, faltasLru, faltasOptimal, faltasNfu)); // Passar faltas diretamente
        frame.setVisible(true);
    }
}
