package Classes.person;

public class Person{
    
    //attributes
    private String name;
    private Integer age;
    private Gender gender;

    //constructors
    public Person(){}

    public Person(String name){
        this.name = name;
    } 

    public Person(String name, Integer age, Gender gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    //getters and setters
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender(){
        return this.gender;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }
    


    //toString()
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
    
    //equals
    // @Override
    // public boolean equals(Object obj) {
    //     Person p = (Person) obj;
    //     return
    //         this.getName().equals(p.getName()) &&
    //         this.getAge() == p.getAge();
    // }
}