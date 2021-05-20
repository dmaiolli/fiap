import React from 'react';
import {
  Image,
  SafeAreaView,
  StyleSheet,
  Text,
  TouchableOpacity,
} from 'react-native';

import p0 from './assets/p0.png';
import p1 from './assets/p1.png';
import p2 from './assets/p2.png';
import p3 from './assets/p3.png';
import p4 from './assets/p4.png';
import p5 from './assets/p5.png';
import p6 from './assets/p6.png';

class App extends React.Component {
  state = {
    contador: 0,
    imagem: [p0, p1, p2, p3, p4, p5, p6],
  };
  render() {
    return (
      <SafeAreaView style={styles.background}>
        <Text style={styles.title}>Galeria de fotos</Text>
        <Image
          style={styles.imagem}
          source={this.state.imagem[this.state.contador]}
        />

        <TouchableOpacity
          style={styles.button}
          title="Próxima imagem"
          onPress={() =>
            this.state.contador < 6
              ? this.setState({contador: this.state.contador + 1})
              : alert('FIM')
          }>
          <Text style={styles.textButton}>PROXIMA IMAGEM</Text>
        </TouchableOpacity>

        <TouchableOpacity
          style={styles.button}
          title="Próxima imagem"
          onPress={() =>
            this.state.contador > 0
              ? this.setState({contador: this.state.contador - 1})
              : alert('Começo')
          }>
          <Text style={styles.textButton}>IMAGEM ANTERIOR</Text>

          {alert(`Você está na imagem: ${this.state.contador + 1}`)}
        </TouchableOpacity>
      </SafeAreaView>
    );
  }
}

const styles = StyleSheet.create({
  title: {
    fontSize: 20,
    color: '#FFF',
    backgroundColor: '#F48',
    padding: 20,
  },
  imagem: {
    alignSelf: 'center',
    width: 200,
    height: 200,
    margin: 16,
  },

  background: {
    flex: 1,
    backgroundColor: '#063986',
  },
  button: {
    width: 350,
    height: 50,
    margin: 7,
    backgroundColor: '#F48',
    color: '#FFF',
    borderRadius: 4,
    textAlign: 'center',
    alignSelf: 'center',
    justifyContent: 'center',
  },
  textButton: {
    color: '#FFF',
    fontSize: 16,
    alignSelf: 'center',
  },
});

export default App;
