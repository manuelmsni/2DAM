"""
El cubo de cada elemento de la lista x.
"""

x = [7, 3, 5, -6, 4, -2, 9]

def cubo(x):
    cubos = []
    for i in x:
        cubos.append(i**3)
    return cubos

print(cubo(x))