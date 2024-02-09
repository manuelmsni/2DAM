"""
Crear una función que calcule el MCD de dos números por el método de Euclides. El método de Euclides es el siguiente:
Se divide el número mayor entre el menor.
Si la división es exacta, el divisor es el MCD.
Si la división no es exacta, dividimos el divisor entre el resto obtenido y se continúa de esta forma hasta obtener una división exacta, siendo el último divisor el MCD. Crea un programa principal que lea dos números enteros y muestre el MCD.

"""


def calcular_mcd(num1, num2):
    while num2 != 0:
        resto = num1 % num2
        num1 = num2
        num2 = resto
    return num1

def programa_principal():
    num1 = int(input("Ingrese el primer número: "))
    num2 = int(input("Ingrese el segundo número: "))
    mcd = calcular_mcd(num1, num2)
    print("El MCD de", num1, "y", num2, "es:", mcd)

programa_principal()

