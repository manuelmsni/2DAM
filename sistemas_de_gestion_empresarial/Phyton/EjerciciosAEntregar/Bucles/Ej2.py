'''
Ej2
Lee valores del usuario hasta que teclee un número par, utilizando un bucle while.
'''

print("--- Ejercicio 2 ---")

num = None

while num is None or num % 2 != 0:
    num = int(input("Por favor, introduzca un número: "))

print("Ha introducido un número par:", num)