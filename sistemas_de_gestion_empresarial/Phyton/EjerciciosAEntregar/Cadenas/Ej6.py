cadena = "Mi nombre completo es Manuel Martín Santamaría"

array = []
cadenaResultado = ""

for i in range(0, len(cadena)):
    if i % 3 == 0:
        cadenaResultado += cadena[i].upper()
    else:
        cadenaResultado += cadena[i]

print(cadenaResultado)