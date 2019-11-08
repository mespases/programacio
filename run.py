from flask import Flask, render_template, request
from flask_login import login_user, login_required, LoginManager, logout_user
from flask_bootstrap import Bootstrap
from logform import LogForm
from werkzeug.security import generate_password_hash, check_password_hash
from werkzeug.utils import redirect
from usuario import User
from pymongo import MongoClient

app = Flask(__name__)
Bootstrap(app)

usuario = User()
app.secret_key = '123456'
login_manager = LoginManager()
login_manager.init_app(app)

# Connection to mongo
cliente = MongoClient('localHost', 27017)
db = cliente.Practica
collection_productos = db['Productos']
collection_menu = db["Menu"]

@login_manager.user_loader
def load_user(user):
    """ Autentica al usuario """
    global usuario
    return usuario

@app.route('/', methods=['GET', 'POST'])
def login():
    """ Login del usuario """
    global usuario
    form = LogForm(request.form)
    try:
        if form.validate():
            if comprobarEmail(form.email.data, form.password.data):
                try:
                    u = User()
                    login_user(u)
                except:
                    print "Login user incorrect"

                return redirect('/dashboard', code=302)
            else:
                print "No encuentro el usuario"
    except:
        pass

    return render_template('login.html', form=form)

def comprobarEmail(email, password):
    """ Comprueba que el email no exista """
    global usuario
    i = 0

    for x in usuario.email:
        if x == email and check_password_hash(usuario.password[i], password):
            return True
        i += 1
    return False

@app.route('/logout')
def logout():
    logout_user()
    return redirect('/')

@app.route('/dashboard')
@login_required
def index():
    return render_template("empty_page.html", collection=collection_menu)

if __name__ == '__main__':
    app.debug = True
    app.run()