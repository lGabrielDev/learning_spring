package br.com.lGabrielDev.CepProject.models.address;


public class MethodsLegais {
    
    //methods legais

    public static Boolean cepHasOnlyNumbers(String cepParaVerificar){

        Character character = 'a'; //character representando cada letra da String

        //vamos percorrer todas as letras da String
        for(int i=0; i<cepParaVerificar.length(); i++){
            character = cepParaVerificar.charAt(i); //recebe a primeira letra/character da String

            //tentamos converter esse character para um Integer
            try{
                Integer.parseInt(String.valueOf(character));
            }
            catch(NumberFormatException e){
                return false; //retornamose saimos do loop
            } 
        }
        return true; //se nao cair no catch, quer dizer que a String só possui Integer
    }
}
