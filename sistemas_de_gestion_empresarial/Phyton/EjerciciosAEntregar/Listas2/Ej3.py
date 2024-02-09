"""
A partir de 2 listas de enteros, 'numeros1' y 'numeros2', crea una lista que contiene aquellos valores de la primera que también están en la segunda e imprímela por pantalla. Es decir, calcula la intersección de ambas listas. 
"""

numeros1 = [1, 2, 3, 4, 5, 6, 7, 8, 9]
numeros2 = [2, 4, 6, 8, 10, 12, 14, 16, 18]

interseccion = []

for numero in numeros1:
    if numero in numeros2:
        interseccion.append(numero)

print(interseccion)
