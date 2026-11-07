-- EXERCÍCIO 2 — Inserção de Dados

INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel) VALUES
    ('L001', 'Harry Potter',      	'livro',   'J. K. Rowling',      NULL,       TRUE),
    ('L002', 'Código Limpo',      	'livro',   'Robert C. Martin',   NULL,       FALSE),
    ('L003', 'Felicidade Crônica', 	'livro',   'Marta Medeiros',     NULL,       TRUE),
    ('R001', 'Exame',         		'revista', 	NULL,              	'Ed. 450',   TRUE),
    ('R002', 'Veja',                'revista', 	NULL,              	'Ed. 2900',  TRUE);

INSERT INTO usuario (nome, tipo, limite_itens) VALUES
    ('Jordan',  'aluno',     3),
    ('Jaques', 	'professor', 5);

INSERT INTO emprestimo
    (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa) VALUES
    -- devolvido com 3 dias de atraso (revista: 3 x R$ 1,00)
    (4, 1, '2026-10-01', '2026-10-08', '2026-10-11', 3.00),
    -- em aberto (Código Limpo com o professor)
    (2, 2, '2026-10-20', '2026-11-03', NULL,         0.00);
