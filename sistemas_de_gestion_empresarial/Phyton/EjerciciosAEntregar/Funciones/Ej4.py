"""
Función que calcula el factorial de un número. Versión recursiva.
"""

def factorial(numero):
    if numero == 1:
        return 1
    else:
        return numero * factorial(numero - 1)
    
numero = 5

print(factorial(numero))