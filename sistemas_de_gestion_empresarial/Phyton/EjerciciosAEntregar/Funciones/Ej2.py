"""
Función que recibe una lista de enteros y devuelve otra lista con aquellos que son pares y ≥ 113.
"""

def pares_113(lista):
    pares = []
    for elemento in lista:
        if elemento % 2 == 0 and elemento >= 113:
            pares.append(elemento)
    return pares

lista = {145,221,3,432,536}

print(pares_113(lista))