'''
Ej1
Escribe un programa que pida al usuario un número del 1 al 7 e imprima el día de
la semana correspondiente.
'''

print("--- Ejercicio 1 ---")

number = int(input("Introduce un número de 1 a 7: "))
if 1 <= number <= 7:
    days = {
        1: "Lunes",
        2: "Martes",
        3: "Miércoles",
        4: "Jueves",
        5: "Viernes",
        6: "Sábado",
        7: "Domingo"
    }
    print(f"El día {number} es: {days[number]}")
else:
    print("Dato de entrada no válido. Introduce un número de 1 a 7.")
