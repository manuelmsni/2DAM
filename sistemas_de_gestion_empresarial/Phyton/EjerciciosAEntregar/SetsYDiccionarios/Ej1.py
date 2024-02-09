"""
¿Cuántos elementos hay en x si se eliminan los repetidos? 
"""

x = [8, 2, 3, 2, 2] 
y = [8, 2, 3, 2, 9]

print(len(set(x) - set(y)))


