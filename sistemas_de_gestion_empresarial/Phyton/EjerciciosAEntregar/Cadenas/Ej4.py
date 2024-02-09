cadena = "Mi nombre completo es Manuel Martín Santamaría"

array = []
longitud = len(cadena)

for i in range(0, 4, +2):
    array.append(cadena[i:i+2])

print("-".join(array))