def ler_num():
    numeros = []
    while True:
     numero = int(input("Digite o número (0 para parar): "))
     if numero == 0:
         break
     numeros.append(numero)

    return numeros

def pares(numeros):
    cont = 0
    for numero in numeros:
        if numero % 2 == 0:
            cont+=1
        return cont
    
def soma_impar(numeros):
    soma = 0
    for numero in numeros:
        if numero % 2 !=0:
            soma = soma + numero
    return soma

def main():
    numero = ler_num()
    print("\n Lista Final: ", numero)
    print("Quantidade de pares: ", pares(numero))
    print("Soma dos impares: ", soma_impar(numero))


main()
