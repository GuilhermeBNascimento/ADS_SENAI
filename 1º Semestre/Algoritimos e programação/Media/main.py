Nome_Aluno = input("Digite o nome do aluno: ")
idade_aluno = int(input("Digite o idade do aluno: "))
n1 = float(input("Digite a Nota1: "))
n2 = float(input("Digite a Nota2: "))
n3 = float(input("Digite a Nota3: "))
media = (n1 + n2 + n3) / 3

if media >= 6:
    print(Nome_Aluno, "Você está aprovado! e sua nota foi :", round(media, 2))
else:
    print(Nome_Aluno, "Você está reprovado! e sua nota foi :", round(media, 2))
