package br.com.projetoleda.HeapSort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class OrdenarPrecosHeapSort {
    private static final String caminhoArquivoParaSerLido = "./Dados/games_formated_release_data.csv";
    private static final String CAMINHO_ARQUIVO_GERADO = "./Dados/games_price_HeapSort_medioCaso.csv";

    public static void gerarArquivo() {
        
        try{
            FileReader leitorDoArquivo = new FileReader(caminhoArquivoParaSerLido);
            BufferedReader reader = new BufferedReader(leitorDoArquivo);


            int contadorLinhas = 0;
            while(reader.readLine() != null){
                contadorLinhas++;
            }

            leitorDoArquivo.close();
            reader.close();

            FileReader leitorFinal = new FileReader(caminhoArquivoParaSerLido);
            CSVPrinter escritorDeArquivo = new CSVPrinter(new FileWriter(CAMINHO_ARQUIVO_GERADO, true), CSVFormat.DEFAULT);
            CSVParser parser = CSVFormat.RFC4180.parse(leitorFinal);
            
            CSVRecord[] lista = new CSVRecord[contadorLinhas];

            int i = 0;
            for(CSVRecord record : parser) {
                if(record.getRecordNumber() == 1){
                    escritorDeArquivo.printRecord(record);
                }
                else if(record.size() > 2){
                    lista[i] = record;
                    i++;
                }
                
            }
            
            heapSort(lista);

            for(CSVRecord record : lista){
                escritorDeArquivo.printRecord(record);
            }
            
            escritorDeArquivo.flush();
            escritorDeArquivo.close();
            leitorFinal.close();

        }catch(IOException  e){
            e.printStackTrace();
        }
    }

    static void heapify(CSVRecord[] lista, int n, int i) {

        // Initialize largest as root
        int largest = i; 

        // left index = 2*i + 1
        int l = 2 * i + 1; 

        // right index = 2*i + 2
        int r = 2 * i + 2;

        // If left child is larger than root

        if (l < n && extrairPreco(lista, l) > extrairPreco(lista, largest)) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && extrairPreco(lista, r) > extrairPreco(lista, largest)) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            CSVRecord temp = lista[i];
            lista[i] = lista[largest];
            lista[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(lista, n, largest);
        }
    }

    // Main function to do heap sort
    static void heapSort(CSVRecord[] lista) {
        int n = lista.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(lista, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {

            // Move current root to end
            CSVRecord temp = lista[0]; 
            lista[0] = lista[i];
            lista[i] = temp;

            // Call max heapify on the reduced heap
            heapify(lista, i, 0);
        }
    }

    public static void trocarElementos(CSVRecord[] lista, int primeiroIndice, int segundoIndice){
        CSVRecord numeroTemporario = lista[primeiroIndice];
        lista[primeiroIndice] = lista[segundoIndice];
        lista[segundoIndice] = numeroTemporario;
    }

    public static double extrairPreco(CSVRecord[] lista, int indice){
        try{
            return Double.parseDouble(lista[indice].get(6));
        } catch(Exception e){
            return 0.0;
        }
    }
}
