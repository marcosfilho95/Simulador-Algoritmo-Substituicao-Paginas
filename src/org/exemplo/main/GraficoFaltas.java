package org.exemplo.main;

import javax.swing.*;
import java.awt.*;

class GraficoFaltas extends JPanel {
    private final int faltasFifo;
    private final int faltasLru;
    private final int faltasOptimal;
    private final int faltasNfu;

    public GraficoFaltas(int faltasFifo, int faltasLru, int faltasOptimal, int faltasNfu) {
        this.faltasFifo = faltasFifo;
        this.faltasLru = faltasLru;
        this.faltasOptimal = faltasOptimal;
        this.faltasNfu = faltasNfu;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int largura = getWidth();
        int altura = getHeight();
        int numBarras = 4;
        int larguraBarra = largura / (numBarras + 1);
        int espacamento = (largura - numBarras * larguraBarra) / 2;

        // Definir cores
        Color corFifo = Color.BLUE;
        Color corLru = Color.GREEN;
        Color corOptimal = new Color(0x00FFFF);
        Color corNfu = Color.RED;

        // Calcular altura máxima
        int maxFaltas = Math.max(Math.max(faltasFifo, faltasLru), Math.max(faltasOptimal, faltasNfu));
        int fatorEscala = (altura - 60) / maxFaltas;

        // Desenhar barras
        int alturaFifo = faltasFifo * fatorEscala;
        g.setColor(corFifo);
        g.fillRect(espacamento, altura - alturaFifo - 40, larguraBarra - 10, alturaFifo);

        int alturaLru = faltasLru * fatorEscala;
        g.setColor(corLru);
        g.fillRect(espacamento + larguraBarra, altura - alturaLru - 40, larguraBarra - 10, alturaLru);

        int alturaOptimal = faltasOptimal * fatorEscala;
        g.setColor(corOptimal);
        g.fillRect(espacamento + 2 * larguraBarra, altura - alturaOptimal - 40, larguraBarra - 10, alturaOptimal);

        int alturaNfu = faltasNfu * fatorEscala;
        g.setColor(corNfu);
        g.fillRect(espacamento + 3 * larguraBarra, altura - alturaNfu - 40, larguraBarra - 10, alturaNfu);

        // Adicionar rótulos
        g.setColor(Color.BLACK);
        g.drawString("FIFO: " + faltasFifo + " faltas", espacamento, altura - 20);
        g.drawString("LRU: " + faltasLru + " faltas", espacamento + larguraBarra, altura - 20);
        g.drawString("Ótimo: " + faltasOptimal + " faltas", espacamento + 2 * larguraBarra, altura - 20);
        g.drawString("NFU: " + faltasNfu + " faltas", espacamento + 3 * larguraBarra, altura - 20);
    }
}
