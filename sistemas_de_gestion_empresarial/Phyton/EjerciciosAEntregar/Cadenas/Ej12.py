cadena = "Mi nombre completo es Manuel Martín Santamaría"

for i in range(len(cadena)):
    if cadena[i] == "o":
        cadena = cadena.replace("o", "0")
    elif cadena[i] == "O":
        cadena = cadena.replace("O", "0")

print(cadena)