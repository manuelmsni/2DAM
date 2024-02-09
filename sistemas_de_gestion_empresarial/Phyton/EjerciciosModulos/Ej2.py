import operaciones_basicas
import operaciones_basicas as op
from operaciones_basicas import *

a,b = 13, 3

print ('Operandos =', a, b)
print ( 'sumar = ', operaciones_basicas.sumar (a, b))
print ( 'restar = ', operaciones_basicas.restar (a, b))
print ( 'multiplicar = ', operaciones_basicas.multiplicar (a, b))
print ( 'dividir = ', operaciones_basicas.dividir (a, b))

a,b = 13, 3

print ('Operandos =', a, b)
print ( 'sumar = ', op.sumar (a, b))
print ( 'restar = ', op.restar (a, b))
print ( 'multiplicar = ', op.multiplicar (a, b))
print ( 'dividir = ', op.dividir (a, b))

a,b = 13, 0

print('Operandos =', a, b)
print('sumar =', sumar(a, b))
print('restar =', restar(a, b))
print('multiplicar =', multiplicar(a, b))
print('dividir =', dividir(a, b))