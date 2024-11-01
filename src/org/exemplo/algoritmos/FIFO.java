package org.exemplo.algoritmos;

import java.util.LinkedList;

public class FIFO {
    private int[] paginas;
    private int quadros;

    public FIFO(int[] paginas, int quadros) {
        this.paginas = paginas;
        this.quadros = quadros;
    }

    public int calcularFaltas() {
        LinkedList<Integer> memoria = new LinkedList<>();
        int faltasDePagina = 0;

        for (int pagina : paginas) {
            if (!memoria.contains(pagina)) {
                if (memoria.size() == quadros) {
                    memoria.poll();
                }
                memoria.add(pagina);
                faltasDePagina++;
            }
        }
        return faltasDePagina;
    }
}
