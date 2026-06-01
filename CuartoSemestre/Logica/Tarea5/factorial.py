import time

def factorial(n):
    if n == 0 or n == 1:
        return 1
    else:
        return n * factorial(n - 1)

# Medir tiempo de ejecución
inicio = time.time()
resultado = factorial(20)
fin = time.time()

print("Factorial:", resultado)
print("Tiempo de ejecución:", (fin - inicio), "segundos")
