public abstract class Usuario {
    private final String nome;
    private int quantidadeEmprestada = 0;

    public Usuario(String nome) { this.nome = nome; }

    public abstract int limiteItens();

    public String getNome() { return nome; }
    public int getQuantidadeEmprestada() { return quantidadeEmprestada; }

    public boolean atingiuLimite() { return quantidadeEmprestada >= limiteItens(); }

    void registrarEmprestimo() { quantidadeEmprestada++; }
    void registrarDevolucao() { if (quantidadeEmprestada > 0) quantidadeEmprestada--; }

    @Override
    public String toString() {
        return String.format("%s %s (%d/%d itens)", getClass().getSimpleName(), nome,
                quantidadeEmprestada, limiteItens());
    }
}