"""
A partir de 2 listas de enteros, 'numeros1' y 'numeros2‘ de igual tamaño, generar otra cuyo primer elemento es el producto del primer elemento de las listas 'numeros1' y 'numeros2', y así sucesivamente. 
"""

numeros1 = [1, 2, 3, 4, 5, 6, 7, 8, 9]
numeros2 = [2, 4, 6, 8, 10, 12, 14, 16, 18]
matriz = []

for i in range(len(numeros2)):
    fila = []
    for j in range(len(numeros1)):
        fila.append(numeros2[i] * numeros1[j])
    matriz.append(fila)

for fila in matriz:
    print(fila)