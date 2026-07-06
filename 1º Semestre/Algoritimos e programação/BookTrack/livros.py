# -*- coding: utf-8 -*-
"""
Módulo: livros.py
Responsabilidade: Regras de negócio relacionadas a livros — cadastro,
                   edição, remoção e exibição. Não realiza E/S em disco
                   diretamente; delega essa tarefa ao módulo arquivos.py.

Variáveis principais deste módulo:
    livros (list) -> vetor de dicionários. Cada dicionário representa
                      um livro com as chaves:
                          titulo          (string)
                          autor           (string)
                          editora         (string)
                          edicao          (string)
                          ano             (int)
                          isbn            (string)
                          status          (string)  ex: "Lendo", "Lido", "Quero ler"
                          paginas_totais  (int)
                          paginas_lidas   (int)
"""

import arquivos


def cadastrar_livro(livros: list, titulo: str, autor: str, editora: str,
                     edicao: str, ano: int, isbn: str, status: str,
                     paginas_totais: int, paginas_lidas: int = 0) -> bool:
    """
    Responsabilidade: Cadastrar um novo livro no vetor de livros,
                       impedindo ISBN duplicado.
    Entradas:
        livros (list): vetor de livros já carregado em memória
        titulo (string), autor (string), editora (string), edicao (string)
        ano (int): ano de publicação
        isbn (string): identificador único do livro
        status (string): situação de leitura
        paginas_totais (int): total de páginas do livro
        paginas_lidas (int, opcional): páginas já lidas (padrão 0)
    Saídas:
        bool: True se cadastrado; False se já existe livro com o mesmo ISBN
    """
    if buscar_livro_por_isbn(livros, isbn) is not None:
        return False

    novo_livro = {
        "titulo": titulo,
        "autor": autor,
        "editora": editora,
        "edicao": edicao,
        "ano": str(ano),
        "isbn": isbn,
        "status": status,
        "paginas_totais": str(paginas_totais),
        "paginas_lidas": str(paginas_lidas),
    }
    livros.append(novo_livro)
    arquivos.salvar_livros(livros)
    return True


def buscar_livro_por_isbn(livros: list, isbn: str) -> dict:
    """
    Responsabilidade: Localizar um livro dentro do vetor a partir do ISBN.
    Entradas:
        livros (list): vetor de livros
        isbn (string): ISBN a ser localizado
    Saídas:
        dict ou None: dicionário do livro encontrado, ou None se não existir
    """
    for livro in livros:
        if livro["isbn"] == isbn:
            return livro
    return None


def editar_livro(livros: list, isbn: str, novo_status: str = None,
                  novas_paginas_lidas: int = None) -> bool:
    """
    Responsabilidade: Atualizar os dados de um livro já cadastrado
                       (tipicamente status de leitura e progresso).
                       Campos não informados (None) permanecem inalterados.
    Entradas:
        livros (list): vetor de livros
        isbn (string): ISBN do livro a ser editado
        novo_status (string, opcional): novo status de leitura
        novas_paginas_lidas (int, opcional): nova contagem de páginas lidas
    Saídas:
        bool: True se o livro foi encontrado e atualizado; False caso contrário
    """
    livro = buscar_livro_por_isbn(livros, isbn)
    if livro is None:
        return False

    if novo_status:
        livro["status"] = novo_status
    if novas_paginas_lidas is not None:
        livro["paginas_lidas"] = str(novas_paginas_lidas)

    arquivos.salvar_livros(livros)
    return True


def remover_livro(livros: list, isbn: str) -> bool:
    """
    Responsabilidade: Remover um livro do vetor de livros.
    Entradas:
        livros (list): vetor de livros
        isbn (string): ISBN do livro a ser removido
    Saídas:
        bool: True se removido com sucesso; False se o livro não existia
    """
    livro = buscar_livro_por_isbn(livros, isbn)
    if livro is None:
        return False

    livros.remove(livro)
    arquivos.salvar_livros(livros)
    return True


def listar_livros(livros: list):
    """
    Responsabilidade: Exibir na tela os dados de todos os livros cadastrados.
    Entradas:
        livros (list): vetor de livros
    Saídas: nenhuma (efeito colateral: impressão no console)
    """
    if not livros:
        print("Nenhum livro cadastrado.")
        return

    print("\n--- Lista de Livros ---")
    for livro in livros:
        print(f"Título: {livro['titulo']} | Autor: {livro['autor']} | "
              f"Status: {livro['status']} | "
              f"Páginas: {livro['paginas_lidas']}/{livro['paginas_totais']}")
    print("-----------------------\n")


def obter_vetor_titulos(livros: list) -> list:
    """
    Responsabilidade: Construir um vetor simples (unidimensional) apenas
                       com os títulos dos livros cadastrados. Utilizado,
                       por exemplo, para telas de busca rápida.
    Entradas:
        livros (list): vetor de livros (dicionários)
    Saídas:
        list: vetor de strings contendo somente os títulos
    """
    titulos = []
    for livro in livros:
        titulos.append(livro["titulo"])
    return titulos
