from main import db


class Consulta(db.Model):
    id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    nome_destinatario = db.Column(db.String(100))
    cep_origem = db.Column(db.String(20))
    cep_destino = db.Column(db.String(20))
    peso = db.Column(db.Float)
    valor_total_frete = db.Column(db.Float)
    data_prevista_entrega = db.Column(db.Date)
    data_consulta = db.Column(db.Date)

    def __init__(self):
        pass

    def __str__(self):
        return f'{super().__str__()}'

    def __repr__(self):
        return (f'ID: {self.id}, \
                NOME_DESTINATARIO: {self.nome_destinatario}, \
                CEP_ORIGEM: {self.cep_origem}, \
                CEP_DESTINATARIO: {self.cep_destino}, \
                PESO: {self.peso},\
                VALOR_TOTAL_FRETE: {self.valor_total_frete}, \
                DATA_PREVISTA_ENTREGA: {self.data_prevista_entrega}, \
                DATA_CONSULTA: {self.data_consulta}')
