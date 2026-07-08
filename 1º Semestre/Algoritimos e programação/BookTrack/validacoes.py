# -*- coding: utf-8 -*-
"""
Módulo: validacoes.py
Responsabilidade: Centralizar a validação de dados digitados pelo usuário
                   no terminal, garantindo que apenas valores do tipo e
                   formato esperado sigam para o restante do sistema.
                   Nenhum outro módulo deve validar entradas de teclado
                   diretamente.
"""

import datetime

STATUS_VALIDOS = ["Lendo", "Lido", "Quero ler"]


def _data_e_valida(dia: int, mes: int, ano: int) -> bool:
    """
    Responsabilidade: Verificar se dia, mês e ano formam uma data real
                       de calendário (ex.: rejeita 31/02/1980).
    Entradas:
        dia (int), mes (int), ano (int)
    Saídas:
        bool: True se a combinação forma uma data válida
    """
    try:
        datetime.date(ano, mes, dia)
        return True
    except ValueError:
        return False


def ler_inteiro(mensagem: str, minimo: int = None, maximo: int = None) -> int:
    """
    Responsabilidade: Solicitar um número inteiro ao usuário, repetindo a
                       pergunta enquanto o valor digitado não for um inteiro
                       válido (e, se informado, dentro do intervalo aceito).
    Entradas:
        mensagem (string): texto exibido ao solicitar o valor
        minimo (int, opcional): valor mínimo aceito (inclusive)
        maximo (int, opcional): valor máximo aceito (inclusive)
    Saídas:
        int: valor inteiro válido digitado pelo usuário
    """
    while True:
        entrada = input(mensagem).strip()
        try:
            valor = int(entrada)
        except ValueError:
            print("Valor inválido. Digite um número inteiro.")
            continue

        if minimo is not None and valor < minimo:
            print(f"O valor deve ser maior ou igual a {minimo}.")
            continue
        if maximo is not None and valor > maximo:
            print(f"O valor deve ser menor ou igual a {maximo}.")
            continue

        return valor


def ler_data_ddmmaaaa(mensagem: str) -> int:
    """
    Responsabilidade: Solicitar uma data no formato DD/MM/AAAA, validar
                       dia, mês e ano, e devolvê-la como um único inteiro
                       no formato DDMMAAAA (ex.: 20/07/1980 -> 20071980).
                       Repete a pergunta enquanto a data for inválida.
    Entradas:
        mensagem (string): texto exibido ao solicitar a data
    Saídas:
        int: data no formato DDMMAAAA
    """
    while True:
        entrada = input(mensagem).strip()
        partes = entrada.split("/")

        if len(partes) != 3:
            print("Formato inválido. Use DD/MM/AAAA (ex.: 20/07/1980).")
            continue

        dia_str, mes_str, ano_str = partes
        if not (dia_str.isdigit() and mes_str.isdigit() and ano_str.isdigit()):
            print("Formato inválido. Use apenas números no formato DD/MM/AAAA.")
            continue

        dia, mes, ano = int(dia_str), int(mes_str), int(ano_str)

        if not (1900 <= ano <= 2100):
            print("Ano inválido. Deve estar entre 1900 e 2100.")
            continue
        if not _data_e_valida(dia, mes, ano):
            print("Essa data não existe no calendário. Verifique dia/mês/ano.")
            continue

        return int(f"{dia:02d}{mes:02d}{ano:04d}")


def ler_data_ddmmaaaa_opcional(mensagem: str) -> int:
    """
    Responsabilidade: Solicitar uma data no formato DD/MM/AAAA que pode ser
                       deixada em branco (o usuário opta por não alterá-la).
                       Se algo for digitado, valida como em ler_data_ddmmaaaa(),
                       repetindo enquanto o valor não for uma data válida.
    Entradas:
        mensagem (string): texto exibido ao solicitar a data
    Saídas:
        int ou None: data no formato DDMMAAAA, ou None se deixado em branco
    """
    while True:
        entrada = input(mensagem).strip()
        if not entrada:
            return None

        partes = entrada.split("/")
        if len(partes) != 3:
            print("Formato inválido. Use DD/MM/AAAA (ex.: 20/07/1980) ou Enter para manter.")
            continue

        dia_str, mes_str, ano_str = partes
        if not (dia_str.isdigit() and mes_str.isdigit() and ano_str.isdigit()):
            print("Formato inválido. Use apenas números no formato DD/MM/AAAA.")
            continue

        dia, mes, ano = int(dia_str), int(mes_str), int(ano_str)

        if not (1900 <= ano <= 2100):
            print("Ano inválido. Deve estar entre 1900 e 2100.")
            continue
        if not _data_e_valida(dia, mes, ano):
            print("Essa data não existe no calendário. Verifique dia/mês/ano.")
            continue

        return int(f"{dia:02d}{mes:02d}{ano:04d}")


def ler_nome_opcional(mensagem: str) -> str:
    """
    Responsabilidade: Solicitar um nome de pessoa que pode ser deixado em
                       branco (o usuário opta por não alterá-lo). Se algo
                       for digitado, valida como em ler_nome(), repetindo
                       enquanto o valor não for um nome válido.
    Entradas:
        mensagem (string): texto exibido ao solicitar o valor
    Saídas:
        string ou None: nome válido, ou None se deixado em branco
    """
    while True:
        entrada = input(mensagem).strip()
        if not entrada:
            return None
        if not all(caractere.isalpha() or caractere.isspace() for caractere in entrada):
            print("Nome inválido. Use apenas letras e espaços (sem números ou símbolos).")
            continue
        return entrada


def formatar_data(data_int: int) -> str:
    """
    Responsabilidade: Converter uma data inteira no formato DDMMAAAA de
                       volta para o formato de exibição DD/MM/AAAA.
    Entradas:
        data_int (int): data no formato DDMMAAAA
    Saídas:
        string: data formatada como DD/MM/AAAA
    """
    texto = str(data_int).zfill(8)
    return f"{texto[0:2]}/{texto[2:4]}/{texto[4:8]}"


def ler_status_livro(mensagem: str = "Status (Lendo/Lido/Quero ler): ") -> str:
    """
    Responsabilidade: Solicitar o status de leitura de um livro como texto,
                       restringindo o valor aceito a um dos itens de
                       STATUS_VALIDOS ("Lendo", "Lido", "Quero ler"),
                       sem diferenciar maiúsculas de minúsculas. Repete a
                       pergunta enquanto o valor digitado for inválido.
    Entradas:
        mensagem (string, opcional): texto exibido ao solicitar o valor
    Saídas:
        string: um dos valores de STATUS_VALIDOS (com a grafia padronizada)
    """
    while True:
        entrada = input(mensagem).strip()
        for valido in STATUS_VALIDOS:
            if entrada.lower() == valido.lower():
                return valido
        print(f"Status inválido. Escolha um dos seguintes: {', '.join(STATUS_VALIDOS)}.")


def ler_status_livro_opcional(mensagem: str = "Novo status (Lendo/Lido/Quero ler, Enter para manter): ") -> str:
    """
    Responsabilidade: Mesma finalidade de ler_status_livro(), mas permite
                       deixar em branco para manter o status atual (usado
                       em telas de edição).
    Entradas:
        mensagem (string, opcional): texto exibido ao solicitar o valor
    Saídas:
        string ou None: um dos valores de STATUS_VALIDOS, ou None se em branco
    """
    while True:
        entrada = input(mensagem).strip()
        if not entrada:
            return None
        for valido in STATUS_VALIDOS:
            if entrada.lower() == valido.lower():
                return valido
        print(f"Status inválido. Escolha um dos seguintes: {', '.join(STATUS_VALIDOS)}.")


def ler_texto_obrigatorio(mensagem: str) -> str:
    """
    Responsabilidade: Solicitar um texto ao usuário, repetindo a pergunta
                       enquanto o campo for deixado em branco.
    Entradas:
        mensagem (string): texto exibido ao solicitar o valor
    Saídas:
        string: texto não vazio digitado pelo usuário
    """
    while True:
        entrada = input(mensagem).strip()
        if entrada:
            return entrada
        print("Este campo não pode ficar em branco.")


def ler_nome(mensagem: str) -> str:
    """
    Responsabilidade: Solicitar um nome de pessoa, repetindo a pergunta
                       enquanto o campo estiver em branco ou contiver
                       números ou símbolos. Aceita apenas letras (incluindo
                       acentuadas) e espaços.
    Entradas:
        mensagem (string): texto exibido ao solicitar o valor
    Saídas:
        string: nome válido contendo apenas letras e espaços
    """
    while True:
        entrada = input(mensagem).strip()
        if not entrada:
            print("Este campo não pode ficar em branco.")
            continue
        if not all(caractere.isalpha() or caractere.isspace() for caractere in entrada):
            print("Nome inválido. Use apenas letras e espaços (sem números ou símbolos).")
            continue
        return entrada
