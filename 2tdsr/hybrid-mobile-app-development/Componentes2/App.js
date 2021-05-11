import React from 'react';
import {
  View,
  Image,
  Button,
  TouchableHighlight,
  TouchableOpacity,
  Text,
  StyleSheet,
  Switch,
  TextInput,
} from 'react-native';

import Background from './assets/natureza.jpg';

class App extends React.Component {
  state = {
    isEnabled: false,
    contador: 0,
    nome: '',
  };

  render() {
    return (
      <View>
        <Image
          resizeMode="cover"
          source={{uri: 'https://picsum.photos/id/237/200/300'}}
          style={{height: 200, widht: 300}}
        />

        <Button
          title="Clique aqui"
          onPress={() => {
            this.setState({contador: this.state.contador + 1});
          }}
        />

        <TouchableOpacity
          activeOpacity={0.2}
          onPress={() => {
            this.setState({contador: this.state.contador + 1});
          }}>
          <Text
            style={this.state.isEnabled ? styles.button : styles.darkButton}>
            Clique em eu
          </Text>
        </TouchableOpacity>

        <TouchableHighlight
          underlayColor="0F0"
          onPress={() => {
            this.setState({contador: this.state.contador + 1});
          }}>
          <Text style={styles.button}>EUUU</Text>
        </TouchableHighlight>

        <View style={{flexDirection: 'row'}}>
          <Text>Texto</Text>
          <Switch
            value={this.state.isEnabled}
            onValueChange={() =>
              this.setState({isEnabled: !this.state.isEnabled})
            }
          />
        </View>

        <Text>Contador de cliques: {this.state.contador}</Text>

        {this.state.isEnabled && (
          <Text>Opção ativaaaaaaaaaaaaaaaaaaaaaaaa</Text>
        )}

        <TextInput
          onChangeText={txt => this.setState({nome: txt})}
          placeholder="Digite seu nome"
          value={this.state.nome}
        />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  button: {
    margin: 7,
    backgroundColor: '#F00',
    padding: 16,
    color: '#000',
    borderRadius: 4,
    textAlign: 'center',
    width: 200,
    alignSelf: 'center',
  },

  darkButton: {
    backgroundColor: '#000',
    color: '#FFF',
    margin: 7,
    padding: 16,
    borderRadius: 4,
    textAlign: 'center',
    width: 200,
    alignSelf: 'center',
  },
});

export default App;
