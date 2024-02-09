'''
Ej3

Escribe un programa que pida al usuario dos números y muestre el resultado de la
división del primer número por el segundo, siempre y cuando el segundo número
sea distinto de 0. Si el segundo número es 0, el programa debe mostrar un
mensaje de error.
'''

print("--- Ejercicio 3 ---")

# Pide al usuario dos números
num1 = float(input("Introduce el primer número: "))
num2 = float(input("Introduce el segundo número: "))

# Verifica si el segundo número es distinto de 0
if num2 != 0:
    # Realiza la división y muestra el resultado
    resultado = num1 / num2
    print("El resultado de la división es:", resultado)
else:
    # Muestra un mensaje de error si el segundo número es 0
    print("Error: No se puede dividir entre 0.")