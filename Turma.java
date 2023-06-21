package com.mycompany.poodisciplinas;

import java.util.*;
import java.io.*;

public class Turma implements Comparable<Turma>{
    protected String Nome_Disciplina;
    protected int Ano, Semestre;
    protected Professor Responsavel;
    protected List<AlunoNota> Lista_Alunos;

    public Turma(BufferedReader b) {
        this.Lista_Alunos = new ArrayList<AlunoNota>();
        try{
            this.Nome_Disciplina = b.readLine();
            this.Ano = Integer.parseInt(b.readLine());
            this.Semestre = Integer.parseInt(b.readLine());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    public void organizarTurma(){
        Collections.sort(this.Lista_Alunos, Collections.reverseOrder());
    }
    
    public void popularTurma (Professor Responsavel, ArrayList<Aluno> ListaCompletaAlunos, BufferedReader b){
        this.Responsavel = Responsavel;
        double nota;
        String matricula;
        AlunoNota aux;
        int count;
        try{
            count = Integer.parseInt(b.readLine());
            for (int i = 0; i < count; i++){
                try{
                    matricula = b.readLine();
                    nota = Double.parseDouble(b.readLine());
                    aux = new AlunoNota(this.procuraAluno(ListaCompletaAlunos, matricula), nota );
                    this.Lista_Alunos.add(aux);
                }
                catch(AlunoNotFoundException e){
                    System.out.println("Aluno não encontrado");
                }
            }
            this.organizarTurma();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public Aluno procuraAluno(ArrayList<Aluno> ListaAlunos, String matricula) throws AlunoNotFoundException{
        for (Aluno aluno : ListaAlunos){
            if (aluno.Matricula.equals(matricula)){
                return aluno;
            }
        }
        throw new AlunoNotFoundException();
    }
    
    public int compareTo(Turma turma){
        if (this.Ano > turma.Ano) return 1;
        if (this.Ano < turma.Ano) return -1;
        
        if (this.Semestre > turma.Semestre) return 1;
        if (this.Semestre < turma.Semestre) return -1;
        
        if (this.Nome_Disciplina.compareTo(turma.Nome_Disciplina) == 0){
            return this.Responsavel.compareTo(turma.Responsavel);
        }
        
        return this.Nome_Disciplina.compareTo(turma.Nome_Disciplina);
    }
}
