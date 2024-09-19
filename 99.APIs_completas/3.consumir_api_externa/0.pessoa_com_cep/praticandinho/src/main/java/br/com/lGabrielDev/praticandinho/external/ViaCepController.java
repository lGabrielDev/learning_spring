package br.com.lGabrielDev.praticandinho.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.lGabrielDev.praticandinho.address.Address;

//usaremos essa interface para representar a "controller class" da api externa
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws") //setamos a url/@requestMapping padrao
public interface ViaCepController {
    

    // ====================== GET ======================
    @GetMapping("/{cep}/json")
    public Address getAddressByCep(@PathVariable("cep") String cep);
}
