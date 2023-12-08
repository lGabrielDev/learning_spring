package br.com.lGabrielDev.manyToMany.models.Treinador;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.lGabrielDev.manyToMany.models.Pokemon.Pokemon;
import br.com.lGabrielDev.manyToMany.models.Pokemon.PokemonRepository;
import br.com.lGabrielDev.manyToMany.models.Treinador.DTOs.TreinadorDTOCreateOnlyName;
import br.com.lGabrielDev.manyToMany.models.Treinador.DTOs.TreinadorDTOFull;
import br.com.lGabrielDev.manyToMany.models.Treinador.DTOs.TreinadorDTOQuantidadePokemons;
import br.com.lGabrielDev.manyToMany.models.Treinador.contracts.TreinadorImplementations;

@Service
public class TreinadorService implements TreinadorImplementations{
    
    //attributes injetados
    @Autowired
    private TreinadorRepository tr;

    @Autowired
    private PokemonRepository pr;


    // =============================== CREATE ===============================
    public TreinadorDTOFull createTreinador(TreinadorDTOCreateOnlyName novoTreinador){

        //se nao for informado o campo 'Name' nao permitimos o cadastro
        if(novoTreinador.getName() == null){
            throw new RuntimeException("PREENCHA O CAMPO 'NAME'"); //depois lancamos um erro melhor
        }
    
        
        //criamos um "treinador Cru" para salvarmos no banco
        Treinador treinadorCru = new Treinador();
        treinadorCru.setName(novoTreinador.getName());
        this.tr.save(treinadorCru);

        //criamos um DTOzinho para retornar todos os attributes desse treinador
        TreinadorDTOFull tdfull = new TreinadorDTOFull(treinadorCru);
        return tdfull;
    }




    // =============================== Adicionar Pokemons ===============================
    @Override
    public TreinadorDTOFull addPokemons(Long treinadorId, List<Long> pokemonsIds) {

        System.out.println("\n\n\n\n=================================\n");
        System.out.println("Treinador #ID: " + treinadorId);
        System.out.println("Pokemon #Ids: " + pokemonsIds.toString());
        
        //verificamos se o #ID do treinador existe no banco
        Optional<Treinador> tOptional = this.tr.findById(treinadorId);

        if(tOptional.isEmpty()){
            throw new RuntimeException(String.format("Treinador #%d não existe no banco",treinadorId));
        }
        //Se o teinador existir, resgatamos esse treinador do banco
        Treinador treinadorCru = tOptional.get();

        //verificamos se os pokemons informados existem no banco. Se 1 deles nao existir, o treinador nao recebe nenhum pokemon
        for(Long i : pokemonsIds){

            Optional<Pokemon> pOptional = this.pr.findById(i);
            if(pOptional.isEmpty()){
                throw new RuntimeException(String.format("Não foi possível cadastrar os pokemons, pois o Pokemon '#%d' não existe no banco", i));
            }
            //se nao tiver sido lancado o erro acima, quer dizer que todos os pokemon #Ids informados, existem no banco
        }


        //TUDO CERTO... O treinador existe E os pokemons tambem existem. 
        //Agora, precisamos verificar se o treinador já possui algum dos pokemons informados.
        for(Long j : pokemonsIds){
            Optional<Pokemon> pOptional = this.pr.findById(j);
            Pokemon pokemonCru = pOptional.get();

            if(treinadorCru.getPokemons().contains(pokemonCru)){
                throw new RuntimeException(String.format("O treinador já possui o pokemon #%d.", j));
            }
        }

        //TUDO CERTO....
        /*
         * Treinador existe no banco...
         * Pokemons eixstem no banco...
         * Treinador nao possui nenhum desses pokemons...
         * 
         */
    
        //Agora, é só fazer o relacionamento bidimensional
        //   Adicionamos esses pokemons ao treinador
        //   Adicionamos esse treinador em todos esses pokemons
        
        for(Long i : pokemonsIds){
            Optional<Pokemon> pOptional = this.pr.findById(i);
            Pokemon pokemonCru = pOptional.get(); //sabemos que esse pokemon existe no banco

            //verificamos se determinado pokemon já existe na lista desse treinador
            
            
            //tudo ok, o treinador nao possui nenhum dos pokemons informados

            treinadorCru.getPokemons().add(pokemonCru); //Adicionamos o pokemon ao treinador
            pokemonCru.getTreinadores().add(treinadorCru); //Ao mesmo tempo, adicionamos esse treinador a esse pokemon

            this.pr.save(pokemonCru); // Atualizamos esse pokemon, que recebeu um treinador
        }
        //depois de adicionar todos os pokemons no treinador, salvamos no banco esse treinador
        this.tr.save(treinadorCru); // Atualizamos esse treinador, que recebeu pokemons
        



        //criamos um DTOFULL para retornar todos os attributes desse Treinador, inclusive os pokemons que foram adicionados
        TreinadorDTOFull treinadordtozinhoFull = new TreinadorDTOFull(treinadorCru);
        return treinadordtozinhoFull;

    }




    // =============================== READ ===============================
    //Find By #ID
    @Override
    public TreinadorDTOFull getTreinador(Long treinadorId) {
        Optional<Treinador> tOptional = this.tr.findById(treinadorId);
        
        if(tOptional.isEmpty()){
            throw new RuntimeException(String.format("Treinador #%d não existe no banco", treinadorId));
        }

        Treinador treinadorCru = tOptional.get();

        return new TreinadorDTOFull(treinadorCru);
        
    }



    //Find All - O usuario vai decidir se deseja retornar:
    //1- Find All sem filtro, listando todos os treinadores
    //2- FindBy All, filtrando por determinado "pokemon name"
    
    @Override
    public List<TreinadorDTOQuantidadePokemons> getTreinadores(String pokemonName, Integer quantidadePokemons) {
        
        List<Treinador> treinadoresCrus = new ArrayList<>();

        if(pokemonName == null && quantidadePokemons == null){
            treinadoresCrus = this.tr.findAll();
        }
        else if(pokemonName != null && quantidadePokemons == null){
            treinadoresCrus = this.tr.findAll(pokemonName); //informamos o filtro
        }
        else if(pokemonName == null && quantidadePokemons != null){
            treinadoresCrus = this.tr.findAll(quantidadePokemons);
        }
        else{
            treinadoresCrus = this.tr.findAll(pokemonName, quantidadePokemons);
        }
        

        TreinadorDTOQuantidadePokemons tQuatPokemons = new TreinadorDTOQuantidadePokemons();
        return tQuatPokemons.converterTreinadores(treinadoresCrus);
        
    }



    
}
