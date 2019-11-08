from wtforms import Form, StringField, PasswordField
from wtforms.validators import InputRequired, Email, Length

class LogForm(Form):
    """ LogForm son las reglas que va a seguir el formulario de login creado en html"""

    email = StringField('email', validators=[Email(message='Invalid email'), Length(max=30)])
    password = PasswordField('password', validators=[Length(min=1, max=20)])