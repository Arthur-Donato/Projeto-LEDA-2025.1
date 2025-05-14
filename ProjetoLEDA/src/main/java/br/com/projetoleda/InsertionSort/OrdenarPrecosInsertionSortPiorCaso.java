package br.com.projetoleda.InsertionSort;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class OrdenarPrecosInsertionSortPiorCaso {
    private static final String caminhoArquivoParaSerLido = "./Dados/games_price_Invertido.csv";
    private static final String CAMINHO_ARQUIVO_GERADO = "./Dados/games_price_InsertionSort_piorCaso.csv";
    public static void main(String[] args) {
        
        try{
            File arquivo = new File(caminhoArquivoParaSerLido);
            FileReader leitorDoArquivo = new FileReader(caminhoArquivoParaSerLido);
            CSVPrinter escritorDeArquivo = new CSVPrinter(new FileWriter(CAMINHO_ARQUIVO_GERADO, true), CSVFormat.DEFAULT);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(leitorDoArquivo);
            
            
            
            CSVRecord[] lista = new CSVRecord[100000];
            Double[] precos = new Double[97411];
            leitorDoArquivo.read();

            int i = 0;
            for(CSVRecord record : records) {
                if(record.getRecordNumber() == 1){
                    escritorDeArquivo.printRecord(record);
                }
                else if(record.size() > 2){
                    lista[i] = record;
                    try{
                        precos[i] = Double.parseDouble(record.get(6));
                    } catch(NullPointerException e){
                        
                        precos[i] = 0.0;
                    }
                    i++;
                }
                
            }
            
            insertionSort(lista, precos, 0, i - 1);
            
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

    public static void insertionSort(CSVRecord[] lista, Double[] precos, int primeiroIndice, int ultimoIndice){
        boolean houveTroca = false;
        for(int j = primeiroIndice + 1; j <= ultimoIndice; j++){
            Double precoPosicaoJ = precos[j];
            CSVRecord chave = lista[j];
            int i = j - 1;
            while(i >= primeiroIndice && precos[i] < precoPosicaoJ){
                houveTroca = true;
                lista[i + 1] = lista[i];
                precos[i + 1] = precos[i];
                i--;
            }

            if(!houveTroca){
                return;
            }
            
            lista[i + 1] = chave;
            precos[i + 1] = precoPosicaoJ;
        }

    }
}
