# -*- coding: utf-8 -*-
"""
Módulo: arquivos.py
Responsabilidade: Centralizar toda a leitura e escrita em disco (persistência),
                  isolando o restante do sistema do formato de armazenamento
                  escolhido (CSV). Nenhum outro módulo deve abrir arquivos
                  diretamente.
"""

import csv
import os

PASTA_DADOS = "dados"
ARQUIVO_USUARIOS = os.path.join(PASTA_DADOS, "usuarios.csv")
ARQUIVO_LIVROS = os.path.join(PASTA_DADOS, "livros.csv")

CAMPOS_USUARIO = ["nome", "username", "senha", "nascimento"]
CAMPOS_LIVRO = ["titulo", "autor", "editora", "edicao", "ano",
                "isbn", "status", "paginas_totais", "paginas_lidas"]


def garantir_pasta_dados():
    """
    Responsabilidade: Garantir que a pasta de dados exista antes de
                       qualquer leitura/escrita.
    Entradas: nenhuma
    Saídas: nenhuma (efeito colateral: cria diretório em disco)
    """
    if not os.path.exists(PASTA_DADOS):
        os.makedirs(PASTA_DADOS)


def ler_csv(caminho: str, campos: list) -> list:
    """
    Responsabilidade: Ler um arquivo CSV genérico e devolver seus registros
                       como um vetor (lista) de dicionários.
    Entradas:
        caminho (str): caminho do arquivo CSV a ser lido
        campos (list): lista com os nomes das colunas esperadas
    Saídas:
        list: vetor de dicionários, um por linha do arquivo. Lista vazia
              se o arquivo não existir ainda.
    """
    garantir_pasta_dados()
    registros = []
    if not os.path.exists(caminho):
        return registros

    with open(caminho, mode="r", newline="", encoding="utf-8") as arquivo:
        leitor = csv.DictReader(arquivo)
        for linha in leitor:
            registros.append(linha)
    return registros


def escrever_csv(caminho: str, campos: list, registros: list):
    """
    Responsabilidade: Sobrescrever um arquivo CSV com o conteúdo atual de
                       um vetor de dicionários (persistir o estado em memória).
    Entradas:
        caminho (str): caminho do arquivo CSV a ser escrito
        campos (list): lista com os nomes das colunas (cabeçalho)
        registros (list): vetor de dicionários a serem gravados
    Saídas: nenhuma (efeito colateral: grava/atualiza arquivo em disco)
    """
    garantir_pasta_dados()
    with open(caminho, mode="w", newline="", encoding="utf-8") as arquivo:
        escritor = csv.DictWriter(arquivo, fieldnames=campos)
        escritor.writeheader()
        for registro in registros:
            escritor.writerow(registro)


def carregar_usuarios() -> list:
    """
    Responsabilidade: Carregar o vetor de usuários a partir do disco.
    Entradas: nenhuma
    Saídas: list -> vetor de dicionários de usuários
    """
    return ler_csv(ARQUIVO_USUARIOS, CAMPOS_USUARIO)


def salvar_usuarios(usuarios: list):
    """
    Responsabilidade: Persistir o vetor de usuários em disco.
    Entradas:
        usuarios (list): vetor de dicionários de usuários
    Saídas: nenhuma
    """
    escrever_csv(ARQUIVO_USUARIOS, CAMPOS_USUARIO, usuarios)


def carregar_livros() -> list:
    """
    Responsabilidade: Carregar o vetor de livros a partir do disco.
    Entradas: nenhuma
    Saídas: list -> vetor de dicionários de livros
    """
    return ler_csv(ARQUIVO_LIVROS, CAMPOS_LIVRO)


def salvar_livros(livros: list):
    """
    Responsabilidade: Persistir o vetor de livros em disco.
    Entradas:
        livros (list): vetor de dicionários de livros
    Saídas: nenhuma
    """
    escrever_csv(ARQUIVO_LIVROS, CAMPOS_LIVRO, livros)
