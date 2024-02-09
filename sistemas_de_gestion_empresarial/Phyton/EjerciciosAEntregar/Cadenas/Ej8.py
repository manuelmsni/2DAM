cadena = "Mi nombre completo es Manuel Martín Santamaría"

contieneElCaracter = False

for i in range(len(cadena)):
    if(cadena[i] == "d"):
        contieneElCaracter = True

print("El carácter 'd' está en la cadena" if contieneElCaracter else "El carácter 'd' no está en la cadena")


