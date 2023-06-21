package com.mycompany.poodisciplinas;

import java.io.*;


public class Professor extends Pessoa implements Comparable<Professor>{
    
    public Professor(BufferedReader b) {
        super(b);
    }
    
    
    public int compareTo(Professor prof){
        if (this.Nome.compareTo(prof.Nome) == 0){
            return this.Cpf.compareTo(prof.Cpf);
        }
        return this.Nome.compareTo(prof.Nome);
    }
}
