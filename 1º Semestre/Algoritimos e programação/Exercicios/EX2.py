entrada = input("Digite algo: ").strip()

if entrada.isdigit():
    print("Contem só Numeros")
elif entrada.isalpha():
    print("Contem apenas letras")
elif entrada.isalnum():
    print("Contem letras e numeros")