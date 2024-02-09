"""
A partir de 2 listas de enteros, 'numeros1' y 'numeros2', almacenar en una lista el resultado de multiplicar cada uno de los elementos de 'numeros1' por, a su vez, cada uno de los elementos de 'numeros2'. Es decir, la lista resultante tendrá len(numeros1) * len(numeros2) elementos. 
"""

numeros1 = [1, 2, 3, 4, 5, 6, 7, 8, 9]
numeros2 = [2, 4, 6, 8, 10, 12, 14, 16, 18]
resultado = []

for i in range(len(numeros1)):
    resultado.append(numeros1[i] * numeros2[i])

print(resultado)