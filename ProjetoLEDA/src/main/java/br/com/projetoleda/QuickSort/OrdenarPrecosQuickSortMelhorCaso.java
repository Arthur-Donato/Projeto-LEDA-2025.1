package br.com.projetoleda.QuickSort;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class OrdenarPrecosQuickSortMelhorCaso {
    private static final String caminhoArquivoParaSerLido = "./Dados/games_price_QuickSort_medioCaso.csv";
    private static final String CAMINHO_ARQUIVO_GERADO = "./Dados/games_price_QuickSort_melhorCaso.csv";

    public static void main(String[] args) {
        try{
            FileReader leitorDoArquivo = new FileReader(caminhoArquivoParaSerLido);
            CSVPrinter escritorDeArquivo = new CSVPrinter(new FileWriter(CAMINHO_ARQUIVO_GERADO, true), CSVFormat.DEFAULT);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(leitorDoArquivo);
            
            CSVRecord[] lista = new CSVRecord[97411];
            int i = 0;
            for(CSVRecord record : records) {
                if(record.getRecordNumber() == 1){
                    escritorDeArquivo.printRecord(record);
                }
                else{
                    lista[i] = record;
                    i++;
                }
                
            }
            
            quickSort(lista, 0, lista.length - 1);

            for(CSVRecord record : lista){
                escritorDeArquivo.printRecord(record);
            }
            
            escritorDeArquivo.flush();
            escritorDeArquivo.close();
            leitorDoArquivo.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void quickSort(CSVRecord[] lista, int primeiroIndice, int ultimoIndice){
        if(primeiroIndice < ultimoIndice){
            int pivot = particaoPivotQuickSort(lista, primeiroIndice, ultimoIndice);
            quickSort(lista, primeiroIndice, pivot - 1);
            quickSort(lista, pivot + 1, ultimoIndice);
        }
    }

    public static int particaoPivotQuickSort(CSVRecord[] lista, int primeiroIndice, int ultimoIndice){
        double pivot = Double.parseDouble(lista[primeiroIndice].get(6));
        int i = primeiroIndice + 1;
        int j = ultimoIndice - 1;

        while(i <= j){
            double numeroPosicaoI;
            double numeroPosicaoJ;
            try{
                numeroPosicaoI = Double.parseDouble(lista[i].get(6));
                numeroPosicaoJ = Double.parseDouble(lista[j].get(6));
            }catch(NullPointerException e){
                numeroPosicaoI = 0;
                numeroPosicaoJ = 0;
                e.printStackTrace();
            }

            if(numeroPosicaoI <= pivot){
                i++;
            }
            else if(numeroPosicaoJ > pivot){
                j--;
            }
            else{
                trocarElementos(lista, i, j);
            }
            
         }
         trocarElementos(lista, primeiroIndice, j);
         return j;
    }

    public static void trocarElementos(CSVRecord[] lista, int primeiroIndice, int segundoIndice){
        CSVRecord recordTemporario = lista[primeiroIndice];
        lista[primeiroIndice] = lista[segundoIndice];
        lista[segundoIndice] = recordTemporario;
    }
}
