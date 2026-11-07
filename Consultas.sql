-- EXERCÍCIO 3 — Consultas

-- 1. Listar todo o acervo, com código, título, tipo e disponibilidade.
SELECT codigo, titulo, tipo, disponivel
FROM item
ORDER BY codigo;

-- 2. Listar os empréstimos em aberto, com o nome do usuário e o título do item.
SELECT u.nome AS usuario, i.titulo, e.data_retirada, e.data_devolucao_prevista
FROM emprestimo e
JOIN usuario u ON u.id = e.usuario_id
JOIN item    i ON i.id = e.item_id
WHERE e.data_devolucao IS NULL;

-- 3. Calcular o total de multas acumuladas por usuário.
SELECT u.nome, COALESCE(SUM(e.valor_multa), 0) AS total_multas
FROM usuario u
LEFT JOIN emprestimo e ON e.usuario_id = u.id
GROUP BY u.id, u.nome
ORDER BY total_multas DESC;

-- 4. Listar os itens que nunca foram emprestados.
SELECT i.codigo, i.titulo
FROM item i
LEFT JOIN emprestimo e ON e.item_id = i.id
WHERE e.id IS NULL;