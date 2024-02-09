"""
Script de mierda
"""
import math
error = True
while error:
    try:
        error = False
        num = int(input("Introduce un número: "))
    except ValueError:
        error = True
        print("Introduce un número válido.")

# Comprueba si el número es par o impar
if num % 2 == 0:
    print(f"El número {num} es par.")
else:
    print(f"El número {num} es impar.")

# Comprueba si el número es primo
if num < 2:
    print(f"El número {num} no es primo.")
else:
    for i in range(2, math.isqrt(num) + 1):
        if (num % i) == 0:
            print(f"El número {num} no es primo.")
            break
    else:
        print(f"El número {num} es primo.")


