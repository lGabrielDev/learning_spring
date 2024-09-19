package br.com.lGabrielDev.praticandinho.person.validations;

import br.com.lGabrielDev.praticandinho.address.Address;
import br.com.lGabrielDev.praticandinho.external.ViaCepController;

public abstract class PersonValidations {
    
    // O campo "name" e o campo "cep" não podem ser NULL
    public static Boolean nameAndCepAreNotNull(String name, String cep){
        String errorMessage = "";

        if(name == null || cep == null){
            if(name == null){
                errorMessage = "'Name' cannot be null!";
            }
            else{
                errorMessage = "cep cannot be null!";
            }
            throw new RuntimeException(errorMessage);
        }
        return true;
    }


    // Um cep possui exatamente 8 dígitos. Nem mais, nem menos.
    public static Boolean cepLengthIs8(String cep){
        if(cep.length() != 8){
            throw new RuntimeException("Cep length must be 8. Not more, not less.");
        }
        return true;
    }


    // O cep só estará correto, se tiver apenas numbers. Não pode ter letras.
    // Para isso, criamos um method para percorrer todas as letras de uma String.
    // Tentamos transformar cada letra dessa String em um Integer Se retornar true, quer dizer que todas as letrar conseguiram ser convertidas para Integer.
    public static Boolean cepOnlyHasNumbers(String cep){
        cep.chars().forEach((c) ->{
            if(!(Character.isDigit(c))){ //method static criado pelo proprio Java, na class Character. Se não for digito (1,2,3....) lancamos a exception
                throw new RuntimeException("CEP deve conter apenas numbers");
            }
        });
        return true;
    }


    //verificamos se o cep existe. Pra isso, só consultar o campo "bairro", ou qualquer outro campo, e verificar se ele não é null
    public static Boolean cepExiste(String cep, ViaCepController viaCepController){
        Address addressCru = viaCepController.getAddressByCep(cep);
        String bairro = addressCru.getBairro();

        if(bairro == null){
            throw new RuntimeException("Cep não existe!");
        }
        return true;
    }

    
    //vamos remover o '-' do attribute cep. O attribute 'cep', do objeto JSON, vem acompanhado de '-'. Nao queremos isso. Queremos apenas numbers.
    public static String removerTraco(String cep){
        return cep.replace("-", "");
    }
}