"""
Una lista que contenga la unión de ambas listas, sin duplicados.
"""

x = [8, 2, 3, 2, 2]
y = [8, 2, 3, 2, 9]

print(list(set(x) | set(y)))
