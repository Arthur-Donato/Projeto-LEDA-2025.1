package br.com.projetoleda.MergeSort;

import br.com.projetoleda.Conquistas.MergeSort.OrdenarConquistasMedioCaso;
import br.com.projetoleda.Conquistas.MergeSort.OrdenarConquistasMelhorCaso;
import br.com.projetoleda.Conquistas.MergeSort.OrdenarConquistasPiorCaso;
import br.com.projetoleda.Precos.MergeSort.OrdenarPrecosMergeSortMedioCaso;
import br.com.projetoleda.Precos.MergeSort.OrdenarPrecosMergeSortMelhorCaso;
import br.com.projetoleda.Precos.MergeSort.OrdenarPrecosMergeSortPiorCaso;

public class GerarArquivosMergeSort {
    public static void main(String[] args) {
        OrdenarConquistasMedioCaso.gerarArquivo();
        OrdenarConquistasMelhorCaso.gerarArquivo();
        OrdenarConquistasPiorCaso.gerarArquivo();

        OrdenarDatasMedioCaso.gerarArquivo();
        OrdenarDatasMergeSortMelhorCaso.gerarArquivo();
        OrdenarDatasMergeSortPiorCaso.gerarArquivo();

        OrdenarPrecosMergeSortMedioCaso.gerarArquivo();
        OrdenarPrecosMergeSortMelhorCaso.gerarArquivo();
        OrdenarPrecosMergeSortPiorCaso.gerarArquivo();
    }
}
