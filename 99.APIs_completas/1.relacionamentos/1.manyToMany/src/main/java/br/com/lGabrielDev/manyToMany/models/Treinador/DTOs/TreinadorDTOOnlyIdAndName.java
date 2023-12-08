package br.com.lGabrielDev.manyToMany.models.Treinador.DTOs;

import br.com.lGabrielDev.manyToMany.models.Treinador.Treinador;

public class TreinadorDTOOnlyIdAndName {

        //attributes
        private Long id;
        private String name;


        //constructors
        public TreinadorDTOOnlyIdAndName(){}

        public TreinadorDTOOnlyIdAndName(Long id, String name){
            this.name = name;
        }

        public TreinadorDTOOnlyIdAndName(Treinador treinadorCru){
            this.id = treinadorCru.getId();
            this.name = treinadorCru.getName();
        }
    
    
    
        //getters and setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }


        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
    
        //toString(){}
        @Override
        public String toString(){
            return
                String.format(
                    "#ID: %d\n" +
                    "Name: %s\n", this.id ,this.name);
        }

        
    
}
