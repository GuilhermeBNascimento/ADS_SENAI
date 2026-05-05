def ler_nomes():
    nomes = []
    for i in range(5):
        nome = input(f"Digite o nome do aluno {i+1}: ")
        nomes.append(nome)
    return nomes


def exibir_nomes(nomes):
    print("\nTodos os nomes:")
    for nome in nomes:
        print(nome)


def contar_maiores_5(nomes):
    contador = 0
    for nome in nomes:
        if len(nome) > 5:
            contador += 1
    return contador


def main():
    nomes = ler_nomes()
    exibir_nomes(nomes)
    
    qtd = contar_maiores_5(nomes)
    print(f"\nQuantidade de nomes com mais de 5 letras: {qtd}")

main()
