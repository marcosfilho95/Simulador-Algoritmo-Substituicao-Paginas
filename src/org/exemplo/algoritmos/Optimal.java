package org.exemplo.algoritmos;

public class Optimal {
    private int[] paginas;
    private int quadros;

    public Optimal(int[] paginas, int quadros) {
        this.paginas = paginas;
        this.quadros = quadros;
    }

    public int calcularFaltas() {
        int[] memoria = new int[quadros];
        int faltas = 0;
        int indice = 0;

        for (int i = 0; i < paginas.length; i++) {
            if (!estaNaMemoria(paginas[i], memoria)) {
                if (indice < quadros) {
                    memoria[indice++] = paginas[i];
                } else {
                    int j = preverPosicao(paginas, memoria, paginas.length, i + 1);
                    memoria[j] = paginas[i];
                }
                faltas++;
            }
        }
        return faltas;
    }

    private boolean estaNaMemoria(int chave, int[] memoria) {
        for (int item : memoria) {
            if (item == chave) {
                return true;
            }
        }
        return false;
    }

    private int preverPosicao(int[] paginas, int[] memoria, int totalPaginas, int indice) {
        int posicaoMaisDistante = -1;
        int maisDistante = indice;

        for (int i = 0; i < memoria.length; i++) {
            int j;
            for (j = indice; j < totalPaginas; j++) {
                if (memoria[i] == paginas[j]) {
                    if (j > maisDistante) {
                        maisDistante = j;
                        posicaoMaisDistante = i;
                    }
                    break;
                }
            }
            if (j == totalPaginas) return i;
        }
        return (posicaoMaisDistante == -1) ? 0 : posicaoMaisDistante;
    }
}
