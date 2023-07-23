mol1, demon1 = map(int, input().split())
mol2, demon2 = map(int, input().split())

def gcd(num1, num2):
    if num2 == 0:
        return num1
    else:
        return gcd(num2, num1 % num2)


gcm = (demon1 * demon2) // gcd(demon1, demon2)

mol1 = mol1 * (gcm // demon1)
mol2 = mol2 * (gcm // demon2)

result_mol = mol1 + mol2
result_demon = (demon1 * demon2) // gcd(demon1, demon2)

#print(mol1 + mol2, gcm)

print(result_mol//gcd(result_mol, result_demon), result_demon//gcd(result_mol, result_demon))
