package br.com.projetoleda.MergeSort;

public class GerarArquivosMergeSort {
    public static void main(String[] args) {
        OrdenarConquistasMedioCaso.gerarArquivo();
        OrdenarConquistasMelhorCaso.gerarArquivo();
        OrdenarConquistasPiorCaso.gerarArquivo();

        OrdenarDatasMedioCaso.gerarArquivo();
        OrdenarDatasMergeSortMelhorCaso.gerarArquivo();
        OrdenarDatasMergeSortPiorCaso.gerarArquivo();

        OrdenarPrecosMedioCaso.gerarArquivo();
        OrdenarPrecosMelhorCaso.gerarArquivo();
        OrdenarPrecosMergeSortPiorCaso.gerarArquivo();
    }
}
