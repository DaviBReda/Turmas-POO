package com.mycompany.poodisciplinas;

import java.io.*;

public abstract class Pessoa {
    protected String Nome;
    protected String Cpf;

    public Pessoa(BufferedReader b) {
        try {
            this.Nome = b.readLine();
            this.Cpf = b.readLine();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
}
