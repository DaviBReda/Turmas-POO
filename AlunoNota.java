package com.mycompany.poodisciplinas;


public class AlunoNota implements Comparable<AlunoNota>{
    protected Aluno Aluno;
    protected double Nota;

    public AlunoNota(Aluno Aluno, double Nota) {
        this.Aluno = Aluno;
        this.Nota = Nota;
    }
    
    
    public int compareTo(AlunoNota alunoNota){
        if (this.Nota > alunoNota.Nota) return 1;
        if (this.Nota < alunoNota.Nota) return -1;
        
        return this.Aluno.compareTo(alunoNota.Aluno);
    }
}
