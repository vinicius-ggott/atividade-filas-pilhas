// Node genérico para lista encadeada
class Node<T> {
    T valor;
    Node<T> proximo;

    Node(T valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

// Implementação de Pilha usando lista encadeada
class Stack<T> {
    private Node<T> topo;

    public Stack() {
        this.topo = null;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public void empilhar(T valor) {
        Node<T> novo = new Node<>(valor);
        novo.proximo = topo;
        topo = novo;
    }

    public T desempilhar() {
        if (estaVazia()) return null;
        T valor = topo.valor;
        topo = topo.proximo;
        return valor;
    }

    public T topo() {
        return estaVazia() ? null : topo.valor;
    }

    public void limpar() {
        topo = null;
    }

    public void imprimir() {
        Node<T> atual = topo;
        System.out.print("[ ");
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println("]");
    }
}

// Simulador de navegador com pilhas de voltar e avançar
class Browser {
    private Stack<String> voltar;
    private Stack<String> avancar;
    private String paginaAtual;

    public Browser() {
        voltar = new Stack<>();
        avancar = new Stack<>();
        paginaAtual = null;
    }

    public void navegarPara(String url) {
        if (paginaAtual != null) {
            voltar.empilhar(paginaAtual);
        }
        paginaAtual = url;
        avancar.limpar();
        System.out.println("Navegando para: " + paginaAtual);
    }

    public void voltar() {
        if (voltar.estaVazia()) {
            System.out.println("Não há página para voltar.");
            return;
        }
        avancar.empilhar(paginaAtual);
        paginaAtual = voltar.desempilhar();
        System.out.println("Voltando para: " + paginaAtual);
    }

    public void avancar() {
        if (avancar.estaVazia()) {
            System.out.println("Não há página para avançar.");
            return;
        }
        voltar.empilhar(paginaAtual);
        paginaAtual = avancar.desempilhar();
        System.out.println("Avançando para: " + paginaAtual);
    }

    public void estadoAtual() {
        System.out.println("Página atual: " + paginaAtual);
        System.out.print("Histórico para voltar: ");
        voltar.imprimir();
        System.out.print("Histórico para avançar: ");
        avancar.imprimir();
    }
}
