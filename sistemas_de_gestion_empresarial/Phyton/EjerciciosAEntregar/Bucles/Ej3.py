'''
Ej3
Imprime por pantalla todas las posiciones de la letra ‘s’ en la cadena: “Sistemas de gestión empresarial”.
'''

print("--- Ejercicio 3 ---")

cadena = "Sistemas de gestión empresarial"
posicion = 0

for caracter in cadena:
    if caracter.lower() == 's':
        print("Posición:", posicion)
    posicion += 1