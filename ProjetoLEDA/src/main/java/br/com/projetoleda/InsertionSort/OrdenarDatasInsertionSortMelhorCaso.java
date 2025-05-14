package br.com.projetoleda.InsertionSort;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class OrdenarDatasInsertionSortMelhorCaso {
    private static final String caminhoArquivoParaSerLido = "./Dados/games_releaseData_InsertionSort_medioCaso.csv";
    private static final String CAMINHO_ARQUIVO_GERADO = "./Dados/games_releaseData_InsertionSort_melhorCaso.csv";
    public static void main(String[] args) {
        
        try{
            FileReader leitorDoArquivo = new FileReader(caminhoArquivoParaSerLido);
            CSVPrinter escritorDeArquivo = new CSVPrinter(new FileWriter(CAMINHO_ARQUIVO_GERADO, true), CSVFormat.DEFAULT);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(leitorDoArquivo);
            
            
            CSVRecord[] lista = new CSVRecord[97411];
            Date[] datas = new Date[97411];  

            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            dataFormatada.setLenient(false);

            int i = 0;
            for(CSVRecord record : records) {
                if(record.getRecordNumber() == 1){
                    escritorDeArquivo.printRecord(record);
                }
                else if(record.size() > 2){
                    lista[i] = record;
                    try{
                        datas[i] = dataFormatada.parse(record.get(2));
                    } catch(ParseException | NullPointerException e){
                        
                        datas[i] = new Date(0);
                    }
                    i++;
                }
                
            }
            
            insertionSort(lista, datas, 0, i - 1);
            
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

    public static void insertionSort(CSVRecord[] lista, Date[] datas, int primeiroIndice, int ultimoIndice){
        boolean houveTroca = false;
        for(int j = primeiroIndice + 1; j <= ultimoIndice; j++){
            Date datasPosicaoJ = datas[j];
            CSVRecord chave = lista[j];
            int i = j - 1;
            while(i >= primeiroIndice && datas[i].compareTo(datasPosicaoJ) > 0){
                houveTroca = true;
                lista[i + 1] = lista[i];
                datas[i + 1] = datas[i];
                i--;
            }

            if(!houveTroca){
                return;
            }
            lista[i + 1] = chave;
            datas[i + 1] = datasPosicaoJ;
        }

    }
}
