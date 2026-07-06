# -*- coding: utf-8 -*-
"""
Módulo: relatorios.py
Responsabilidade: Gerar relatórios de progresso de leitura utilizando uma
                   matriz (vetor de vetores) para organizar os dados em
                   formato de linhas x colunas antes da exibição.
"""


def gerar_matriz_relatorio(livros: list) -> list:
    """
    Responsabilidade: Construir uma matriz (lista de listas) em que cada
                       linha representa um livro e cada coluna representa
                       um dado do relatório, na ordem:
                       [titulo, status, paginas_lidas, paginas_totais, percentual]
    Entradas:
        livros (list): vetor de livros (dicionários)
    Saídas:
        list: matriz (list[list]) com os dados do relatório
    """
    matriz = []
    for livro in livros:
        paginas_totais = int(livro["paginas_totais"])
        paginas_lidas = int(livro["paginas_lidas"])
        if paginas_totais > 0:
            percentual = round((paginas_lidas / paginas_totais) * 100, 1)
        else:
            percentual = 0.0

        linha = [
            livro["titulo"],
            livro["status"],
            paginas_lidas,
            paginas_totais,
            percentual,
        ]
        matriz.append(linha)
    return matriz


def exibir_matriz_relatorio(matriz: list):
    """
    Responsabilidade: Percorrer a matriz de relatório (linha por linha,
                       coluna por coluna) e exibi-la formatada no console.
    Entradas:
        matriz (list): matriz gerada por gerar_matriz_relatorio()
    Saídas: nenhuma (efeito colateral: impressão no console)
    """
    if not matriz:
        print("Nenhum dado disponível para o relatório.")
        return

    print("\n--- Relatório de Progresso de Leitura ---")
    print(f"{'Título':30} {'Status':12} {'Lidas':>7} {'Totais':>7} {'%':>6}")
    for linha in matriz:
        titulo, status, lidas, totais, percentual = linha
        print(f"{titulo[:30]:30} {status:12} {lidas:>7} {totais:>7} {percentual:>5.1f}%")
    print("------------------------------------------\n")
