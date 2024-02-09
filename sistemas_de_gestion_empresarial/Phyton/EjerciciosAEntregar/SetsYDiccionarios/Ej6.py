"""
Un diccionario en el que se almacena el número de veces que cada entero aparece en la lista y.
"""

y = [8, 2, 3, 2, 9]

dic = {}

for i in y:
    dic[i] = dic.get(i, 0) + 1

print(dic)