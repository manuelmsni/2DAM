"""
Escribir un programa que pregunte al usuario una cantidad a invertir, el interés anual y el número
de años, y muestre por pantalla el capital obtenido en la inversión.
"""

cantidad = float(input("Introduce la cantidad a invertir: "))
interes = float(input("Introduce el interes anual: "))
anios = int(input("Introduce el numero de años: "))
print("Tu capital obtenido es: " + str(cantidad * (interes / 100 + 1) ** anios))
