package br.com.lGabrielDev.CepProject.external_api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lGabrielDev.CepProject.models.address.Address;

@RestController
@RequestMapping("/api/")
public class ControllerTeste {
    
    @Autowired
    private ExternalApiController epc;

    
    //rotas
    @GetMapping("{cep}")
    public Address getAddress(@PathVariable(name = "cep") String cep){
        return epc.findCep(cep);
    }
}
