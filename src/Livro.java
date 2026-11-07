public class Livro extends ItemBiblioteca {
    public Livro(String codigo, String titulo) { super(codigo, titulo); }

    @Override public int prazoDias() { return 14; }
    @Override public double multaPorDia() { return 0.50; }
}
