public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        ItemBiblioteca l1 = new Livro("L001", "Código Limpo");
        ItemBiblioteca l2 = new Livro("L002", "Harry Potter");
        ItemBiblioteca l3 = new Livro("L003", "Felicidade Crônica");
        ItemBiblioteca r1 = new Revista("R001", "Exame");
        biblioteca.adicionarItem(l1);
        biblioteca.adicionarItem(l2);
        biblioteca.adicionarItem(l3);
        biblioteca.adicionarItem(r1);

        Usuario aluno = new Aluno("Jordan");
        Usuario professor = new Professor("Jaques");

        System.out.println("=== Acervo Inicial ===");
        biblioteca.listarAcervo();

        System.out.println("\n=== Empréstimos ===");
        biblioteca.emprestar(aluno, l1);
        biblioteca.emprestar(aluno, l2);
        biblioteca.emprestar(aluno, r1);
        biblioteca.emprestar(aluno, l3);

        System.out.println("\n=== Devolução com Atraso ===");
        biblioteca.devolver(aluno, r1, 3);

        System.out.println("\n=== Acervo Final ===");
        biblioteca.listarAcervo();
        System.out.println("\n" + aluno);
        System.out.println(professor);
    }
}