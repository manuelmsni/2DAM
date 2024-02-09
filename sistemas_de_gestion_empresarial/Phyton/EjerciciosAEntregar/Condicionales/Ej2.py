'''
Ej2

Escribe un programa que pida al usuario tres números y muestre el mayor de
ellos.
'''

print("--- Ejercicio 2 ---")

num1 = float(input("Introduce el primer número: "))
num2 = float(input("Introduce el segundo número: "))
num3 = float(input("Introduce el tercer número: "))

largest = max(num1, num2, num3)

print("El mayor número introducido es:", largest)