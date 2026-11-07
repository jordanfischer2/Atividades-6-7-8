public class Biblioteca {
    private final ItemBiblioteca[] acervo = new ItemBiblioteca[100];
    private int totalItens = 0;

    public boolean adicionarItem(ItemBiblioteca item) {
        if (totalItens >= acervo.length) return false;
        acervo[totalItens++] = item;
        return true;
    }

    public boolean emprestar(Usuario usuario, ItemBiblioteca item) {
        if (!item.isDisponivel()) {
            System.out.println("Recusado: \"" + item.getTitulo() + "\" já está emprestado.");
            return false;
        }
        if (usuario.atingiuLimite()) {
            System.out.println("Recusado: " + usuario.getNome() + " atingiu o limite de "
                    + usuario.limiteItens() + " itens.");
            return false;
        }
        item.marcarEmprestado();
        usuario.registrarEmprestimo();
        System.out.println("Emprestado: \"" + item.getTitulo() + "\" para " + usuario.getNome()
                + " (prazo de " + item.prazoDias() + " dias).");
        return true;
    }

    public double devolver(Usuario usuario, ItemBiblioteca item, int diasAtraso) {
        item.marcarDevolvido();
        usuario.registrarDevolucao();
        double multa = item.calcularMulta(diasAtraso);
        System.out.printf("Devolvido: \"%s\" por %s. Multa: R$ %.2f%n",
                item.getTitulo(), usuario.getNome(), multa);
        return multa;
    }

    public void listarAcervo() {
        for (int i = 0; i < totalItens; i++) {
            System.out.println(acervo[i]);
        }
    }
}