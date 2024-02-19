SQLALCHEMY_DATABASE_URI = \
    '{SGBD}://{usuario}:{senha}@{servidor}/{database}'.format(
        SGBD='postgresql',
        usuario='root',
        senha='root',
        servidor='localhost',
        database='pythontest'
    )