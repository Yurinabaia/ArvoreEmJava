
public class TurmaBasica {

	public static void main(String[] args) {
		Aluno	alunoNovo,	alunoPesquisado;
        ABBAlunos turma = new ABBAlunos();

        if (turma.arvoreVazia())
            System.out.println("A turma está vazia."); /// Essa mensagem deve ser exibida.
        else
            System.out.println("A turma possui alunos matriculados.");

        alunoNovo = new Aluno (5, "Amanda", 85.00);
        turma.inserir(alunoNovo);

        alunoNovo = new Aluno(8, "Uriel", 87.00);
        turma.inserir(alunoNovo);

        alunoNovo = new Aluno(6, "Ivo", 75.00);
        turma.inserir(alunoNovo);

        alunoNovo = new Aluno(3, "Olivia", 90.00);
        turma.inserir(alunoNovo);

        alunoNovo = new Aluno(2, "Julia", 88.00);
        turma.inserir(alunoNovo);

        alunoNovo = new Aluno(9, "Elaine", 85.00);
        turma.inserir(alunoNovo);

        alunoNovo = new Aluno(4, "Sônia", 82.00);
        turma.inserir(alunoNovo);

        alunoNovo = new Aluno(6, "Ivo", 75.00);
        turma.inserir(alunoNovo); /// Deve ser exibida a mensagem: "O aluno Ivo, cuja matrícula é 6, já foi inserido anteriormente na árvore."
	
        System.out.println("Número	de	alunos	matriculados	na	turma:	" +	turma.numAlunos());	///	

        
    	System.out.println("Resultado	da	pesquisa	pelo	aluno	de	número	de	matrícula	3:");
		alunoPesquisado =	turma.buscar(3);
		if (alunoPesquisado !=	null)
		{
			alunoPesquisado.imprimir();	///	Olivia - 3	- 90.0
		}
		
	
        



        turma.remover(23); /// Deve ser exibida a mensagem: "O aluno, cuja matrícula é 23, não foi encontrado."

        turma.remover(5);
        
        turma.remover(3);
        
        turma.remover(4);
        System.out.println("Número	de	alunos	matriculados	na	turma:	" +	turma.numAlunos());	///	


        
        turma.remover(8);
        
        turma.remover(6);
        
        turma.remover(9);
        
        turma.remover(9); /// Deve ser exibida a mensagem: "O aluno, cuja matrícula é 9, não foi encontrado."
        
        turma.remover(2);
        
        
		if ((alunoPesquisado =	turma.menorNumeroMatricula())	!=	null)
		{
						System.out.println("Dados	do	aluno	que	possui	o	menor	número	de	matrícula	da	turma.");
						alunoPesquisado.imprimir();	///	Julia - 2	- 88.0
		}	
	}
}
