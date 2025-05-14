package br.com.projetoleda.QuickSort;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class OrdenarDatasQuickSortPiorCaso {
    private static final String caminhoArquivoParaSerLido = "./Dados/games_releaseData_Invertido.csv";
    private static final String CAMINHO_ARQUIVO_GERADO = "./Dados/games_releaseData_QuickSort_medioCaso.csv";

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
                else if(record.size() > 2){
                    lista[i] = record;
                    i++;
                }
                
            }
            
            quickSort(lista, 0, i- 1);

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
        Date pivot = extrairValor(lista, primeiroIndice);
        int i = primeiroIndice + 1;
        int j = ultimoIndice;

        while(i <= j){
            Date dataPosicaoI = extrairValor(lista, i);
            Date dataPosicaoJ = extrairValor(lista, j);
           
            
            if(dataPosicaoI.compareTo(pivot) <= 0){
                i++;
            }
            else if(dataPosicaoJ.compareTo(pivot) > 0){
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

    public static Date extrairValor(CSVRecord[] lista, int indice){
        try{

            String data = lista[indice].get(2);
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            dataFormatada.setLenient(false);

            return dataFormatada.parse(data);

        }catch(ParseException | NullPointerException e ){

            try{
                return new SimpleDateFormat("dd/MM/yyyy").parse("01/01/0001");
            } catch(ParseException ex){
                return new Date(0);
            }
        }
    }
}
