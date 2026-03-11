Nome_Aluno = input("Digite o nome do aluno: ")
Idade_Aluno = int(input("Digite a idade do aluno: "))

qtd = int(input("Quantas notas deseja inserir? "))

soma = 0

for i in range(qtd):
    nota = float(input(f"Digite a nota {i+1}: "))
    soma += nota

media = soma / qtd

if media >= 6:
    print(Nome_Aluno,"Você está aprovado! e sua nota é: ", round(media,1))
else:
    print(Nome_Aluno,"Você está reprovado! e sua nota é: ", round(media,1))
