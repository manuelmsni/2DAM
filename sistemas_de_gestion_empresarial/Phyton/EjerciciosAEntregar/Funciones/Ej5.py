"""
Función que recibe un número y devuelve una lista con todos sus divisores.
"""

def divisores(numero):
    lista = []
    for i in range(1, numero + 1):
        if numero % i == 0:
            lista.append(i)
    return lista

numero = 10

print(divisores(numero))

