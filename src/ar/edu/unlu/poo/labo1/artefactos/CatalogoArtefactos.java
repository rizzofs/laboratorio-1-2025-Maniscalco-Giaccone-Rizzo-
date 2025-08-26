package ar.edu.unlu.poo.labo1.artefactos;

import java.util.*;

public class CatalogoArtefactos {

    private Set<Artefacto> l_artefactos;

    public CatalogoArtefactos() {
        this.l_artefactos = null;
    }

    public Set<Artefacto> getL_artefactos() {
        return l_artefactos;
    }

    public List BuscarArtefactoPorTipo(String tipo){
        List<Artefacto> lista = new ArrayList<>();

        l_artefactos.forEach(artefacto -> {
            if (artefacto.getTipo() == tipo){
                lista.add(artefacto);
            }
        });

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - i - 1; j++) {
                if (lista.get(j).getPoder() > lista.get(j + 1).getPoder()) {
                    Artefacto temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }

        return lista;
    }

    public Map contarArtefactosPorTipo(String tipo){
        Map<String, Integer> mapa = new HashMap<>();

        l_artefactos.forEach(artefacto -> {
            if (artefacto.getTipo() == tipo){
                int cantidad = mapa.get(artefacto.getNombre());
                mapa.put(artefacto.getNombre(), cantidad + 1);
            }
        });
    }
}
