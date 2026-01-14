-- 1. Primeiro criamos as categorias
INSERT INTO categoria (nome) VALUES ('Trabalho');
INSERT INTO categoria (nome) VALUES ('Pessoal');

-- 2. Agora inserimos as tarefas referenciando o ID da categoria (supondo IDs 1 e 2)
-- A coluna categoria_id foi criada automaticamente pelo JPA devido ao @JoinColumn
INSERT INTO tarefa (descricao, concluida, categoria_id) VALUES ('Relatório mensal', true, 1);
INSERT INTO tarefa (descricao, concluida, categoria_id) VALUES ('Academia', false, 2);