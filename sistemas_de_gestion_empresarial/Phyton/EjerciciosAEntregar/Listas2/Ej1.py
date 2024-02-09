notas = []
for i in range(5):
    nota = float(input("Introduce la nota: "))
    notas.append(nota)

print("Notas: ", notas)
print("Nota media: ", sum(notas)/len(notas))
print("Nota más alta: ", max(notas))
print("Nota más baja: ", min(notas))