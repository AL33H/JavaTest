from datetime import datetime

from flask import jsonify, request
from main import app, db
from models.entity.Consulta import Consulta


@app.route('/', methods=['GET'])
def index():
    consultas = Consulta.query.order_by(Consulta.id).all()

    dados_consultas = []
    for consulta in consultas:
        dados_consultas.append({
            'id': consulta.id,
            'nome_destinatario': consulta.nome_destinatario,
            'cep_origem': consulta.cep_origem,
            'cep_destino': consulta.cep_destino,
            'peso': consulta.peso,
        })

    return jsonify(dados_consultas)


@app.route('/new', methods=['POST'])
def new():
    json = request.json

    consulta = Consulta()
    consulta.nome_destinatario = json['nome_destinatario']
    consulta.cep_origem = json['cep_origem']
    consulta.cep_destino = json['cep_destino']
    consulta.peso = json['peso']
    consulta.data_consulta = datetime.now().date()

    db.session.add(consulta)
    db.session.commit()

    return jsonify('Cadastro efetuado com sucesso'), 200