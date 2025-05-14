package br.com.projetoleda.InsertionSort;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class OrdenarPrecosInsertionSort {
    private static final String caminhoArquivoParaSerLido = "./Dados/games_formated_release_data.csv";
    private static final String CAMINHO_ARQUIVO_GERADO = "./Dados/games_price_InsertionSort_medioCaso.csv";
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
            
            insertionSort(lista, 0, lista.length - 1);
            
            for(CSVRecord record : lista){
                escritorDeArquivo.printRecord(record);
                
            }
            System.out.println("Escrrito!");

            escritorDeArquivo.flush();
            escritorDeArquivo.close();
            leitorDoArquivo.close();

        }catch(IOException  e){
            e.printStackTrace();
        }
    }

    public static void insertionSort(CSVRecord[] lista, int primeiroIndice, int ultimoIndice){
        for(int j = primeiroIndice + 1; j < ultimoIndice; j++){
            Double precoPosicaoJ = Double.parseDouble(lista[j].get(6));
            CSVRecord chave = lista[j];
            int i = j - 1;
            while(i >= primeiroIndice && Double.parseDouble(lista[i].get(6)) > precoPosicaoJ){
                lista[i + 1] = lista[i];
                i--;
            }
            lista[i + 1] = chave;
        }

    }
}
