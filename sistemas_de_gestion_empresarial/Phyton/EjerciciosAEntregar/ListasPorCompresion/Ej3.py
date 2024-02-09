"""
El cuadrado de los elementos pares y positivos de x.
"""

x = [7, 3, 5, -6, 4, -2, 9]

def cuadrado(x):
    cuadrados = []
    for i in x:
        if i % 2 == 0 and i > 0:
            cuadrados.append(i**2)
    return cuadrados

print(cuadrado(x))