email = input("Digite o email: ")
email_formatado = email.strip().lower()

if email_formatado.endswith(".com"):
    print("Email valido")
else:
    print("Email invalido")