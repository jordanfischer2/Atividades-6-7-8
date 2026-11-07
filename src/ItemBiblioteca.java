public abstract class ItemBiblioteca {
    private final String codigo;
    private final String titulo;
    private boolean disponivel = true;

    public ItemBiblioteca(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    public abstract int prazoDias();
    public abstract double multaPorDia();

    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public boolean isDisponivel() { return disponivel; }

    void marcarEmprestado() { disponivel = false; }
    void marcarDevolvido() { disponivel = true; }

    public double calcularMulta(int diasAtraso) {
        return diasAtraso > 0 ? diasAtraso * multaPorDia() : 0.0;
    }

    @Override
    public String toString() {
        return String.format("[%s] %-8s %-28s prazo: %2d dias | multa: R$ %.2f/dia | %s",
                codigo, getClass().getSimpleName(), titulo, prazoDias(), multaPorDia(),
                disponivel ? "disponível" : "emprestado");
    }
}
