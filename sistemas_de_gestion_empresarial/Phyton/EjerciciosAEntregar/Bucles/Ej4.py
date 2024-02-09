'''
Ej4
Escribe un programa que calcule el factorial de un número utilizando un for.
'''

print("--- Ejercicio 4 ---")

num = int(input("Introduce un número: "))
factorial = 1

for i in range(1, num + 1):
    factorial *= i

print("El factorial de", num, "es", factorial)