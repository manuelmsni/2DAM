cadena = "Mi nombre completo es Manuel Martín Santamaría"

contieneElCaracterEnMayuscula = False
contieneElCaracterEnMinuscula = False

for i in range(len(cadena)):
    if(cadena[i] == "a"):
        contieneElCaracterEnMinuscula = True
    elif(cadena[i] == "A"):
        contieneElCaracterEnMayuscula = True

salida = ""

if(contieneElCaracterEnMinuscula and contieneElCaracterEnMayuscula):
    salida = "Contiene tento el carácter en minúscula como el caracter en mayúscula."
elif(contieneElCaracterEnMinuscula):
    salida = "Contiene el carácter en minúscula."
elif(contieneElCaracterEnMayuscula):
    salida = "Contiene el carácter en mayúscula."
else:
    salida = "No contiene el carácter en minúscula ni en mayúscula."

print(salida)
