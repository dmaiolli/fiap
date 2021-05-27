import React from 'react';
import {
  Button,
  FlatList,
  Image,
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  TextInput,
  TouchableOpacity,
  View,
} from 'react-native';

import Contato from './components/pages/Contato';
import Descricao from './components/pages/Descricao';

import produtos from './assets/json/produtos.json';

const PAGE_NOVIDADES = 0;
const PAGE_CONTATO = 1;
const PAGE_DESC_PRODUTO = 2;

class App extends React.Component {
  state = {
    paginaAtual: PAGE_NOVIDADES,
    produtoAtual: null,
  };

  paginaNovidades = () => this.setState({paginaAtual: PAGE_NOVIDADES});

  paginaContato = () => this.setState({paginaAtual: PAGE_CONTATO});

  render() {
    const estiloMenu = styles.buttonTextMenu;
    const estiloMenuAtivo = [
      styles.buttonTextMenu,
      styles.buttonTextMenuActive,
    ];

    return (
      <SafeAreaView>
        <StatusBar backgroundColor="#489800" />

        {/* MENU */}
        <View style={styles.menu}>
          <TouchableOpacity onPress={this.paginaNovidades}>
            <Text
              style={
                this.state.paginaAtual === PAGE_NOVIDADES
                  ? estiloMenuAtivo
                  : estiloMenu
              }>
              Novidades
            </Text>
          </TouchableOpacity>

          <TouchableOpacity onPress={this.paginaContato}>
            <Text
              style={
                this.state.paginaAtual === PAGE_CONTATO
                  ? estiloMenuAtivo
                  : estiloMenu
              }>
              Contato
            </Text>
          </TouchableOpacity>
        </View>

        {/* NOVIDADES */}
        {this.state.paginaAtual === PAGE_NOVIDADES && (
          <View style={styles.page}>
            <FlatList
              data={produtos}
              keyExtractor={item => item.id.toString()}
              renderItem={({item}) => (
                <TouchableOpacity
                  onPress={() => {
                    this.setState({
                      paginaAtual: PAGE_DESC_PRODUTO,
                      produtoAtual: item,
                    });
                  }}
                  activeOpacity={0.75}
                  style={styles.itemProduto}>
                  <Image
                    source={{uri: item.imagem}}
                    style={styles.produtoImagem}
                  />

                  <View>
                    <Text style={styles.produtoNome}>{item.nome}</Text>

                    <Text>Valor: {item.valor}</Text>
                  </View>
                </TouchableOpacity>
              )}
            />
          </View>
        )}

        {this.state.paginaAtual === PAGE_DESC_PRODUTO && (
          <Descricao
            produto={this.state.produtoAtual}
            onPressFechar={this.paginaNovidades}
          />
        )}

        {/* CONTATO */}
        {this.state.paginaAtual === PAGE_CONTATO && <Contato />}
      </SafeAreaView>
    );
  }
}

export default App;

const styles = StyleSheet.create({
  menu: {
    backgroundColor: '#c7e2ae',
    flexDirection: 'row',
    padding: 8,
    justifyContent: 'center',
  },

  page: {
    padding: 16,
  },
  buttonTextMenu: {
    fontSize: 16,
    marginHorizontal: 8,
    padding: 8,
  },
  buttonTextMenuActive: {
    backgroundColor: '#a0c785',
    fontSize: 16,
    padding: 8,
    borderRadius: 8,
    fontWeight: 'bold',
  },
  itemProduto: {
    borderBottomColor: '#CCC',
    borderBottomWidth: 1,
    padding: 16,
    flexDirection: 'row',
  },
  produtoImagem: {
    height: 80,
    marginRight: 8,
    width: 100,
  },
  produtoNome: {
    fontSize: 16,
    fontWeight: 'bold',
  },
});
