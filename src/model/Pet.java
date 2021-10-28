package model;

public class Pet {
    private int id;
    private int tutorId;
    private String nome;
    private String relatorio;
    private String especie;
    private String raca;
    private int idade;

    public Pet(String nome, int id, int tutorId){
        this.nome = nome;
        this.id = id;
        this.tutorId = tutorId;
    }
    
        public Pet(String nome, int id){
        this.nome = nome;
        this.id = id;
    }
        
    public Pet(int id){
        this.id = id;
    }
    
     public Pet(String nome, String relatorio, String especie, String raca, int idade){
        this.nome = nome;
        this.relatorio = relatorio;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
    }
     
    public Pet(String nome, String especie, String relatorio,  String raca, int idade, int tutorID, int id){
        this.nome = nome;
        this.relatorio = relatorio;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.tutorId = tutorID;
        this.id = id;
    }
     
    public Pet(int donoId, String nome, String relatorio, String especie, String raca, int idade){
        this.tutorId = donoId;
        this.nome = nome;
        this.relatorio = relatorio;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
    }
   
    public int getTutorId() {
        return tutorId;
    }

    public void setTutorId(int tutorId) {
        this.tutorId = tutorId;
    }
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    
    public void setTutorID(int id) {
        this.tutorId = id;
    }

    public int getTutorID() {
        return tutorId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
}
