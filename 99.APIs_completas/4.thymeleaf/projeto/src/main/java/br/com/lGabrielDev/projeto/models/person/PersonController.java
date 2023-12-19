package br.com.lGabrielDev.projeto.models.person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.lGabrielDev.projeto.models.person.dtos.PersonCreateDto;
import jakarta.validation.Valid;
import java.util.*;


@Controller //vamos retornar paginas html
@RequestMapping("/v1/api")
public class PersonController {

    //injected attributes
    @Autowired
    private PersonService ps;
    

    

    // ============================= READ ============================
    //read all
    @GetMapping("/person")
    public ModelAndView rotaTeste(){
        ModelAndView mv = new ModelAndView("/read/readAll.html");
        mv.addObject("personList", this.ps.getAllPerson()); //agora, essa pagina html tera acesso a lista de pessoas do banco de dados
        return mv;
    }




    // ============================= CREATE ============================
    @GetMapping("/person/new")
    public ModelAndView formularioParaCriarUmaNovaPerson(){ 
        ModelAndView mv = new ModelAndView("/create/createForm.html");
        mv.addObject("person1DTO", new PersonCreateDto()); //precisamos passar um dtozinho para nossa pagina html conseguir usar o th:object
        return mv;
    }




    @PostMapping("/person")
    public ModelAndView recebendoObjetoDoFormulario(@Valid PersonCreateDto personInformadaNoBody, BindingResult br){


        //validamos os attributes/inputs enviados
        if(br.hasErrors()){
            
            //pegamos todos os erros de input/validacao e enviamos para a view html
            List<FieldError> errosCrusFieldName = br.getFieldErrors("name");
            List<FieldError> errosCrusFieldAge = br.getFieldErrors("age");

            List<String> errosFieldNameEmString = new ArrayList<>();
            List<String> errosFieldAgeEmString = new ArrayList<>();

            errosCrusFieldName.stream().forEach(item -> errosFieldNameEmString.add(item.getDefaultMessage()));
            errosCrusFieldAge.stream().forEach(item -> errosFieldAgeEmString.add(item.getDefaultMessage()));


            ModelAndView mv = new ModelAndView("/create/createForm.html"); //vamos retornar a mesma pagina, juntamente com os erros dos inputs, informados automaticamente pelo BindingResult
            mv.addObject("person1DTO", new PersonCreateDto()); //precisamos passar um dtozinho para nossa pagina html conseguir usar o th:object

            mv.addObject("listaDeErrosCampoName", errosFieldNameEmString);
            mv.addObject("listaDeErrosCampoAge", errosFieldAgeEmString);
            return mv;
        }


        //vamos cadastrar essa pessoa no banco
        this.ps.createPerson(personInformadaNoBody);
        ModelAndView mv = new ModelAndView("/read/readAll.html"); //apos cadastrar uma "person", vamos redirecionar para a pagina contendo a lista de persons
        mv.addObject("sucessCreatedMessage", "Person criada com sucesso!");
        mv.addObject("personList", this.ps.getAllPerson()); //agora, essa pagina html tera acesso a lista de pessoas do banco de dados
        return mv;
    }

    
    // ============================= UPDATE ============================
    //formulario para editar
    @GetMapping("/person/{id}/edit")
    public ModelAndView formularioParaEditarUmRegistro(@PathVariable(value = "id") Long id){
        //verificamos se de fato existe uma 'person' com esse #ID
        Boolean idIsCorrect = this.ps.personIdIsCorrect(id);

        //nao existindo, lancamos uma pagina de erro
        if(!(idIsCorrect)){
            ModelAndView mv = new ModelAndView("/exceptions/idNotFoundException.html");
            mv.addObject("personIdNotFound", String.format("ID #%d not found", id));
            return mv;
        }

        //se existir, vamos passar os dados dessa pessoa, atraves do #ID
        Person personToBeUpdated = this.ps.getPersonById(id);


        ModelAndView mv = new ModelAndView("/update/updateForm.html");
        mv.addObject("personToBeUpdated", personToBeUpdated); //enviamos os dados da "pessoa" que queremos atualizar
        mv.addObject("personCreateDto", new PersonCreateDto()); //enviamos um dtoziho para essa view conseguir enviar no formulario
        return mv;
    }





    //rota posta que vai receber o JSON enviado pelo formulario
    @PostMapping("/person/{id}")
    public ModelAndView receberDadosParaAtualizar(@PathVariable(value = "id") Long id, @Valid @ModelAttribute PersonCreateDto personDtoInformadoNoBody, BindingResult br){
        
        Person personToBeUpdated = this.ps.getPersonById(id);

       
        //validamos os inputs
        if(br.hasErrors()){

            //criamos uma lista de erros para enviar para a view
            List<FieldError> listaErrosCruaCampoName = br.getFieldErrors("name");
            List<FieldError> listaErrosCruaCampoAge = br.getFieldErrors("age");
            //pegamos apenas as mensagens desses erros
            List<String> mensagensErroCampoName = new ArrayList<>();
            List<String> mensagensErroCampoAge = new ArrayList<>();

            listaErrosCruaCampoName.stream().forEach((item) -> mensagensErroCampoName.add(item.getDefaultMessage()));
            listaErrosCruaCampoAge.stream().forEach((item) -> mensagensErroCampoAge.add(item.getDefaultMessage()));


            ModelAndView mv = new ModelAndView("/update/updateForm.html");
            mv.addObject("personToBeUpdated", personToBeUpdated); //enviamos os dados da "pessoa" que queremos atualizar
            mv.addObject("personCreateDto", new PersonCreateDto()); //enviamos um dtoziho para essa view conseguir enviar no formulario
            mv.addObject("listaErrosCampoName", mensagensErroCampoName); //enviamos para a view html essa lista de erros do campo "name"
            mv.addObject("listaErrosCampoAge", mensagensErroCampoAge); //enviamos para a view html essa lista de erros do campo "age"
            return mv;
        }
    
        //inputs corretos, atualizamos no banco
        this.ps.updatePerson(id, personDtoInformadoNoBody);

        ModelAndView mv = new ModelAndView("/read/readAll.html");
        mv.addObject("personList", this.ps.getAllPerson()); //agora, essa pagina html tera acesso a lista de pessoas do banco de dados
        mv.addObject("updatedSucess", String.format("Registro #%d atualizado com sucesso!", id));

        return mv;
    }





    // ============================= DELETE ============================
    @GetMapping("/person/delete/{id}")
    public ModelAndView deletePersonById(@PathVariable(value = "id") Long id){
        
        Boolean personWasDeleted = this.ps.deletePersonById(id);

        if(personWasDeleted){
            ModelAndView mv = new ModelAndView("/read/readAll.html"); //redirecionamos para a rota de listar todas as persons
            mv.addObject("deletedSucess", String.format("ID #%d was successfully deleted", id));
            mv.addObject("personList", this.ps.getAllPerson());
            
            return mv;
        }
        
        //se o id estiver errado...
        ModelAndView mv = new ModelAndView("/exceptions/idNotFoundException.html");
        mv.addObject("personIdNotFound", String.format("ID #%d not found", id));
        return mv;
    }
}
