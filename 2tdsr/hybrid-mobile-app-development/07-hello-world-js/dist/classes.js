"use strict";

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var Pessoa = function () {
  function Pessoa() {
    _classCallCheck(this, Pessoa);

    this._nome = "";
    this._email = "";
    this._telefone = "";
  }

  _createClass(Pessoa, [{
    key: "nome",
    get: function get() {
      return this._nome;
    },
    set: function set(value) {
      this._nome = value;
    }
  }]);

  return Pessoa;
}();

var pessoa = new Pessoa();
// pessoa._nome = "Denys";
pessoa.nome = "Denys";

console.log(pessoa.nome);