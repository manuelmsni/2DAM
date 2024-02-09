"""
Función que recibe una lista de enteros y devuelve la suma de todos sus elementos. Sin utilizar sum().
"""

def suma_lista(lista):
    suma = 0
    for elemento in lista:
        suma += elemento
    return suma

lista = {1,2,3,4,5}

print(suma_lista(lista))
