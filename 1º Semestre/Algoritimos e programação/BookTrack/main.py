# -*- coding: utf-8 -*-
"""
Módulo: main.py
Responsabilidade: Ponto de entrada do sistema. Controla o fluxo de
                   navegação entre os menus (login, usuários, livros,
                   relatório) e conecta os demais módulos.
"""

import arquivos
import usuarios
import livros
import relatorios
import validacoes


def tela_login(lista_usuarios: list) -> dict:
    """
    Responsabilidade: Conduzir o fluxo de login, solicitando username e
                       senha até que a autenticação seja bem-sucedida ou o
                       usuário opte por cadastrar-se.
    Entradas:
        lista_usuarios (list): vetor de usuários carregado em memória
    Saídas:
        dict: dicionário do usuário autenticado
    """
    while True:
        print("\n=== LOGIN ===")
        print("1 - Entrar")
        print("2 - Cadastrar novo usuário")
        opcao = input("Escolha uma opção: ").strip()

        if opcao == "1":
            username = input("Username: ").strip()
            senha = input("Senha: ").strip()
            if usuarios.autenticar_login(lista_usuarios, username, senha):
                print(f"Login efetuado com sucesso. Bem-vindo(a)!")
                return usuarios.buscar_usuario_por_username(lista_usuarios, username)
            else:
                print("Username ou senha inválidos. Tente novamente.")

        elif opcao == "2":
            nome = validacoes.ler_nome("Nome completo: ")
            username = validacoes.ler_texto_obrigatorio("Escolha um username: ")
            senha = validacoes.ler_texto_obrigatorio("Escolha uma senha: ")
            nascimento = validacoes.ler_data_ddmmaaaa("Data de nascimento (DD/MM/AAAA): ")
            sucesso = usuarios.registrar_usuario(lista_usuarios, nome, username,
                                                  senha, nascimento)
            if sucesso:
                print("Cadastro realizado com sucesso! Agora faça login.")
            else:
                print("Já existe um usuário com esse username.")
        else:
            print("Opção inválida.")


def menu_usuarios(lista_usuarios: list):
    """
    Responsabilidade: Exibir e controlar o submenu de gerenciamento de
                       usuários (editar, excluir, listar).
    Entradas:
        lista_usuarios (list): vetor de usuários
    Saídas: nenhuma
    """
    while True:
        print("\n--- Gerenciar Usuários ---")
        print("1 - Listar usuários")
        print("2 - Editar usuário")
        print("3 - Excluir usuário")
        print("0 - Voltar")
        opcao = input("Escolha uma opção: ").strip()

        if opcao == "1":
            usuarios.listar_usuarios(lista_usuarios)
        elif opcao == "2":
            username = input("Username do usuário a editar: ").strip()
            novo_nome = validacoes.ler_nome_opcional("Novo nome (Enter para manter): ")
            novo_username = input("Novo username (Enter para manter): ").strip() or None
            nova_senha = input("Nova senha (Enter para manter): ").strip() or None
            novo_nasc = validacoes.ler_data_ddmmaaaa_opcional(
                "Nova data de nascimento DD/MM/AAAA (Enter para manter): ")

            resultado = usuarios.editar_usuario(lista_usuarios, username, novo_nome,
                                                 novo_username, nova_senha, novo_nasc)
            if resultado == "ok":
                print("Usuário atualizado com sucesso.")
            elif resultado == "username_em_uso":
                print("Esse username já está em uso por outro usuário.")
            else:
                print("Usuário não encontrado.")
        elif opcao == "3":
            username = input("Username do usuário a excluir: ").strip()
            if usuarios.excluir_usuario(lista_usuarios, username):
                print("Usuário excluído com sucesso.")
            else:
                print("Usuário não encontrado.")
        elif opcao == "0":
            break
        else:
            print("Opção inválida.")


def menu_livros(lista_livros: list):
    """
    Responsabilidade: Exibir e controlar o submenu de gerenciamento de
                       livros (cadastrar, editar, remover, listar, relatório).
    Entradas:
        lista_livros (list): vetor de livros
    Saídas: nenhuma
    """
    while True:
        print("\n--- Gerenciar Livros ---")
        print("1 - Cadastrar livro")
        print("2 - Listar livros")
        print("3 - Editar progresso/status de um livro")
        print("4 - Remover livro")
        print("5 - Relatório de progresso (matriz)")
        print("0 - Voltar")
        opcao = input("Escolha uma opção: ").strip()

        if opcao == "1":
            titulo = validacoes.ler_texto_obrigatorio("Título: ")
            autor = validacoes.ler_texto_obrigatorio("Autor: ")
            editora = validacoes.ler_texto_obrigatorio("Editora: ")
            edicao = validacoes.ler_texto_obrigatorio("Edição: ")
            ano = validacoes.ler_inteiro("Ano: ", minimo=1000, maximo=2100)
            isbn = validacoes.ler_texto_obrigatorio("ISBN: ")
            status = validacoes.ler_texto_obrigatorio("Status (Lendo/Lido/Quero ler): ")
            paginas_totais = validacoes.ler_inteiro("Páginas totais: ", minimo=1)
            paginas_lidas = validacoes.ler_inteiro(
                "Páginas já lidas (0 se ainda não começou): ",
                minimo=0, maximo=paginas_totais)

            sucesso = livros.cadastrar_livro(
                lista_livros, titulo, autor, editora, edicao,
                ano, isbn, status, paginas_totais, paginas_lidas
            )
            if sucesso:
                print("Livro cadastrado com sucesso.")
            else:
                print("Já existe um livro com esse ISBN.")

        elif opcao == "2":
            livros.listar_livros(lista_livros)

        elif opcao == "3":
            isbn = input("ISBN do livro: ").strip()
            novo_status = input("Novo status (Enter para manter): ").strip() or None
            resposta_paginas = input("Novas páginas lidas (Enter para manter): ").strip()
            novas_paginas = validacoes.ler_inteiro("Confirme as páginas lidas: ", minimo=0) \
                if resposta_paginas else None
            if livros.editar_livro(lista_livros, isbn, novo_status, novas_paginas):
                print("Livro atualizado com sucesso.")
            else:
                print("Livro não encontrado.")

        elif opcao == "4":
            isbn = input("ISBN do livro a remover: ").strip()
            if livros.remover_livro(lista_livros, isbn):
                print("Livro removido com sucesso.")
            else:
                print("Livro não encontrado.")

        elif opcao == "5":
            matriz = relatorios.gerar_matriz_relatorio(lista_livros)
            relatorios.exibir_matriz_relatorio(matriz)

        elif opcao == "0":
            break
        else:
            print("Opção inválida.")


def menu_principal():
    """
    Responsabilidade: Orquestrar a execução do sistema: carregar os dados,
                       exibir o menu principal e direcionar para os submenus.
    Entradas: nenhuma
    Saídas: nenhuma
    """
    arquivos.garantir_pasta_dados()
    lista_usuarios = arquivos.carregar_usuarios()
    lista_livros = arquivos.carregar_livros()

    print("=== Bem-vindo ao BookTrack ===")
    usuario_logado = tela_login(lista_usuarios)

    while True:
        print(f"\n=== Menu Principal ({usuario_logado['nome']}) ===")
        print("1 - Gerenciar Usuários")
        print("2 - Gerenciar Livros")
        print("0 - Sair")
        opcao = input("Escolha uma opção: ").strip()

        if opcao == "1":
            menu_usuarios(lista_usuarios)
        elif opcao == "2":
            menu_livros(lista_livros)
        elif opcao == "0":
            print("Saindo do sistema. Até logo!")
            break
        else:
            print("Opção inválida.")


if __name__ == "__main__":
    menu_principal()
