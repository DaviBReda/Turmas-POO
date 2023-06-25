package com.mycompany.poodisciplinas;

import java.io.*;

public class Aluno extends Pessoa implements Comparable<Aluno>{
    protected String Matricula;

    public Aluno(BufferedReader b) {
        super(b);
        try{
            this.Matricula = b.readLine();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    public int compareTo(Aluno aluno){
        if (this.Nome.compareTo(aluno.Nome) == 0){
            return this.Cpf.compareTo(aluno.Cpf);
        }
        return (this.Nome.compareTo(aluno.Nome)*-1);
    }
}
