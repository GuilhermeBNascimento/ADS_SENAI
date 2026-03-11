def guardar(login, senha):
    with open('user.csv', 'a') as file:
        file.write(f'{login},{senha}\n')
    return login


def validar(login, senha):
    try:
        with open('user.csv', 'r') as file:
            for linha in file:
                user, pwd = linha.strip().split(',')
                if user == login and pwd == senha:
                    return True
        return False
    except FileNotFoundError:
        return False


def cadastrar():
    login = input("Digite o login: ")
    senha = input("Digite a senha: ")
    guardar(login, senha)
    print("Usuário cadastrado com sucesso!")


def get_login():
    login = input("Login: ")
    senha = input("Senha: ")
    return login, senha


def inicio():
    while True:
        print("\n1 - Login")
        print("2 - Cadastrar")
        print("3 - Sair")

        opcao = input("Escolha: ")

        if opcao == "1":
            login, senha = get_login()
            if validar(login, senha):
                print("Login realizado com sucesso!")
            else:
                print("Login ou senha incorretos.")

        elif opcao == "2":
            cadastrar()

        elif opcao == "3":
            print("Saindo do sistema...")
            break

        else:
            print("Opção inválida.")


inicio()