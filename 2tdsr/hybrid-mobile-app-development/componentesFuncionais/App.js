import React, { useEffect, useState } from 'react';

import { Button, Text, View } from 'react-native';

const Contador = (props) => <Text>COntador: { props.numero }</Text>

const App = () => {
  let [contador, setContador] = useState(0);
  let [exemplo, setExemplo] = useState("");
  // Criar variável para ser o estado

  useEffect(() => {
    alert('Componente renderizado');

    return () => {
      alert('Componente desmontado')
    }
  }, [exemplo]) // useEffect irá disparar somente quando o estado "exemplo" for alterado (oque ainda não acontece)

  return (
    <View>
      <Contador numero = {contador} />
      <Button title="Incrementar" onPress={() => setContador(contador + 1)} />
      <Button title="Resetar" onPress={() => setContador(0)} />
    </View>
  )
}

export default App;