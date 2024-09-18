package Classes.fileHandling;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class InsaneMethods{

    // ################## Verificar os arquivos ##################
    public static List<String> arquivosNaoEncontrados(String... filesToCheck) {
        List<String> arquivosNaoEncontrados = new ArrayList<>();
        
        for(String i : filesToCheck){
            File file = new File(i); //nao precisar usar o FileReader ou BufferedReader
            
            if(!(file.exists())){
                arquivosNaoEncontrados.add(i);
            }
        }
        return arquivosNaoEncontrados;
    }

    public static List<String> arquivosEncontrados(String... filesToCheck) {
        List<String> arquivosEncontrados = new ArrayList<>();
        
        for(String i : filesToCheck){
                File file = new File(i);


                if(file.exists()){
                    arquivosEncontrados.add(i);
                }
            }
        return arquivosEncontrados;
    }


    // ################## ler arquivos ##################
    public static String lerArquivo(String filePath){
        
        File file = new File(filePath);
        String conteudoArquivo = "";
    
        try{
            Scanner scan = new Scanner(file); // para ler arquivos com a class Scanner, voce precisa informar um "File"
            do{
                conteudoArquivo += scan.nextLine() + "\n";
            }
            while(scan.hasNextLine());
            scan.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found!");
        }
        return conteudoArquivo;
    }

    // ################## Printar arquivos ##################
    public static void printarArquivosNaoEncontrados(List<String> arquivosNaoEncontrados){
        System.out.println(String.format(" \n###### Arquivos NAO encontrados (%d) ######", arquivosNaoEncontrados.size()));
        for(String i : arquivosNaoEncontrados){
            System.out.println("- " + i);
        }
    }
    
    public static void printarArquivosEncontrados(List<String> arquivosEncontrados){
        System.out.println(String.format(" \n###### Arquivos encontrados (%d) ######", arquivosEncontrados.size()));
        for(String i : arquivosEncontrados){
            System.out.println("- " + i + "\n");
            System.out.println(lerArquivo(i) + "\n");  
        }
    }
}