package org.exemplo.algoritmos;

import java.util.HashMap;
import java.util.Map;

public class NFU {
    private int[] paginas;
    private int quadros;

    public NFU(int[] paginas, int quadros) {
        this.paginas = paginas;
        this.quadros = quadros;
    }

    public int calcularFaltas() {
        int faltas = 0;
        Map<Integer, Integer> contagemUso = new HashMap<>();
        Map<Integer, Integer> memoria = new HashMap<>();

        for (int pagina : paginas) {
            contagemUso.put(pagina, contagemUso.getOrDefault(pagina, 0) + 1);

            if (!memoria.containsKey(pagina)) {
                if (memoria.size() == quadros) {
                    int paginaMenosUsada = memoria.keySet().stream()
                        .min((a, b) -> contagemUso.get(a) - contagemUso.get(b)).get();
                    memoria.remove(paginaMenosUsada);
                }
                memoria.put(pagina, 1);
                faltas++;
            }
        }
        return faltas;
    }
}
