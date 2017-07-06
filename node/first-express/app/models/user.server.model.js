var mongoose = require('mongoose'),
    crypto = require('crypto'),
    Schema = mongoose.Schema;

//esquema do modelo
var userSchema = new Schema({
    firstName: String,
    lastName: String,
    email: {
        type: String,
        match: [/.+\@.+\..+/, 'Please fill a valid e-mail address']
    },
    username: {
        type: String,
        unique: true,
        required: 'Username is required',
        trim: true
    },
    password: {
        type: String,
        validate: [function (password) {
            return password.length >= 6;
        }, 'Password should be longer']
    },
    salt: {
        type: String
    },
    provider: {
        type: String,
        required: 'Provider is required'
    },
    providerId: String,
    providerData: {},
    created: {
        type: Date,
        default: Date.now
    }
});


//criando um atributo virtual
userSchema.virtual('fullName').get(function () {
    return this.firstName + ' ' + this.lastName;
}).set(function (fullName) {
    var splitName = fullName.spli(' ');
    this.firstName = splitName[0] || '';
    this.lastName = splitName[1] || '';

});


//pre middleware - antes de salvar
userSchema.pre('save', function (next) {
    if (this.password) {
        this.salt = new Buffer(crypto.randomBytes(16).toString('base64'), 'base64');
        this.password = this.hashPassword(this.password);
    }

    next();
});


userSchema.methods.hashPassword = function (password) {
    return crypto.pbkdf2Sync(password, this.salt, 10000, 64).toString('base64');
}

//Adicionando um método de instância
userSchema.methods.authenticate = function (password) {
    return this.password === this.hashPassword(password);
}




//Adicionando um método estático 
userSchema.static.findUniqueUsername = function (username, suffix, callback) {
    var _this = this;
    var possibleUsername = username + (suffix || '');

    _this.findOne({ username: possibleUsername },
        function (err, user) {
            if (!err) {
                if (!user) {
                    callback(possibleUsername);
                } else {
                    return _this.findUniqueByUserName(username, (suffix || 0) + 1, callback);
                }
            } else {
                callback(null);
            }
        });
};


//habilitando getter's personalizados e atributos virtuais
userSchema.set('toJSON', {
    getters: true,
    virtuals: true
});

//registrando o modelo
mongoose.model('User', userSchema);