cadena = "Mi nombre completo es Manuel Martín Santamaría"

vocales = "aeiouAEIOU"
cuenta = 0
for i in vocales:
    for j in i:
        if j in vocales:
            cuenta += 1

print(cuenta)
