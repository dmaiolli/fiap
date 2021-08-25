import React, {
  useState
} from 'react'
import {
  StyleSheet,
  Text,
  View,
  Button,
  Input
} from 'react-native'
import { SafeAreaView, SafeAreaProvider } from 'react-native-safe-area-view';
// import {
//   Button,
//   Input
// } from 'react-native-elements'
import {
  clear,
  insertString,
  read,
  readAll
} from './DB'

const App = () => {
  const [rm, setRM] = useState('')
  const [media, setMedia] = useState('')
  return (
    <SafeAreaProvider>

      <SafeAreaView style={estilos.screen}>
        <Text>Informe seu RM:</Text>
        <Input
          onChangeText={(txt) => setRM(txt)}
          value={rm} />
        <Text>Informe a média final:</Text>
        <Input
          onChangeText={(txt) => setMedia(txt)}
          value={media} />
        <Button
          onPress={() => {
            if (rm.trim().length == 0) {
              alert('Informe corretamente o RM!')
              return
            }
            if (media.trim().length == 0) {
              alert('Informe corretamente a média!')
              return
            }
            insertString(rm, media, (error) => {
              if (error) {
                alert('Não foi possível salvar!')
              } else {
                alert('Registro salvo com sucesso!')
              }
            })
          }}
          title="Salvar" />
        <View style={estilos.divisor} />
        <Button
          onPress={() => {
            readAll((error, result) => {
              if (error) {
                alert('Não foi possível retornar todos os registros!')
                return
              }
              result.forEach((element) => {
                read(element, (error2, value) => {
                  if (error2) {
                    alert('Não foi possível encontrar o elemento ' + element)
                    return
                  }
                  alert(`${element} : ${value}`)
                })
              })
            })
          }}
          title="Listar todos" />
        <View style={estilos.divisor} />
        <Button
          onPress={() => {
            clear((error) => {
              if (error) {
                alert('Não foi possível limpar o banco de dados')
              } else {
                alert('Banco resetado com sucesso!')
              }
            })
          }}
          title="Limpar banco" />
      </SafeAreaView>
    </SafeAreaProvider>

  )
}
const estilos = StyleSheet.create({
  divisor: {
    marginBottom: 8
  },
  screen: {
    padding: 16
  }
})
export default App;