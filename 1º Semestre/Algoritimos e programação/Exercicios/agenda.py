def cadastrar(agenda):
    nome = input("Digite seu nome: ")
    telefone = int(input("Digite seu telefone: "))
    agenda.append([nome, telefone])
    print("contato cadastrado")

def listar(agenda):
    if not agenda:
        print("Agenda vazia!")
        return 
    
    for contato in agenda:
        print("Nome: ", contato[0])
        print("Telefone: ", contato[1])
        print("-" * 20)

def menu():
    print("1 - Cadastrar contato")
    print("2 - Listar contato")
    print("0 - Sair")

def main():
    agenda = []
    while True:
        menu()
        opcao = input("Escolha: ")

        if opcao == "1":
            cadastrar(agenda)
        elif opcao == "2":
            listar(agenda)
        elif opcao == "0":
            print("Encerrando programa...")
            break
        else:
            print("Opção inválida!\n")


# Executa o programa
main()
