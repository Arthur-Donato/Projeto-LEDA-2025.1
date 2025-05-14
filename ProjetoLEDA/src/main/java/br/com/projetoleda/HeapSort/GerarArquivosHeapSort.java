package br.com.projetoleda.HeapSort;

import br.com.projetoleda.Conquistas.HeapSort.OrdenarConquistasHeapSortMedioCaso;
import br.com.projetoleda.Conquistas.HeapSort.OrdenarConquistasHeapSortMelhorCaso;
import br.com.projetoleda.Conquistas.HeapSort.OrdenarConquistasHeapSortPiorCaso;
import br.com.projetoleda.Precos.HeapSort.OrdenarPrecosHeapSortMedioCaso;
import br.com.projetoleda.Precos.HeapSort.OrdenarPrecosHeapSortMelhorCaso;
import br.com.projetoleda.Precos.HeapSort.OrdenarPrecosHeapSortPiorCaso;

public class GerarArquivosHeapSort {
    public static void main(String[] args) {
        OrdenarConquistasHeapSortMedioCaso.gerarArquivo();
        OrdenarConquistasHeapSortMelhorCaso.gerarArquivo();
        OrdenarConquistasHeapSortPiorCaso.gerarArquivo();

        OrdenarDatasHeapSortMedioCaso.gerarArquivo();
        OrdenarDatasHeapSortMelhorCaso.gerarArquivo();
        OrdenarDatasHeapSortPiorCaso.gerarArquivo();


        OrdenarPrecosHeapSortMedioCaso.gerarArquivo();
        OrdenarPrecosHeapSortMelhorCaso.gerarArquivo();
        OrdenarPrecosHeapSortPiorCaso.gerarArquivo();
        
    }
}
