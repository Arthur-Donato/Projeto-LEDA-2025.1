package br.com.projetoleda.InsertionSort;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class OrdenarConquistasInsertionSortMelhorCaso {
    private static final String caminhoArquivoParaSerLido = "./Dados/games_achievements_InsertionSort_medioCaso.csv";
    private static final String CAMINHO_ARQUIVO_GERADO = "./Dados/games_achievements_InsertionSort_melhorCaso.csv";
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

            escritorDeArquivo.flush();
            escritorDeArquivo.close();
            leitorDoArquivo.close();

        }catch(IOException  e){
            e.printStackTrace();
        }
    }

    public static void insertionSort(CSVRecord[] lista, int primeiroIndice, int ultimoIndice){
        boolean houveTroca = false;
        for(int j = primeiroIndice + 1; j < ultimoIndice; j++){
            int conquistasPosicaoJ = extrairValor(lista, j);
            CSVRecord chave = lista[j];
            int i = j - 1;
            while(i >= primeiroIndice && extrairValor(lista, i) > conquistasPosicaoJ){
                houveTroca = true;
                lista[i + 1] = lista[i];
                i--;
            }

            if(!houveTroca){
                return;
            }
            lista[i + 1] = chave;
        }

    }

    public static int extrairValor(CSVRecord[] lista, int indice){
        try{
            return Integer.parseInt(lista[indice].get(26));
        } catch(Exception e){
            return 0;
        }
    }
}
