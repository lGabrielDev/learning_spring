package br.com.lGabrielDev.manyToMany.models.Pokemon;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.lGabrielDev.manyToMany.enums.PokemonPower;
import br.com.lGabrielDev.manyToMany.methodsLegais.MethodsLegais;
import br.com.lGabrielDev.manyToMany.models.Pokemon.DTOs.PokemonDTOCreate;
import br.com.lGabrielDev.manyToMany.models.Pokemon.DTOs.PokemonDTOFull;
import br.com.lGabrielDev.manyToMany.models.Pokemon.DTOs.PokemonDTOQuantidadeTreiadores;
import br.com.lGabrielDev.manyToMany.models.Pokemon.contracts.PokemonImplementations;

@Service
public class PokemonService implements PokemonImplementations{

    //attributes injetados
    @Autowired
    private PokemonRepository pr;

    

    // =================================================== CREATE ===================================================
    @Override
    public PokemonDTOFull createPokemon(PokemonDTOCreate pokemonRecebido) {

        //faremos as verificacoes:
        /*
         * - Campo "name" nao pode ser null
         * - Campo "power" nao pode ser null
         *      - Campo "power" só podera receber os "powers" existentes no enum: ['grass', 'electricity', 'fire', 'water'] VAMOS TRATAR PELO EXCEPTION HANDLER
         */
        if(pokemonRecebido.getName() == null){
            throw new RuntimeException("O campo NAME precisa ser informado");//depois usamos uma exception propria melhor
        }
        if(pokemonRecebido.getPower() == null){
            throw new RuntimeException("O campo POWER precisa ser informado");//depois usamos uma exception propria melhor
        }

        
        //verificamos seo "power" está correto:  ['grass', 'electricity', 'fire', 'water']
        if(!(MethodsLegais.powerIsCorrect(pokemonRecebido.getPower()))){
            throw new RuntimeException("Informe um 'power' correto: ['grass', 'electricity', 'fire', 'water'] ");
        }


        //tudo certinho?? Cadastramos esse pokemon no banco
        Pokemon pokemonCru = new Pokemon();
        pokemonCru.setName(pokemonRecebido.getName());
        
        //dependendo do "power" informado, setamos o power ideal
        if(pokemonRecebido.getPower().toLowerCase().equals("electricity"))
        pokemonCru.setPower(PokemonPower.ELECTRICITY);

        if(pokemonRecebido.getPower().toLowerCase().equals("fire"))
        pokemonCru.setPower(PokemonPower.FIRE);

        if(pokemonRecebido.getPower().toLowerCase().equals("water"))
        pokemonCru.setPower(PokemonPower.WATER);

        if(pokemonRecebido.getPower().toLowerCase().equals("grass"))
        pokemonCru.setPower(PokemonPower.GRASS);

        this.pr.save(pokemonCru); //salvamos no banco
        
        //criamos um DTOzinho full, para retornar um pokemon com todos os attributes 
        PokemonDTOFull pokemonDtoFull = new PokemonDTOFull(pokemonCru);

        return pokemonDtoFull;
    }



    



    // =================================================== READ ===================================================

    //Find By #ID
    @Override
    public PokemonDTOFull getPokemon(Long id) {

        Optional<Pokemon> pOptional = this.pr.findById(id);

        if(pOptional.isEmpty()){
            throw new RuntimeException(String.format("Pokemon #%d não existe.", id));
        }

        Pokemon p1 = pOptional.get();


        //retornamos um DTozinho completinho com todos os attributes desse pokemon
        return new PokemonDTOFull(p1);
    }




    //Find By #All
    @Override
    public List<PokemonDTOQuantidadeTreiadores> getAllPokemons() {
        List<Pokemon> pokemonsCrus = this.pr.findAll();

        return PokemonDTOQuantidadeTreiadores.converterPokemons(pokemonsCrus);
    }    
    
}
