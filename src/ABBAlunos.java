public class ABBAlunos {

	private NodoAluno raiz; // refer�ncia � raiz da �rvore.
    /// Construtor da classe.
    /// Esse construtor cria uma nova �rvore bin�ria de alunos vazia. Para isso, esse m�todo atribui null � raiz da �rvore.
    public ABBAlunos()
    {
        raiz = null;
    }

    /// M�todo booleano que indica se a �rvore est� vazia ou n�o.
    /// Retorna: 
    /// verdadeiro: se a raiz da �rvore for null, o que significa que a �rvore est� vazia.
    /// falso: se a raiz da �rvore n�o for null, o que significa que a �rvore n�o est� vazia.
    public Boolean arvoreVazia()
    {
        /// Se a raiz da �rvore for null, a �rvore est� vazia.
        if (this.raiz == null)
            return true;
        /// Caso contr�rio, a �rvore n�o est� vazia.
        else
            return false;
    }

    /// M�todo recursivo respons�vel por adicionar um aluno � �rvore.
    /// Par�metro "raizArvore": raiz da �rvore ou sub-�rvore em que o aluno ser� adicionado.
    /// Par�metro "alunoNovo": aluno que dever� ser adicionado � �rvore.
    /// Retorna a raiz atualizada da �rvore ou sub-�rvore em que o aluno foi adicionado.
    private NodoAluno adicionar(NodoAluno raizArvore, Aluno alunoNovo)
    {
        /// Se a raiz da �rvore ou sub-�rvore for null, a �rvore est� vazia e ent�o um novo aluno � inserido.
        if (raizArvore == null)
            raizArvore = new NodoAluno(alunoNovo);
        else
        {
            /// Se o n�mero de matr�cula do aluno armazenado na raiz da �rvore for maior do que o n�mero de matr�cula do aluno que dever� ser inserido na �rvore:
            /// adicione esse aluno � sub-�rvore esquerda; e atualize a refer�ncia para a sub-�rvore esquerda modificada. 
            if (raizArvore.item.getNumMatricula() > alunoNovo.getNumMatricula())
                raizArvore.esquerda = adicionar(raizArvore.esquerda, alunoNovo);
            else
            {
                /// Se o n�mero de matr�cula do aluno armazenado na raiz da �rvore for menor do que o n�mero de matr�cula do aluno que dever� ser inserido na �rvore:
                /// adicione esse aluno � sub-�rvore direita; e atualize a refer�ncia para a sub-�rvore direita modificada.
                if (raizArvore.item.getNumMatricula() < alunoNovo.getNumMatricula())
                    raizArvore.direita = adicionar(raizArvore.direita, alunoNovo);
                else
                    /// O n�mero de matr�cula do aluno armazenado na raiz da �rvore � igual ao n�mero de matr�cula do aluno que deveria ser inserido na �rvore.
                    System.out.println("O aluno " + alunoNovo.getNome() + ", cuja matr�cula � " + alunoNovo.getNumMatricula() + ", j� foi inserido anteriormente na �rvore.");
            }
        }
        /// Retorna a raiz atualizada da �rvore ou sub-�rvore em que o aluno foi adicionado.
        return raizArvore;
    }

    /// Metodo que encapsula a adi��o recursiva de alunos � �rvore.
    /// Par�metro "alunoNovo": aluno que dever� ser inserido na �rvore.
    public void inserir(Aluno alunoNovo)
    {
        /// Chama o m�todo recursivo "adicionar", que ser� respons�vel por adicionar, o aluno passado como par�metro, � �rvore.
        /// O m�todo "adicionar" receber�, como primeiro par�metro, a raiz atual da �rvore; e, como segundo par�metro, o aluno que dever� ser adicionado � �rvore.
        /// Por fim, a raiz atual da �rvore � atualizada, com a raiz retornada pelo m�todo "adicionar".
        this.raiz = adicionar(this.raiz, alunoNovo);
    }

    /// M�todo recursivo respons�vel por localizar na �rvore ou sub-�rvore o antecessor do n� que dever� ser retirado. 
    /// O antecessor do n� que dever� ser retirado da �rvore corresponde
    /// ao n� que armazena os dados do aluno cujo n�mero de matr�cula � o maior, 
    /// dentre os n�meros de matr�cula menores do que o n�mero de matr�cula do n� que dever� ser retirado.
    /// Depois de ser localizado na �rvore ou sub-�rvore, 
    /// o antecessor do n� que dever� ser retirado da �rvore o substitui.
    /// Adicionalmente, a �rvore ou sub-�rvore � atualizada com a remo��o do antecessor.
    /// Par�metro "alunoRetirar": refer�ncia ao n� que armazena o aluno que dever� ser retirado da �rvore.
    /// Par�metro "raizArvore": raiz da �rvore ou sub-�rvore em que o antecessor do n� que dever� ser retirado dever� ser localizado.
    /// Retorna: raiz atualizada da �rvore ou sub-�rvore ap�s a remo��o do antecessor do n� que foi retirado da �rvore.
    private NodoAluno antecessor(NodoAluno alunoRetirar, NodoAluno raizArvore)
    {
        /// Se o antecessor do n� que dever� ser retirado da �rvore ainda n�o foi encontrado...
        if (raizArvore.direita != null)
        {
            /// Pesquise o antecessor na sub-�rvore direita.
            raizArvore.direita = antecessor(alunoRetirar, raizArvore.direita);
            return raizArvore;
        }
        /// O antecessor do n� que dever� ser retirado da �rvore foi encontrado.
        else
        {
            /// O antecessor do n� que dever� ser retirado da �rvore foi localizado e dever� substitui-lo.
            alunoRetirar.item.setNumMatricula(raizArvore.item.getNumMatricula());
            alunoRetirar.item.setNome(raizArvore.item.getNome());
            alunoRetirar.item.setNota(raizArvore.item.getNota());
            /// A raiz da �rvore ou sub-�rvore � atualizada com os descendentes � esquerda do antecessor.
            /// Ou seja, retira-se o antecessor da �rvore.
            return raizArvore.esquerda;
        }
    }

    /// M�todo recursivo respons�vel por localizar um aluno na �rvore e retir�-lo da �rvore.
    /// Par�metro "raizArvore": raiz da �rvore ou sub-�rvore da qual o aluno ser� retirado.
    /// Par�metro "matricula": n�mero de matr�cula do aluno que dever� ser localizado e removido da �rvore.
    /// Retorna a raiz atualizada da �rvore ou sub-�rvore da qual o aluno foi retirado; ou null, caso n�o tenha sido localizado aluno com o n�mero de matr�cula informado.
    private NodoAluno retirar(NodoAluno raizArvore, int matricula)
    {
        /// Se a raiz da �rvore ou sub-�rvore for null, a �rvore est� vazia e o aluno, que deveria ser retirado dessa �rvore, n�o foi encontrado.
        /// Nesse caso, deve-se retornar null.
        if (raizArvore == null)
        {
        	 System.out.println("O aluno, cuja matr�cula � " + matricula + ", n�o foi encontrado.");
            return raizArvore;
        }
        else
        {
            /// O n�mero de matr�cula do aluno armazenado na raiz da �rvore � igual ao n�mero de matr�cula do aluno que deve ser retirado dessa �rvore.
            /// Ou seja, o aluno que deve ser retirado da �rvore foi encontrado.
            if (raizArvore.item.getNumMatricula() == matricula)
            {
                /// O n� da �rvore que ser� retirado n�o possui descendentes � direita.
                /// Nesse caso, os descendentes � esquerda do n� que est� sendo retirado da �rvore passar�o a ser descendentes do n�-pai do n� que est� sendo retirado.
                if (raizArvore.direita == null)
                    return (raizArvore.esquerda);
                else
                    /// O n� da �rvore que ser� retirado n�o possui descendentes � esquerda.
                    /// Nesse caso, os descendentes � direita do n� que est� sendo retirado da �rvore passar�o a ser descendentes do n�-pai do n� que est� sendo retirado.
                    if (raizArvore.esquerda == null)
                        return (raizArvore.direita);
                    else
                    {
                        /// O n� que est� sendo retirado da �rvore possui descendentes � esquerda e � direita.
                        /// Nesse caso, o antecessor do n� que est� sendo retirado � localizado na sub-�rvore esquerda desse n�. 
                        /// O antecessor do n� que est� sendo retirado da �rvore corresponde
                        /// ao n� que armazena o aluno cujo n�mero de matr�cula � o maior, 
                        /// dentre os n�meros de matr�cula menores do que o n�mero de matr�cula do n� que est� sendo retirado.
                        /// Depois de ser localizado na sub-�rvore esquerda do n� que est� sendo retirado, 
                        /// o antecessor desse n� o substitui.
                        /// A sub-�rvore esquerda do n� que foi retirado � atualizada com a remo��o do antecessor.
                        raizArvore.esquerda = antecessor(raizArvore, raizArvore.esquerda);
                        /// Retorna a raiz atualizada da �rvore ou sub-�rvore da qual o aluno foi retirado.
                        return (raizArvore);
                    }
            }
            else
            {
                /// Se o n�mero de matr�cula do aluno armazenado na raiz da �rvore for maior do que o n�mero de matr�cula do aluno que dever� ser localizado e retirado da �rvore:
                /// pesquise e retire esse aluno da sub-�rvore esquerda.
                if (raizArvore.item.getNumMatricula() > matricula)
                    raizArvore.esquerda = retirar(raizArvore.esquerda, matricula);
                else
                    /// Se o n�mero de matr�cula do aluno armazenado na raiz da �rvore for menor do que o n�mero de matr�cula do aluno que dever� ser localizado e retirado da �rvore:
                    /// pesquise e retire esse aluno da sub-�rvore direita.
                    raizArvore.direita = retirar(raizArvore.direita, matricula);
                /// Retorna a raiz atualizada da �rvore ou sub-�rvore da qual o aluno foi retirado.
                return raizArvore;
            }
        }
    }

    /// M�todo que encapsula a retirada recursiva de um aluno da �rvore.
    /// Par�metro "matriculaRemover": n�mero de matr�cula do aluno que dever� ser localizado e removido da �rvore.
    public void remover(int matriculaRemover)
    {
        /// Chama o m�todo recursivo "retirar", que ser� respons�vel por pesquisar o aluno, cujo n�mero de matr�cula foi passado como par�metro, na �rvore e retir�-lo da �rvore.
        /// O m�todo "retirar" receber�, como primeiro par�metro, a raiz atual da �rvore; e, como segundo par�metro, o n�mero de matr�cula do aluno que dever� ser localizado e retirado dessa �rvore.
        this.raiz = retirar(this.raiz, matriculaRemover);
    }
    
    public Aluno menorNumeroMatricula() 
    {
    	
    	if(!arvoreVazia()) 
    	{
    		int matriculaMaior = raiz.item.getNumMatricula();
    		Aluno menor = null;
    		while(raiz != null) 
    		{
    			if(matriculaMaior > raiz.item.getNumMatricula()) 
    			{
    				menor = raiz.item;
        			//System.out.println(menor.getNumMatricula());
    			}
    			raiz = raiz.esquerda;
    			
    		}
    		return menor;
    		
    	}
    	return null;
    }
    
    private int contarNumAlunos(NodoAluno raizArvore) 
    {
    	NodoAluno atual = raizArvore;
    	if(atual == null) 
    	{
    		return 0;
    	}
    	else 
    	{
    		return (1 + contarNumAlunos(raizArvore.esquerda) + contarNumAlunos(raizArvore.direita));
    	}
    }
    public int numAlunos() 
    {
    	return contarNumAlunos(this.raiz);
    }
    
    private NodoAluno pesquisar(NodoAluno raizArvore, int matricula) 
    {
    	if (arvoreVazia()) return null; // se arvore vazia
    	NodoAluno atual = raizArvore;  // come�a a procurar desde raiz
        while (atual.item.getNumMatricula()!= matricula) 
        { 
        // enquanto nao encontrou
          if(matricula < atual.item.getNumMatricula() ) atual = atual.esquerda; // caminha para esquerda
          else atual = atual.direita; // caminha para direita

          if (atual == null) 
         {
        	  return null; 
         }// encontrou uma folha -> sai
          raizArvore = raiz.esquerda;
        } // fim la�o while
        return atual; // terminou o la�o while e chegou aqui � pq encontrou item
    }
    
    public Aluno buscar (int matricula) 
    {
    	Aluno as = pesquisar(this.raiz, matricula).item;
		return as;
    }
}
