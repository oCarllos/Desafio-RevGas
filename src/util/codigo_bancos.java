package util;

public class codigo_bancos {   

    private int id;
    private String instituicao;

    public codigo_bancos(int id, String instituicao) {
        this.id = id;
        this.instituicao = instituicao;
    }
    
    public int id(){
        return id;
    }
    
    public String instituicao(){
        return instituicao;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setInstituicao(String instituicao){
        this.instituicao = instituicao;
    }
}

