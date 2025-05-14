package br.com.projetoleda.SelectionSort;

public class GerarArquivosSelectionSort {
    public static void main(String[] args) {
        OrdenarConquistasSelectionSort.gerarArquivo();
        OrdenarConquistasSelectionSortMelhorCaso.gerarArquivo();
        OrdenarConquistasSelectionSortPiorCaso.gerarArquivo();


        OrdenarDatasSelectionSortMedioCaso.gerarArquivo();
        OrdenarDatasSelectionSortMelhorCaso.gerarArquivo();
        OrdenarDatasSelectionSortPiorCaso.gerarArquivo();


        OrdenarPrecosSelectionSort.gerarArquivo();
        OrdenarPrecosSelectionSortMelhorCaso.gerarArquivo();
        OrdenarPrecosSelectionSortPiorCaso.gerarArquivo();
    }
}
