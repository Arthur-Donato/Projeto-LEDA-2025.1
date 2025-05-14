package br.com.projetoleda.HeapSort;

public class GerarArquivosHeapSort {
    public static void main(String[] args) {
        OrdenarConquistasHeapSortMedioCaso.gerarArquivo();
        OrdenarConquistasHeapSortMelhorCaso.gerarArquivo();
        OrdenarConquistasHeapSortPiorCaso.gerarArquivo();

        OrdenarDatasHeapSortMedioCaso.gerarArquivo();
        OrdenarDatasHeapSortMelhorCaso.gerarArquivo();
        OrdenarDatasHeapSortPiorCaso.gerarArquivo();


        OrdenarPrecosHeapSort.gerarArquivo();
        OrdenarPrecosHeapSortMelhorCaso.gerarArquivo();
        OrdenarPrecosHeapSortPiorCaso.gerarArquivo();
        
    }
}
