"""
Función que recibe una lista de enteros y calcula su media aritmética sin utilizar el módulo maths. 
"""

def media_aritmetica(lista):
    suma = 0
    for elemento in lista:
        suma += elemento
    media = suma / len(lista)
    return media

lista = {1,2,3,4,5}

print(media_aritmetica(lista))