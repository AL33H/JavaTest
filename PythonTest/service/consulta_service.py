from datetime import timedelta

import requests

from repository import consulta_repository
from models.cep import Cep
from models.entity.Consulta import Consulta


def find_all():
    return consulta_repository.buscar_todos()


def new(consulta: Consulta):
    cep_origem_json = consultar_cep(consulta.cep_origem)
    cep_destino_json = consultar_cep(consulta.cep_destino)

    cep_origem = Cep(cep_origem_json['cep'], cep_origem_json['uf'], cep_origem_json['ddd'])
    cep_destino = Cep(cep_destino_json['cep'], cep_destino_json['uf'], cep_destino_json['ddd'])

    print(f'cep_origem, {cep_origem}')
    print(f'destino {cep_destino}')
    consulta.valor_total_frete = calcular_valor_total(consulta.peso, cep_origem, cep_destino)
    consulta.data_prevista_entrega = consulta.data_consulta + timedelta(
        days=calcular_prazo_entrega(cep_origem, cep_destino))

    consulta_repository.salvar(consulta)

    return consulta


def consultar_cep(cep):
    return requests.get(f'https://viacep.com.br/ws/{cep}/json').json()


def calcular_valor_total(peso, origem: Cep, destino: Cep):
    return peso * calcular_desconto(origem, destino)


def calcular_desconto(origem: Cep, destino: Cep):
    if origem.uf == destino.uf:
        return 0.25

    if origem.ddd == destino.ddd:
        return 0.5

    return 1.0


def calcular_prazo_entrega(origem: Cep, destino: Cep):
    if origem.uf == destino.uf:
        return 1

    if origem.ddd == destino.ddd:
        return 3

    return 10
