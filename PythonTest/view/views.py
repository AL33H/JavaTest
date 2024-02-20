from datetime import datetime

from flask import jsonify, request

from main import app
from models.entity.Consulta import Consulta
from service.consulta_service import new, find_all


@app.route('/', methods=['GET'])
def buscar_todos():
    consultas = find_all()

    dados_consultas = []
    for consulta in consultas:
        dados_consultas.append({
            'id': consulta.id,
            'nome_destinatario': consulta.nome_destinatario,
            'cep_origem': consulta.cep_origem,
            'cep_destino': consulta.cep_destino,
            'peso': consulta.peso,
            'valor_total_frete': consulta.valor_total_frete,
            'data_prevista_entrega': consulta.data_prevista_entrega,
            'data_consulta': consulta.data_consulta
        })

    return jsonify(dados_consultas)


@app.route('/new', methods=['POST'])
def novo():
    json = request.json

    consulta = Consulta()
    consulta.nome_destinatario = json['nome_destinatario']
    consulta.cep_origem = json['cep_origem']
    consulta.cep_destino = json['cep_destino']
    consulta.peso = json['peso']
    consulta.data_consulta = datetime.now().date()

    nova_consulta = new(consulta)

    return jsonify(nova_consulta.__str__())
