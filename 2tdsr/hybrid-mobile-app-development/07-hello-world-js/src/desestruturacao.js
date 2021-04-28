const meuArray = ["azul", "vermelho", "terceiro"];
const [cor1, cor2, ...restoArray] = meuArray;
console.log(cor1);

const meuObjeto = { x: 10, y: 20, z: 30 };
const { x, y } = meuObjeto;
console.log(x);
