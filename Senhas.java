import java.util.LinkedList;
import java.util.List;

// Fila genérica usando lista encadeada
class Queue<T> {
    private Node<T> frente;
    private Node<T> tras;

    public Queue() {
        frente = tras = null;
    }

    public boolean estaVazia() {
        return frente == null;
    }

    public void enfileirar(T valor) {
        Node<T> novo = new Node<>(valor);
        if (estaVazia()) {
            frente = tras = novo;
        } else {
            tras.proximo = novo;
            tras = novo;
        }
    }

    public T desenfileirar() {
        if (estaVazia()) return null;
        T valor = frente.valor;
        frente = frente.proximo;
        if (frente == null) tras = null;
        return valor;
    }

    public void imprimir() {
        Node<T> atual = frente;
        System.out.print("[ ");
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println("]");
    }
}

// Gerenciador de senhas e fila do hospital
class FilaSenhas {
    private Queue<Integer> fila;
    private List<Integer> historico;
    private int contador;

    public FilaSenhas() {
        fila = new Queue<>();
        historico = new LinkedList<>();
        contador = 1;
    }

    public void gerarSenha() {
        fila.enfileirar(contador);
        System.out.println("Senha gerada: " + contador);
        contador++;
    }

    public void chamarProximo() {
        if (fila.estaVazia()) {
            System.out.println("Fila vazia. Nenhum paciente para chamar.");
            return;
        }
        int senha = fila.desenfileirar();
        historico.add(senha);
        System.out.println("Chamando senha: " + senha);
    }

    public void mostrarHistorico() {
        System.out.println("Histórico de chamadas: " + historico);
    }

    public void estadoFila() {
        System.out.print("Fila atual: ");
        fila.imprimir();
    }
}
