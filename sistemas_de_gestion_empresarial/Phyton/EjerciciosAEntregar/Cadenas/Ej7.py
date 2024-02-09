cadena = "Mi nombre completo es Manuel Martín Santamaría"

array = []

ultima = 20
longitud = len(cadena)

if(ultima>longitud):
    ultima = longitud

for i in range(3, ultima, +2):
    array.append(cadena[i:i+2])

print("-".join(array))