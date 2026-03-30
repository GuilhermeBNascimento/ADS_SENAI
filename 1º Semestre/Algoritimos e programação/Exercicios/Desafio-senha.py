senha_correta = 123
max_tentativas = 3

while max_tentativas > 0:
    try:
        senha = int(input("Digite a senha: "))
    except:
        print("Digite apenas números!")
        continue

    if senha == senha_correta:
        print("Acesso liberado")
        break
    else:
        max_tentativas -= 1
        print("Tentativas restantes:", max_tentativas)

if max_tentativas == 0:
    print("Acesso bloqueado")