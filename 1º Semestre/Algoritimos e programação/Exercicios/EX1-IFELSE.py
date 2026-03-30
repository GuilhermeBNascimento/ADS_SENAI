idade = int(input("Digite a idade: "))

if idade < 16:
    print("Não vota")
elif idade == 16 or idade == 17:
    print("Voto opcional")
else:
    print("Voto Obrigatorio")