package Classes.fileHandling;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class WritterMethodsInsanos {

    // ============== read a file ==============
    public static String readFile(File file){
        String fileContent = "";
        String nextLine = "";

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            nextLine = br.readLine();

            while(nextLine != null){
                fileContent += nextLine + "\n";
                nextLine = br.readLine();
            }
            br.close();
        }
        catch(IOException e){
            System.out.println(String.format("You cannot read file \"%s\"", file.getPath()));
        }
        return fileContent; 
    }


    // ============== write in a file ==============
    public static void writeInAFile(File fileToReceive, String fileContent){

        if(fileToReceive.exists()){
            try{
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileToReceive, false));
                bw.write(fileContent);
                bw.close();
                System.out.println(String.format("\"%s\" recebeu o conteudo com sucesso!", fileToReceive.getPath()));
            }
            catch(IOException e){
                System.out.println(String.format("\"%s\" file not found", fileToReceive.getPath()));
            }
        }
        else{
            System.out.println(String.format("\"%s\" file not found", fileToReceive.getPath()));
        }    
    }


    // ============== copy file content ==============
    public static void copyContentFile(File fileToCopy, File fileToReceive){
        
        //check if the files exists
        if(!(fileToCopy.exists())){
            try{
                throw new FileNotFoundException(String.format("\"%s\" file not found", fileToCopy.getPath()));
            }
            catch(FileNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
        else if(fileToReceive.exists()){ //arquivo ja existe. Nao podemos editar um arquivo que ja exista, sacou?
            try{
                throw new FileNotFoundException(String.format("\"%s\" file already exists", fileToReceive.getPath()));
            }
            catch(FileNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
        //agora sim, o arquivo pra copiar existe e o arquivo que vai receber ainda nao existe. Vamos copiar o arquivo para o mesmo diretorio
        else{
            String fileContent = readFile(fileToCopy);
            //criar um novo arquivo tal
            File arquivoNovinho = new File(fileToReceive.getPath());
            
            try{
                if(arquivoNovinho.createNewFile()){ //criamos o arquivo
                    System.out.println(String.format("%s criado com sucesso!", fileToReceive.getPath()));
                }
            }
            catch(IOException e){
                System.out.println("Erro ao criar arquivo");
            }
            WritterMethodsInsanos.writeInAFile(arquivoNovinho, fileContent);            
        }
    }
}