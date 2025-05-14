package br.com.projetoleda.SelectionSort;

import br.com.projetoleda.Conquistas.SelectionSort.OrdenarConquistasSelectionSort;
import br.com.projetoleda.Conquistas.SelectionSort.OrdenarConquistasSelectionSortMelhorCaso;
import br.com.projetoleda.Conquistas.SelectionSort.OrdenarConquistasSelectionSortPiorCaso;
import br.com.projetoleda.Precos.SelectionSort.OrdenarPrecosSelectionSortMedioCaso;
import br.com.projetoleda.Precos.SelectionSort.OrdenarPrecosSelectionSortMelhorCaso;
import br.com.projetoleda.Precos.SelectionSort.OrdenarPrecosSelectionSortPiorCaso;

public class GerarArquivosSelectionSort {
    public static void main(String[] args) {
        OrdenarConquistasSelectionSort.gerarArquivo();
        OrdenarConquistasSelectionSortMelhorCaso.gerarArquivo();
        OrdenarConquistasSelectionSortPiorCaso.gerarArquivo();


        OrdenarDatasSelectionSortMedioCaso.gerarArquivo();
        OrdenarDatasSelectionSortMelhorCaso.gerarArquivo();
        OrdenarDatasSelectionSortPiorCaso.gerarArquivo();


        OrdenarPrecosSelectionSortMedioCaso.gerarArquivo();
        OrdenarPrecosSelectionSortMelhorCaso.gerarArquivo();
        OrdenarPrecosSelectionSortPiorCaso.gerarArquivo();
    }
}
