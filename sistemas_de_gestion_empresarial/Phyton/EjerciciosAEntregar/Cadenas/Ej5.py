cadena = "Mi nombre completo es Manuel Martín Santamaría"

array = []
longitud = len(cadena)

for i in range(longitud-9, longitud, +3):
    array.append(cadena[i:i+3])

print("-".join(array))