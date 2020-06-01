public class NodoAluno {

	Aluno item;           // cont�m os dados do aluno armazenado no nodo da �rvore.
	NodoAluno direita;    // refer�ncia ao nodo armazenado, na �rvore, � direita do aluno em quest�o.
    NodoAluno esquerda;   // refer�ncia ao nodo armazenado, na �rvore, � esquerda do aluno em quest�o.

    public NodoAluno(Aluno registro) {
    	item = registro;
    	direita = null;
    	esquerda = null;
    }
}
