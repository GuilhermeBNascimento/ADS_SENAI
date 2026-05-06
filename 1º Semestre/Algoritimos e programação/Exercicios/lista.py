def ler_numeros(qtd):
    numeros = []
    for i in range(qtd):
        numero = int(input(f"Digite o número {i + 1}: "))
        numeros.append(numero)
    return numeros

def calcular_soma(numeros):
    return sum(numeros)

def calcular_media(numeros):
    return sum(numeros) / len(numeros)

def maior_numero(numeros):
    return max(numeros)

def menor_numero(numeros):
    return min(numeros)

def main():
    qtd = int(input("Quantos números você deseja digitar? "))
    numeros = ler_numeros(qtd)

    print(f"Soma: {calcular_soma(numeros)}")
    print(f"Média: {calcular_media(numeros)}")
    print(f"Maior número: {maior_numero(numeros)}")
    print(f"Menor número: {menor_numero(numeros)}")

main()