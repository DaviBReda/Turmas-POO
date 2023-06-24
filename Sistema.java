package com.mycompany.poodisciplinas;

import java.util.*;
import java.io.*;

public class Sistema {
    protected ArrayList<Aluno> Alunos;
    protected List<Professor> Professores;
    protected List<Turma> Turmas;

    public Sistema(){
        this.Alunos = new ArrayList<Aluno>();
        this.Professores = new ArrayList<Professor>();
        this.Turmas = new ArrayList<Turma>();
        
        this.populaAlunos();
        this.populaProfessores();
        this.populaTurmas();
    }
    
    
    private void populaAlunos(){
        try{
            FileReader f = new FileReader("alunos.txt");
            BufferedReader b = new BufferedReader(f);
            
            int c = Integer.parseInt(b.readLine());
            Aluno aux;
            
            for (int i = 0; i<c; i++){
                aux = new Aluno(b);
                this.Alunos.add(aux);
            }
            b.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void populaProfessores(){
        try{
            FileReader f = new FileReader("professores.txt");
            BufferedReader b = new BufferedReader(f);
            
            int c = Integer.parseInt(b.readLine());
            Professor aux;
            
            for (int i = 0; i<c; i++){
                aux = new Professor(b);
                this.Professores.add(aux);
            }
            b.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void populaTurmas(){
        try{
            FileReader f = new FileReader("turmas.txt");
            BufferedReader b = new BufferedReader(f);
            
            int c = Integer.parseInt(b.readLine());
            String cpf;
            Turma aux;
            
            for (int i = 0; i<c; i++){
                aux = new Turma(b);
                cpf = b.readLine();
                aux.popularTurma(this.procuraProfessor(cpf), this.Alunos, b);
                this.Turmas.add(aux);
            }
            Collections.sort(this.Turmas);
            b.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ProfessorNotFoundException e){
            System.out.println("Aviso: Professor nao encontrado.");
            System.exit(-1);
        }
    }
    
    public Professor procuraProfessor(String cpf) throws ProfessorNotFoundException{
        for (Professor professor : this.Professores){
            if (professor.Cpf.equals(cpf)){ 
                return professor;
            }
        }
        throw new ProfessorNotFoundException();
    }
    
    public void exibirNotas(){
        int count;
        try{
            FileWriter f = new FileWriter("resultado.txt");
            BufferedWriter b = new BufferedWriter(f);
            
            for (Turma turma : this.Turmas){
                b.write(turma.Nome_Disciplina+" ("+turma.Ano+"/"+turma.Semestre+")"+ " - "+turma.Responsavel.Nome+"\n");
                count = turma.Lista_Alunos.size();
                for (int i = 0; i<count; i++){
                    b.write("- "+turma.Lista_Alunos.get(i).Aluno.Nome+" ("+turma.Lista_Alunos.get(i).Aluno.Matricula+"): "+turma.Lista_Alunos.get(i).Nota+"\n");
                }
            }
            b.close();
        }
        catch(IOException e){
            System.out.println("Erro ao escrever arquivo resultado.txt");
        }
    }
}
