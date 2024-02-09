cadena = input("Introduce una cadena de texto: ")
vocales = "aeiou"
for letra in cadena:
    if letra in vocales:
        print(letra, "es una vocal")
    else:
        print(letra, "es una consonante")