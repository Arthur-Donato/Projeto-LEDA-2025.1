package br.com.projetoleda.InsertionSort;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class OrdenarConquistasInsertionSortPiorCaso {
    private static final String caminhoArquivoParaSerLido = "./Dados/games_achievements_Invertido.csv";
    private static final String CAMINHO_ARQUIVO_GERADO = "./Dados/games_achievements_InsertionSort_piorCaso.csv";
    public static void main(String[] args) {
        
        try{
            FileReader leitorDoArquivo = new FileReader(caminhoArquivoParaSerLido);
            CSVPrinter escritorDeArquivo = new CSVPrinter(new FileWriter(CAMINHO_ARQUIVO_GERADO, true), CSVFormat.DEFAULT);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(leitorDoArquivo);
            
            
            CSVRecord[] lista = new CSVRecord[97411];
            int[] conquistas = new int[97411];  

            int i = 0;
            for(CSVRecord record : records) {
                if(record.getRecordNumber() == 1){
                    escritorDeArquivo.printRecord(record);
                }
                else if(record.size() > 2){
                    lista[i] = record;
                    try{
                        conquistas[i] = Integer.parseInt(record.get(26));
                    } catch(NullPointerException e){
                        
                        conquistas[i] = 0;
                    }
                    i++;
                }
                
            }
            
            insertionSort(lista, conquistas, 0, i - 1);
            
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

    public static void insertionSort(CSVRecord[] lista, int[] conquistas, int primeiroIndice, int ultimoIndice){
        boolean houveTroca = false;
        for(int j = primeiroIndice + 1; j <= ultimoIndice; j++){
            int conquistaPosicaoJ = conquistas[j];
            CSVRecord chave = lista[j];
            int i = j - 1;
            while(i >= primeiroIndice && conquistas[i] > conquistaPosicaoJ){
                houveTroca = true;
                lista[i + 1] = lista[i];
                conquistas[i + 1] = conquistas[i];
                i--;
            }

            if(!houveTroca){
                return;
            }
            lista[i + 1] = chave;
            conquistas[i + 1] = conquistaPosicaoJ;
        }

    }
}
