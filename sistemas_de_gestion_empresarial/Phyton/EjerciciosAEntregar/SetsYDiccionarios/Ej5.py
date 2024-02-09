"""
Un diccionario en el que para cada entero de la lista x se almacena su cuadrado.
"""
x = [8, 2, 3, 2, 2]

dic = {}

for i in x:
    dic[i] = i ** 2

print(dic)