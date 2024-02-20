class Cep:
    def __init__(self, cep, uf, ddd):
        self.cep = cep
        self.uf = uf
        self.ddd = ddd

    def __str__(self):
        return f'CEP: {self.cep}, UF: {self.uf}, DDD: {self.ddd}'