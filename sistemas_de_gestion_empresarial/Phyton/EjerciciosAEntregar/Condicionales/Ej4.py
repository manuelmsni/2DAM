'''
Ej4

Escribe un programa que pida al usuario un número y muestre si es primo.
'''

print("--- Ejercicio 4 ---")

def es_primo(numero):
    if numero < 2:
        return False
    for i in range(2, int(numero ** 0.5) + 1):
        if numero % i == 0:
            return False
    return True

numero = int(input("Introduce un número: "))

if es_primo(numero):
    print(f"El número {numero} es primo.")
else:
    print(f"El número {numero} no es primo.")