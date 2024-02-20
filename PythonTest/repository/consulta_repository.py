from main import db
from models.entity.Consulta import Consulta


def salvar(consulta: Consulta):
    db.session.add(consulta)
    db.session.commit()


def buscar_todos():
    return Consulta.query.order_by(Consulta.id)
