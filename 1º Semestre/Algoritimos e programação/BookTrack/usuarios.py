# -*- coding: utf-8 -*-
"""
Módulo: usuarios.py
Responsabilidade: Regras de negócio relacionadas a usuários — registro,
                   edição, exclusão, login e exibição. Não realiza E/S em
                   disco diretamente; delega essa tarefa ao módulo arquivos.py.

Variáveis principais deste módulo:
    usuarios (list) -> vetor de dicionários. Cada dicionário representa
                        um usuário com as chaves:
                            nome        (string)
                            username    (string)
                            senha       (string)
                            nascimento  (int, formato DDMMAAAA, ex: 20071980)
"""

import arquivos
import validacoes


def registrar_usuario(usuarios: list, nome: str, username: str,
                       senha: str, nascimento: int) -> bool:
    """
    Responsabilidade: Cadastrar um novo usuário no vetor de usuários,
                       impedindo usernames duplicados.
    Entradas:
        usuarios (list): vetor de usuários já carregado em memória
        nome (string): nome completo do usuário
        username (string): login único do usuário
        senha (string): senha de acesso
        nascimento (int): data de nascimento no formato DDMMAAAA (ex: 20071980)
    Saídas:
        bool: True se o cadastro foi realizado; False se o username já existe
    """
    if buscar_usuario_por_username(usuarios, username) is not None:
        return False

    novo_usuario = {
        "nome": nome,
        "username": username,
        "senha": senha,
        "nascimento": str(nascimento),
    }
    usuarios.append(novo_usuario)
    arquivos.salvar_usuarios(usuarios)
    return True


def buscar_usuario_por_username(usuarios: list, username: str) -> dict:
    """
    Responsabilidade: Localizar um usuário dentro do vetor a partir do
                       seu username.
    Entradas:
        usuarios (list): vetor de usuários
        username (string): username a ser localizado
    Saídas:
        dict ou None: dicionário do usuário encontrado, ou None se não existir
    """
    for usuario in usuarios:
        if usuario["username"] == username:
            return usuario
    return None


def editar_usuario(usuarios: list, username: str, novo_nome: str = None,
                    novo_username: str = None, nova_senha: str = None,
                    novo_nascimento: int = None) -> str:
    """
    Responsabilidade: Atualizar os dados de um usuário já existente.
                       Campos não informados (None) permanecem inalterados.
    Entradas:
        usuarios (list): vetor de usuários
        username (string): username atual do usuário a ser editado
        novo_nome (string, opcional): novo nome
        novo_username (string, opcional): novo username (login)
        nova_senha (string, opcional): nova senha
        novo_nascimento (int, opcional): nova data de nascimento (formato DDMMAAAA)
    Saídas:
        string: "ok" se atualizado com sucesso;
                "nao_encontrado" se o username informado não existe;
                "username_em_uso" se novo_username já pertence a outro usuário
    """
    usuario = buscar_usuario_por_username(usuarios, username)
    if usuario is None:
        return "nao_encontrado"

    if novo_username and novo_username != usuario["username"]:
        if buscar_usuario_por_username(usuarios, novo_username) is not None:
            return "username_em_uso"
        usuario["username"] = novo_username

    if novo_nome:
        usuario["nome"] = novo_nome
    if nova_senha:
        usuario["senha"] = nova_senha
    if novo_nascimento:
        usuario["nascimento"] = str(novo_nascimento)

    arquivos.salvar_usuarios(usuarios)
    return "ok"


def excluir_usuario(usuarios: list, username: str) -> bool:
    """
    Responsabilidade: Remover um usuário do vetor de usuários.
    Entradas:
        usuarios (list): vetor de usuários
        username (string): username do usuário a ser removido
    Saídas:
        bool: True se removido com sucesso; False se o usuário não existia
    """
    usuario = buscar_usuario_por_username(usuarios, username)
    if usuario is None:
        return False

    usuarios.remove(usuario)
    arquivos.salvar_usuarios(usuarios)
    return True


def autenticar_login(usuarios: list, username: str, senha: str) -> bool:
    """
    Responsabilidade: Validar as credenciais informadas (login).
    Entradas:
        usuarios (list): vetor de usuários
        username (string): username informado
        senha (string): senha informada
    Saídas:
        bool: True se username e senha conferem; False caso contrário
    """
    usuario = buscar_usuario_por_username(usuarios, username)
    if usuario is None:
        return False
    return usuario["senha"] == senha


def listar_usuarios(usuarios: list):
    """
    Responsabilidade: Exibir na tela os dados de todos os usuários cadastrados.
    Entradas:
        usuarios (list): vetor de usuários
    Saídas: nenhuma (efeito colateral: impressão no console)
    """
    if not usuarios:
        print("Nenhum usuário cadastrado.")
        return

    print("\n--- Lista de Usuários ---")
    for usuario in usuarios:
        nascimento_formatado = validacoes.formatar_data(int(usuario["nascimento"]))
        print(f"Nome: {usuario['nome']} | Username: {usuario['username']} "
              f"| Nascimento: {nascimento_formatado}")
    print("-------------------------\n")
