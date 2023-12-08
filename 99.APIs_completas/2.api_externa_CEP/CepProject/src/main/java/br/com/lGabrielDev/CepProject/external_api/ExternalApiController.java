package br.com.lGabrielDev.CepProject.external_api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.lGabrielDev.CepProject.models.address.Address;


//usaremos essa interface para representar a "controller class" da api externa
@FeignClient(
    name = "viacep",
    url = "viacep.com.br/ws/" //representa o @RequestMapping/rota padrao da api externa
)
public interface ExternalApiController {
    
    
    
    // ===================================== GET Cep =====================================
    @GetMapping("{cep}/json/") //vamos mandar um request pra esse rota
    public Address findCep(@PathVariable(name = "cep") String cep); //o "cep" vamos informar quando usarmos esse method   
}
